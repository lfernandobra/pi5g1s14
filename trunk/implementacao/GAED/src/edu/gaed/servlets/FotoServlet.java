package edu.gaed.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.gaed.albumWeb.exception.PersistenceException;
import edu.gaed.vo.Foto;
import edu.gaed.albumWeb.services.FotoServices;

/**
 * Servlet implementation class FotoServlet
 */
@WebServlet("/FotoServlet")
public class FotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_cod_foto = request.getParameter("foto");
		if (str_cod_foto == null || str_cod_foto.isEmpty()) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		}
		else {
			try {
				int cod_foto = Integer.parseInt(str_cod_foto);
				Foto foto = new Foto();
				foto.setId(cod_foto);
				
				foto = FotoServices.getInstance().obterFoto(foto);
				
				response.reset();
	            response.setContentType("image/jpg");
	            response.getOutputStream().write(foto.getImagem(),0,foto.getImagem().length);
	            response.getOutputStream().flush(); 
			}
			catch (Exception e) {
				e.printStackTrace();
				//do noting
			}
		}			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(
				request);
		if (!isMultipart) {
			request.setAttribute("erro", "O arquivo não foi submetido!");
		} else {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = null;

			Foto foto = new Foto();
			
			try {
				items = upload.parseRequest(request);				
			} catch (FileUploadException e) {
				request.setAttribute("erro", "Erro ao carregar informações do arquivo!");
			}
				
			for (FileItem item : items) {
				
				if (item.isFormField()){
					if (item.getFieldName().equals("nome")) {
						foto.setNome(item.getString());
					} else if (item.getFieldName().equals("descricao")) {
						foto.setDescricao(item.getString());
					} else if (item.getFieldName().equals("id")) {
						foto.setId(Integer.parseInt(item.getString()));
					}
				} else {
					FileInputStream fis = null;
					try {
						File file = File.createTempFile("img", ".png");
						item.write(file);
						
						fis =  new FileInputStream(file);
						byte[] buffer = new byte[fis.available()];
						
						fis.read(buffer);						
						foto.setImagem(buffer);						
						
					} catch (Exception e) {
						request.setAttribute("erro", "Erro ao carregar informações do arquivo!");
					}
					finally {
						if (fis != null) {
							fis.close();
						}
					}
				}
			}
			
			try {
				FotoServices.getInstance().salvarFoto(foto);
				
				if (foto.getId() > 0) {
					request.setAttribute("sucesso", "Foto editada com sucesso");
				}
				else {
					request.setAttribute("sucesso", "Foto adicionada com sucesso");
				}
			} catch (PersistenceException e) {
				request.setAttribute("erro", "Erro ao salvar informações da foto!");
			}
		}
		
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	}
}
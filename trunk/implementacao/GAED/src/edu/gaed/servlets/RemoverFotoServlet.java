package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import edu.gaed.albumWeb.exception.PersistenceException;
import edu.gaed.vo.Foto;
import edu.gaed.albumWeb.services.FotoServices;

/**
 * Servlet implementation class ExcluirFotoServlet
 */
@WebServlet("/RemoverFotoServlet")
public class RemoverFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	boolean isSuccess = false;
		
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				
				Foto foto = new Foto();
				foto.setId(id);
				
				FotoServices fotoServices = FotoServices.getInstance();
				isSuccess = fotoServices.removerFoto(foto);
				
				if (!isSuccess) {
					request.setAttribute("erro", "Não foi possível remover a foto!");
				}
				else {
					request.setAttribute("sucesso", "Foto removida com sucesso!");
				}
				
			}
			catch (NumberFormatException e) {
				request.setAttribute("erro", "Id da foto inválido!");
			}
			catch (PersistenceException e) { 
				request.setAttribute("erro", "Erro ao remover a foto!");
			}
		} else {
			request.setAttribute("erro", "Não foi possível determinar id da foto a ser removida!");
		}
		
		getServletContext().getRequestDispatcher("/AlbumServlet").forward(request,response);
	}

}

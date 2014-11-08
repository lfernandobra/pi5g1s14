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
 * Servlet implementation class EditarFotoServlet
 */
@WebServlet("/EditarFotoServlet")
public class EditarFotoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
boolean isSuccess = false;
		
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				
				Foto foto = new Foto();
				foto.setId(id);
				
				FotoServices fotoServices = FotoServices.getInstance();
				foto = fotoServices.obterFoto(foto);
				
				if (foto == null) {
					request.setAttribute("erro", "Não foi possível obter dados da foto!");
				}
				else {
					request.setAttribute("foto", foto);
					isSuccess = true;
				}
			}
			catch (NumberFormatException e) {
				request.setAttribute("erro", "Id da foto é inválido!");
			}
			catch (PersistenceException e) { 
				request.setAttribute("erro", "Erro ao obter a foto para edição!");
			}
		} else {
			request.setAttribute("erro", "Não foi possível determinar id da foto a ser editada!");
		}
		
		if (isSuccess) {
			getServletContext().getRequestDispatcher("/foto.jsp").forward(request,response);
		}
		else {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		}

	}

}

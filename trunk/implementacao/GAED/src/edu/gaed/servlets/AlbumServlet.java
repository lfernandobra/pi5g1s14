package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import edu.gaed.albumWeb.exception.PersistenceException;
import edu.gaed.vo.Foto;
import edu.gaed.albumWeb.services.FotoServices;

/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet("/AlbumServlet")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Foto> fotos = FotoServices.getInstance().obterFotos();
			
			request.setAttribute("album", fotos);
		}
		catch (PersistenceException e) {
			request.setAttribute("erro", "Erro ao obter as fotos!");
		}
		
		getServletContext().getRequestDispatcher("/album.jsp").forward(request,response);
	}

}

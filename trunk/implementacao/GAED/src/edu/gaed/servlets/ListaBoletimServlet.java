package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.modelo.Boletim;
//import edu.gaed.modelo.BoletimTurma;


/**
 * Servlet implementation class BoletimServlet
 */
@WebServlet({ "/ListaBoletimServlet"})
public class ListaBoletimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaBoletimServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String strIndiceProfessor = request.getParameter("idProfessor");
		//int indiceProfessor = Integer.parseInt(strIndiceProfessor);
		
		//obtem a lista de contatos do banco com base no identificador do usuario
		BoletimDao boletimDao = new BoletimDao();
		List<Boletim> boletim = boletimDao.obterBoletim(); //teste
						
		System.out.println(boletim);				
		//coloca agenda no escopo de requisi��o para ser exibido no agenda.jsp
		request.setAttribute("boletim", boletim);
			
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);
		
		
	}

}
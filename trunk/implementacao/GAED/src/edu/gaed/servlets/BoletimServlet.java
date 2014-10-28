package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.modelo.BoletimTurma;


/**
 * Servlet implementation class BoletimServlet
 */
@WebServlet({ "/BoletimServlet", "/BoletimTurmaServlet" })
public class BoletimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoletimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String strID = request.getParameter("ID");
	    //String strSerie = request.getParameter("serie");
	    
	    //int ID = Integer.parseInt(strID);
	    //int serie = Integer.parseInt(strSerie);
		
		//obtem a lista de contatos do banco com base no identificador do usuario
		BoletimDao boletimDao = new BoletimDao();
		List<BoletimTurma> boletim = boletimDao.obterBoletimTurma(1, 1); //teste
						
		System.out.println(boletim);				
		//coloca agenda no escopo de requisição para ser exibido no agenda.jsp
		request.setAttribute("boletim", boletim);
			
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);
	}

}

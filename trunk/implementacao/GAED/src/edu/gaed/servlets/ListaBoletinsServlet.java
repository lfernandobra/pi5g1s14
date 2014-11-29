package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.vo.Inserido;

/**
 * Servlet implementation class ListaBoletinsServlet
 */
@WebServlet("/ListaBoletinsServlet")
public class ListaBoletinsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaBoletinsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtem a lista de boletins do banco com base no identificador do aluno
		
		BoletimDao boletimDao = new BoletimDao();
		List<Inserido> boletins = boletimDao.obterBoletinsInseridos();
								
								
		//coloca agenda no escopo de requisição para ser exibido no agenda.jsp
		request.setAttribute("boletins", boletins);
		
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/agenda_boletins_inseridos.jsp").forward(request, response);
	}

}

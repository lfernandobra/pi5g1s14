package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.OcorrenciaDao;
import edu.gaed.vo.Recebe;

/**
 * Servlet implementation class ListaOcorrenciasServlet
 */
@WebServlet("/ListaOcorrenciasServlet")
public class ListaOcorrenciasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaOcorrenciasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtem a lista de ocorrencias do banco com base no identificador do aluno
		
		OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
		List<Recebe> ocorrencias = ocorrenciaDao.obterOcorrenciasAluno();
						
						
		//coloca agenda no escopo de requisição para ser exibido no agenda.jsp
		request.setAttribute("ocorrencias", ocorrencias);
			
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/agenda_ocorrencias.jsp").forward(request, response);
	}

}

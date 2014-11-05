package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.ProfessorDao;
import edu.gaed.dao.TurmaDao;
import edu.gaed.vo.Professor;
import edu.gaed.vo.Turma;

/**
 * Servlet implementation class TurmaServlet
 */
@WebServlet({ "/ObterTurmaProfessor", "/SalvarTurma", "/AtualizarTurma" })
public class TurmaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TurmaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getServletPath().equals("/ObterTurmaProfessor"))
		{		
			obterTurmaProfessor(request, response);
		
		}
		
	}
	
	private void obterTurmaProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strIDUsuario = request.getParameter("id");
		int idUsuario = Integer.parseInt(strIDUsuario);
				
		ProfessorDao professorDao = new ProfessorDao();
		Professor professor = professorDao.obterProfessor(idUsuario);
		
		TurmaDao turmaDao = new TurmaDao();
		List<Turma> turmas = turmaDao.obterTurmas(professor.getIdProfessor());
						
						
		
		request.setAttribute("turmas", turmas);
	
		
		getServletContext().getRequestDispatcher("/turmas_disciplina.jsp").forward(request, response);
	}
	

}

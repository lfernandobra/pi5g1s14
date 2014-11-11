package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.DisciplinaDao;
import edu.gaed.dao.ProfessorDao;
import edu.gaed.dao.TurmaDao;
import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Professor;
import edu.gaed.vo.Turma;
import edu.gaed.vo.Usuario;

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
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("login"); //colocado pelo professor
			
		ProfessorDao professorDao = new ProfessorDao();
		Professor professor = professorDao.obterProfessor(usuario.getId());
		
		DisciplinaDao disciplinaDao = new DisciplinaDao();
		Disciplina disciplina = disciplinaDao.obtemDisciplinaProfessor(professor);
		
		TurmaDao turmaDao = new TurmaDao();
		List<Turma> turmas = turmaDao.obterTurmas(professor.getIdProfessor());
						
						
		request.setAttribute("disciplina", disciplina);
		request.setAttribute("turmas", turmas);
		
		
		getServletContext().getRequestDispatcher("/turmas_disciplina.jsp").forward(request, response);
	}
	

}

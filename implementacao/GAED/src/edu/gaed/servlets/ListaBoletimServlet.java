package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.dao.CompoeDao;

import edu.gaed.dao.EstudaDao;
import edu.gaed.dao.InseridoDao;
import edu.gaed.vo.Boletim;
import edu.gaed.vo.Compoe;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Inserido;

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
		
		String strIndiceTurma = request.getParameter("idTurma");
		int indiceTurma = Integer.parseInt(strIndiceTurma);
		
		String strIndiceDisciplina = request.getParameter("idDisciplina");
		int indiceDisciplina = Integer.parseInt(strIndiceDisciplina);
		
		//obtem a lista de todo os boletins armazenados no banco
		BoletimDao boletimDao = new BoletimDao();
		List<Boletim> boletins = boletimDao.obterBoletinsTurma(indiceTurma,indiceDisciplina); //teste
							
		System.out.println(boletins);				
		
		CompoeDao compoeDao = new CompoeDao();
		List<Compoe> compoe = compoeDao.obterComposicao(boletins);
		
		InseridoDao inseridoDao = new InseridoDao();
		List<Inserido> alunosinseridos = inseridoDao.obterComposicao(boletins);
		
		EstudaDao estudaDao = new EstudaDao();
		List<Estuda> estudaTurma = estudaDao.obterComposicao(alunosinseridos);
		
		request.setAttribute("idDisciplina", indiceDisciplina);
		request.setAttribute("compoe",compoe);
		request.setAttribute("alunos",alunosinseridos);
		request.setAttribute("turmas", estudaTurma);	
		
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);
		
		
		
	}

}

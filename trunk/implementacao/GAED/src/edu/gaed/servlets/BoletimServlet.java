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
import edu.gaed.vo.Aluno;
import edu.gaed.vo.Boletim;
import edu.gaed.vo.Compoe;
import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Inserido;
import edu.gaed.vo.Possui;

/**
 * Servlet implementation class BoletimServlet
 */
@WebServlet({ "/BoletimServlet","/ObterBoletim","/ObterBoletimTurma", "/EditarBoletim", "/AtualizarBoletim","/InserirBoletim"})
public class BoletimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoletimServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getServletPath().equals("/AtualizarBoletim"))
		{
			atualizarBoletim(request, response);
		}
		
		else if (request.getServletPath().equals("/InserirBoletim"))
		{
			inserirBoletim(request, response);
		}
		
		else if (request.getServletPath().equals("/ObterBoletim"))
		{
			obterBoletim(request, response);
		}
				
		else if (request.getServletPath().equals("/ObterBoletimTurma"))
		{
			obterBoletimTurma(request, response);
		}
	
	}
	
	private void obterBoletim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String strIndiceAluno = request.getParameter("idAluno");
			String strIndiceBoletim = request.getParameter("idBoletim");
			String strIndiceDisciplina = request.getParameter("idDisciplina");
							
			int indiceAluno = Integer.parseInt(strIndiceAluno);
			int indiceBoletim = Integer.parseInt(strIndiceBoletim);
			int indiceDisciplina = Integer.parseInt(strIndiceDisciplina);
								
			String erro = null;
		
			BoletimDao boletimDao = new BoletimDao();
		
			//obtem contato e envia usuario para formulario de edição do contato
			Compoe boletim = boletimDao.obterBoletim(indiceAluno, indiceBoletim,indiceDisciplina);
				
			//se nao houver agenda ou indice contato não estiver na agenda, informa erro
			if (boletim == null)
			{
				erro = "Boletim não encontrado.";
			}
			else
			{			
				//seta contato no escopo de requisição para ser exibido pelo jsp 
				request.setAttribute("compoe", boletim);
			}
		
			if (erro != null)
			{
				//se houver erro, envia o usuario de volta para a página de agenda
		
				request.setAttribute("mensagem_erro", erro);
				getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);
			}
			else
			{
				
				request.setAttribute("conteudo", "editar_boletim.jsp"); //verificar
			
				getServletContext().getRequestDispatcher("/editar_boletim.jsp").forward(request, response);
			}
	}
		
	private void obterBoletimTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strIndiceTurma = request.getParameter("idTurma");
		int indiceTurma = Integer.parseInt(strIndiceTurma);
		
		String strIndiceDisciplina = request.getParameter("idDisciplina");
		int indiceDisciplina = Integer.parseInt(strIndiceDisciplina);
		
		//obtem a lista de todo os boletins armazenados no banco
		BoletimDao boletimDao = new BoletimDao();
		List<Boletim> boletins = boletimDao.obterBoletinsTurma(indiceTurma,indiceDisciplina); //teste		
		
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
		request.setAttribute("conteudo", "boletim_turma.jsp"); //verificar
		getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);		
		
	}
	
	private void atualizarBoletim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {    
			
			String strIndiceBoletim = request.getParameter("idBoletim");
			String strIndiceDisciplina = request.getParameter("idDisciplina");
			String strNota = request.getParameter("nota");
			String strFaltas = request.getParameter("faltas");
			
			int indiceBoletim = Integer.parseInt(strIndiceBoletim);
			int indiceDisciplina = Integer.parseInt(strIndiceDisciplina);
			int faltas = Integer.parseInt(strFaltas);
			float nota = Float.parseFloat(strNota);
			
			
	        Boletim boletim = new Boletim();
	        boletim.setID(indiceBoletim);
	        
	        Disciplina disciplina = new Disciplina();
	        
	        disciplina.setID(indiceDisciplina);
	        
	        Compoe compoe = new Compoe();
	        
	        compoe.setBoletim(boletim);
	        compoe.setDisciplina(disciplina);
	        compoe.setNota(nota);
	        compoe.setFaltas(faltas);
	        
	        System.out.println("Recebido"+compoe);
	        
	        BoletimDao boletimDao = new BoletimDao();
	        
	        
                  
	        boolean sucesso = false;
	        
	        sucesso = boletimDao.atualizaBoletim(compoe);
	         
	        if (sucesso)
	        {
	          //requisição foi bem sucedida, vamos finaliza-la e redirecionar o usuario para outro servlet
	          response.sendRedirect(getServletContext().getContextPath() + "/boletim_turma.jsp");                            
	        }
	        else
	        {
	          request.setAttribute("mensagemErro", "Não foi possível salvar dados do aluno.");
	          getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	      }
	    catch (Exception e) {
	      request.setAttribute("mensagemErro", "Informações do aluno estão inválidas.");
	      getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	    }

	}
	
	private void inserirBoletim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {    
			
			String strIndiceAluno = request.getParameter("idAluno");
			String strIndiceBimestre = request.getParameter("idBimestre");
			
			
			int indiceAluno = Integer.parseInt(strIndiceAluno);
			int indiceBimestre = Integer.parseInt(strIndiceBimestre);
						
			Boletim boletim = new Boletim();
	        boletim.setBimestre(indiceBimestre);
	        
	        Aluno aluno = new Aluno();
	        aluno.setID(indiceAluno);
	        
	        Inserido inserido = new Inserido();
	        inserido.setAluno(aluno);
	        inserido.setBoletim(boletim);
	        
	        BoletimDao boletimDao = new BoletimDao();
                  
	        boolean sucesso = false;
	        
	        sucesso = boletimDao.insereBoletim(inserido);
	         
	        if (sucesso)
	        {
	          //requisição foi bem sucedida, vamos finaliza-la e redirecionar o usuario para outro servlet
	          response.sendRedirect(getServletContext().getContextPath() + "/inserir_boletim.jsp");                            
	        }
	        else
	        {
	          request.setAttribute("mensagemErro", "Não foi possível salvar boletim");
	          getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	        }
	      }
	    catch (Exception e) {
	      request.setAttribute("mensagemErro", "Informações do boletim estão inválidas.");
	      getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	    }

	}
	
}



package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.vo.Boletim;
import edu.gaed.vo.Compoe;
import edu.gaed.vo.Disciplina;

/**
 * Servlet implementation class BoletimServlet
 */
@WebServlet({ "/BoletimServlet", "/ObterBoletim", "/EditarBoletim", "/SalvarBoletim" })
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
		
		if (request.getServletPath().equals("/SalvarBoletim"))
		{
			salvarBoletim(request, response);
		}
		
		
		else if (request.getServletPath().equals("/ObterBoletim"))
		{
			obterBoletim(request, response);
		}
				
		else if (request.getServletPath().equals("/EditarBoletim"))
		{
			//removerEntidade(request, response);
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
			
			System.out.println(boletim);
				
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
	
	private void salvarBoletim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		        
		        BoletimDao boletimDao = new BoletimDao();
		        
		        
	                  
		        boolean sucesso = false;
		        
		        sucesso = boletimDao.atualizaBoletim(compoe);
		         
		        if (sucesso)
		        {
		          //requisição foi bem sucedida, vamos finaliza-la e redirecionar o usuario para outro servlet
		          response.sendRedirect(getServletContext().getContextPath() + "/ObterBoletim");                            
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
	
}



package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.BoletimDao;
import edu.gaed.modelo.Boletim;

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
        // TODO Auto-generated constructor stub
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
		
		System.out.println(indiceDisciplina);
		
		String erro = null;
		
		BoletimDao boletimDao = new BoletimDao();
		
		//obtem contato e envia usuario para formulario de edição do contato
		Boletim boletim = (Boletim) boletimDao.obterBoletim(indiceAluno, indiceBoletim,indiceDisciplina);
				
				
		//se nao houver agenda ou indice contato não estiver na agenda, informa erro
		if (boletim == null)
		{
			erro = "Boletim não encontrado.";
		}
		else
		{			
			//seta contato no escopo de requisição para ser exibido pelo jsp 
			request.setAttribute("boletim", boletim);
		}
		
		if (erro != null)
		{
			//se houver erro, envia o usuario de volta para a página de agenda
		
			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/boletim_turma.jsp").forward(request, response);
		}
		else
		{
			System.out.println(boletim);
			request.setAttribute("conteudo", "editar_boletim.jsp"); //verificar
			
			getServletContext().getRequestDispatcher("/editar_boletim.jsp").forward(request, response);
		}
	}
	
	private void salvarBoletim(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boletim boletim = (Boletim) request.getAttribute("boletim");
		//int faltas = (int)request.getAttribute("faltas");
		//float nota = (float)request.getAttribute("nota");
				
		//String confirmaSenha = request.getParameter("confirmasenha");
		String erro = null;
		
		//se não existir usuario, retorna para página de cadastro
		if (boletim == null)
		{
			erro = "Favor informar notas ou faltas do boletim.";						
		}
		else
		{
			//se não houver erro, salva usuario
			if (erro == null)
			{
				BoletimDao boletimDao = new BoletimDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisição, altera usuario. caso contrário, insere
				//este valor é definido em usuarios.jsp
				if (boletim.getID() == 0)
				{
					System.out.println(boletim);
					sucesso = boletimDao.atualizaBoletim(boletim);
				}
				else
				{
					sucesso = boletimDao.atualizaBoletim(boletim);
					/*
					//se o usuario for o mesmo logado, atualiza dados do usuario na sessão.
					Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("login");					
					if (usuarioLogado.getId() == doador.getId())
					{
						request.getSession().setAttribute("login", doador);
					}*/
				}
				
				if (!sucesso)
				{
					erro = "Não foi possível salvar doador.";
				}
			}
		}
		
		if (erro != null)
		{
			//se houver erro, encaminha para página de cadastro

			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/usuario.jsp").forward(request, response);			
		}
		else
		{
			//caso contrario, redireciona para agenda

			response.sendRedirect(getServletContext().getContextPath() + "/ListaDoadoresServlet");
		}
	}

}

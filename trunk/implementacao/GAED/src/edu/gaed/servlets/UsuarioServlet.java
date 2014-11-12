package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.AlunoDao;
import edu.gaed.dao.ProfessorDao;
import edu.gaed.dao.ResponsavelDao;
import edu.gaed.dao.UsuarioDao;
import edu.gaed.vo.Aluno;
import edu.gaed.vo.Professor;
import edu.gaed.vo.Responsavel;
import edu.gaed.vo.Usuario;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet({ "/UsuarioServlet","/SalvarUsuario","/ObterUsuario","/ObterProfessor","/SalvarResponsavel","/SalvarAluno"})
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getServletPath().equals("/ObterUsuario"))
		{		
			obterUsuario(request, response);
		
		}
		else if (request.getServletPath().equals("/SalvarUsuario"))
		{		
			salvarUsuario(request, response);
		
		}
		else if (request.getServletPath().equals("/SalvarResponsavel"))
		{		
			salvarResponsavel(request, response);
		
		}
		else if (request.getServletPath().equals("/SalvarAluno"))
		{		
			salvarAluno(request, response);
		
		}
		else if (request.getServletPath().equals("/ObterProfessor"))
		{		
			obterProfessor(request, response);
		
		}
		
	}
	
	private void obterUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String strIndiceUsuario = request.getParameter("id");
			int indiceUsuario = Integer.parseInt(strIndiceUsuario);
			String erro = null;
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			//obtem contato e envia usuario para formulario de edição do contato
			Usuario usuario = (Usuario) usuarioDao.obterUsuario(indiceUsuario);
					
					
			//se nao houver agenda ou indice contato não estiver na agenda, informa erro
			if (usuario == null)
			{
				erro = "Contato não encontrado.";
			}
			else
			{			
				//seta contato no escopo de requisição para ser exibido pelo jsp 
				request.setAttribute("usuario", usuario);
			}
			
			if (erro != null)
			{
				//se houver erro, envia o usuario de volta para a página de agenda
			
				request.setAttribute("mensagem_erro", erro);
				getServletContext().getRequestDispatcher("/agenda.jsp").forward(request, response);
			}
			else
			{
				//caso contrário, encaminha usuario para a página de cadastro de contato
				
				//getServletContext().getRequestDispatcher("/cadastrar_Usuario.jsp").forward(request, response);
				
				request.setAttribute("conteudo", "cadastrar_usuario.jsp");
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	
	private void salvarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		
		String senha = request.getParameter("senha");
		
		String erro = null;
		
		//se não existir usuario, retorna para página de cadastro
		if (usuario == null)
		{
			erro = "Favor informar dados do Usuario.";						
		}
		else
		{
			//se não houver erro, salva Usuario
			if (erro == null)
			{
				UsuarioDao UsuarioDao = new UsuarioDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisição, altera usuario. caso contrário, insere
				//este valor é definido em usuarios.jsp
				if (usuario.getId() == 0)
				{
					sucesso = UsuarioDao.insereUsuario(usuario,senha);
				}
				/* Implementar depois
				else
				{
					sucesso = UsuarioDao.atualizaUsuario(Usuario);
					
					//se o usuario for o mesmo logado, atualiza dados do usuario na sessão.
					Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("login");					
					if (usuarioLogado.getId() == Usuario.getId())
					{
						request.getSession().setAttribute("login", Usuario);
					}
				}*/
				
				if (!sucesso)
				{
					erro = "Não foi possível salvar usuario.";
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

			response.sendRedirect(getServletContext().getContextPath() + "/ListaUsuariosServlet");
		}
	}
	
	private void salvarResponsavel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Responsavel responsavel = (Responsavel) request.getAttribute("responsavel");
		
		String senha = request.getParameter("senha");
		
		String erro = null;
		
		//se não existir responsavel, retorna para página de cadastro
		if (responsavel == null)
		{
			erro = "Favor informar dados do Responsavel.";						
		}
		else
		{
			//se não houver erro, salva Responsavel
			if (erro == null)
			{
				ResponsavelDao ResponsavelDao = new ResponsavelDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisição, altera responsavel. caso contrário, insere
				//este valor é definido em responsavels.jsp
				if (responsavel.getId() == 0)
				{
					sucesso = ResponsavelDao.insereResponsavel(responsavel,senha);
				}
				/* Implementar depois
				else
				{
					sucesso = ResponsavelDao.atualizaResponsavel(Responsavel);
					
					//se o responsavel for o mesmo logado, atualiza dados do responsavel na sessão.
					Responsavel responsavelLogado = (Responsavel) request.getSession().getAttribute("login");					
					if (responsavelLogado.getId() == Responsavel.getId())
					{
						request.getSession().setAttribute("login", Responsavel);
					}
				}*/
				
				if (!sucesso)
				{
					erro = "Não foi possível salvar responsavel.";
				}
			}
		}
		
		if (erro != null)
		{
			//se houver erro, encaminha para página de cadastro

			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/responsavel.jsp").forward(request, response);			
		}
		else
		{
			//caso contrario, redireciona para agenda

			response.sendRedirect(getServletContext().getContextPath() + "/ListaResponsavelsServlet");
		}
	}
	
	private void salvarAluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Aluno aluno = (Aluno) request.getAttribute("aluno");
		
		String senha = request.getParameter("senha");
		
		String erro = null;
		
		//se não existir aluno, retorna para página de cadastro
		if (aluno == null)
		{
			erro = "Favor informar dados do Aluno.";						
		}
		else
		{
			//se não houver erro, salva Aluno
			if (erro == null)
			{
				AlunoDao AlunoDao = new AlunoDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisição, altera aluno. caso contrário, insere
				//este valor é definido em alunos.jsp
				if (aluno.getId() == 0)
				{
					sucesso = AlunoDao.insereAluno(aluno,senha);
				}
				/* Implementar depois
				else
				{
					sucesso = AlunoDao.atualizaAluno(Aluno);
					
					//se o aluno for o mesmo logado, atualiza dados do aluno na sessão.
					Aluno alunoLogado = (Aluno) request.getSession().getAttribute("login");					
					if (alunoLogado.getId() == Aluno.getId())
					{
						request.getSession().setAttribute("login", Aluno);
					}
				}*/
				
				if (!sucesso)
				{
					erro = "Não foi possível salvar aluno.";
				}
			}
		}
		
		if (erro != null)
		{
			//se houver erro, encaminha para página de cadastro

			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/aluno.jsp").forward(request, response);			
		}
		else
		{
			//caso contrario, redireciona para agenda

			response.sendRedirect(getServletContext().getContextPath() + "/ListaAlunosServlet");
		}
	}
	
	private void obterProfessor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("login"); //colocado pelo professor
		
		ProfessorDao professorDao = new ProfessorDao();
		Professor professor = professorDao.obterProfessor(usuario.getId());		
					
		request.setAttribute("professor", professor);
			
		getServletContext().getRequestDispatcher("/boletim.jsp").forward(request, response);
	}
	
}


package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.UsuarioDao;
import edu.gaed.vo.Usuario;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet({ "/UsuarioServlet","/SalvarUsuario","/ObterUsuario","/RemoverUsuario","/ObterDoador","/SalvarDoador","/RemoverDoador"})
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getServletPath().equals("/ObterUsuario"))
		{		
			obterUsuario(request, response);
		
		}
		else if (request.getServletPath().equals("/SalvarUsuario"))
		{		
			salvarUsuario(request, response);
		
		}
	}
	
	private void obterUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String strIndiceUsuario = request.getParameter("id");
			System.out.println(strIndiceUsuario);
			int indiceUsuario = Integer.parseInt(strIndiceUsuario);
			String erro = null;
			
			UsuarioDao usuarioDao = new UsuarioDao();
			
			//obtem contato e envia usuario para formulario de edi��o do contato
			Usuario usuario = (Usuario) usuarioDao.obterUsuario(indiceUsuario);
					
					
			//se nao houver agenda ou indice contato n�o estiver na agenda, informa erro
			if (usuario == null)
			{
				erro = "Contato n�o encontrado.";
			}
			else
			{			
				//seta contato no escopo de requisi��o para ser exibido pelo jsp 
				request.setAttribute("usuario", usuario);
			}
			
			if (erro != null)
			{
				//se houver erro, envia o usuario de volta para a p�gina de agenda
			
				request.setAttribute("mensagem_erro", erro);
				getServletContext().getRequestDispatcher("/agenda.jsp").forward(request, response);
			}
			else
			{
				//caso contr�rio, encaminha usuario para a p�gina de cadastro de contato
				
				//getServletContext().getRequestDispatcher("/cadastrar_Usuario.jsp").forward(request, response);
				
				request.setAttribute("conteudo", "cadastrar_usuario.jsp");
				
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
	
	private void salvarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) request.getAttribute("usuario");
		
		String senha = request.getParameter("senha");
		
		String erro = null;
		
		//se n�o existir usuario, retorna para p�gina de cadastro
		if (usuario == null)
		{
			erro = "Favor informar dados do Usuario.";						
		}
		else
		{
			//se n�o houver erro, salva Usuario
			if (erro == null)
			{
				UsuarioDao UsuarioDao = new UsuarioDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisi��o, altera usuario. caso contr�rio, insere
				//este valor � definido em usuarios.jsp
				if (usuario.getId() == 0)
				{
					sucesso = UsuarioDao.insereUsuario(usuario,senha);
				}
				/* Implementar depois
				else
				{
					sucesso = UsuarioDao.atualizaUsuario(Usuario);
					
					//se o usuario for o mesmo logado, atualiza dados do usuario na sess�o.
					Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("login");					
					if (usuarioLogado.getId() == Usuario.getId())
					{
						request.getSession().setAttribute("login", Usuario);
					}
				}*/
				
				if (!sucesso)
				{
					erro = "N�o foi poss�vel salvar usuario.";
				}
			}
		}
		
		if (erro != null)
		{
			//se houver erro, encaminha para p�gina de cadastro

			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/usuario.jsp").forward(request, response);			
		}
		else
		{
			//caso contrario, redireciona para agenda

			response.sendRedirect(getServletContext().getContextPath() + "/ListaUsuariosServlet");
		}
	}
}


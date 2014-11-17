package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.OcorrenciaDao;
import edu.gaed.vo.Ocorrencia;

/**
 * Servlet implementation class OcorrenciaServlet
 */
@WebServlet({"/OcorrenciaServlet","/InserirOcorrencia"})
public class OcorrenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OcorrenciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getServletPath().equals("/InserirOcorrencia"))
		{		
			inserirOcorrencia(request, response);
		
		}
	}
	
	private void inserirOcorrencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String indiceAluno = request.getParameter("aluno");
        String assunto = request.getParameter("assunto");
        String descricao = request.getParameter("descricao");
        String data = request.getParameter("data");
	    		
		Ocorrencia ocorrencia = new Ocorrencia();
		
		Integer idAluno = (Integer) Integer.parseInt(indiceAluno);
		ocorrencia.setAssunto(assunto);
		ocorrencia.setDescricao(descricao);
		ocorrencia.setData(data);
		
		
		String erro = null;
		
		//se não existir usuario, retorna para página de cadastro
		if (idAluno == null)
		{
			erro = "Favor informar aluno";						
		}
		else
		{
			//se não houver erro, salva a ocorrencia
			if (erro == null)
			{
				OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
				boolean sucesso = false;
				
				//se houver indice definido na requisição, altera usuario. caso contrário, insere
				//este valor é definido em usuarios.jsp
				if (ocorrencia.getID() == 0)
				{
					sucesso = ocorrenciaDao.insereOcorrencia(idAluno, ocorrencia);
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
					erro = "Não foi possível salvar ocorrencia.";
				}
			}
		}
		
		if (erro != null)
		{
			//se houver erro, encaminha para página de cadastro

			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/erro.jsp").forward(request, response);			
		}
		else
		{
			//caso contrario, redireciona para agenda

			response.sendRedirect(getServletContext().getContextPath() + "/ListaUsuariosServlet");
		}
	}

}

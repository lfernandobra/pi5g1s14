package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.AlunoDao;
import edu.gaed.dao.EstudaDao;
import edu.gaed.dao.OcorrenciaDao;
import edu.gaed.vo.Aluno;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Ocorrencia;
import edu.gaed.vo.Recebe;

/**
 * Servlet implementation class OcorrenciaServlet
 */
@WebServlet({"/OcorrenciaServlet","/InserirOcorrencia","/ObterOcorrencia","/ObterOcorrenciasAluno","/AtualizaOcorrencia"})
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
		
		}else if(request.getServletPath().equals("/ObterOcorrencia")){
			
			obterOcorrencia(request, response);
		}
		
		else if(request.getServletPath().equals("/ObterOcorrenciasAluno")){
		
			obterOcorrenciasAluno(request, response);
		}
		
		else if(request.getServletPath().equals("/AtualizaOcorrencia")){
		
			atualizarOcorrencia(request, response);
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
		System.out.println(idAluno);
		
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
			request.setAttribute("conteudo", "/sucesso.jsp");
        	request.setAttribute("sucesso", "Ocorrência registrada com sucesso.");
        	getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}
	
	private void obterOcorrencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strIndiceAluno = request.getParameter("idAluno");
		int indiceAluno = Integer.parseInt(strIndiceAluno);
		
		String strIndiceOcorrencia = request.getParameter("idOcorrencia");
		int indiceOcorrencia = Integer.parseInt(strIndiceOcorrencia);
		
		String erro = null;
		
		OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
		
		//obtem contato e envia usuario para formulario de edição do contato
		Ocorrencia ocorrencia = (Ocorrencia) ocorrenciaDao.obterOcorrencia(indiceAluno, indiceOcorrencia);
				
				
		//se nao houver agenda ou indice contato não estiver na agenda, informa erro
		if (ocorrencia == null)
		{
			erro = "Ocorrência não encontrada.";
		}
		else
		{			
			//seta contato no escopo de requisição para ser exibido pelo jsp 
			request.setAttribute("ocorrencia", ocorrencia);
		}
		
		if (erro != null)
		{
			//se houver erro, envia o usuario de volta para a página de agenda
		
			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/agenda_ocorrencias.jsp").forward(request, response);
		}
		else
		{
			//caso contrário, encaminha usuario para a página de cadastro de contato
			
			//getServletContext().getRequestDispatcher("/cadastrar_Usuario.jsp").forward(request, response);
			
			request.setAttribute("conteudo", "editar_ocorrencia.jsp");
			
			getServletContext().getRequestDispatcher("/editar_ocorrencia.jsp").forward(request, response);
		}
	}
	
	private void atualizarOcorrencia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {    
			
			String strIndiceOcorrencia = request.getParameter("idOcorrencia");
			String strAssunto = request.getParameter("assunto");
			String strDescricao = request.getParameter("descricao");
			String strData = request.getParameter("data");
			
			int indiceOcorrencia = Integer.parseInt(strIndiceOcorrencia);
						
	        Ocorrencia ocorrencia = new Ocorrencia();
	        
			ocorrencia.setID(indiceOcorrencia);
			ocorrencia.setAssunto(strAssunto);
			ocorrencia.setDescricao(strDescricao);
			ocorrencia.setData(strData);
			      
			System.out.println(ocorrencia.getAssunto());
			
	        OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
	        	                         
	        boolean sucesso = false;
	        
	        sucesso = ocorrenciaDao.atualizaOcorrencia(ocorrencia);
	         
	        if (sucesso)
	        {
	          //requisição foi bem sucedida, vamos finaliza-la e redirecionar o usuario para outro servlet
	          response.sendRedirect(getServletContext().getContextPath() + "/agenda_ocorrencias.jsp");                            
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
	
	private void obterOcorrenciasAluno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strIndiceUsuario = request.getParameter("idUsuario");
										
		int indiceUsuario = Integer.parseInt(strIndiceUsuario);
						
		String erro = null;
	
		OcorrenciaDao ocorrenciaDao = new OcorrenciaDao();
		AlunoDao alunoDao = new AlunoDao();
		EstudaDao estudaDao = new EstudaDao();
	
		List<Recebe> listaocorrencias = ocorrenciaDao.obterOcorrenciasAluno(indiceUsuario);
		Aluno aluno = alunoDao.obterAluno(indiceUsuario);
		Estuda estudaTurma = estudaDao.obterComposicao(indiceUsuario);
			
		//se nao houver agenda ou indice contato não estiver na agenda, informa erro
		if (listaocorrencias == null)
		{
			erro = "Ocorrências não encontradas.";
		}
		else
		{			 
			request.setAttribute("ocorrencias", listaocorrencias);
			request.setAttribute("aluno", aluno);
			request.setAttribute("estudaTurma", estudaTurma);
		}
	
		if (erro != null)
		{
			request.setAttribute("mensagem_erro", erro);
			getServletContext().getRequestDispatcher("/ocorrencias_aluno.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("conteudo", "/ocorrencias_aluno.jsp");
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		}
	}
	

}

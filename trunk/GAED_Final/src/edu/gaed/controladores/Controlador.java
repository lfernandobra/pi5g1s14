package edu.gaed.controladores;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Livro;
import modelos.LivroDAO;

@WebServlet({ "/Controlador", "/controlador" })

public class Controlador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Controlador() {
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	processaRequisicao(request, response);
    	
    }
    
    private void processaRequisicao(HttpServletRequest request, HttpServletResponse response) {
    	
    	String metodo = request.getParameter("nmmetodo");
    	
    	if (metodo.equals("resp_incluir")) {
    		
    		//Instancia o objeto livro com os valores que estão vindo pela requisição
    		Responsavel resp = new Responsavel();
    		livro.setIsbn( request.getParameter("nmisbn") );
    		livro.setTitulo( request.getParameter("nmtitulo") );
    		livro.setAutor( request.getParameter("nmautor") );
    		//int ano = Integer.parseInt(request.getParameter("nmano"));
    		//livro.setAno(ano);

    		//Prepara a sessão para mostrar as informações de sucesso da operação
    		HttpSession sessao = request.getSession(true);
    		
    		//Instancia o objeto livroDAO para lidar com a inclusão do objeto livro na tabela livros do banco de dados dbbiblioteca
    		LivroDAO livroDAO = new LivroDAO();
    		try {
    			
    			livroDAO.inclui(livro);
    			
    			sessao.setAttribute("mensagem", "Livro incluído com sucesso!");
    			
    			livroDAO.listar();
    			
    			
    			//livroDAO.excluir(); Verificar depois
    			
    		} catch (Exception e) {

    			sessao.setAttribute("mensagem", e.getMessage());
    			
    		} finally {
    			
    			sessao.setAttribute("objLivro", livro);
        		RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
    			
        		try {
    			
        			dispatcher.forward(request, response);
    			
        		} catch (ServletException | IOException e) {
    			
    				e.printStackTrace();
    			
        		}
    			
    		}
    		

    	}
    	
    }

}

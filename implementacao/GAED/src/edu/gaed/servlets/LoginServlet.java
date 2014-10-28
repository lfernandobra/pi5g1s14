package edu.gaed.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.UsuarioDao;
import edu.gaed.modelo.Usuario;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	  private static final long serialVersionUID = 1L;

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //obtem parâmetros da requisição
	    String login = request.getParameter("login");
	    String senha = request.getParameter("senha");

	    //verifica os valores dos parâmetros da requisição
	    if (login == null || login.isEmpty() || senha == null || senha.isEmpty())
	    {
	      //em caso de erro, grava mensagem de erro na requisição e retorna para página inicial
	      String mensagem = "Login ou senha inválidos!";
	      request.setAttribute("mensagemErro", mensagem);
	      getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	    }
	    else
	    {
	      UsuarioDao usuarioDao = new UsuarioDao();
	      Usuario usuario = usuarioDao.obterUsuario(login, senha);
	      
	      System.out.println(usuario);
	      
	      if (usuario != null)
	      {
	        request.getSession().setAttribute("login", usuario);
	        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	      }
	      else
	      {
	        String mensagem = "Login ou senha inválidos!";
	        request.setAttribute("mensagemErro", mensagem);
	        
	        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	      }
	    }
	  }
	}

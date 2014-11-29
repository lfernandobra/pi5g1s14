package edu.gaed.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.gaed.dao.AlunoDao;
import edu.gaed.dao.UsuarioDao;
import edu.gaed.vo.Estuda;
import edu.gaed.vo.Usuario;


/**
 * Servlet implementation class ListaUsuariosServlet
 */
@WebServlet({"/ListaUsuariosServlet","/ListaAlunosServlet"})
public class ListaUsuariosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUsuariosServlet() {
        super();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if (request.getServletPath().equals("/ListaUsuariosServlet"))
		{		
			listaUsuarios(request, response);
		
		}
		else if (request.getServletPath().equals("/ListaAlunosServlet"))
		{		
			listaAlunos(request, response);
		
		}
	}	
	
	private void listaUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtem a lista de contatos do banco com base no identificador do usuario
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.obterUsuarios();
					
					
		//coloca agenda no escopo de requisição para ser exibido no agenda.jsp
		request.setAttribute("usuarios", usuarios);
		
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/agenda_usuarios.jsp").forward(request, response);
	}
	
	private void listaAlunos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtem a lista de contatos do banco com base no identificador do usuario
		
		AlunoDao alunoDao = new AlunoDao();
		List<Estuda> alunos = alunoDao.obterAlunos();
		
					
					
		//coloca agenda no escopo de requisição para ser exibido no agenda.jsp
		request.setAttribute("alunos", alunos);
		
		//encaminha para agenda_entidades.jsp exibir a agenda
		getServletContext().getRequestDispatcher("/agenda_alunos.jsp").forward(request, response);
	}

}

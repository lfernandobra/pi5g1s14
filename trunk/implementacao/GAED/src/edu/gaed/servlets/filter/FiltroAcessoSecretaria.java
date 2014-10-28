package edu.gaed.servlets.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.gaed.modelo.Usuario;

/**
 * Servlet Filter implementation class FiltroAcessoSecretaria
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST }
					, 
		urlPatterns = { 
				"/FiltroAcessoSecretaria", 
				"/agenda_usuarios"
		}, 
		servletNames = { 
				"ListaUsuariosServlet", 
				"UsuarioServlet"
		})
public class FiltroAcessoSecretaria implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroAcessoSecretaria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        HttpSession session = req.getSession();

        if(session.getAttribute("login") != null) {
          Usuario usuario = (Usuario) session.getAttribute("login");
          
          if (!usuario.getPerfil().isProfessor())  {            
            res.sendRedirect(req.getServletContext().getContextPath() + "/index.jsp");
          }
        }else{
            // passa a requisição adiante
            chain.doFilter(request, response);}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

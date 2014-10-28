package edu.gaed.servlets.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;


/**
 * Servlet Filter implementation class FiltroAutenticacao
 */
@WebFilter("/FiltroAutenticacao")
public class FiltroAutenticacao implements Filter {
	 
    //private ServletContext context;
     
    public void init(FilterConfig fConfig) throws ServletException {
    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
         
        //obtem URL requisitada
        String uri = req.getRequestURI();
         
        HttpSession session = req.getSession(false);
         
        if(session == null && !(uri.endsWith("html") || uri.endsWith("LoginServlet") || uri.endsWith("index.jsp"))){
            res.sendRedirect("login.jsp");
        }else{
            // passa a requisição adiante
            chain.doFilter(request, response);
        }
    }
 
    public void destroy() {
        //close any resources here
    } 
}


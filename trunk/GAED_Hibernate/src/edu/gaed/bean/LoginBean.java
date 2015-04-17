package edu.gaed.bean;
 
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.gaed.dao.LoginDao;
import edu.gaed.vo.Usuario;
 
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
     
	private Usuario usuario = new Usuario();
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}     
    
 
    public String verificarDatos() throws Exception {
    	LoginDao usuDAO = new LoginDao();
    	Usuario us;
    	String resultado;
    	
    	try {
    		us = usuDAO.verificaDados(this.usuario);
    		if(us != null) {
    			FacesContext.getCurrentInstance().getExternalContext()
    					.getSessionMap().put("usuario",us);
    			resultado = "login";
    		} else { resultado = "home";}
    	} catch (Exception e) {
    		throw e;
    	}
    	
    	return resultado;
    }
    
    public String encerrarSession(){
    	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    	return "index?faces-redirect=true";
    }
    
    
}
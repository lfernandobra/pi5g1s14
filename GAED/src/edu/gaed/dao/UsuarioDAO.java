package edu.gaed.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import edu.gaed.vo.Usuario;

public class UsuarioDAO extends DAO {
	
	EntityManager em = getEntityManager();
	
	public Usuario procure(String chave) {
		
		Usuario usr = em.find(Usuario.class, chave);
		em.close();
		return usr;
	
	}

	public boolean valideUsuario(Usuario usr, String senha) {
	
		boolean validado = false;
		
		if( senha.equals( usr.getSenha() ) ){
			validado = true;
		}
		 else {
		      /* Cria uma mensagem. */
		      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
		      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
		      FacesContext.getCurrentInstance().addMessage("erro", msg);
		      return validado;
		    }
		
		return validado;
		
	}
		
}

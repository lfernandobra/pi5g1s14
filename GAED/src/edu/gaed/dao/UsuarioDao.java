package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;

import edu.gaed.vo.Usuario;
 
public abstract class UsuarioDao extends DAO{      
	
	//protected EntityManager em = JPAUtil.getEntityManager();
	protected List<Usuario> usuarios;
	protected Usuario usuario;
	//getters and setters
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public UsuarioDao(EntityManager em, List<Usuario> usuarios) {
		super();
		this.em = em;
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}	

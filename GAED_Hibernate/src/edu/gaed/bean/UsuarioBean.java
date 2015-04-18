package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Usuario;
import edu.gaed.dao.UsuarioDao;
 
@ManagedBean(name="UsuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Usuario usuario = new Usuario();
	 
	List<Usuario> usuarios = new ArrayList<Usuario>(); 
	
	public UsuarioBean(Usuario usuario, List<Usuario> usuarios) {
		super();
		this.usuario = new Usuario();
		this.usuarios = new ArrayList<Usuario>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public UsuarioBean(){
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
       
    }
	public String getUsuarioEscolhida(){
        return usuario!=null && usuario.getId()!=null ? usuario.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new UsuarioDao().inserir(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Usuario usuario){
		new UsuarioDao().alterar(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new UsuarioDao().excluir(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
 
	//getters and setters
	
 
	
}

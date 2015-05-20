package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FileUploadEvent;
import edu.gaed.vo.Usuario;
import edu.gaed.dao.UsuarioDao;

@ManagedBean(name = "UsuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Usuario usuario = new Usuario();
	Set<Usuario> usuarios = new HashSet<Usuario>();
	FotoBean fotoBean = new FotoBean();
	
	public UsuarioBean(Usuario usuario, Set<Usuario> usuarios) {
		super();
		this.usuario = new Usuario();
		this.usuarios = new HashSet<Usuario>();
	}

	// construtor
	@SuppressWarnings("unchecked")
	public UsuarioBean() {
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();

	}

	public String getUsuarioEscolhida() {
		return usuario != null && usuario.getId() != null ? usuario.toString()
				: "Classe não escolhida";
	}

	// Métodos dos botões
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent,FileUploadEvent event) {
		new UsuarioDao().inserir(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new UsuarioDao().alterar(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Usuario usuario) {
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
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}

}

package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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

	private UploadedFile file;

	List<Usuario> usuarios = new ArrayList<Usuario>();

	public UsuarioBean(Usuario usuario, List<Usuario> usuarios) {
		super();
		this.usuario = new Usuario();
		this.usuarios = new ArrayList<Usuario>();
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
	public void cadastrar(ActionEvent actionEvent) {
		new UsuarioDao().inserir(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	public void alterar(Usuario usuario) {
		new UsuarioDao().alterar(usuario);
		usuarios = new UsuarioDao().listar();
		usuario = new Usuario();
	}

	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent) {
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	// getters and setters
	public void fileUpload(FileUploadEvent event) throws IOException {
		try {
			// Instância objetos
			
			// Cria um arquivo UploadFile, para receber o arquivo do evento
			UploadedFile arq = event.getFile();
			// Transformar a imagem em bytes para salvar em banco de dados
			byte[] bimagem = event.getFile().getContents();
			
			usuario.setFoto(bimagem);
			FacesMessage msg = new FacesMessage("O Arquivo ", arq.getFileName()
					+ " salvo em banco de dados.");
			FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

package edu.gaed.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.event.FileUploadEvent;

import edu.gaed.util.TransformaStringMD5;
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
	List<Usuario> usuarios = new ArrayList<Usuario>();
	FotoBean fotoBean = new FotoBean();

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
				: "Classe nï¿½o escolhida";
	}

	// Mï¿½todos dos botï¿½es
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent, FileUploadEvent event) {
		String senhaSCript = senhaMD5(usuario.getSenha());
		usuario.setSenha(senhaSCript);

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

	public String verificarDatos() throws Exception {
		UsuarioDao usuDAO = new UsuarioDao();
		Usuario us;
		String resultado;

		try {
			// Enviando la encriptacion
			String encript = DigestUtils.md5Hex(this.usuario.getSenha());
			// String encript = DigestUtils.sha1Hex(this.usuario.getSenha());
			this.usuario.setSenha(encript);

			us = usuDAO.verificarDatos(this.usuario);
			if (us != null) {

				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("usuario", us);

				resultado = "home"; // recalcar que el faces-redirect=true,
									// olvida la peticion anterior y se
									// dirige a la vista
				System.out.println("Encontrado");
			} else {
				resultado = "login";
				System.out.println("Não Encontrado");
			}
		} catch (Exception e) {
			throw e;
		}

		return resultado;
	}

	public boolean verificarSesion() {
		boolean estado;

		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("usuario") == null) {
			estado = false;
		} else {
			estado = true;
		}

		return estado;
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "index";
	}

	public String senhaMD5(String senha) {
		return TransformaStringMD5.md5(senha);
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

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}

	public String verFoto() {

		try {
			ServletContext sContext = (ServletContext) FacesContext
					.getCurrentInstance().getExternalContext().getContext();

			File folder = new File(sContext.getRealPath("/temp"));
			if (!folder.exists()) {
				folder.mkdirs();

			}
			String nomeArquivo = usuario.getNome() + ".png";
			String arquivo = sContext.getRealPath("/temp") + File.separator
					+ nomeArquivo;
			System.out.println(arquivo);
			System.out.println(usuario.getFoto().getFoto());
			criaArquivo(usuario.getFoto().getFoto(), arquivo);

			return nomeArquivo;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private void criaArquivo(byte[] bytes, String arquivo) {
		FileOutputStream fos;

		try {
			fos = new FileOutputStream(arquivo);
			fos.write(bytes);

			fos.flush();
			fos.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}

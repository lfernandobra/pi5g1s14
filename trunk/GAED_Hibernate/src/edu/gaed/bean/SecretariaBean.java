package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;

import edu.gaed.vo.Secretaria;
import edu.gaed.dao.SecretariaDao;

@ManagedBean(name = "SecretariaBean")
@ViewScoped
public class SecretariaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Secretaria secretaria = new Secretaria();
	Set<Secretaria> secretarias = new HashSet<Secretaria>();
	FotoBean fotoBean = new FotoBean();

	public SecretariaBean(Secretaria secretaria, Set<Secretaria> secretarias) {
		super();
		this.secretaria = new Secretaria();
		this.secretarias = new HashSet<Secretaria>();
	}

	// construtor
	@SuppressWarnings("unchecked")
	public SecretariaBean() {
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();

	}

	public String getSecretariaEscolhida() {
		return secretaria != null && secretaria.getId() != null ? secretaria
				.toString() : "Classe não escolhida";
	}

	// getters and setters

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}


	public Set<Secretaria> getSecretarias() {
		return secretarias;
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setSecretarias(Set<Secretaria> secretarias) {
		this.secretarias = secretarias;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}

	// Métodos dos botões
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent) {
		new SecretariaDao().inserir(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new SecretariaDao().alterar(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Secretaria secretaria) {
		new SecretariaDao().excluir(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	// Upload foto

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.fotoBean.fileUpload(event);
		this.secretaria.setFoto(this.fotoBean.getFoto());
	}

}

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

import edu.gaed.vo.Secretaria;
import edu.gaed.dao.SecretariaDao;

@ManagedBean(name = "SecretariaBean")
@ViewScoped
public class SecretariaBean extends UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Secretaria secretaria = new Secretaria();
	List<Secretaria> secretarias = new ArrayList<Secretaria>();
	FotoBean fotoBean = new FotoBean();

	public SecretariaBean(Secretaria secretaria, List<Secretaria> secretarias) {
		super();
		this.secretaria = new Secretaria();
		this.secretarias = new ArrayList<Secretaria>();
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
				.toString() : "Classe n�o escolhida";
	}

	// getters and setters

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public List<Secretaria> getSecretarias() {
		return secretarias;
	}

	public void setSecretarias(List<Secretaria> secretarias) {
		this.secretarias = secretarias;
	}

	// M�todos dos bot�es
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent) {
		String senhaSCript = senhaMD5(secretaria.getSenha());
		secretaria.setSenha(senhaSCript);
		secretaria.setStatus(true);
		new SecretariaDao().inserir(secretaria);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  " Secret�ria(o) " + secretaria.getNome() + "  cadastrada(o) com sucesso!") );
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new SecretariaDao().alterar(secretaria);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  " Secret�ria(o) " + secretaria.getNome() + "  Alterada(o) com sucesso!") );
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Secretaria secretaria) {
		new SecretariaDao().excluir(secretaria);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exclu�do", "Exclu�do com sucesso!") );
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	// Upload foto

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.fotoBean.fileUpload(event);
		this.secretaria.setFoto(this.fotoBean.getFoto());
	}

}

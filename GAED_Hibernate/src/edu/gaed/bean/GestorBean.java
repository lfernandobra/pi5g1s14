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

import edu.gaed.vo.Gestor;
import edu.gaed.dao.GestorDao;

@ManagedBean(name = "GestorBean")
@ViewScoped
public class GestorBean extends UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Gestor gestor = new Gestor();
	List<Gestor> gestors = new ArrayList<Gestor>();
	FotoBean fotoBean = new FotoBean();
	
	public GestorBean(Gestor gestor, List<Gestor> gestors) {
		super();
		this.gestor = new Gestor();
		this.gestors = new ArrayList<Gestor>();
	}

	// construtor
	@SuppressWarnings("unchecked")
	public GestorBean() {
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		gestors = new GestorDao().listar();
		gestor = new Gestor();

	}

	public String getGestorEscolhida() {
		return gestor != null && gestor.getId() != null ? gestor.toString()
				: "Classe n�o escolhida";
	}

	// M�todos dos bot�es
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent) {
		String senhaSCript = senhaMD5(gestor.getSenha());
		gestor.setSenha(senhaSCript);
		gestor.setStatus(true);
		new GestorDao().inserir(gestor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  " Gestor(a) " + gestor.getNome() + "  cadastrado(a) com sucesso!") );
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new GestorDao().alterar(gestor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  " Gestor(a) " + gestor.getNome() + "  alterado(a) com sucesso!") );
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Gestor gestor) {
		new GestorDao().excluir(gestor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Exclu�do", "Exclu�do com sucesso!") );
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public List<Gestor> getGestors() {
		return gestors;
	}

	public void setGestors(List<Gestor> gestors) {
		this.gestors = gestors;
	}

	// getters and setters

	// Upload foto

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.fotoBean.fileUpload(event);
		this.gestor.setFoto(this.fotoBean.getFoto());
	}

}

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

import edu.gaed.vo.Professor;
import edu.gaed.dao.ProfessorDao;

@ManagedBean(name = "ProfessorBean")
@ViewScoped
public class ProfessorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Professor professor = new Professor();
	List<Professor> professors = new ArrayList<Professor>();
	FotoBean fotoBean = new FotoBean();

	public ProfessorBean(Professor professor, List<Professor> professors) {
		super();
		this.professor = new Professor();
		this.professors = new ArrayList<Professor>();
	}

	// construtor
	@SuppressWarnings("unchecked")
	public ProfessorBean() {
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}
	
	// getters and setters
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	

	// Upload foto

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.fotoBean.fileUpload(event);
		this.professor.setFoto(this.fotoBean.getFoto());
	}

	// M�todos dos bot�es
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent) {
		new ProfessorDao().inserir(professor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  " Professor(a) " + professor.getNome() + "  cadastrado(a) com sucesso!") );
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new ProfessorDao().alterar(professor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  " Professor(a) " + professor.getNome() + "  alterado(a) com sucesso!") );
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Professor professor) {
		new ProfessorDao().excluir(professor);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluído", "Excluído com sucesso!") );
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}
}

package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
	Set<Professor> professors = new HashSet<Professor>();
	FotoBean fotoBean = new FotoBean();

	public ProfessorBean(Professor professor, List<Professor> professors) {
		super();
		this.professor = new Professor();
		this.professors = new HashSet<Professor>();
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

	public Set<Professor> getProfessors() {
		return professors;
	}

	@SuppressWarnings("unchecked")
	public void setProfessors(List<Professor> professors) {
		this.professors = (Set<Professor>) professors;
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
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new ProfessorDao().alterar(professor);
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Professor professor) {
		new ProfessorDao().excluir(professor);
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}
}

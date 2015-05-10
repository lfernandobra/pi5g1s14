package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;

import edu.gaed.vo.Disciplina;
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
	private List<Disciplina> selectedDisciplinas;
	private List<Disciplina> disciplinas;
	DisciplinaBean disciplinaBean = new DisciplinaBean();

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
		disciplinas = new ArrayList<Disciplina>();

		List<Disciplina> disciplinasBeanCadastradas = disciplinaBean.disciplinas;

		disciplinas = new ArrayList<Disciplina>(
				disciplinasBeanCadastradas.size());

		for (Disciplina d : disciplinasBeanCadastradas) {
			disciplinas.add(d);
		}
	}

	public String getProfessorEscolhida() {
		return professor != null && professor.getId() != null ? professor
				.toString() : "Classe não escolhida";
	}

	// getters and setters
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	// Upload foto

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.fotoBean.fileUpload(event);
		this.professor.setFoto(this.fotoBean.getFoto());
	}

	// Métodos dos botões
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

	public List<Disciplina> getSelectedDisciplinas() {
		return selectedDisciplinas;
	}

	public void setSelectedDisciplinas(List<Disciplina> selectedDisciplinas) {
		this.selectedDisciplinas = selectedDisciplinas;
		System.out.println(selectedDisciplinas.size());
		this.professor.setDisciplinas(selectedDisciplinas); 
		//Problema ocorre aqui, quando é atribuido o array de Disciplinas 
		//selecionado as disciplinas ministradas do professor 
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

}

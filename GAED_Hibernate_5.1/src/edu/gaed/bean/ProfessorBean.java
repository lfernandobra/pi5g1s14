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

//import edu.gaed.vo.Disciplina;
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
	//private List<Disciplina> disciplinas; //disciplinas relacionadas ao professor
	//private List<Disciplina> disciplinasCad; //disciplinas cadastradas no sistema
	//DisciplinaBean disciplinaBean = new DisciplinaBean();

	public ProfessorBean(Professor professor, List<Professor> professors) {
		super();
		this.professor = new Professor();
		this.professors = new ArrayList<Professor>();
	}

	// construtor
	@SuppressWarnings("unchecked")
	public ProfessorBean() {
		professors = new ProfessorDao().listarTudo();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		professors = new ProfessorDao().listarTudo();
		professor = new Professor();
		/*
		disciplinasCad = new ArrayList<Disciplina>(); 
		disciplinas = new ArrayList<Disciplina>(); 
		
		List<Disciplina> disciplinasBeanCadastradas = disciplinaBean.disciplinas;

		disciplinasCad = new ArrayList<Disciplina>(disciplinasBeanCadastradas.size());

		for (Disciplina d : disciplinasBeanCadastradas) {
			disciplinasCad.add(d);
		}*/
	}

	public String getProfessorEscolhida() {
		return professor != null && professor.getId() != null ? professor
				.toString() : "Classe n�o escolhida";
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

	// M�todos dos bot�es
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent) {
		//professor.setDisciplinas(disciplinas);
		new ProfessorDao().salvar(professor);
		professors = new ProfessorDao().listarTudo();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void alterar() {
		new ProfessorDao().atualizar(professor);
		professors = new ProfessorDao().listarTudo();
		professor = new Professor();
	}

	@SuppressWarnings("unchecked")
	public void excluir(Professor professor) {
		new ProfessorDao().excluir(professor);
		professors = new ProfessorDao().listarTudo();
		professor = new Professor();
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}

	
/*
	public void setSelectedDisciplinas(List<Disciplina> selectedDisciplinas) {
		this.disciplinas = selectedDisciplinas;
		//System.out.println(selectedDisciplinas.size());
		//this.professor.setDisciplinas(selectedDisciplinas); 
		//Problema ocorre aqui, quando � atribuido o array de Disciplinas (selectedDisciplinas 
		//as disciplinas do professor (linha 123) 
		//selecionado as disciplinas ministradas do professor 
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public List<Disciplina> getDisciplinasCad() {
		return disciplinasCad;
	}

	public DisciplinaBean getDisciplinaBean() {
		return disciplinaBean;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setDisciplinasCad(List<Disciplina> disciplinasCad) {
		this.disciplinasCad = disciplinasCad;
	}

	public void setDisciplinaBean(DisciplinaBean disciplinaBean) {
		this.disciplinaBean = disciplinaBean;
	}
*/
}

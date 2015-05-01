package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Professor;
import edu.gaed.dao.ProfessorDao;
 
@ManagedBean(name="ProfessorBean")
@ViewScoped
public class ProfessorBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Professor professor = new Professor();
	 
	List<Professor> professors = new ArrayList<Professor>(); 
	
	public ProfessorBean(Professor professor, List<Professor> professors) {
		super();
		this.professor = new Professor();
		this.professors = new ArrayList<Professor>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public ProfessorBean(){
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		professors = new ProfessorDao().listar();
		professor = new Professor();
       
    }
	public String getProfessorEscolhida(){
        return professor!=null && professor.getId()!=null ? professor.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new ProfessorDao().inserir(professor);
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new ProfessorDao().alterar(professor);
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Professor professor){
		new ProfessorDao().excluir(professor);
		professors = new ProfessorDao().listar();
		professor = new Professor();
	}

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
 
	//getters and setters
	
 
	
}

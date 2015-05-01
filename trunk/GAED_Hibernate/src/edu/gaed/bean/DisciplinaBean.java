package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Disciplina;
import edu.gaed.dao.DisciplinaDao;
 
@ManagedBean(name="DisciplinaBean")
@ViewScoped
public class DisciplinaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Disciplina disciplina = new Disciplina();
	 
	List<Disciplina> disciplinas = new ArrayList<Disciplina>(); 
	
	public DisciplinaBean(Disciplina disciplina, List<Disciplina> disciplinas) {
		super();
		this.disciplina = new Disciplina();
		this.disciplinas = new ArrayList<Disciplina>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public DisciplinaBean(){
		disciplinas = new DisciplinaDao().listar();
		disciplina = new Disciplina();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		disciplinas = new DisciplinaDao().listar();
		disciplina = new Disciplina();
       
    }
	public String getDisciplinaEscolhida(){
        return disciplina!=null && disciplina.getId()!=null ? disciplina.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new DisciplinaDao().inserir(disciplina);
		disciplinas = new DisciplinaDao().listar();
		disciplina = new Disciplina();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new DisciplinaDao().alterar(disciplina);
		disciplinas = new DisciplinaDao().listar();
		disciplina = new Disciplina();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Disciplina disciplina){
		new DisciplinaDao().excluir(disciplina);
		disciplinas = new DisciplinaDao().listar();
		disciplina = new Disciplina();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
 
	//getters and setters
	
 
	
}

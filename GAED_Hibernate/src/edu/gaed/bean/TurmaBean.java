package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.DragDropEvent;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Turma;
import edu.gaed.dao.AlunoDao;
import edu.gaed.dao.TurmaDao;
 
@ManagedBean(name="TurmaBean")
@ViewScoped
public class TurmaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Turma turma = new Turma();	 
	List<Turma> turmas = new ArrayList<Turma>(); 
	
	public TurmaBean(Turma turma, List<Turma> turmas) {
		super();
		this.turma = new Turma();
		this.turmas = new ArrayList<Turma>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public TurmaBean(){
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		turmas = new TurmaDao().listar();
		turma = new Turma();
       
    }
	 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new TurmaDao().inserir(turma);
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new TurmaDao().alterar(turma);
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Turma turma){
		new TurmaDao().excluir(turma);
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	} 
	
}

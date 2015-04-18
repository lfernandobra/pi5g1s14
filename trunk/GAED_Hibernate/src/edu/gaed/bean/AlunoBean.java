package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Aluno;
import edu.gaed.dao.AlunoDao;
 
@ManagedBean(name="AlunoBean")
@ViewScoped
public class AlunoBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Aluno aluno = new Aluno();
	 
	List<Aluno> alunos = new ArrayList<Aluno>(); 
	
	public AlunoBean(Aluno aluno, List<Aluno> alunos) {
		super();
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public AlunoBean(){
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
       
    }
	public String getAlunoEscolhida(){
        return aluno!=null && aluno.getId()!=null ? aluno.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new AlunoDao().inserir(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Aluno aluno){
		new AlunoDao().alterar(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new AlunoDao().excluir(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
 
	//getters and setters
	
 
	
}

package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.BoletimAlunoDisciplina;
import edu.gaed.vo.Turma;
import edu.gaed.dao.BoletimAlunoDisciplinaDao;
 
@ManagedBean(name="BoletimAlunoDisciplinaBean")
@ViewScoped
public class BoletimAlunoDisciplinaBean {
 
	BoletimAlunoDisciplina boletimalunodisciplina = new BoletimAlunoDisciplina();
	 
	List<BoletimAlunoDisciplina> boletimalunodisciplinas = new ArrayList<BoletimAlunoDisciplina>(); 
	
	public BoletimAlunoDisciplinaBean(BoletimAlunoDisciplina boletimalunodisciplina, List<BoletimAlunoDisciplina> boletimalunodisciplinas) {
		super();
		this.boletimalunodisciplina = new BoletimAlunoDisciplina();
		this.boletimalunodisciplinas = new ArrayList<BoletimAlunoDisciplina>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public BoletimAlunoDisciplinaBean(){
		boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
		boletimalunodisciplina = new BoletimAlunoDisciplina();
	}
 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new BoletimAlunoDisciplinaDao().inserir(boletimalunodisciplina);
		boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
		boletimalunodisciplina = new BoletimAlunoDisciplina();
		
		
	}
	/*
	public void cadastrar(Turma turma){
		for(int i=0;i<turma.getAlunos().size();i++){
			boletimalunodisciplina.setAluno(turma.getAlunos().contains(i).);
			
		}
		new BoletimAlunoDisciplinaDao().inserir(boletimalunodisciplina);
		boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
		boletimalunodisciplina = new BoletimAlunoDisciplina();
		
		
	}
 	*/
	@SuppressWarnings("unchecked")
	public void alterar(){
		new BoletimAlunoDisciplinaDao().alterar(boletimalunodisciplina);
		boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
		boletimalunodisciplina = new BoletimAlunoDisciplina();
	}
	@SuppressWarnings("unchecked")
	public void excluir(BoletimAlunoDisciplina boletimalunodisciplinaex){
		new BoletimAlunoDisciplinaDao().excluir(boletimalunodisciplinaex);
		boletimalunodisciplinas = new BoletimAlunoDisciplinaDao().listar();
		boletimalunodisciplina = new BoletimAlunoDisciplina();
	}
	
	//getters and setters
	

	public List<BoletimAlunoDisciplina> getBoletimAlunoDisciplinas() {
		return boletimalunodisciplinas;
	}

	public void setBoletimAlunoDisciplinas(List<BoletimAlunoDisciplina> boletimalunodisciplinas) {
		this.boletimalunodisciplinas = boletimalunodisciplinas;
	}

	public BoletimAlunoDisciplina getBoletimAlunoDisciplina() {
		return boletimalunodisciplina;
	}

	public void setBoletimAlunoDisciplina(BoletimAlunoDisciplina boletimalunodisciplina) {
		this.boletimalunodisciplina = boletimalunodisciplina;
	}
 
	// m�todos reset
	
	
}

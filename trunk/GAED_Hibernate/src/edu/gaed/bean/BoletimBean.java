package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Boletim;
import edu.gaed.dao.BoletimDao;
 
@ManagedBean(name="BoletimBean")
@ViewScoped
public class BoletimBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Boletim boletim = new Boletim();
	 
	Set<Boletim> boletims = new HashSet<Boletim>(); 
	
	public BoletimBean(Boletim boletim, Set<Boletim> boletims) {
		super();
		this.boletim = new Boletim();
		this.boletims = new HashSet<Boletim>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public BoletimBean(){
		boletims = new BoletimDao().listar();
		boletim = new Boletim();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		boletims = new BoletimDao().listar();
		boletim = new Boletim();
       
    }
	public String getBoletimEscolhida(){
        return boletim!=null && boletim.getId()!=null ? boletim.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new BoletimDao().inserir(boletim);
		boletims = new BoletimDao().listar();
		boletim = new Boletim();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new BoletimDao().alterar(boletim);
		boletims = new BoletimDao().listar();
		boletim = new Boletim();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Boletim boletim){
		new BoletimDao().excluir(boletim);
		boletims = new BoletimDao().listar();
		boletim = new Boletim();
	}

	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	public Set<Boletim> getBoletims() {
		return boletims;
	}

	public void setBoletims(Set<Boletim> boletims) {
		this.boletims = boletims;
	}

	
 
	//getters and setters
	
 
	
}

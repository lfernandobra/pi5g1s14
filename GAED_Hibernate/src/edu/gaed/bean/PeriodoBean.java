package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Periodo;
import edu.gaed.dao.PeriodoDao;
 
@ManagedBean(name="PeriodoBean")
@ViewScoped
public class PeriodoBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Periodo periodo = new Periodo();
	 
	List<Periodo> periodos = new ArrayList<Periodo>(); 
	
	public PeriodoBean(Periodo periodo, List<Periodo> periodos) {
		super();
		this.periodo = new Periodo();
		this.periodos = new ArrayList<Periodo>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public PeriodoBean(){
		periodos = new PeriodoDao().listar();
		periodo = new Periodo();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		periodos = new PeriodoDao().listar();
		periodo = new Periodo();
       
    }
	public String getPeriodoEscolhida(){
        return periodo!=null && periodo.getId()!=null ? periodo.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new PeriodoDao().inserir(periodo);
		periodos = new PeriodoDao().listar();
		periodo = new Periodo();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Periodo periodo){
		new PeriodoDao().alterar(periodo);
		periodos = new PeriodoDao().listar();
		periodo = new Periodo();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new PeriodoDao().excluir(periodo);
		periodos = new PeriodoDao().listar();
		periodo = new Periodo();
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
 
	//getters and setters
	
 
	
}

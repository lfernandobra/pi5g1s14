package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Logradouro;
import edu.gaed.dao.LogradouroDao;
 
@ManagedBean(name="LogradouroBean")
@ViewScoped
public class LogradouroBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logradouro logradouro = new Logradouro();
	 
	List<Logradouro> logradouros = new ArrayList<Logradouro>(); 
	
	public LogradouroBean(Logradouro logradouro, List<Logradouro> logradouros) {
		super();
		this.logradouro = new Logradouro();
		this.logradouros = new ArrayList<Logradouro>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public LogradouroBean(){
		logradouros = new LogradouroDao().listar();
		logradouro = new Logradouro();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		logradouros = new LogradouroDao().listar();
		logradouro = new Logradouro();
       
    }
	public String getUFEscolhida(){
        return logradouro!=null && logradouro.getId()!=null ? logradouro.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new LogradouroDao().inserir(logradouro);
		logradouros = new LogradouroDao().listar();
		logradouro = new Logradouro();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Logradouro logradouro){
		new LogradouroDao().alterar(logradouro);
		logradouros = new LogradouroDao().listar();
		logradouro = new Logradouro();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new LogradouroDao().excluir(logradouro);
		logradouros = new LogradouroDao().listar();
		logradouro = new Logradouro();
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}
 
	//getters and setters
	
	@SuppressWarnings("unchecked")
	public List<Logradouro> completeLogradouro(){
        logradouros = new LogradouroDao().listar();
        return logradouros;
    }
	
	
	public String clear(){  
        this.logradouro = null;  
        return "";  
    }  
}

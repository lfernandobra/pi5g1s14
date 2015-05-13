package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Logradouro;
import edu.gaed.dao.LogradouroDao;
 
@ManagedBean(name="LogradouroBean")
@ViewScoped
public class LogradouroBean {
 
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
		logradouros = new LogradouroDao().listarTudo();
		logradouro = new Logradouro();
	}
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new LogradouroDao().salvar(logradouro);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Unidade Federativa: " + logradouro.getNome() + " cadastrado com sucesso") );
		logradouros = new LogradouroDao().listarTudo();
		logradouro = new Logradouro();
		
		
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new LogradouroDao().atualizar(logradouro);;
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  "Unidade Federativa: " + logradouro.getNome() + " alterada com sucesso") );
		logradouros = new LogradouroDao().listarTudo();
		logradouro = new Logradouro();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Logradouro logradouroex){
		new LogradouroDao().excluir(logradouroex);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Unidade Federativa: " + logradouroex.getNome() + " excluida com sucesso") );
		logradouros = new LogradouroDao().listarTudo();
		logradouro = new Logradouro();
	}
	
	//getters and setters
	

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
 
	// métodos reset
	
	@SuppressWarnings("unchecked")
	public List<Logradouro> completeLogradouro(){
        logradouros = new LogradouroDao().listarTudo();
        return logradouros;
    }
	
	
	public String clear(){  
        this.logradouro = null;  
        return "";  
    }
}

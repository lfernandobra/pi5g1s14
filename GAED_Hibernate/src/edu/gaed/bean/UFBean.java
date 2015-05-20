package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 







import edu.gaed.vo.UF;
import edu.gaed.dao.UFDao;
 
@ManagedBean(name="UFBean")
@ViewScoped
public class UFBean {
 
	UF uf = new UF();
	 
	List<UF> ufs = new ArrayList<UF>(); 
	
	public UFBean(UF uf, List<UF> ufs) {
		super();
		this.uf = new UF();
		this.ufs = new ArrayList<UF>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public UFBean(){
		ufs = new UFDao().listar();
		uf = new UF();
	}
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new UFDao().inserir(uf);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Unidade Federativa: " + uf.getNome() + " cadastrado com sucesso") );
		ufs = new UFDao().listar();
		uf = new UF();
		
		
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new UFDao().alterar(uf);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  "Unidade Federativa: " + uf.getNome() + " alterada com sucesso") );
		ufs = new UFDao().listar();
		uf = new UF();
	}
	@SuppressWarnings("unchecked")
	public void excluir(UF ufex){
		new UFDao().excluir(ufex);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Unidade Federativa: " + ufex.getNome() + " excluida com sucesso") );
		ufs = new UFDao().listar();
		uf = new UF();
	}
	
	//getters and setters
	

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
 
	// métodos reset
	
	
}

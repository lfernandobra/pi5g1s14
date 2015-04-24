package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
		ufs = new UFDao().listar();
		uf = new UF();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(ActionEvent actionEvent){
		new UFDao().alterar(uf);
		ufs = new UFDao().listar();
		uf = new UF();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new UFDao().excluir(uf);
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
 
	
}

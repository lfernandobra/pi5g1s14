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
 
	//construtor
	public UFBean(){
		ufs = new UFDao().listar();
		uf = new UF();
	}
 
	//Métodos dos botões 
	public void cadastrar(ActionEvent actionEvent){
		new UFDao().inserir(uf);
		ufs = new UFDao().listar();
		uf = new UF();
	}
 
	public void alterar(ActionEvent actionEvent){
		new UFDao().alterar(uf);
		ufs = new UFDao().listar();
		uf = new UF();
	}
	public void excluir(ActionEvent actionEvent){
		new UFDao().excluir(uf);
		ufs = new UFDao().listar();
		uf = new UF();
	}
 
	//getters and setters
	public UF getUF() {
		return uf;
	}
 
	public void setUF(UF uf) {
		this.uf = uf;
	}
 
	public List<UF> getUFs() {
		return ufs;
	}
 
	public void setUFs(List<UF> ufs) {
		this.ufs = ufs;
	}
}

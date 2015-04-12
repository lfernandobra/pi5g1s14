package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped; 


import edu.gaed.dao.UFDao;
import edu.gaed.vo.UF;


@ManagedBean(name="UFBean")
@ViewScoped
public class UFBean {
	
	UF uf = new UF();
	List<UF> ufs = new ArrayList<UF>();
    
	public UFBean(){
		ufs = new UFDao().lista();
		uf = new UF();
	}
	
	//getters e setters
    	
	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(UF uf) throws Exception{
		new UFDao().salvar(uf);
		ufs = new UFDao().lista();
		uf = new UF();
    }
		
	//Excluir 
	public void excluir(UF uf) throws Exception{
		new UFDao().excluir(uf);
		ufs = new UFDao().lista();
		uf = new UF();
	}

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

}

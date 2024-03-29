package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Bimestre;
import edu.gaed.dao.BimestreDao;
 
@ManagedBean(name="BimestreBean")
@ViewScoped
public class BimestreBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Bimestre bimestre = new Bimestre();
	 
	List<Bimestre> bimestres = new ArrayList<Bimestre>(); 
	
	public BimestreBean(Bimestre bimestre, List<Bimestre> bimestres) {
		super();
		this.bimestre = new Bimestre();
		this.bimestres = new ArrayList<Bimestre>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public BimestreBean(){
		bimestres = new BimestreDao().listar();
		bimestre = new Bimestre();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		bimestres = new BimestreDao().listar();
		bimestre = new Bimestre();
       
    }
	public String getBimestreEscolhida(){
        return bimestre!=null && bimestre.getId()!=null ? bimestre.toString():"Classe n�o escolhida";
    }
 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new BimestreDao().inserir(bimestre);
		bimestres = new BimestreDao().listar();
		bimestre = new Bimestre();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new BimestreDao().alterar(bimestre);
		bimestres = new BimestreDao().listar();
		bimestre = new Bimestre();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Bimestre bimestre){
		new BimestreDao().excluir(bimestre);
		bimestres = new BimestreDao().listar();
		bimestre = new Bimestre();
	}

	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}

	public List<Bimestre> getBimestres() {
		return bimestres;
	}

	public void setBimestres(List<Bimestre> bimestres) {
		this.bimestres = bimestres;
	}
 
	//getters and setters
	
 
	
}

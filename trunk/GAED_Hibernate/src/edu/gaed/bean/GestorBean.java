package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Gestor;
import edu.gaed.dao.GestorDao;
 
@ManagedBean(name="GestorBean")
@ViewScoped
public class GestorBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Gestor gestor = new Gestor();
	 
	List<Gestor> gestors = new ArrayList<Gestor>(); 
	
	public GestorBean(Gestor gestor, List<Gestor> gestors) {
		super();
		this.gestor = new Gestor();
		this.gestors = new ArrayList<Gestor>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public GestorBean(){
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		gestors = new GestorDao().listar();
		gestor = new Gestor();
       
    }
	public String getGestorEscolhida(){
        return gestor!=null && gestor.getId()!=null ? gestor.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new GestorDao().inserir(gestor);
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new GestorDao().alterar(gestor);
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Gestor gestor){
		new GestorDao().excluir(gestor);
		gestors = new GestorDao().listar();
		gestor = new Gestor();
	}

	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}

	public List<Gestor> getGestors() {
		return gestors;
	}

	public void setGestors(List<Gestor> gestors) {
		this.gestors = gestors;
	}
 
	//getters and setters
	
 
	
}

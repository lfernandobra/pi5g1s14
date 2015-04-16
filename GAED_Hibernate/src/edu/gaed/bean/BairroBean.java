package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Bairro;
import edu.gaed.dao.BairroDao;
 
@ManagedBean(name="BairroBean")
@ViewScoped
public class BairroBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Bairro bairro = new Bairro();
	 
	List<Bairro> bairros = new ArrayList<Bairro>(); 
	
	public BairroBean(Bairro bairro, List<Bairro> bairros) {
		super();
		this.bairro = new Bairro();
		this.bairros = new ArrayList<Bairro>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public BairroBean(){
		bairros = new BairroDao().listar();
		bairro = new Bairro();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		bairros = new BairroDao().listar();
		bairro = new Bairro();
       
    }
	public String getUFEscolhida(){
        return bairro!=null && bairro.getId()!=null ? bairro.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new BairroDao().inserir(bairro);
		bairros = new BairroDao().listar();
		bairro = new Bairro();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Bairro bairro){
		new BairroDao().alterar(bairro);
		bairros = new BairroDao().listar();
		bairro = new Bairro();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new BairroDao().excluir(bairro);
		bairros = new BairroDao().listar();
		bairro = new Bairro();
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
 
	//getters and setters
	
 
	
}

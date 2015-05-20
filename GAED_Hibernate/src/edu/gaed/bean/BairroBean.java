package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
	 
	Set<Bairro> bairros = new HashSet<Bairro>(); 
	
	public BairroBean(Bairro bairro, Set<Bairro> bairros) {
		super();
		this.bairro = new Bairro();
		this.bairros = new HashSet<Bairro>();
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
	public void alterar(){
		new BairroDao().alterar(bairro);
		bairros = new BairroDao().listar();
		bairro = new Bairro();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Bairro bairro){
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

	public Set<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(Set<Bairro> bairros) {
		this.bairros = bairros;
	}

	
 
	
}

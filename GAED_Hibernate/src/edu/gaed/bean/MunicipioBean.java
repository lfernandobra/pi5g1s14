package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Municipio;
import edu.gaed.dao.MunicipioDao;
 
@ManagedBean(name="MunicipioBean")
@ViewScoped
public class MunicipioBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Municipio municipio = new Municipio();
	 
	List<Municipio> municipios = new ArrayList<Municipio>(); 
	
	public MunicipioBean(Municipio municipio, List<Municipio> municipios) {
		super();
		this.municipio = new Municipio();
		this.municipios = new ArrayList<Municipio>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public MunicipioBean(){
		municipios = new MunicipioDao().listar();
		municipio = new Municipio();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		municipios = new MunicipioDao().listar();
		municipio = new Municipio();
       
    }
	public String getUFEscolhida(){
        return municipio!=null && municipio.getId()!=null ? municipio.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new MunicipioDao().inserir(municipio);
		municipios = new MunicipioDao().listar();
		municipio = new Municipio();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new MunicipioDao().alterar(municipio);
		municipios = new MunicipioDao().listar();
		municipio = new Municipio();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Municipio municipio){
		new MunicipioDao().excluir(municipio);
		municipios = new MunicipioDao().listar();
		municipio = new Municipio();
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
 
	//getters and setters
	
 
	
}

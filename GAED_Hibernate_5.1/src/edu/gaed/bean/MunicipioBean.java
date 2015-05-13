package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import edu.gaed.vo.Municipio;
import edu.gaed.dao.MunicipioDao;
 
@ManagedBean(name="MunicipioBean")
@ViewScoped
public class MunicipioBean {
 
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
		municipios = new MunicipioDao().listarTudo();
		municipio = new Municipio();
	}
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new MunicipioDao().salvar(municipio);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Unidade Federativa: " + municipio.getNome() + " cadastrado com sucesso") );
		municipios = new MunicipioDao().listarTudo();
		municipio = new Municipio();
		
		
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new MunicipioDao().atualizar(municipio);;
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  "Unidade Federativa: " + municipio.getNome() + " alterada com sucesso") );
		municipios = new MunicipioDao().listarTudo();
		municipio = new Municipio();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Municipio municipioex){
		new MunicipioDao().excluir(municipioex);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Unidade Federativa: " + municipioex.getNome() + " excluida com sucesso") );
		municipios = new MunicipioDao().listarTudo();
		municipio = new Municipio();
	}
	
	//getters and setters
	

	public List<Municipio> getUfs() {
		return municipios;
	}

	public void setUfs(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio getUf() {
		return municipio;
	}

	public void setUf(Municipio municipio) {
		this.municipio = municipio;
	}
 
	// métodos reset
	
	
}

package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Anexo;
import edu.gaed.dao.AnexoDao;
 
@ManagedBean(name="AnexoBean")
@ViewScoped
public class AnexoBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Anexo anexo = new Anexo();
	 
	List<Anexo> anexos = new ArrayList<Anexo>(); 
	
	public AnexoBean(Anexo anexo, List<Anexo> anexos) {
		super();
		this.anexo = new Anexo();
		this.anexos = new ArrayList<Anexo>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public AnexoBean(){
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
       
    }
	public String getAnexoEscolhida(){
        return anexo!=null && anexo.getId()!=null ? anexo.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new AnexoDao().inserir(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Anexo anexo){
		new AnexoDao().alterar(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new AnexoDao().excluir(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}

	public Anexo getAnexo() {
		return anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
 
	//getters and setters
	
 
	
}

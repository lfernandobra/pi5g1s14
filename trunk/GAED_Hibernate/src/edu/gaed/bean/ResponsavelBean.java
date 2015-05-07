package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import org.primefaces.event.FileUploadEvent;

import edu.gaed.vo.Responsavel;
import edu.gaed.dao.ResponsavelDao;
 
@ManagedBean(name="ResponsavelBean")
@SessionScoped
public class ResponsavelBean extends UsuarioBean implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Responsavel responsavel = new Responsavel();
	List<Responsavel> responsavels = new ArrayList<Responsavel>();
	FotoBean fotoBean = new FotoBean();
	
	
	public ResponsavelBean(Responsavel responsavel, List<Responsavel> responsavels) {
		super();
		this.responsavel = new Responsavel();
		this.responsavels = new ArrayList<Responsavel>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public ResponsavelBean(){
		responsavels = new ResponsavelDao().listar();
		responsavel = new Responsavel();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		responsavels = new ResponsavelDao().listar();
		responsavel = new Responsavel();
       
    }
	public String getResponsavelEscolhida(){
        return responsavel!=null && responsavel.getId()!=null ? responsavel.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(){
		new ResponsavelDao().inserir(responsavel);
		responsavels = new ResponsavelDao().listar();
		responsavel = new Responsavel();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new ResponsavelDao().alterar(responsavel);
		responsavels = new ResponsavelDao().listar();
		responsavel = new Responsavel();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Responsavel responsavel){
		new ResponsavelDao().excluir(responsavel);
		responsavels = new ResponsavelDao().listar();
		responsavel = new Responsavel();
	}
	
	//getters and setters
	
	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public List<Responsavel> getResponsavels() {
		return responsavels;
	}

	public void setResponsavels(List<Responsavel> responsavels) {
		this.responsavels = responsavels;
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}
	
	//Upload foto
	
	public void uploadAction (FileUploadEvent event) throws IOException{
		this.fotoBean.fileUpload(event);
		this.responsavel.setFoto(this.fotoBean.getFoto());
	}
	
 
	
}

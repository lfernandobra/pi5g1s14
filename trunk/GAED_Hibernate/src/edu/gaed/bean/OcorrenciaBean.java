package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Ocorrencia;
import edu.gaed.dao.OcorrenciaDao;
 
@ManagedBean(name="OcorrenciaBean")
@ViewScoped
public class OcorrenciaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ocorrencia ocorrencia = new Ocorrencia();
	 
	List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>(); 
	
	public OcorrenciaBean(Ocorrencia ocorrencia, List<Ocorrencia> ocorrencias) {
		super();
		this.ocorrencia = new Ocorrencia();
		this.ocorrencias = new ArrayList<Ocorrencia>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public OcorrenciaBean(){
		ocorrencias = new OcorrenciaDao().listar();
		ocorrencia = new Ocorrencia();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		ocorrencias = new OcorrenciaDao().listar();
		ocorrencia = new Ocorrencia();
       
    }
	public String getOcorrenciaEscolhida(){
        return ocorrencia!=null && ocorrencia.getId()!=null ? ocorrencia.toString():"Classe não escolhida";
    }
 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new OcorrenciaDao().inserir(ocorrencia);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Ocorrência  cadastrada com sucesso") );
		ocorrencias = new OcorrenciaDao().listar();
		ocorrencia = new Ocorrencia();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new OcorrenciaDao().alterar(ocorrencia);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado", "Ocorrência alterada com sucesso") );
		ocorrencias = new OcorrenciaDao().listar();
		ocorrencia = new Ocorrencia();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Ocorrencia ocorrencia){
		new OcorrenciaDao().excluir(ocorrencia);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Ocorrência excluida com sucesso") );
		ocorrencias = new OcorrenciaDao().listar();
		ocorrencia = new Ocorrencia();
	}

	public Ocorrencia getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(Ocorrencia ocorrencia) {
		this.ocorrencia = ocorrencia;
	}

	public List<Ocorrencia> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
 
	//getters and setters
	
 
	
}

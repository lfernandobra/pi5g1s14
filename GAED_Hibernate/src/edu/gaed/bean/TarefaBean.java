package edu.gaed.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
 


import org.primefaces.event.FileUploadEvent;

import edu.gaed.vo.Tarefa;
import edu.gaed.dao.TarefaDao;
 
@ManagedBean(name="TarefaBean")
@ViewScoped
public class TarefaBean {
 
	Tarefa tarefa = new Tarefa();
	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	AnexoBean anexoBean = new AnexoBean();
	
	public TarefaBean(Tarefa tarefa, List<Tarefa> tarefas) {
		super();
		this.tarefa = new Tarefa();
		this.tarefas = new ArrayList<Tarefa>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public TarefaBean(){
		tarefas = new TarefaDao().listar();
		tarefa = new Tarefa();
	}
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new TarefaDao().inserir(tarefa);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Tarefa ID: " + tarefa.getId() + " cadastrada com sucesso") );
		tarefas = new TarefaDao().listar();
		tarefa = new Tarefa();		
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new TarefaDao().alterar(tarefa);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  "Tarefa ID: " + tarefa.getId() + " alterada com sucesso") );
		tarefas = new TarefaDao().listar();
		tarefa = new Tarefa();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Tarefa tarefaex){
		new TarefaDao().excluir(tarefaex);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Tarefa ID: " + tarefa.getId() + " excluida com sucesso") );
		tarefas = new TarefaDao().listar();
		tarefa = new Tarefa();
	}
	
	// Upload anexo

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.anexoBean.fileUpload(event);
		System.out.println(this.anexoBean.getAnexo().getNome());
		tarefa.setAnexo(anexoBean.anexo);
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public AnexoBean getAnexoBean() {
		return anexoBean;
	}

	public void setAnexoBean(AnexoBean anexoBean) {
		this.anexoBean = anexoBean;
	}
	
	//getters and setters
	

	
 
	// métodos reset
	
	
}

package edu.gaed.bean;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
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
	Set<Tarefa> tarefas = new HashSet<Tarefa>();
	AnexoBean anexoBean = new AnexoBean();
	
	public TarefaBean(Tarefa tarefa, Set<Tarefa> tarefas) {
		super();
		this.tarefa = new Tarefa();
		this.tarefas = new HashSet<Tarefa>();
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
        context.addMessage(null, new FacesMessage("Excluido",  "Tarefa ID: " + tarefaex.getId() + " excluida com sucesso") );
		tarefas = new TarefaDao().listar();
		tarefa = new Tarefa();
	}
	
	public Tarefa getTarefa() {
		return tarefa;
	}

	public Set<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public AnexoBean getAnexoBean() {
		return anexoBean;
	}

	public void setAnexoBean(AnexoBean anexoBean) {
		this.anexoBean = anexoBean;
	}
	
	// Upload anexo

	public void uploadAction(FileUploadEvent event) throws IOException {
		this.anexoBean.fileUpload(event);
		System.out.println(this.anexoBean.getAnexo().getNome());
		tarefa.setAnexo(anexoBean.anexo);
	}
	
}

package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.gaed.vo.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

@ManagedBean(name="TurmaAlunoBean")
@ViewScoped
public class TurmaAlunoBean implements Serializable{
	
	public TurmaAlunoBean(){
		//init();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8114644463999946372L;
	
	private Turma turma;
	private DualListModel<Aluno> alunosDualList;
	
	@ManagedProperty(value="#{AlunoBean}")
	private AlunoBean alunoBean;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
        List<Aluno> alunosSource = alunoBean.alunos;
        List<Aluno> alunosTarget = new ArrayList<Aluno>();
        
        alunosDualList = new DualListModel<Aluno>(alunosSource,alunosTarget);
	}

	//getters and setters
	public DualListModel<Aluno> getAlunosDualList() {
		return alunosDualList;
	}

	public void setAlunosDualList(DualListModel<Aluno> alunosDualList) {
		this.alunosDualList = alunosDualList;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public AlunoBean getAlunoBean() {
		return alunoBean;
	}

	public void setAlunoBean(AlunoBean alunoBean) {
		this.alunoBean = alunoBean;
	}

	//m�todos
	public void onTransfer(TransferEvent event) {
        StringBuilder builder = new StringBuilder();
        for(Object item : event.getItems()) {
            builder.append(((Aluno) item).getNome()).append("<br />");
        }
         
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        msg.setSummary("Items Transferred");
        msg.setDetail(builder.toString());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } 
 
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
    } 
	

}

package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Turma;
import edu.gaed.dao.TurmaDao;
 
@ManagedBean(name="TurmaBean")
@ViewScoped
public class TurmaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Turma turma = new Turma();	 
	Set<Turma> turmas = new HashSet<Turma>(); 
	
	public TurmaBean(Turma turma, Set<Turma> turmas) {
		super();
		this.turma = new Turma();
		this.turmas = new HashSet<Turma>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public TurmaBean(){
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		turmas = new TurmaDao().listar();
		turma = new Turma();
       
    }
	 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new TurmaDao().inserir(turma);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrada",  " Turma " + turma.getNome() + "  criada com sucesso!") );
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new TurmaDao().alterar(turma);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterada",  " Turma " + turma.getNome() + "  alterada com sucesso!") );
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Turma turma){
		new TurmaDao().excluir(turma);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluída", "Excluída com sucesso!") );
		turmas = new TurmaDao().listar();
		turma = new Turma();
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	} 
	
}

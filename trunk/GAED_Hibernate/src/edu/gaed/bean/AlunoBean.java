package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.FileUploadEvent;

import edu.gaed.vo.Aluno;
import edu.gaed.dao.AlunoDao;
 
@ManagedBean(name="AlunoBean")
@ViewScoped
public class AlunoBean extends UsuarioBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Aluno aluno = new Aluno();
	Set<Aluno> alunos = new HashSet<Aluno>();
	FotoBean fotoBean = new FotoBean();
	
	public AlunoBean(Aluno aluno, List<Aluno> alunos) {
		super();
		this.aluno = new Aluno();
		this.alunos = new HashSet<Aluno>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public AlunoBean(){
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
       
    }
	public String getAlunoEscolhida(){
        return aluno!=null && aluno.getId()!=null ? aluno.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new AlunoDao().inserir(aluno);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  " Aluno(a) " + aluno.getNome() + "  cadastrado(a) com sucesso!") );
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new AlunoDao().alterar(aluno);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  " Aluno(a) " + aluno.getNome() + "  alterado(a) com sucesso!") );
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Aluno aluno){
		new AlunoDao().excluir(aluno);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluído", "Excluído com sucesso!") );
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
 
	//getters and setters
	//Upload foto
	
	public void uploadAction (FileUploadEvent event) throws IOException{
		this.fotoBean.fileUpload(event);
		this.aluno.setFoto(this.fotoBean.getFoto());
	}

	

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public FotoBean getFotoBean() {
		return fotoBean;
	}

	public void setFotoBean(FotoBean fotoBean) {
		this.fotoBean = fotoBean;
	}
 
	
}

package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
	List<Aluno> alunos = new ArrayList<Aluno>(); 
	FotoBean fotoBean = new FotoBean();
	
	public AlunoBean(Aluno aluno, List<Aluno> alunos) {
		super();
		this.aluno = new Aluno();
		this.alunos = new ArrayList<Aluno>();
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
        return aluno!=null && aluno.getId()!=null ? aluno.toString():"Classe n�o escolhida";
    }
 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new AlunoDao().inserir(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new AlunoDao().alterar(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Aluno aluno){
		new AlunoDao().excluir(aluno);
		alunos = new AlunoDao().listar();
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
 
	//getters and setters
	//Upload foto
	
	public void uploadAction (FileUploadEvent event) throws IOException{
		this.fotoBean.fileUpload(event);
		this.aluno.setFoto(this.fotoBean.getFoto());
	}
 
	
}
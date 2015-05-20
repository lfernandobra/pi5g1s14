package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Ocorrencia;
import edu.gaed.vo.Turma;
import edu.gaed.dao.OcorrenciaDao;
 
@ManagedBean(name="OcorrenciaBean")
@ViewScoped
public class OcorrenciaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Turma turma;  
	  
	private Aluno aluno;  
      
    private Map<Turma,Turma> turmas = new HashMap<Turma, Turma>();  
  
    private Map<Turma,Map<Aluno,Aluno>> alunoTurma = new HashMap<Turma, Map<Aluno,Aluno>>();  
      
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
	public void handleTurmaChange(){
		if(turma !=null && turma.equals(""))
			alunos = alunoTurma.get(aluno);
		else
			alunoTurma = new HashMap<Turma, Map<Aluno,Aluno>>();	
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
 
	 public Turma getTurma() {
			return turma;
		}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Map<Turma, Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(Map<Turma, Turma> turmas) {
		this.turmas = turmas;
	}

	public Map<Turma, Map<Aluno, Aluno>> getAlunoTurma() {
		return alunoTurma;
	}

	public void setAlunoTurma(Map<Turma, Map<Aluno, Aluno>> alunoTurma) {
		this.alunoTurma = alunoTurma;
	}

	public Map<Aluno, Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Map<Aluno, Aluno> alunos) {
		this.alunos = alunos;
	}

	private Map<Aluno,Aluno> alunos = new HashMap<Aluno, Aluno>();  
		
	
 
	
}

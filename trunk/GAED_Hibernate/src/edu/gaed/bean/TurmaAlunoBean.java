package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import edu.gaed.dao.AlunoDao;
import edu.gaed.vo.Aluno;
import edu.gaed.vo.Turma;

@ManagedBean(name="TurmaAlunoBean")
@ViewScoped
public class TurmaAlunoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8114644463999946372L;
	
	private Turma turma;
	private DualListModel<Aluno> alunosDualList = new DualListModel<Aluno>(new ArrayList<Aluno>(),new ArrayList<Aluno>());
	
	@ManagedProperty(value="#{AlunoBean}")
	private AlunoBean alunoBean;

	//getters and setters
	public DualListModel<Aluno> getAlunosDualList() {
		if (turma != null){
			List<Aluno> alunosTarget = new ArrayList<Aluno>();
			alunosTarget.addAll(turma.getAlunos());
			
			List<Aluno> alunosSource = new ArrayList<Aluno>();
			alunosSource.addAll(alunoBean.alunosSemTurma);
			alunosSource.removeAll(alunosTarget);
			alunosDualList = new DualListModel<Aluno>(alunosSource,alunosTarget);
			
		}
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
	
	public void adicionarAlunos(){
		for(Aluno a : alunosDualList.getTarget()){
			turma.addAluno(a);
			new AlunoDao().alterar(a);
		}
		for(Aluno a : alunosDualList.getSource()){
			a.setTurma(null);
			new AlunoDao().alterar(a);
		}
	}
	

}

package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import edu.gaed.dao.ProfessorDao;
import edu.gaed.vo.Professor;
import edu.gaed.vo.ProfessorTurma;
import edu.gaed.vo.Turma;

@ManagedBean(name="TurmaProfessorBean")
@ViewScoped
public class TurmaProfessorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4162079689691664177L;
	
	private Turma turma;
	private DualListModel<Professor> professoresDualList = new DualListModel<Professor>(new ArrayList<Professor>(),new ArrayList<Professor>());

	//getters and setters
	public DualListModel<Professor> getProfessoresDualList() {
		if (turma != null){
			Set<Professor> profTarget = new HashSet<Professor>();
			for (ProfessorTurma pf : turma.getProfessorTurma()){
				profTarget.add(pf.getProfessor());
			}
			List<Professor> profTargetList = new ArrayList<Professor>();
			profTargetList.addAll(profTarget);
			
			List<Professor> alunosSource = new ProfessorDao().listar();
			alunosSource.removeAll(profTargetList);
			professoresDualList = new DualListModel<Professor>(alunosSource,profTargetList);
			
		}
		return professoresDualList;
	}

	public void setProfessoresDualList(DualListModel<Professor> professoresDualList) {
		this.professoresDualList = professoresDualList;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void adicionarProfessor(){
		for(Professor a : professoresDualList.getTarget()){
		}
		for(Professor a : professoresDualList.getSource()){
			
		}
	}
	

}

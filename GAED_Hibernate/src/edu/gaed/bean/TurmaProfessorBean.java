package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DualListModel;

import edu.gaed.dao.ProfessorDao;
import edu.gaed.dao.TurmaDao;
import edu.gaed.dao.TurmaDisciplinaDao;
import edu.gaed.vo.Disciplina;
import edu.gaed.vo.Professor;
import edu.gaed.vo.Turma;
import edu.gaed.vo.TurmaDisciplina;

@ManagedBean(name="TurmaProfessorBean")
@ViewScoped
public class TurmaProfessorBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4162079689691664177L;
	
	private Turma turma;
	private DualListModel<TurmaDisciplina> professoresDualList = new DualListModel<TurmaDisciplina>(new ArrayList<TurmaDisciplina>(),new ArrayList<TurmaDisciplina>());

	//getters and setters
	public DualListModel<TurmaDisciplina> getProfessoresDualList() {
		if (turma != null){
			
			List<TurmaDisciplina> profTargetList = new ArrayList<TurmaDisciplina>(turma.getTurmasDisciplinas());
			
			List<Professor> alunosSource = new ProfessorDao().listar();
			List<TurmaDisciplina> turmaDisciplinaSource = new ArrayList<TurmaDisciplina>();
			for(Professor p: alunosSource){
				for (Disciplina d: p.getDisciplinas()){
					TurmaDisciplina turmaDisciplina = new TurmaDisciplina(p, turma, d);
					turmaDisciplinaSource.add(turmaDisciplina);
				}
			}
			turmaDisciplinaSource.removeAll(profTargetList);
			professoresDualList = new DualListModel<TurmaDisciplina>(turmaDisciplinaSource,profTargetList);
			
		}
		return professoresDualList;
	}

	public void setProfessoresDualList(DualListModel<TurmaDisciplina> professoresDualList) {
		this.professoresDualList = professoresDualList;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public void adicionarProfessor(){
		for(TurmaDisciplina turmaDisciplina : professoresDualList.getTarget()){
			if (turmaDisciplina.getId() == null){
				new TurmaDisciplinaDao().inserir(turmaDisciplina);				
			}
		}
		for(TurmaDisciplina turmaDisciplina : professoresDualList.getSource()){
			if (turmaDisciplina.getId() != null){
				new TurmaDisciplinaDao().excluir(turmaDisciplina);			
			}
		}
	}
	

}

package edu.gaed.vo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "professor_disciplina_turma")
@AssociationOverrides({
		@AssociationOverride(name = "pk.professor", 
			joinColumns = @JoinColumn(name = "professor_id")),
		@AssociationOverride(name = "pk.disciplina", 
			joinColumns = @JoinColumn(name = "disciplina_id")), 
		@AssociationOverride(name = "pk.turma", 
		joinColumns = @JoinColumn(name = "turma_id"))})


public class ProfessorDisciplinaTurma {

		private ProfessorDisciplinaTurmaID pk = new  ProfessorDisciplinaTurmaID();
		
		public ProfessorDisciplinaTurma() {
			
		}
	 
		@EmbeddedId
		public ProfessorDisciplinaTurmaID getPk() {
			return pk;
		}
	 
		public void setPk(ProfessorDisciplinaTurmaID pk) {
			this.pk = pk;
		}
	 
		@Transient
		public Professor getProfessor() {
			return getPk().getProfessor();
		}
	 
		public void setProfessor(Professor professor) {
			getPk().setProfessor(professor);
		}
	 
		@Transient
		public Turma getTurma() {
			return getPk().getTurma();
		}
	 
		public void setTurma(Turma turma) {
			getPk().setTurma(turma);
		}

		
		@Transient
		public Disciplina getDisciplina() {
			return getPk().getDisciplina();
		}
	 
		public void setDisciplina(Disciplina disciplina) {
			getPk().setDisciplina(disciplina);
		}

}

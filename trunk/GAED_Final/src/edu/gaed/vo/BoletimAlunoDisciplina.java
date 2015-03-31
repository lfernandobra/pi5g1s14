package edu.gaed.vo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "boletim_aluno_disciplina")
@AssociationOverrides({
		@AssociationOverride(name = "pk.boletim", 
			joinColumns = @JoinColumn(name = "boletim_id")),
		@AssociationOverride(name = "pk.aluno", 
			joinColumns = @JoinColumn(name = "aluno_id")),
		@AssociationOverride(name = "pk.disciplina", 
			joinColumns = @JoinColumn(name = "disciplina_id")) })


public class BoletimAlunoDisciplina {

		private BoletimAlunoDisciplinaID pk = new BoletimAlunoDisciplinaID();
		@Column
		private float nota;
		@Column
		private int falta;
	 
		public BoletimAlunoDisciplina() {
			
		}
	 
		@EmbeddedId
		public BoletimAlunoDisciplinaID getPk() {
			return pk;
		}
	 
		public void setPk(BoletimAlunoDisciplinaID pk) {
			this.pk = pk;
		}
	 
		@Transient
		public Boletim getBoletim() {
			return getPk().getBoletim();
		}
	 
		public void setBoletim(Boletim boletim) {
			getPk().setBoletim(boletim);
		}
	 
		@Transient
		public Aluno getAluno() {
			return getPk().getAluno();
		}
	 
		public void setAluno(Aluno aluno) {
			getPk().setAluno(aluno);
		}

		
		@Transient
		public Disciplina getDisciplina() {
			return getPk().getDisciplina();
		}
	 
		public void setDisciplina(Disciplina disciplina) {
			getPk().setDisciplina(disciplina);
		}

		public float getNota() {
			return nota;
		}

		public void setNota(float nota) {
			this.nota = nota;
		}

		public int getFalta() {
			return falta;
		}

		public void setFalta(int falta) {
			this.falta = falta;
		}			
}

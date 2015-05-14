package edu.gaed.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "professor_turma")
public class ProfessorTurma implements Serializable {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idturma", column = @Column(name = "idturma", nullable = false)),
			@AttributeOverride(name = "idprofessor", column = @Column(name = "idprofessor", nullable = false)) })
	private Id id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idturma", nullable = false, insertable = false, updatable = false)
	private Turma turma;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idprofessor", nullable = false, insertable = false, updatable = false)
	private Professor professor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "horario", length = 19)
	private Date horario;

	// getters e setters omitidos

	// Id da associacao (chave composta no banco)
	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "idTurma", nullable = false)
		private Integer idTurma;

		@Column(name = "idProfessor", nullable = false)
		private Integer idProfessor;

		public Integer getIdTurma() {
			return this.idTurma;
		}

		public void setIdTurma(Integer idturma) {
			this.idTurma = idturma;
		}

		public Integer getIdProfessor() {
			return this.idProfessor;
		}

		public void setIdProfessor(Integer idprofessor) {
			this.idProfessor = idprofessor;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + idProfessor;
			result = prime * result + idTurma;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Id other = (Id) obj;
			if (idProfessor != other.idProfessor)
				return false;
			if (idTurma != other.idTurma)
				return false;
			return true;
		}
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}
}
package edu.gaed.vo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name="limite")
	private int qtdAluLimite;
	
	@Column(name="inseridos")
	private int qtdAluInseridos;
	
	@ManyToOne
	@JoinColumn(name="id_periodo")
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name="id_serie")
	private Serie serie;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "turma")
	private Set<ProfessorTurma> professorTurma = new HashSet<ProfessorTurma>(0);

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "turma")
	private Set<Aluno> alunos = new HashSet<Aluno>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ProfessorTurma> getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(Set<ProfessorTurma> professorTurma) {
		this.professorTurma = professorTurma;
	}

	public Set<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getQtdAluLimite() {
		return qtdAluLimite;
	}

	public int getQtdAluInseridos() {
		return qtdAluInseridos;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setQtdAluLimite(int qtdAluLimite) {
		this.qtdAluLimite = qtdAluLimite;
	}

	public void setQtdAluInseridos(int qtdAluInseridos) {
		this.qtdAluInseridos = qtdAluInseridos;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		result = prime * result
				+ ((professorTurma == null) ? 0 : professorTurma.hashCode());
		result = prime * result + qtdAluInseridos;
		result = prime * result + qtdAluLimite;
		result = prime * result + ((serie == null) ? 0 : serie.hashCode());
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
		Turma other = (Turma) obj;
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		if (professorTurma == null) {
			if (other.professorTurma != null)
				return false;
		} else if (!professorTurma.equals(other.professorTurma))
			return false;
		if (qtdAluInseridos != other.qtdAluInseridos)
			return false;
		if (qtdAluLimite != other.qtdAluLimite)
			return false;
		if (serie == null) {
			if (other.serie != null)
				return false;
		} else if (!serie.equals(other.serie))
			return false;
		return true;
	}

	
}
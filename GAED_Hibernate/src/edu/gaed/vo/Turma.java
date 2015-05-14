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

	@Column(name = "descricao")
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	
}
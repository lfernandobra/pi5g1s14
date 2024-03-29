package edu.gaed.vo;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_turma", nullable=false)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="limite")
	private int qtdAluLimite;
	
	@Column(name="inseridos")
	private int qtdAluInseridos;
	
	@ManyToOne
	@JoinColumn(name="id_periodo", referencedColumnName="id_periodo", foreignKey = @ForeignKey(name="fk_periodo"))
	private Periodo periodo;
	
	@ManyToOne
	@JoinColumn(name="id_serie", referencedColumnName="id_serie", foreignKey = @ForeignKey(name="fk_serie"))
	private Serie serie;
	
	@OneToMany
	private Set<Aluno> aluno = new HashSet<Aluno>(0);
	/*
	@OneToMany
	private Set<Professor> professor = new HashSet<Professor>(0);
	*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdAluLimite() {
		return qtdAluLimite;
	}

	public void setQtdAluLimite(int qtdAluLimite) {
		this.qtdAluLimite = qtdAluLimite;
	}

	public int getQtdAluInseridos() {
		return qtdAluInseridos;
	}

	public void setQtdAluInseridos(int qtdAluInseridos) {
		this.qtdAluInseridos = qtdAluInseridos;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Set<Aluno> getAlunos() {
		return aluno;
	}

	public void setAlunos(Set<Aluno> alunos) {
		this.aluno = alunos;
	}

	public Set<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}
	/*
	public Set<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(Set<Professor> professor) {
		this.professor = professor;
	}*/
}

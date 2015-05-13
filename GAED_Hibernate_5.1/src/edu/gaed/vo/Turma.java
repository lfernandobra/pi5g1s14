package edu.gaed.vo;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_turma", nullable=false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
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
	
	@OneToMany
	private Set<Aluno> aluno = new HashSet<Aluno>(0);
	/*
	@OneToMany
	private Set<Professor> professor = new HashSet<Professor>(0);
	*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

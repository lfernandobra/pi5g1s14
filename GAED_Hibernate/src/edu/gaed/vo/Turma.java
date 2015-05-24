package edu.gaed.vo;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
@Table(name = "turma")
public class Turma implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
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
	
	@OneToMany(mappedBy="turma")
	@Fetch(FetchMode.JOIN)
	private Set<TurmaDisciplina> turmasDisciplinas = new HashSet<TurmaDisciplina>();
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "turma_disciplina",
	joinColumns = { @JoinColumn(name = "idturma", nullable = false,
	updatable =  false) }, inverseJoinColumns = {@JoinColumn(name = "iddisciplina", nullable = false, updatable = false) })
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "turma")
	private Set<Aluno> alunos = new HashSet<Aluno>(0);
	
	public boolean adicionaTurmaDisciplina(TurmaDisciplina turmaDisciplina) {
		if (turmasDisciplinas != null) {
			return turmasDisciplinas.add(turmaDisciplina);
		}
		return false;
	}	

	public Set<TurmaDisciplina> getTurmasDisciplinas() {
		return turmasDisciplinas;
	}

	public void setTurmasDisciplinas(Set<TurmaDisciplina> turmasDisciplinas) {
		this.turmasDisciplinas = turmasDisciplinas;
	}

	/**
     * Creates a BI-directional relationship between brand and product
     * 
     * @return the boolean
     */
	public boolean addAluno(Aluno aluno) {
		if (this.alunos == null) {
		    return false;
		}
		if (!this.equals(aluno.getTurma())) {
		    if (aluno.getTurma() != null) {
		    	aluno.getTurma().getAlunos().remove(aluno);
		    }
		    aluno.setTurma(this);
		}
		return this.alunos.add(aluno);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", nome=" + nome + ", qtdAluLimite="
				+ qtdAluLimite + ", qtdAluInseridos=" + qtdAluInseridos
				+ ", periodo=" + periodo + ", serie=" + serie
				+ "]";
	}

	
}
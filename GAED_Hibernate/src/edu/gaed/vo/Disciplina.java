package edu.gaed.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina implements Serializable{
	
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disciplina(Long id, String nome, String conteudo) {
		super();
		this.id = id;
		this.nome = nome;
		this.conteudo = conteudo;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_disciplina", nullable=false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="conteudo")
	private String conteudo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "disciplina_professor",
	joinColumns = { @JoinColumn(name = "iddisciplina", nullable = false,
	updatable = false) }, inverseJoinColumns = {
	@JoinColumn(name = "idprofessor", nullable = false, updatable = false) })
    private List<Professor> professores = new ArrayList<Professor>();
	
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
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((professores == null) ? 0 : professores.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (professores == null) {
			if (other.professores != null)
				return false;
		} else if (!professores.equals(other.professores))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", conteudo="
				+ conteudo + ", professores=" + professores + "]";
	}
	
}

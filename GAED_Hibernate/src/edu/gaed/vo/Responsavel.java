package edu.gaed.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "responsavel")
public class Responsavel extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="adimplente", columnDefinition = "BIT", length = 1)
	private boolean adimplente;
	
	@OneToMany
	private Set<Aluno> aluno = new HashSet<Aluno>(0);
	
	public Responsavel() {
		super();
	}
	
	public boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	public Set<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	public void adicionaAluno(Aluno aluno){
		this.aluno.add(aluno);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (adimplente ? 1231 : 1237);
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		if (adimplente != other.adimplente)
			return false;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsavel [adimplente=" + adimplente + ", aluno=" + aluno
				+ "]";
	}

	
	
}

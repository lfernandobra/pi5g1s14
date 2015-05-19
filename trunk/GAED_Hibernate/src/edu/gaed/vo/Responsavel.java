package edu.gaed.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "responsavel")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public Responsavel() {
		super();
	}
	
	public boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (adimplente ? 1231 : 1237);
		result = prime * result + ((alunos == null) ? 0 : alunos.hashCode());
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
		if (alunos == null) {
			if (other.alunos != null)
				return false;
		} else if (!alunos.equals(other.alunos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Responsavel [adimplente=" + adimplente + ", alunos=" + alunos
				+ "]";
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	

	
	
}

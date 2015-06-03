package edu.gaed.vo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "responsavel")
@DiscriminatorValue(value="RESPONSAVEL")
public class Responsavel extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="adimplente", columnDefinition = "BIT", length = 1)
	private boolean adimplente;
	
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL, mappedBy = "responsavel")
	private List<Aluno> alunos = new ArrayList<Aluno>();
	
	public Responsavel() {
		setPerfil(Perfil.RESPONSAVEL);
	}
	
	public boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (adimplente ? 1231 : 1237);
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
		return true;
	}

	@Override
	public String toString() {
		return "Responsavel [adimplente=" + adimplente + ", alunos.size()=" + alunos.size()
				+ "]";
	}

	
	
}

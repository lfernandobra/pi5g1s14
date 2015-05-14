package edu.gaed.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "secretaria")
public class Secretaria extends Usuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="experiAnt", nullable=false)
	private String experiAnterior;
	
	@Column(name="instituicaoAnt", nullable=false)
	private String instituicaoAnterior;
	
	@Column(name="formacAcad", nullable=false)
	private String formacaoAcad;
	
	@Column(name="instAcad", nullable=false)
	private String instituicaoAcad;
	
	@Column(name="anoConcl", nullable=false)
	private Date anoConclusao;

	public String getExperiAnterior() {
		return experiAnterior;
	}

	public void setExperiAnterior(String experiAnterior) {
		this.experiAnterior = experiAnterior;
	}

	public String getInstituicaoAnterior() {
		return instituicaoAnterior;
	}

	public void setInstituicaoAnterior(String instituicaoAnterior) {
		this.instituicaoAnterior = instituicaoAnterior;
	}

	public String getFormacaoAcad() {
		return formacaoAcad;
	}

	public void setFormacaoAcad(String formacaoAcad) {
		this.formacaoAcad = formacaoAcad;
	}

	public String getInstituicaoAcad() {
		return instituicaoAcad;
	}

	public void setInstituicaoAcad(String instituicaoAcad) {
		this.instituicaoAcad = instituicaoAcad;
	}

	public Date getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Date anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((anoConclusao == null) ? 0 : anoConclusao.hashCode());
		result = prime * result
				+ ((experiAnterior == null) ? 0 : experiAnterior.hashCode());
		result = prime * result
				+ ((formacaoAcad == null) ? 0 : formacaoAcad.hashCode());
		result = prime * result
				+ ((instituicaoAcad == null) ? 0 : instituicaoAcad.hashCode());
		result = prime
				* result
				+ ((instituicaoAnterior == null) ? 0 : instituicaoAnterior
						.hashCode());
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
		Secretaria other = (Secretaria) obj;
		if (anoConclusao == null) {
			if (other.anoConclusao != null)
				return false;
		} else if (!anoConclusao.equals(other.anoConclusao))
			return false;
		if (experiAnterior == null) {
			if (other.experiAnterior != null)
				return false;
		} else if (!experiAnterior.equals(other.experiAnterior))
			return false;
		if (formacaoAcad == null) {
			if (other.formacaoAcad != null)
				return false;
		} else if (!formacaoAcad.equals(other.formacaoAcad))
			return false;
		if (instituicaoAcad == null) {
			if (other.instituicaoAcad != null)
				return false;
		} else if (!instituicaoAcad.equals(other.instituicaoAcad))
			return false;
		if (instituicaoAnterior == null) {
			if (other.instituicaoAnterior != null)
				return false;
		} else if (!instituicaoAnterior.equals(other.instituicaoAnterior))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Secretaria [experiAnterior=" + experiAnterior
				+ ", instituicaoAnterior=" + instituicaoAnterior
				+ ", formacaoAcad=" + formacaoAcad + ", instituicaoAcad="
				+ instituicaoAcad + ", anoConclusao=" + anoConclusao + "]";
	}

}

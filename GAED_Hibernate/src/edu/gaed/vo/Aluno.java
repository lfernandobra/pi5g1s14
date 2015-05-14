package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "aluno")
public class Aluno extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="escolaAnterior")
	private String escolaAnterior;
	
	@Column(name="serieAnterior")
	private String serieAnterior;
	
	@Column(name="escolaAtual")
	private String escolaAtual;
	
	@Column(name="serieAtual")
	private String serieAtual;
	
	//@ManyToMany(targetEntity=edu.gaed.vo.usuario.Aluno.class, mappedBy="aluno")
	
	/*
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_responsavel", referencedColumnName="id_usuario", foreignKey = @ForeignKey(name="fk_responsavel"))
	private Responsavel responsavel;
	*/
		
	public Aluno() {
		super();
	}

	public String getEscolaAnterior() {
		return escolaAnterior;
	}

	public void setEscolaAnterior(String escolaAnterior) {
		this.escolaAnterior = escolaAnterior;
	}

	public String getSerieAnterior() {
		return serieAnterior;
	}

	public void setSerieAnterior(String serieAnterior) {
		this.serieAnterior = serieAnterior;
	}

	public String getEscolaAtual() {
		return escolaAtual;
	}

	public void setEscolaAtual(String escolaAtual) {
		this.escolaAtual = escolaAtual;
	}

	public String getSerieAtual() {
		return serieAtual;
	}

	public void setSerieAtual(String serieAtual) {
		this.serieAtual = serieAtual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((escolaAnterior == null) ? 0 : escolaAnterior.hashCode());
		result = prime * result
				+ ((escolaAtual == null) ? 0 : escolaAtual.hashCode());
		result = prime * result
				+ ((serieAnterior == null) ? 0 : serieAnterior.hashCode());
		result = prime * result
				+ ((serieAtual == null) ? 0 : serieAtual.hashCode());
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
		Aluno other = (Aluno) obj;
		if (escolaAnterior == null) {
			if (other.escolaAnterior != null)
				return false;
		} else if (!escolaAnterior.equals(other.escolaAnterior))
			return false;
		if (escolaAtual == null) {
			if (other.escolaAtual != null)
				return false;
		} else if (!escolaAtual.equals(other.escolaAtual))
			return false;
		if (serieAnterior == null) {
			if (other.serieAnterior != null)
				return false;
		} else if (!serieAnterior.equals(other.serieAnterior))
			return false;
		if (serieAtual == null) {
			if (other.serieAtual != null)
				return false;
		} else if (!serieAtual.equals(other.serieAtual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [escolaAnterior=" + escolaAnterior + ", serieAnterior="
				+ serieAnterior + ", escolaAtual=" + escolaAtual
				+ ", serieAtual=" + serieAtual + "]";
	}	
}

package edu.gaed.vo.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno extends Usuario{
	
	@Column(name="escolaAnterior")
	private String escolaAnterior;
	
	@Column(name="serieAnterior")
	private String serieAnterior;
	
	@Column(name="escolaAtual")
	private String escolaAtual;
	
	@Column(name="serieAtual")
	private String serieAtual;
	
	@ManyToOne
	@JoinColumn(name="id_responsavel", referencedColumnName="id_usuario",nullable=false)
	private Responsavel responsavel;
	
	public Aluno() {
		super();
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
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

	

	
	
}

package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "aluno")
public class Aluno extends Usuario{
	
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

	

	
	
}

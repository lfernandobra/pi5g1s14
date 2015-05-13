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

}

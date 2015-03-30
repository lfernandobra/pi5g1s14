package edu.gaed.vo.usuario;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Gestor extends Usuario{
	
	@Column(name="formacAcad", nullable=false)
	private String formacaoAcad;
	
	@Column(name="instAcad", nullable=false)
	private String instituicaoAcad;
	
	@Column(name="anoConcl", nullable=false)
	private Date anoConclusao;

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

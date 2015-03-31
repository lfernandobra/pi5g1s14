package edu.gaed.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")

public class Professor extends Usuario{
		
	@Column(name="escolaAnt", nullable=false)
	private String escolaAnterior;
	
	@Column(name="formacAcad", nullable=false)
	private String formacaoAcad;
	
	@Column(name="instAcad", nullable=false)
	private String instituicaoAcad;
	
	@Column(name="anoConcl", nullable=false)
	private Date anoConclusao;
	
	@OneToMany
	private Set<Disciplina> disciplina = new HashSet<Disciplina>(0);
	
	public String getEscolaAnterior() {
		return escolaAnterior;
	}
	public void setEscolaAnterior(String escolaAnterior) {
		this.escolaAnterior = escolaAnterior;
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
	public Set<Disciplina> getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Set<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
	
	
	
}

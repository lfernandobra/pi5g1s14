package edu.gaed.vo.ocorrencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.gaed.vo.usuario.Aluno;

@Entity
public class Ocorrencia {
	
	@Id
	@Column(name="id_ocorrencia", nullable=false)
	private int id;
	
	@Column(name="assunto")
	private String assunto;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")
	private Aluno aluno;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}

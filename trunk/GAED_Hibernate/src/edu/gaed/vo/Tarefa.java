package edu.gaed.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tarefa")
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tarefa", nullable=false)
	private int id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="inicio")
	private Date inicio;
	
	@Column(name="fim")
	private Date fim;
	
	@ManyToOne
	@JoinColumn(name="id_turma")
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="id_anexo")
	private Anexo anexo;
	
	@OneToMany(mappedBy="tarefa")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Anexo getAnexo() {
		return anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}
}

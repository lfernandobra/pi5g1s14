package edu.gaed.vo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "responsavel")
public class Responsavel extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="adimplente", columnDefinition = "BIT", length = 1)
	private boolean adimplente;
	
	@OneToMany
	private Set<Aluno> aluno = new HashSet<Aluno>(0);
	
	public Responsavel() {
		super();
	}
	
	public boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	public Set<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(Set<Aluno> aluno) {
		this.aluno = aluno;
	}
	
	public void adicionaAluno(Aluno aluno){
		this.aluno.add(aluno);
	}

	
	
}

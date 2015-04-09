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
	
	@Column(name="adimplente", nullable=false)
	private boolean adimplente;
	
	@OneToMany
	private Set<Aluno> aluno = new HashSet<Aluno>(0);
	
	public Responsavel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean getAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	
	
}

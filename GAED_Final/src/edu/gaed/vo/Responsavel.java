package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
public class Responsavel extends Usuario{
	
	@Column(name="adimplente", nullable=false)
	private boolean adimplente;
	
	public Responsavel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isAdimplente() {
		return adimplente;
	}

	public void setAdimplente(boolean adimplente) {
		this.adimplente = adimplente;
	}

	
	
}

package edu.gaed.vo.usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
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

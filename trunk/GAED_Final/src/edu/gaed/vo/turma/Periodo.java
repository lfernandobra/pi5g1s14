package edu.gaed.vo.turma;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periodo {
	
	@Id
	@Column(name="id_periodo", nullable=false)
	private int id;
	
	@Column(name="periodo")
	private String periodo;
	
	@OneToMany(mappedBy="periodo")
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}

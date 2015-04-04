package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "periodo")
public class Periodo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

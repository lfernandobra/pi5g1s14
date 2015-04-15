package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boletim")
public class Boletim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_boletim", nullable=false)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="id_bimestre")
	private Bimestre bimestre;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}
	
	
}

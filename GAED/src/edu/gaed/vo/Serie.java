package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_serie", nullable=false)
	private int id;
	@Column(name="serie")
	private String serie;
	
	@OneToMany(mappedBy="serie")

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}
	
}

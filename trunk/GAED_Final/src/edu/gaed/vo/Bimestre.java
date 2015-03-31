package edu.gaed.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bimestre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_bimestre", nullable=false)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="datainicial")
	private Date datainic;
	
	@Column(name="datafinal", nullable=false)
	private Date datafin;

	@OneToMany(mappedBy="bimestre")
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatainic() {
		return datainic;
	}

	public void setDatainic(Date datainic) {
		this.datainic = datainic;
	}

	public Date getDatafin() {
		return datafin;
	}

	public void setDatafin(Date datafin) {
		this.datafin = datafin;
	}
	
}

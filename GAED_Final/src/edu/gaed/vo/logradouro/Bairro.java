package edu.gaed.vo.logradouro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bairro {
	@Id
	@Column(name="id_bairro", nullable=false)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_municipio", referencedColumnName="id_municipio")
	private Municipio municipio;
	
	@OneToMany(mappedBy="bairro")
	
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
	
	@ManyToOne
	@JoinColumn(name="id_municipio", referencedColumnName="id_municipio")
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
}

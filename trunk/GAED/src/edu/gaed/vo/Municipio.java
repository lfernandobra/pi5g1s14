package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Municipio {
	@Id
	@Column(name="id_municipio", nullable=false)
	private int id;
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_UF", referencedColumnName="id_UF", foreignKey = @ForeignKey(name="fk_UF"))
	private UF uf;
	
	@OneToMany(mappedBy="municipio")
	
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
	
	public UF getUf() {
		return uf;
	}
	
	public void setUf(UF uf) {
		this.uf = uf;
	}
}

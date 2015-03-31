package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Logradouro {
	@Id
	@Column(name="id_logradouro", nullable=false)
	private int id;
	@Column(name="nome_logradouro", nullable=false)
	private String nome;
	@Column(name="CEP", nullable=false)
	private String CEP;
	
	@ManyToOne
	@JoinColumn(name="id_bairro", referencedColumnName="id_bairro", foreignKey = @ForeignKey(name="fk_bairro"))
	private Bairro bairro;
	
	@OneToMany(mappedBy="logradouro")
	
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
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
}

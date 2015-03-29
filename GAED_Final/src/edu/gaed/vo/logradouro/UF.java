package edu.gaed.vo.logradouro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class UF {
	@Id
	@Column(name="id_UF", nullable=false)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sigla")
	private String sigla;
	
	@OneToMany(mappedBy="uf")
	
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
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}

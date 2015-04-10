package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "uf")
public class UF {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_UF", nullable=false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sigla")
	private String sigla;
	
	@OneToMany(mappedBy="uf")
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	public void validate(){
        if(nome == null){
            throw new IllegalArgumentException("Nome não pode estar nulo");
        }
    }
}

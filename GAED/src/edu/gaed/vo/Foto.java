package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "foto")
public class Foto {
	  
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name="id_foto",nullable=false)
	  private int id;
	  
	  @Column(name="nome",nullable=false)
	  private String nome;
	  
	  @Column(name="imagem",nullable=false)
	  private byte[] imagem; 
	  
	  @OneToOne(mappedBy="foto")
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
	  /*
	  public byte[] getImagem() {
	    return imagem;
	  }
	  public void setImagem(byte[] imagem) {
	    this.imagem = imagem;
	  }
	  */
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	
}

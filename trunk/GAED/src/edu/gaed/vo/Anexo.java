package edu.gaed.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Anexo {
	  
	  @Id
	  @Column(name="id_anexo",nullable=false)
	  private int id;
	  
	  @Column(name="nome",nullable=false)
	  private String nome;
	  
	  @Column(name="anexo",nullable=false)
	  private byte[] anexo;
	  
	  @OneToOne(mappedBy="anexo")
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
	  public byte[] getAnexo() {
	    return anexo;
	  }
	  public void setAnexo(byte[] anexo) {
	    this.anexo = anexo;
	  }

}

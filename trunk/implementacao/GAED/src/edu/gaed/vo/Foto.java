package edu.gaed.vo;

public class Foto {
	  private int id;
	  private String nome, descricao;
	  private byte[] imagem;
	  
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
	  public String getDescricao() {
	    return descricao;
	  }
	  public void setDescricao(String descricao) {
	    this.descricao = descricao;
	  }
	  public byte[] getImagem() {
	    return imagem;
	  }
	  public void setImagem(byte[] imagem) {
	    this.imagem = imagem;
	  }

}

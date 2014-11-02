package edu.gaed.vo;

public class Disciplina {
	private int ID;
	private String nome,conteudo;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	@Override
	public String toString() {
		return "Disciplina [ID=" + ID + ", nome=" + nome + ", conteudo="
				+ conteudo + "]";
	}
	
}

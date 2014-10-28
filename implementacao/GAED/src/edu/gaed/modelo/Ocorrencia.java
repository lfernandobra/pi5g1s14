package edu.gaed.modelo;

import java.util.Date;

public class Ocorrencia {
	private int ID;
	private Date data;
	private String Assunto,Descricao;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getAssunto() {
		return Assunto;
	}
	public void setAssunto(String assunto) {
		Assunto = assunto;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	
	
}

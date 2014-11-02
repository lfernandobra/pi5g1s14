package edu.gaed.vo;

import java.util.Date;

public class Aluno extends Usuario{
	
	private int ID;
	private Responsavel responsavel;
	private Date dataingresso;
	
	public Aluno() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Date getDataingresso() {
		return dataingresso;
	}

	public void setDataingresso(Date data_Ingresso) {
		dataingresso = data_Ingresso;
	}

	@Override
	public String toString() {
		return "Aluno [ID=" + ID + ", responsavel=" + responsavel
				+ ", Data_Ingresso=" + dataingresso + "]";
	}

	
	
}

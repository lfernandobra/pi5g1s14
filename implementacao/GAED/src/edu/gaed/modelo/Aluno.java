package edu.gaed.modelo;

import java.util.Date;

public class Aluno extends Usuario{
	
	private int ID;
	private Responsavel responsavel;
	private Date Data_Ingresso;
	
	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getData_Ingresso() {
		return Data_Ingresso;
	}

	public void setData_Ingresso(Date data_Ingresso) {
		Data_Ingresso = data_Ingresso;
	}

	@Override
	public String toString() {
		return "Aluno [ID=" + ID + ", responsavel=" + responsavel
				+ ", Data_Ingresso=" + Data_Ingresso + "]";
	}

	
	
}

package edu.gaed.vo;

import java.util.Date;

public class Professor extends Usuario{
	private Date Data;
	private int idProfessor;

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	@Override
	public String toString() {
		return "Professor [Data=" + Data + ", idProfessor=" + idProfessor + "]";
	}
	
	
}

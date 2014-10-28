package edu.gaed.modelo;

import java.util.Date;

public class Boletim {
	private int ID;
	private int Bimestre;
	private Date Data_Boletim;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBimestre() {
		return Bimestre;
	}
	public void setBimestre(int i) {
		Bimestre = i;
	}
	public Date getData_Boletim() {
		return Data_Boletim;
	}
	public void setData_Boletim(Date data_Boletim) {
		Data_Boletim = data_Boletim;
	}
	@Override
	public String toString() {
		return "Boletim [ID=" + ID + ", Bimestre=" + Bimestre
				+ ", Data_Boletim=" + Data_Boletim + "]";
	}
	
	
}

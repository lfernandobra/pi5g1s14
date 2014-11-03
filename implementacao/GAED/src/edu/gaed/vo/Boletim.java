package edu.gaed.vo;

import java.util.Date;

public class Boletim {
	
	private int ID,bimestre;
	private Date dataBoletim;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getDataBoletim() {
		return dataBoletim;
	}
	public void setDataBoletim(Date dataBoletim) {
		this.dataBoletim = dataBoletim;
	}
	
	public Boletim(int iD, int bimestre, Date dataBoletim) {
		super();
		ID = iD;
		this.dataBoletim = dataBoletim;
	}
	
	public Boletim() {
		super();
	}
	public int getBimestre() {
		return bimestre;
	}
	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}
	
	
	
}

package edu.gaed.modelo;

import java.util.Date;

public class Boletim {
	private int ID,bimestre;
	private Date Data_Boletim;
	private Compoe compoe;
	private Aluno aluno;
	private Turma turma;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getBimestre() {
		return bimestre;
	}
	public void setBimestre(int i) {
		bimestre = i;
	}
	public Date getData_Boletim() {
		return Data_Boletim;
	}
	public void setData_Boletim(Date data_Boletim) {
		Data_Boletim = data_Boletim;
	}
	public Compoe getCompoe() {
		return compoe;
	}
	public void setCompoe(Compoe compoe) {
		this.compoe = compoe;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	
}

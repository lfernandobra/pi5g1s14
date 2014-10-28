package edu.gaed.modelo;

public class Turma {
	private int ID,Serie,Ano_letivo,Bimestre;
	private String Nome,Periodo;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSerie() {
		return Serie;
	}
	public void setSerie(int serie) {
		Serie = serie;
	}
	public int getAno_letivo() {
		return Ano_letivo;
	}
	public void setAno_letivo(int ano_letivo) {
		Ano_letivo = ano_letivo;
	}
	public int getBimestre() {
		return Bimestre;
	}
	public void setBimestre(int bimestre) {
		Bimestre = bimestre;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getPeriodo() {
		return Periodo;
	}
	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}
	@Override
	public String toString() {
		return "Turma [ID=" + ID + ", Serie=" + Serie + ", Ano_letivo="
				+ Ano_letivo + ", Bimestre=" + Bimestre + ", Nome=" + Nome
				+ ", Periodo=" + Periodo + "]";
	}
	
	
}

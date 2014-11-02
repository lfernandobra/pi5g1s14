package edu.gaed.vo;

public class Turma {
	private int ID,serie,ano,bimestre;
	private String nome,periodo;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getAno_letivo() {
		return ano;
	}
	public void setAno_letivo(int ano_letivo) {
		ano = ano_letivo;
	}
	public int getBimestre() {
		return bimestre;
	}
	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	@Override
	public String toString() {
		return "Turma [ID=" + ID + ", Serie=" + serie + ", Ano_letivo="
				+ ano + ", Bimestre=" + bimestre + ", Nome=" + nome
				+ ", Periodo=" + periodo + "]";
	}
	
	
}

package edu.gaed.modelo;

public class BoletimTurma {
	private String nomealuno,nometurma,serieturma,nomedisciplina;
	private int serie,bimestre,faltas;
	private float nota;
	public String getNomealuno() {
		return nomealuno;
	}
	public void setNomealuno(String nomealuno) {
		this.nomealuno = nomealuno;
	}
	public String getNometurma() {
		return nometurma;
	}
	public void setNometurma(String nometurma) {
		this.nometurma = nometurma;
	}
	public String getSerieturma() {
		return serieturma;
	}
	public void setSerieturma(String serieturma) {
		this.serieturma = serieturma;
	}
	public String getNomedisciplina() {
		return nomedisciplina;
	}
	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}
	public int getSerie() {
		return serie;
	}
	public void setSerie(int serie) {
		this.serie = serie;
	}
	public int getBimestre() {
		return bimestre;
	}
	public void setBimestre(int bimestre) {
		this.bimestre = bimestre;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "BoletimTurma [nomealuno=" + nomealuno + ", nometurma="
				+ nometurma + ", serieturma=" + serieturma
				+ ", nomedisciplina=" + nomedisciplina + ", serie=" + serie
				+ ", bimestre=" + bimestre + ", faltas=" + faltas + ", nota="
				+ nota + "]";
	}
	
	
	
}

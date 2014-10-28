package edu.gaed.modelo;

public class Compoe {
	private Disciplina Disciplina;
	private Boletim Boletim;
	private float Nota;
	private int Faltas;
	public Disciplina getDisciplina() {
		return Disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		Disciplina = disciplina;
	}
	public Boletim getBoletim() {
		return Boletim;
	}
	public void setBoletim(Boletim boletim) {
		Boletim = boletim;
	}
	public float getNota() {
		return Nota;
	}
	public void setNota(float nota) {
		Nota = nota;
	}
	public int getFaltas() {
		return Faltas;
	}
	public void setFaltas(int faltas) {
		Faltas = faltas;
	}
	@Override
	public String toString() {
		return "Compoe [Disciplina=" + Disciplina + ", Boletim=" + Boletim
				+ ", Nota=" + Nota + ", Faltas=" + Faltas + "]";
	}
}

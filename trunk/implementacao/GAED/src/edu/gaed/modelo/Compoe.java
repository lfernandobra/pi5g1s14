package edu.gaed.modelo;

public class Compoe {
	private Disciplina disciplina;
	private Boletim boletim;
	private float nota;
	private int faltas;
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Boletim getBoletim() {
		return boletim;
	}
	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	@Override
	public String toString() {
		return "Compoe [Disciplina=" + disciplina + ", Boletim=" + boletim
				+ ", Nota=" + nota + ", Faltas=" + faltas + "]";
	}
}

package edu.gaed.vo;

public class Estuda {
	private Turma turma;
	private Aluno aluno;
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	@Override
	public String toString() {
		return "Estuda [turma=" + turma + ", aluno=" + aluno + "]";
	}
	
}

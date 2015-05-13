package edu.gaed.vo;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ProfessorDisciplinaTurmaID implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private Turma turma;
	private Disciplina disciplina;
	

	@ManyToOne
	@JoinColumn(name="id_professor")
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	@ManyToOne
	@JoinColumn(name="id_turma")
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	/*
 	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        ProfessorTurmaDisciplina that = (ProfessorTurmaDisciplina) o;
 
        if (Professor != null ? !Professor.equals(that.Professor) : that.Professor != null) return false;
        if (Turma != null ? !Turma.equals(that.Turma) : that.Turma != null)
            return false;
        if (disciplina != null ? !disciplina.equals(that.disciplina) : that.disciplina != null)
            return false;
 
        return true;
    }
 	public int hashCode() {
        int result;
        result = (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }*/
     
}
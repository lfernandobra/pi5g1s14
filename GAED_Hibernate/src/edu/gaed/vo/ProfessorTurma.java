package edu.gaed.vo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "professor_turma")
public class ProfessorTurma implements Serializable {

	@EmbeddedId
	private ProfessorTurmaPk professorTurmapk;
	
	public ProfessorTurma(Turma turma, Professor professor){
		professorTurmapk = new ProfessorTurmaPk(turma,professor);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((professorTurmapk == null) ? 0 : professorTurmapk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorTurma other = (ProfessorTurma) obj;
		if (professorTurmapk == null) {
			if (other.professorTurmapk != null)
				return false;
		} else if (!professorTurmapk.equals(other.professorTurmapk))
			return false;
		return true;
	}

	public ProfessorTurmaPk getProfessorTurmapk() {
		return professorTurmapk;
	}

	public void setProfessorTurmapk(ProfessorTurmaPk professorTurmapk) {
		this.professorTurmapk = professorTurmapk;
	}
}

package edu.gaed.vo.boletim;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import edu.gaed.vo.disciplina.Disciplina;
import edu.gaed.vo.usuario.Aluno;

@Embeddable
public class BoletimAlunoDisciplinaID implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boletim boletim;
	private Aluno aluno;
	private Disciplina disciplina;
	

	@ManyToOne
	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	@ManyToOne
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne
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
 
        BoletimAlunoDisciplina that = (BoletimAlunoDisciplina) o;
 
        if (boletim != null ? !boletim.equals(that.boletim) : that.boletim != null) return false;
        if (aluno != null ? !aluno.equals(that.aluno) : that.aluno != null)
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
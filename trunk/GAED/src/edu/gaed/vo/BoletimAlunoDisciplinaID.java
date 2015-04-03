package edu.gaed.vo;


import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@JoinColumn(name="id_boletim", referencedColumnName="id_boletim", foreignKey = @ForeignKey(name="fk_boletim"))
	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	@ManyToOne
	@JoinColumn(name="id_aluno", referencedColumnName="id_aluno", foreignKey = @ForeignKey(name="fk_alu"))
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne
	@JoinColumn(name="id_disciplina", referencedColumnName="id_disciplina", foreignKey = @ForeignKey(name="fk_discip"))
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
package edu.gaed.vo;


import javax.persistence.Embeddable;
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
	@JoinColumn(name="id_boletim")
	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	@ManyToOne
	@JoinColumn(name="id_aluno")
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((boletim == null) ? 0 : boletim.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
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
		BoletimAlunoDisciplinaID other = (BoletimAlunoDisciplinaID) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (boletim == null) {
			if (other.boletim != null)
				return false;
		} else if (!boletim.equals(other.boletim))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BoletimAlunoDisciplinaID [boletim=" + boletim + ", aluno="
				+ aluno + ", disciplina=" + disciplina + "]";
	}
	
}
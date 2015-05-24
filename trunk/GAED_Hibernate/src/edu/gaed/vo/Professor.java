package edu.gaed.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@PrimaryKeyJoinColumn(name="id_usuario")
@Table(name = "professor")
@DiscriminatorValue(value="PROFESSOR")
public class Professor extends Usuario{
	
	public Professor(){
		setPerfil(Perfil.PROFESSOR);
	}
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="escolaAnt", nullable=false)
	private String escolaAnterior;
	
	@Column(name="formacAcad", nullable=false)
	private String formacaoAcad;
	
	@Column(name="instAcad", nullable=false)
	private String instituicaoAcad;
	
	@Column(name="anoConcl", nullable=false)
	private Date anoConclusao;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "disciplina_professor",
	joinColumns = { @JoinColumn(name = "idprofessor", nullable = false,
	updatable =  false) }, inverseJoinColumns = {@JoinColumn(name = "iddisciplina", nullable = false, updatable = false) })
    private Set<Disciplina> disciplinas = new HashSet<Disciplina>();
	
	@OneToMany(mappedBy="professor")
	@Fetch(FetchMode.JOIN)
	private Set<TurmaDisciplina> turmas = new HashSet<TurmaDisciplina>();
	
	public Set<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(Set<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Set<TurmaDisciplina> getTurmas() {
		return turmas;
	}
	public void setTurmas(Set<TurmaDisciplina> turmas) {
		this.turmas = turmas;
	}
	public String getEscolaAnterior() {
		return escolaAnterior;
	}
	public void setEscolaAnterior(String escolaAnterior) {
		this.escolaAnterior = escolaAnterior;
	}
	public String getFormacaoAcad() {
		return formacaoAcad;
	}
	public void setFormacaoAcad(String formacaoAcad) {
		this.formacaoAcad = formacaoAcad;
	}
	public String getInstituicaoAcad() {
		return instituicaoAcad;
	}
	public void setInstituicaoAcad(String instituicaoAcad) {
		this.instituicaoAcad = instituicaoAcad;
	}
	public Date getAnoConclusao() {
		return anoConclusao;
	}
	public void setAnoConclusao(Date anoConclusao) {
		this.anoConclusao = anoConclusao;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((anoConclusao == null) ? 0 : anoConclusao.hashCode());
		result = prime * result
				+ ((escolaAnterior == null) ? 0 : escolaAnterior.hashCode());
		result = prime * result
				+ ((formacaoAcad == null) ? 0 : formacaoAcad.hashCode());
		result = prime * result
				+ ((instituicaoAcad == null) ? 0 : instituicaoAcad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (anoConclusao == null) {
			if (other.anoConclusao != null)
				return false;
		} else if (!anoConclusao.equals(other.anoConclusao))
			return false;
		if (escolaAnterior == null) {
			if (other.escolaAnterior != null)
				return false;
		} else if (!escolaAnterior.equals(other.escolaAnterior))
			return false;
		if (formacaoAcad == null) {
			if (other.formacaoAcad != null)
				return false;
		} else if (!formacaoAcad.equals(other.formacaoAcad))
			return false;
		if (instituicaoAcad == null) {
			if (other.instituicaoAcad != null)
				return false;
		} else if (!instituicaoAcad.equals(other.instituicaoAcad))
			return false;
		return true;
	}
	
}

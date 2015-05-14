package edu.gaed.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bimestre")
public class Bimestre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_bimestre", nullable=false)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="datainicial")
	private Date datainic;
	
	@Column(name="datafinal", nullable=false)
	private Date datafin;

	@OneToMany(mappedBy="bimestre")
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatainic() {
		return datainic;
	}

	public void setDatainic(Date datainic) {
		this.datainic = datainic;
	}

	public Date getDatafin() {
		return datafin;
	}

	public void setDatafin(Date datafin) {
		this.datafin = datafin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datafin == null) ? 0 : datafin.hashCode());
		result = prime * result
				+ ((datainic == null) ? 0 : datainic.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Bimestre other = (Bimestre) obj;
		if (datafin == null) {
			if (other.datafin != null)
				return false;
		} else if (!datafin.equals(other.datafin))
			return false;
		if (datainic == null) {
			if (other.datainic != null)
				return false;
		} else if (!datainic.equals(other.datainic))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bimestre [id=" + id + ", nome=" + nome + ", datainic="
				+ datainic + ", datafin=" + datafin + "]";
	}
	
	
	
}

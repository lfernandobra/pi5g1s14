package edu.gaed.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "municipio")
@NamedQueries({
    @NamedQuery(name="Municipio.listarTudo" , query = "SELECT municipio FROM Municipio municipio"),
    @NamedQuery(name="Municipio.listarPorCodigo" , query="SELECT municipio FROM Municipio municipio WHERE municipio.id = :id")
})
public class Municipio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_municipio", nullable=false)
	private Long id;
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_UF")
	private UF uf;
	
	@OneToMany(mappedBy="municipio")
	
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
	
	public UF getUf() {
		return uf;
	}
	
	public void setUf(UF uf) {
		this.uf = uf;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Municipio other = (Municipio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Classe [id=" + id + ", nome=" + nome + "]";
    }
	
}

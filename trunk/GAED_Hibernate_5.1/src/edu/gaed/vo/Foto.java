package edu.gaed.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity //A Classe foto também é uma Entitidade do Banco de Dados.
@Table(name="foto") //Nome da Tabela do Banco de Dados.
@NamedQueries({
    @NamedQuery(name="Foto.listarTudo" , query = "SELECT foto FROM Foto foto"),
    @NamedQuery(name="Foto.listarPorCodigo" , query="SELECT foto FROM Foto foto WHERE foto.id = :id")
})
public class Foto implements Serializable{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_foto", nullable = false)
	private Long id;

	@Column(name = "nome")
	private String nome;

		
	@Column(name="foto",length=1000000)
	@Lob
	private byte[] foto;

	@OneToOne(mappedBy = "foto")
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Foto other = (Foto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Classe [id=" + id + ", nome=" + nome + ", foto=" + foto + "]";
    }


}

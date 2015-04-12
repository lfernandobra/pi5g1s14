package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.vo.Municipio;

public class MunicipioDao extends DAO{
	
	private List<Municipio> municipios;
	
	//getters and setters
	public List<Municipio> getUfs() {
		return municipios;
	}

	public void setUfs(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	//Salvar ou Editar
	public void salvar(Municipio municipio) throws Exception {
		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Verifica se a entidade ainda não está salva no banco de dados.
			if (municipio.getId() == null) {
				// Salva os dados da pessoa.
				em.persist(municipio);
			} else {
				// Atualiza os dados da pessoa.
				municipio = em.merge(municipio);
			}
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}	
	
	//Excluir
	public void excluir(Municipio municipio) throws Exception{

		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Consulta a pessoa na base de dados através do seu ID.
			System.out.println("Excluindo os dados de: " + municipio.getNome());
			// Remove a pessoa da base de dados.
			Municipio c=em.merge(municipio); 
			
			em.remove(c);
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Municipio> lista() {
		
		if(this.municipios == null) {
			Query q = em.createQuery("select m from Municipio m",Municipio.class);
			this.municipios= q.getResultList();
		}	
		return municipios;
	
	}
	
	//Buscar
	public Municipio buscaMunicipio(Municipio municipio) {
	    return em.find(Municipio.class, municipio.getId());
	}
	
	
	//Consulta por ID
	public Municipio consultarPorId(Long id) {
	    
	    Municipio municipio = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      municipio = em.find(Municipio.class, id);
	    } finally {
	      em.close();
	    }
	    return municipio;
	}
	

	
	  
}  



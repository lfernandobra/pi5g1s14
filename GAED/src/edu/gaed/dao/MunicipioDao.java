package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.Municipio;


public class MunicipioDao extends DAO{
	
	private List<Municipio> municipios;
	EntityManager em = JPAUtil.getEntityManager();
	
	//Salvar
	public void salvar(Municipio munic){
		
		em.getTransaction().begin();
		em.persist(munic);
		em.getTransaction().commit();
		em.close();
    }
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Municipio> lista() {
		
		if(this.municipios == null) {
			Query q = em.createQuery("select munic from Municipio munic",Municipio.class);
			this.municipios= q.getResultList();
			em.close();
		}	
		return municipios;
	}
	
	//Excluir
	public void excluir(Municipio munic){

		try {  
	        em = JPAUtil.getEntityManager();  
	        em.getTransaction().begin();  
	        munic = em.merge(munic);  
	        em.remove(munic);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
	
	//Editar
	public void editar(Municipio munic){  
		EntityManager em = JPAUtil.getEntityManager();
		try { 	  
			Municipio munEncontrado = em.find(Municipio.class, munic.getId());
			em.getTransaction().begin();
			munEncontrado.setNome(munic.getNome());
			munEncontrado.setUf(munic.getUf());
			em.getTransaction().commit();  
        	} catch (Exception e) {  
        		e.printStackTrace();
        		em.getTransaction().rollback();  
        	}
	}
	
	//Buscar
	public Municipio buscaMunicipio(Municipio munic) {
	    return em.find(Municipio.class, munic.getId());
	}


}

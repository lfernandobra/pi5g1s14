package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.Municipio;

public class MunicipioDao extends DAO{
	
	private List<Municipio> municipios;
	EntityManager em = JPAUtil.getEntityManager();
	
	public void add(Municipio munic){
		
		em.getTransaction().begin();
		em.persist(munic);
		em.getTransaction().commit();
		em.close();
    }
	
	@SuppressWarnings("unchecked")
	public List<Municipio> lista() {
		
		if(this.municipios == null) {
			Query q = em.createQuery("select munic from Municipio munic",Municipio.class);
			this.municipios= q.getResultList();
			em.close();
		}	
		return municipios;
	}
	
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

}

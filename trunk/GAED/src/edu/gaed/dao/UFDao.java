package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.UF;

public class UFDao extends DAO{
	
	private List<UF> ufs;
		
	public void add(UF uf){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(uf);
		em.getTransaction().commit();
		em.close();
    }
	@SuppressWarnings("unchecked")
	public List<UF> lista() {
		
		if(this.ufs == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select uf from UF uf",UF.class);
			this.ufs= q.getResultList();
			em.close();
		}	
		return ufs;
	
	}
	public void excluir(UF uf){

		EntityManager em = null;  
	    try {  
	        em = JPAUtil.getEntityManager();  
	        em.getTransaction().begin();  
	        uf = em.merge(uf);  
	        em.remove(uf);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
}


package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.UF;

public class UFDao extends DAO{
	
	private List<UF> ufs;
	EntityManager em = JPAUtil.getEntityManager();	
	
	//Salvar
	public void salvar(UF uf){
		em.getTransaction().begin();
		em.persist(uf);
		em.getTransaction().commit();
		em.close();
    }
	
	//Listar
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
	
	//Excluir
	public void excluir(UF uf){

	    try {    
	        em.getTransaction().begin();  
	        uf = em.merge(uf);
	        em.remove(uf);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
	
	//Editar
	public void editar(UF uf){  
		EntityManager em = JPAUtil.getEntityManager();
		try { 	  
			UF ufEncontrado = em.find(UF.class, uf.getId());
			em.getTransaction().begin();
			  ufEncontrado.setNome(uf.getNome());
			  ufEncontrado.setSigla(uf.getSigla());
			em.getTransaction().commit();  
        	} catch (Exception e) {  
        		e.printStackTrace();
        		em.getTransaction().rollback();  
        	}
	}
	
	//Buscar
	public UF buscaUF(UF uf) {
	    return em.find(UF.class, uf.getId());
	}
	  
}  



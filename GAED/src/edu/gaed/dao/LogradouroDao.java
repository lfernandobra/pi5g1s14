package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.Logradouro;

public class LogradouroDao extends DAO{
	
	private List<Logradouro> logradouros;
	EntityManager em = JPAUtil.getEntityManager();	
	
	//Salvar
	public void salvar(Logradouro logradouro){
		em.getTransaction().begin();
		em.persist(logradouro);
		em.getTransaction().commit();
		em.close();
    }
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Logradouro> lista() {
		
		if(this.logradouros == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select l from Logradouro l",Logradouro.class);
			this.logradouros= q.getResultList();
			em.close();
		}	
		return logradouros;
	
	}
	
	//Excluir
	public void excluir(Logradouro logradouro){

	    try {    
	        em.getTransaction().begin();  
	        logradouro = em.merge(logradouro);
	        em.remove(logradouro);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
	
	//Editar
	public void editar(Logradouro logradouro){  
		EntityManager em = JPAUtil.getEntityManager();
		try { 	  
			Logradouro logradouroEncontrado = em.find(Logradouro.class, logradouro.getId());
			em.getTransaction().begin();
			  logradouroEncontrado.setBairro(logradouro.getBairro());
			  logradouroEncontrado.setNome(logradouro.getNome());
			em.getTransaction().commit();  
        	} catch (Exception e) {  
        		e.printStackTrace();
        		em.getTransaction().rollback();  
        	}
	}
	
	//Buscar
	public Logradouro buscaLogradouro(Logradouro logradouro) {
	    return em.find(Logradouro.class, logradouro.getId());
	}
	  
}  



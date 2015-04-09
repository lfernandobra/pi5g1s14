package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.Bairro;

public class BairroDao extends DAO{
	
	private List<Bairro> bairros;
	EntityManager em = JPAUtil.getEntityManager();	
	
	//Salvar
	public void salvar(Bairro bairro){
		em.getTransaction().begin();
		em.persist(bairro);
		em.getTransaction().commit();
		em.close();
    }
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Bairro> lista() {
		
		if(this.bairros == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select b from Bairro b",Bairro.class);
			this.bairros= q.getResultList();
			em.close();
		}	
		return bairros;
	
	}
	
	//Excluir
	public void excluir(Bairro bairro){

	    try {    
	        em.getTransaction().begin();  
	        bairro = em.merge(bairro);
	        em.remove(bairro);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
	
	//Editar
	public void editar(Bairro bairro){  
		EntityManager em = JPAUtil.getEntityManager();
		try { 	  
			Bairro bairroEncontrado = em.find(Bairro.class, bairro.getId());
			em.getTransaction().begin();
			  bairroEncontrado.setMunicipio(bairro.getMunicipio());
			  bairroEncontrado.setNome(bairro.getNome());
			em.getTransaction().commit();  
        	} catch (Exception e) {  
        		e.printStackTrace();
        		em.getTransaction().rollback();  
        	}
	}
	
	//Buscar
	public Bairro buscaBairro(Bairro bairro) {
	    return em.find(Bairro.class, bairro.getId());
	}
	  
}  



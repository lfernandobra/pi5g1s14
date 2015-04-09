package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.Responsavel;


public class ResponsavelDao extends DAO{
	
	private List<Responsavel> responsaveis;
	private Responsavel responsavel = new Responsavel();
	EntityManager em = JPAUtil.getEntityManager();	
	
	//getters and setters
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	//Salvar
	public void salvar(Responsavel responsavel){
		em.getTransaction().begin();
		em.persist(responsavel);
		em.getTransaction().commit();
		em.close();
    }
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Responsavel> lista() {
		
		if(this.responsaveis == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select responsavel from Responsavel responsavel",Responsavel.class);
			this.responsaveis= q.getResultList();
			em.close();
		}	
		return responsaveis;
	
	}
	
	//Excluir
	public void excluir(Responsavel responsavel){

	    try {    
	        em.getTransaction().begin();  
	        responsavel = em.merge(responsavel);
	        em.remove(responsavel);  
	        em.getTransaction().commit();  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        em.getTransaction().rollback();  
	    }
	}
	
	//Editar
	public void editar(Responsavel responsavel){  
		EntityManager em = JPAUtil.getEntityManager();
		try { 	  
			Responsavel responsavelEncontrado = em.find(Responsavel.class, responsavel.getId());
			em.getTransaction().begin();
			  responsavelEncontrado.setNome(responsavel.getNome());
			  responsavelEncontrado.setSobrenome(responsavel.getSobrenome());
			em.getTransaction().commit();  
        	} catch (Exception e) {  
        		e.printStackTrace();
        		em.getTransaction().rollback();  
        	}
	}
	
	//Buscar
	public Responsavel busca(Responsavel responsavel) {
	    return em.find(Responsavel.class, responsavel.getId());
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	
	
	  
}  



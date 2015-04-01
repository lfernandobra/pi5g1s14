package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import edu.gaed.vo.Responsavel;


public class ResponsavelDAO extends BaseDAO{
	
	public void inclui(Responsavel responsavel){
		
		EntityManager em = getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(responsavel);
		tx.commit();
		em.close();
		
	}
	@SuppressWarnings("unchecked")
	public void listarResponsavel(){
		
		EntityManager em = getEntityManager();
		List<Responsavel> responsaveis = em.createQuery("select r from Responsavel r").getResultList();
		for (Responsavel responsavel : responsaveis) {
			  System.out.println(responsavel.getNome());
			}
		
	}
	//Verificar depois
	public void excluir(int idResp){
		EntityManager em = getEntityManager();
		EntityTransaction tx = em.getTransaction();
		Responsavel resp = em.find(Responsavel.class, idResp);
				
		tx.begin();
		em.remove(resp);
		tx.commit();
		
	}


}

package edu.gaed.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAO {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	EntityManager em = emf.createEntityManager();
	EntityTransaction tx = em.getTransaction();
	
}

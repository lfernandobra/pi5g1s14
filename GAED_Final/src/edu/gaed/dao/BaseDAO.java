package edu.gaed.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAO {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("default");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
}

package edu.gaed.controladores;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

//import edu.gaed.vo.Usuario;

public class PersistidorDeUsuario {
	public static void main(String[] args) {
		
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		//Usuario auto = new Usuario();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//em.persist(auto);
		tx.commit();
		em.close();
		emf.close();

	}
}

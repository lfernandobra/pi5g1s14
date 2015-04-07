package edu.gaed.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
 
public class UserDAO {      
	
	public static boolean login(String user, String password) {
        int i;
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select login, senha from usuario u where login = :paramlogin and senha = :paramsenha");
		q.setParameter("paramlogin", user);
		q.setParameter("paramsenha", password);
		i = q.executeUpdate();
		em.close(); 
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
}	

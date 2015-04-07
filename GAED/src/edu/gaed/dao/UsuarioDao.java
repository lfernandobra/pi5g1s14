package edu.gaed.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
 
public class UsuarioDao extends DAO{      
	
	public static boolean login(String user, String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try{
			
			Query q = em.createQuery("select u.login,u.senha from Usuario u where u.login =:paramlogin and u.senha =:paramsenha");
			q.setParameter("paramlogin", user);
			q.setParameter("paramsenha", password);
						
			if (q.getSingleResult()!=null) // found
            {
				return true;
            }
            else {
            	return false;
            }	
			}catch (Exception ex){  
				return false;
			}finally {
				em.close();
		}
		
	}
}	

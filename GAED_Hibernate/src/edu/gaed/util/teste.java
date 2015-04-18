package edu.gaed.util;


import org.hibernate.Session;
import edu.gaed.util.HibernateUtil;
 
public class teste {
 
	public static void main(String[] args) {
 
		Session session =  HibernateUtil.getSessionFactory().openSession();
 
		//realizando operação para salvar no banco
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
	}
}

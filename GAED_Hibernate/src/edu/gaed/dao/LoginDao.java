package edu.gaed.dao;


//import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Usuario;
 
public class LoginDao{      
	
	private Session session;
	
	public Usuario verificaDados(Usuario usuario){
		Usuario us = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE login = '" +usuario.getLogin() +
					"' and senha = '" + usuario.getSenha() + "'";
			Query query = session.createQuery(hql);
			
			if(!query.list().isEmpty()){
				us = (Usuario) query.list().get(0);
			}
		}catch (Exception e){
			throw e;
		}
		
		return us;
	}
	//Login
	/*
	public static boolean login(String login, String senha) {

		Transaction transaction = null;
	    try {
	      session = HibernateUtil.getSession();
	      transaction  = session.beginTransaction();
	      Criteria criteria = session.createCriteria(Usuario.class);
	         //na tabela usu�rio deve constar os campos login e senha.
	        criteria.add(Restrictions.eq("login", login));
	        criteria.add(Restrictions.eq("senha", senha));
	       System.out.println((Usuario) criteria.uniqueResult()!=null) ;
	      transaction.commit();
	      return (Usuario) criteria.uniqueResult()!=null;
	    }
	    catch (RuntimeException e) {
	        transaction.rollback();
	        throw e;
	    }   
		
		/*
		session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class);
	         //na tabela usu�rio deve constar os campos login e senha.
	        criteria.add(Restrictions.eq("login", login));
	        criteria.add(Restrictions.eq("senha", senha));
	        //session.getTransaction().commit();
	        
	        return (Usuario) criteria.uniqueResult()!=null;*/        
}
	

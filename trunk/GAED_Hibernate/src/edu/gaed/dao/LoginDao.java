package edu.gaed.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Usuario;


 
public abstract class LoginDao{      
	
	private static Session session;
	//Login
	public static Usuario login(String login, String senha) {

			session = HibernateUtil.getSessionFactory().getCurrentSession();
	        Criteria criteria = session.createCriteria(Usuario.class);
	         //na tabela usuário deve constar os campos login e senha.
	        criteria.add(Restrictions.eq("login", login));
	        criteria.add(Restrictions.eq("senha", senha));
	        session.close();

	        return (Usuario) criteria.uniqueResult();        
	 }
}	

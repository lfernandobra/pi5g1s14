package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;

import edu.gaed.vo.Logradouro;

import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class LogradouroDao {
 
	private Session session; 
 
		public void inserir(Logradouro logradouro){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(logradouro);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Logradouro logradouro){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(logradouro);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(logradouro);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Logradouro logradouro){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(logradouro);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(logradouro);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Set listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Logradouro.class);
				return new HashSet(cri.list());
			}finally{
				session.close();
 
			}
		}
}

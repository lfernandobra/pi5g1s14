package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Professor;

import org.hibernate.Query;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class ProfessorDao {
 
	private Session session; 
 
		public void inserir(Professor professor){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(professor);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Professor professor){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(professor);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(professor);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Professor professor){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(professor);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(professor);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				String hql = "select prof from Professor prof group by prof.id"; 
				Query query = session.createQuery(hql);
				
				List results = query.list();
				
				return results;
			}finally{
				session.close();
 
			}
		}
}

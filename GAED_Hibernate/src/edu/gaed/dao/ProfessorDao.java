package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;
import edu.gaed.vo.Professor;
import org.hibernate.Criteria;
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
 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Set listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Professor.class);
				return new HashSet(cri.list());
			}finally{
				session.close();
 
			}
		}
}

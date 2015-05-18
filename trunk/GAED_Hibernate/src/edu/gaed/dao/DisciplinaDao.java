package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Disciplina;

import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class DisciplinaDao {
 
	private Session session; 
 
		public void inserir(Disciplina disciplina){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(disciplina);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Disciplina disciplina){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(disciplina);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(disciplina);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Disciplina disciplina){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(disciplina);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(disciplina);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Disciplina.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

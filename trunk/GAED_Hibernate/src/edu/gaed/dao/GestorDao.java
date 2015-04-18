package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Gestor;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class GestorDao {
 
	private Session session; 
 
		public void inserir(Gestor gestor){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(gestor);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Gestor gestor){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(gestor);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(gestor);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Gestor gestor){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(gestor);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(gestor);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Gestor.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

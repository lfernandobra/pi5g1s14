package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Secretaria;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class SecretariaDao {
 
	private Session session; 
 
		public void inserir(Secretaria secretaria){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(secretaria);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Secretaria secretaria){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(secretaria);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(secretaria);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Secretaria secretaria){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(secretaria);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(secretaria);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Secretaria.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

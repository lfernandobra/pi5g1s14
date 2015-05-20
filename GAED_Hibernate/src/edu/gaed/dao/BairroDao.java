package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Bairro;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class BairroDao {
 
	private Session session; 
 
		public void inserir(Bairro bairro){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(bairro);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Bairro bairro){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(bairro);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(bairro);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Bairro bairro){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(bairro);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(bairro);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Bairro.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

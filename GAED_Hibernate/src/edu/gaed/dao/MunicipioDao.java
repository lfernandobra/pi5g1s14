package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Municipio;

import org.hibernate.Criteria;


import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class MunicipioDao {
 
	private Session session; 
 
		public void inserir(Municipio municipio){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(municipio);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Municipio municipio){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(municipio);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(municipio);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Municipio municipio){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(municipio);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(municipio);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Municipio.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Anexo;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class AnexoDao {
 
	private Session session; 
 
		public void inserir(Anexo anexo){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(anexo);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Anexo anexo){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(anexo);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(anexo);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Anexo anexo){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(anexo);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(anexo);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Anexo.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

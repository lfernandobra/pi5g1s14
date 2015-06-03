package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Responsavel;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class ResponsavelDao {
 
	private Session session; 
 
		public void inserir(Responsavel responsavel){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(responsavel);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Responsavel responsavel){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(responsavel);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(responsavel);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Responsavel responsavel){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(responsavel);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(responsavel);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				String hql = "select resp from Responsavel resp group by resp.id"; 
				Query query = session.createQuery(hql);
				
				List results = query.list();
				
				return results;
			}finally{
				session.close();
 
			}
		}
}

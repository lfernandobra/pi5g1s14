package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.TurmaDisciplina;
 
public class TurmaDisciplinaDao {
 
	private Session session; 
 
		public void inserir(TurmaDisciplina turmaDisciplina){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(turmaDisciplina);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(TurmaDisciplina turmaDisciplina){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(turmaDisciplina);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(turmaDisciplina);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(TurmaDisciplina turmaDisciplina){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(turmaDisciplina);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(turmaDisciplina);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Set listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(TurmaDisciplina.class);
				return new HashSet(cri.list());
			}finally{
				session.close();
 
			}
		}
}

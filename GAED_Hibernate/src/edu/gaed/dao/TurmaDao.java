package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Turma;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class TurmaDao {
 
	private Session session; 
 
		public void inserir(Turma turma){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(turma);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Turma turma){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(turma);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(turma);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Turma turma){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(turma);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(turma);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Turma.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

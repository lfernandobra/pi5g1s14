package edu.gaed.dao;

import java.util.List;
import edu.gaed.vo.Aluno;
import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class AlunoDao {
 
	private Session session; 
 
		public void inserir(Aluno aluno){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(aluno);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Aluno aluno){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(aluno);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(aluno);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Aluno aluno){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(aluno);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(aluno);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Aluno.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

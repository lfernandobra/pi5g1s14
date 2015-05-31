package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Ocorrencia;
import edu.gaed.vo.Responsavel;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class OcorrenciaDao {
 
	private Session session; 
 
		public void inserir(Ocorrencia ocorrencia){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(ocorrencia);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Ocorrencia ocorrencia){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(ocorrencia);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(ocorrencia);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Ocorrencia ocorrencia){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(ocorrencia);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(ocorrencia);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Ocorrencia.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
		
		@SuppressWarnings("rawtypes")
		public List listarPorAluno(Aluno aluno){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				String hql = "FROM Ocorrencia Oc WHERE Oc.aluno = :aluno";
				Query query = session.createQuery(hql);
				query.setParameter("aluno",aluno);
				List results = query.list();
				//Criteria cri = session.createCriteria(Ocorrencia.class);
				
				return results;
			}finally{
				session.close();
 
			}
		}
		
		@SuppressWarnings("rawtypes")
		public List listarPorResponsavel(Responsavel responsavel){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				String hql = "FROM Ocorrencia Oc WHERE Oc.aluno.responsavel = :responsavel";
				Query query = session.createQuery(hql);
				query.setParameter("responsavel",responsavel);
				List results = query.list();
				return results;
			}finally{
				session.close();
 
			}
		}
}

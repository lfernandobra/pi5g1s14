package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Imagem;

import org.hibernate.Criteria;

import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class ImagemDao {
 
	private Session session; 
 
		public void inserir(Imagem imagem){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(imagem);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Imagem imagem){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(imagem);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(imagem);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Imagem imagem){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(imagem);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(imagem);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings("rawtypes")
		public List listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Imagem.class);
				return cri.list();
			}finally{
				session.close();
 
			}
		}
}

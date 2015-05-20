package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;
import edu.gaed.vo.Foto;
import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class FotoDao {
 
	private Session session; 
 
		public void inserir(Foto foto){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(foto);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Foto foto){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(foto);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(foto);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Foto foto){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(foto);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(foto);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Set listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Foto.class);
				return new HashSet(cri.list());
			}finally{
				session.close();
 
			}
		}
}

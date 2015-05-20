package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;
import edu.gaed.vo.Bimestre;
import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
 
public class BimestreDao {
 
	private Session session; 
 
		public void inserir(Bimestre bimestre){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				session.beginTransaction();
				session.save(bimestre);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		public void alterar(Bimestre bimestre){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(bimestre);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.saveOrUpdate(bimestre);
				session.getTransaction().commit();
			}finally{
				session.close();
 
			}
		}
 
		public void excluir(Bimestre bimestre){
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println(bimestre);
			try{
				session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				session.delete(bimestre);
				session.getTransaction().commit();
 
			}finally{
				session.close();
 
			}
		}
 
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Set listar(){
			session = HibernateUtil.getSessionFactory().openSession();
 
			try{
				Criteria cri = session.createCriteria(Bimestre.class);
				return new HashSet(cri.list());
			}finally{
				session.close();
 
			}
		}
}

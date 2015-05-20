package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;
import edu.gaed.vo.UF;
import org.hibernate.Criteria;
import org.hibernate.Session;
import edu.gaed.util.HibernateUtil;

public class UFDao {

	private Session session;

	public void inserir(UF uf) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(uf);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

	public void alterar(UF uf) {
		System.out.println(uf);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(uf);
			session.getTransaction().commit();
		} finally {
			session.close();

		}
	}

	public void excluir(UF uf) {
		System.out.println(uf);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(uf);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Set listar(){
		session = HibernateUtil.getSessionFactory().openSession();

		try{
			Criteria cri = session.createCriteria(UF.class);
			
			return new HashSet(cri.list());
		}finally{
			session.close();

		}
	}
}

package edu.gaed.dao;

import java.util.HashSet;
import java.util.Set;
import edu.gaed.vo.Tarefa;
import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;

public class TarefaDao {

	private Session session;

	public void inserir(Tarefa tarefa) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(tarefa);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

	public void alterar(Tarefa tarefa) {
		System.out.println(tarefa);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(tarefa);
			session.getTransaction().commit();
		} finally {
			session.close();

		}
	}

	public void excluir(Tarefa tarefa) {
		System.out.println(tarefa);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(tarefa);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Set listar(){
		session = HibernateUtil.getSessionFactory().openSession();

		try{
			Criteria cri = session.createCriteria(Tarefa.class);
			return new HashSet(cri.list());
		}finally{
			session.close();

		}
	}
}

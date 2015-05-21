package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;

public class UsuarioDao {

	private Session session;

	public void inserir(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	public void alterar(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(usuario);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(usuario);
			session.getTransaction().commit();
		} finally {
			session.close();

		}
	}

	public void excluir(Usuario usuario) {
		session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(usuario);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(usuario);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	@SuppressWarnings("rawtypes")
	public List listar() {
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria cri = session.createCriteria(Usuario.class);
			return cri.list();
		} finally {
			session.close();

		}
	}

	public Usuario verificarDatos(Usuario usuario) throws Exception {
		Usuario us = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE login = '" + usuario.getLogin()
					+ "' and senha = '" + usuario.getSenha() + "'";
			Query query = session.createQuery(hql);

			if (!query.list().isEmpty()) {
				us = (Usuario) query.list().get(0);
			}

		} catch (Exception e) {
			throw e;
		}

		return us;
	}

}

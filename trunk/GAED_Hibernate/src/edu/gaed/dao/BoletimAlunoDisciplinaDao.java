package edu.gaed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.BoletimAlunoDisciplina;

public class BoletimAlunoDisciplinaDao {
	private Session session;

	public void inserir(BoletimAlunoDisciplina boletimalunodisciplina) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(boletimalunodisciplina);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

	public void alterar(BoletimAlunoDisciplina boletimalunodisciplina) {
		System.out.println(boletimalunodisciplina);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(boletimalunodisciplina);
			session.getTransaction().commit();
		} finally {
			session.close();

		}
	}

	public void excluir(BoletimAlunoDisciplina boletimalunodisciplina) {
		System.out.println(boletimalunodisciplina);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(boletimalunodisciplina);
			session.getTransaction().commit();

		} finally {
			session.close();

		}
	}

	@SuppressWarnings("rawtypes")
	public List listar() {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(BoletimAlunoDisciplina.class);
			return cri.list();
		} finally {
			session.close();

		}
	}
}


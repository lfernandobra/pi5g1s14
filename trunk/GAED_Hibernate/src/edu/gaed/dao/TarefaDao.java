package edu.gaed.dao;

import java.util.List;

import edu.gaed.vo.Aluno;
import edu.gaed.vo.Responsavel;
import edu.gaed.vo.Tarefa;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@SuppressWarnings("rawtypes")
	public List listar() {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Criteria cri = session.createCriteria(Tarefa.class);
			return cri.list();
		} finally {
			session.close();

		}
	}
	
	@SuppressWarnings("rawtypes")
	public List listarPorAluno(Aluno aluno){
		session = HibernateUtil.getSessionFactory().openSession();

		try{
			String hql = "select tar from Tarefa tar join tar.turmas as turma join turma.alunos as aluno where aluno = :aluno"; 
			Query query = session.createQuery(hql);
			query.setParameter("aluno",aluno);
			List results = query.list();
			
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

package edu.gaed.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Aluno;
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
        
        @SuppressWarnings("rawtypes")
    	public List listarPorAluno(Aluno aluno){
    		session = HibernateUtil.getSessionFactory().openSession();

    		try{
    			String hql = "select boletimAluDisc from BoletimAlunoDisciplina boletimAluDisc where boletimAluDisc.pk.aluno =:aluno"; 
    			Query query = session.createQuery(hql);
    			query.setParameter("aluno",aluno);
    			List results = query.list();
    			
    			return results;
    		}finally{
    			session.close();

    		}
    	}
}

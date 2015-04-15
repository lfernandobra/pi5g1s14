package edu.gaed.util;

import edu.gaed.vo.Pessoa;
import org.hibernate.Session;
import edu.gaed.util.HibernateUtil;
 
public class teste {
 
	public static void main(String[] args) {
 
		Session session =  HibernateUtil.getSessionFactory().openSession();
 
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Maria"); 
 
		//realizando operação para salvar no banco
		session.beginTransaction();
		session.save(pessoa);
		session.getTransaction().commit();
		session.close();
	}
}

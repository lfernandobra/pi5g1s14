package edu.gaed.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
 
public class HibernateUtil {
 
	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry;
 
	static {
		try {
			sessionFactory = getSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			sessionFactory.openSession();
			return sessionFactory;
		}
		return sessionFactory;
	}
 
	public static Session getSession() {
		return sessionFactory.openSession();
	}
 
	public static void gerarBanco() {
		// Carrega as configurações do arquivo
		// hibernate.cfg.xml
		Configuration conf = new Configuration();
		conf.configure();
		SchemaExport se2 = new SchemaExport(conf);
		// Executa a operação da criação do Banco de Dados
		se2.create(true, true);
	}
 
}
package edu.gaed.util;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
  
public class HibernateUtil {
      
    //Declara��o de uma vari�vel statica que criar� a sess�o!
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    private static SessionFactory buildSessionFactory() {
        try{
            //Todos os M�todos pertinentes a Configura��o de Sess�o
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }catch(Throwable ex){
            System.err.println("Erro ao Inicial Fqabrica" + ex);
            throw  new ExceptionInInitializerError(ex);
        }
          
    }    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}

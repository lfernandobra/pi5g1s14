package edu.gaed.util;

import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
  
public class HibernateUtil {
      
    //Declaração de uma variável statica que criará a sessão!
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    private static SessionFactory buildSessionFactory() {
        try{
            //Todos os Métodos pertinentes a Configuração de Sessão
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

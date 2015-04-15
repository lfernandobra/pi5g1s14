package edu.gaed.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
 
    public static final SessionFactory session = buildSession();
 
    @SuppressWarnings("deprecation")
	private static SessionFactory buildSession() {
 
    try{
         Configuration cfg = new Configuration();
                       cfg.configure("hibernate.cfg.xml");
        ServiceRegistry serRegis;
        serRegis.
        return cfg..buildSessionFactory("hibernate.cfg.xml");
 
       }catch(Throwable b){
 
            System.out.println("Não deu \n" + b);
            throw new ExceptionInInitializerError();
       }
   }
 
   public static SessionFactory getSessionFactory(){
       return session;
   }
}

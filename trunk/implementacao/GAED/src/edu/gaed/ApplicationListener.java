package edu.gaed;

import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import edu.gaed.dao.BaseDao;;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Executado quando a aplicação web é inicializada
     * 
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	Properties prop = new Properties();
    	 
    	try {
    		//lê o arquivo de propriedades
    		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
    		
    		//obtem as propriedades do arquivo e carrega no Dao
            BaseDao.DRIVER =  prop.getProperty("driver");
            BaseDao.URL =  prop.getProperty("url");
            BaseDao.USER =  prop.getProperty("user");
    		BaseDao.PASSWORD =  prop.getProperty("password");
    		
    		//carrega driver no DriverManager
    		Class.forName(BaseDao.DRIVER);    		
 
    	} catch (Exception ex) {
    		ex.printStackTrace();
        }
    }

	/**
     * Executado quando a aplicação web é finalizada
     * 
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // do nothing
    }
	
}

package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Logradouro;
 
public class LogradouroDao {
      
    public void salvar(Logradouro logradouro){
        //Instancia a fabrica de sess�o, para o hibernate possa tratar a requisi��o
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transa��o se caso der algo errado n�o insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transa��o
            transaction = session.beginTransaction();
            //Salva dados da classe logradouros
            session.save(logradouro);
            //Finaliza a transa��o
            transaction.commit();
        }catch(Exception ex){
              
            if(transaction != null){
                transaction.rollback();
            }
            throw ex;
        }finally{
            //Fecha fabrica de sess�o
            session.close();
        }
    }
     
    public void atualizar(Logradouro logradouro){
        //Chamada da Fabrica de Sess�o, para o Hibernate atender as requisi��es
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transa��o
        Transaction transaction = null;
        try{
            //Atribuindo a transa��o um inicio de uma sess�o
            transaction = session.beginTransaction();
            //Executando a atualiza��o do logradouro no banco
            session.update(logradouro);
            //Finalizando a Transa��o
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(Logradouro logradouro){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(logradouro);
            transaction.commit();
        }catch(RuntimeException ex){
             if(transaction != null){
                transaction.rollback();
            }
            throw  ex;
        }finally{
           session.close();
        }
    }
    
    public Logradouro listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        Logradouro logradouro = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do Logradouro.class
            Query consulta = session.getNamedQuery("Logradouro.listarPorCodigo");
        //Setando um c�digo a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informa��es no objeto logradouro para futuras requisi��es
            logradouro  = (Logradouro) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return logradouro;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List logradouros = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do Logradouro.class
         Query consulta = session.getNamedQuery("Logradouro.listarTudo");
         //Guardando uma lista de Logradouros
          logradouros = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return logradouros;
    }
}  
    
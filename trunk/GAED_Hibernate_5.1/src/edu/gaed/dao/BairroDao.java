package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Bairro;
 
public class BairroDao {
      
    public void salvar(Bairro bairro){
        //Instancia a fabrica de sessão, para o hibernate possa tratar a requisição
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transação se caso der algo errado não insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transação
            transaction = session.beginTransaction();
            //Salva dados da classe bairros
            session.save(bairro);
            //Finaliza a transação
            transaction.commit();
        }catch(Exception ex){
              
            if(transaction != null){
                transaction.rollback();
            }
            throw ex;
        }finally{
            //Fecha fabrica de sessão
            session.close();
        }
    }
     
    public void atualizar(Bairro bairro){
        //Chamada da Fabrica de Sessão, para o Hibernate atender as requisições
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transação
        Transaction transaction = null;
        try{
            //Atribuindo a transação um inicio de uma sessão
            transaction = session.beginTransaction();
            //Executando a atualização do bairro no banco
            session.update(bairro);
            //Finalizando a Transação
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(Bairro bairro){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(bairro);
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
    
    public Bairro listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        Bairro bairro = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do Bairro.class
            Query consulta = session.getNamedQuery("Bairro.listarPorCodigo");
        //Setando um código a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informações no objeto bairro para futuras requisições
            bairro  = (Bairro) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return bairro;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List bairros = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do Bairro.class
         Query consulta = session.getNamedQuery("Bairro.listarTudo");
         //Guardando uma lista de Bairros
          bairros = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return bairros;
    }
}  
    
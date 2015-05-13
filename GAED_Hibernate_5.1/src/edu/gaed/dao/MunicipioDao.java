package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Municipio;
 
public class MunicipioDao {
      
    public void salvar(Municipio municipio){
        //Instancia a fabrica de sess�o, para o hibernate possa tratar a requisi��o
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transa��o se caso der algo errado n�o insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transa��o
            transaction = session.beginTransaction();
            //Salva dados da classe municipios
            session.save(municipio);
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
     
    public void atualizar(Municipio municipio){
        //Chamada da Fabrica de Sess�o, para o Hibernate atender as requisi��es
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transa��o
        Transaction transaction = null;
        try{
            //Atribuindo a transa��o um inicio de uma sess�o
            transaction = session.beginTransaction();
            //Executando a atualiza��o do municipio no banco
            session.update(municipio);
            //Finalizando a Transa��o
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(Municipio municipio){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(municipio);
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
    
    public Municipio listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        Municipio municipio = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do Municipio.class
            Query consulta = session.getNamedQuery("Municipio.listarPorCodigo");
        //Setando um c�digo a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informa��es no objeto municipio para futuras requisi��es
            municipio  = (Municipio) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return municipio;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List municipios = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do Municipio.class
         Query consulta = session.getNamedQuery("Municipio.listarTudo");
         //Guardando uma lista de Municipios
          municipios = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return municipios;
    }
}  
    
package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.UF;
 
public class UFDao {
      
    public void salvar(UF uf){
        //Instancia a fabrica de sessão, para o hibernate possa tratar a requisição
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transação se caso der algo errado não insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transação
            transaction = session.beginTransaction();
            //Salva dados da classe ufs
            session.save(uf);
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
     
    public void atualizar(UF uf){
        //Chamada da Fabrica de Sessão, para o Hibernate atender as requisições
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transação
        Transaction transaction = null;
        try{
            //Atribuindo a transação um inicio de uma sessão
            transaction = session.beginTransaction();
            //Executando a atualização do uf no banco
            session.update(uf);
            //Finalizando a Transação
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(UF uf){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(uf);
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
    
    public UF listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        UF uf = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do UF.class
            Query consulta = session.getNamedQuery("UF.listarPorCodigo");
        //Setando um código a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informações no objeto uf para futuras requisições
            uf  = (UF) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return uf;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List ufs = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do UF.class
         Query consulta = session.getNamedQuery("UF.listarTudo");
         //Guardando uma lista de UFs
          ufs = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return ufs;
    }
}  
    
package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Disciplina;
 
public class DisciplinaDao {
      
    public void salvar(Disciplina disciplina){
        //Instancia a fabrica de sessão, para o hibernate possa tratar a requisição
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transação se caso der algo errado não insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transação
            transaction = session.beginTransaction();
            //Salva dados da classe disciplinas
            session.save(disciplina);
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
     
    public void atualizar(Disciplina disciplina){
        //Chamada da Fabrica de Sessão, para o Hibernate atender as requisições
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transação
        Transaction transaction = null;
        try{
            //Atribuindo a transação um inicio de uma sessão
            transaction = session.beginTransaction();
            //Executando a atualização do disciplina no banco
            session.update(disciplina);
            //Finalizando a Transação
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(Disciplina disciplina){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(disciplina);
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
    
    public Disciplina listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        Disciplina disciplina = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do Disciplina.class
            Query consulta = session.getNamedQuery("Disciplina.listarPorCodigo");
        //Setando um código a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informações no objeto disciplina para futuras requisições
            disciplina  = (Disciplina) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return disciplina;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List disciplinas = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do Disciplina.class
         Query consulta = session.getNamedQuery("Disciplina.listarTudo");
         //Guardando uma lista de Disciplinas
          disciplinas = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return disciplinas;
    }
}  
    
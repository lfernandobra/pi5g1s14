package edu.gaed.dao;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.gaed.util.HibernateUtil;
import edu.gaed.vo.Usuario;
 
public class UsuarioDao {
      
    public void salvar(Usuario usuario){
        //Instancia a fabrica de sessão, para o hibernate possa tratar a requisição
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciada uma transação se caso der algo errado não insira nenhum dado.
        Transaction transaction = null;
        try{
            //Inicia a transação
            transaction = session.beginTransaction();
            //Salva dados da classe usuarios
            session.save(usuario);
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
     
    public void atualizar(Usuario usuario){
        //Chamada da Fabrica de Sessão, para o Hibernate atender as requisições
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Transação
        Transaction transaction = null;
        try{
            //Atribuindo a transação um inicio de uma sessão
            transaction = session.beginTransaction();
            //Executando a atualização do usuario no banco
            session.update(usuario);
            //Finalizando a Transação
            transaction.commit();
        }catch(Exception ex ){
             
            if(transaction != null){
                 
                transaction.rollback();
            }
            throw  ex;
        }
    }
    public void excluir(Usuario usuario){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.delete(usuario);
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
    
    public Usuario listarPorCodigo(long codigo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Instanciando um Objeto do Tipo ALuno para armazenamento de dados
        Usuario usuario = null;
        try{
            //Instanciando um objeto tipo Query e resgatando @NamedQuery do Usuario.class
            Query consulta = session.getNamedQuery("Usuario.listarPorCodigo");
        //Setando um código a busca pelo parametro codigo acima
            consulta.setLong("codigo", codigo);
        //Guardando informações no objeto usuario para futuras requisições
            usuario  = (Usuario) consulta.uniqueResult();
        }catch(RuntimeException ex){
           throw ex;
        }finally{
            session.close();
        }
          
        return usuario;
    }
    
    @SuppressWarnings({ "rawtypes" })
    public List listarTudo(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List usuarios = null;
        try{
        //Instranciando um objeto tipo Query e pegando a @NamedQuery do Usuario.class
         Query consulta = session.getNamedQuery("Usuario.listarTudo");
         //Guardando uma lista de Usuarios
          usuarios = consulta.list();
        }catch(RuntimeException ex){
            throw ex;
        }finally{
            session.close();
        }
          
        return usuarios;
    }
}  
    
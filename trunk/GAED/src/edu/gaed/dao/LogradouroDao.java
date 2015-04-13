package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.vo.Logradouro;

public class LogradouroDao extends DAO{
	
	private List<Logradouro> logradouros;
	
	//getters and setters
	public List<Logradouro> getUfs() {
		return logradouros;
	}

	public void setUfs(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	//Salvar ou Editar
	public void salvar(Logradouro logradouro) throws Exception {
		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Verifica se a entidade ainda não está salva no banco de dados.
			if (logradouro.getId() == null) {
				// Salva os dados da pessoa.
				em.persist(logradouro);
			} else {
				// Atualiza os dados da pessoa.
				logradouro = em.merge(logradouro);
			}
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}	
	
	//Excluir
	public void excluir(Logradouro logradouro) throws Exception{

		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Consulta a pessoa na base de dados através do seu ID.
			System.out.println("Excluindo os dados de: " + logradouro.getNome());
			// Remove a pessoa da base de dados.
			Logradouro c=em.merge(logradouro); 
			
			em.remove(c);
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Logradouro> lista() {
		
		if(this.logradouros == null) {
			Query q = em.createQuery("select l from Logradouro l",Logradouro.class);
			this.logradouros= q.getResultList();
		}	
		return logradouros;
	
	}
	
	//Buscar
	public Logradouro buscaLogradouro(Logradouro logradouro) {
	    return em.find(Logradouro.class, logradouro.getId());
	}
	
	
	//Consulta por ID
	public Logradouro consultarPorId(Long id) {
	    
	    Logradouro logradouro = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      logradouro = em.find(Logradouro.class, id);
	    } finally {
	      em.close();
	    }
	    return logradouro;
	}
	

	
	  
}  



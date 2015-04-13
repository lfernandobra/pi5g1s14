package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.vo.Bairro;

public class BairroDao extends DAO{
	
	private List<Bairro> bairros;
	
	//getters and setters
	public List<Bairro> getUfs() {
		return bairros;
	}

	public void setUfs(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	//Salvar ou Editar
	public void salvar(Bairro bairro) throws Exception {
		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Verifica se a entidade ainda não está salva no banco de dados.
			if (bairro.getId() == null) {
				// Salva os dados da pessoa.
				em.persist(bairro);
			} else {
				// Atualiza os dados da pessoa.
				bairro = em.merge(bairro);
			}
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}	
	
	//Excluir
	public void excluir(Bairro bairro) throws Exception{

		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Consulta a pessoa na base de dados através do seu ID.
			System.out.println("Excluindo os dados de: " + bairro.getNome());
			// Remove a pessoa da base de dados.
			Bairro c=em.merge(bairro); 
			
			em.remove(c);
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<Bairro> lista() {
		
		if(this.bairros == null) {
			Query q = em.createQuery("select b from Bairro b",Bairro.class);
			this.bairros= q.getResultList();
		}	
		return bairros;
	
	}
	
	//Buscar
	public Bairro buscaBairro(Bairro bairro) {
	    return em.find(Bairro.class, bairro.getId());
	}
	
	
	//Consulta por ID
	public Bairro consultarPorId(Long id) {
	    
	    Bairro bairro = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      bairro = em.find(Bairro.class, id);
	    } finally {
	      em.close();
	    }
	    return bairro;
	}
	

	
	  
}  



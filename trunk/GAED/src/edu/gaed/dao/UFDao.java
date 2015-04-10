package edu.gaed.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.vo.UF;

public class UFDao extends DAO{
	
	private List<UF> ufs;
	
	//getters and setters
	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	//Salvar
	public void salvar(UF uf) throws Exception {
		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Verifica se a entidade ainda não está salva no banco de dados.
			if (uf.getId() == null) {
				// Salva os dados da pessoa.
				em.persist(uf);
			} else {
				// Atualiza os dados da pessoa.
				uf = em.merge(uf);
			}
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	
	
	//Excluir
	public void excluir(UF uf) throws Exception{

		try {
			// Inicia uma transação com o banco de dados.
			tx.begin();
			// Consulta a pessoa na base de dados através do seu ID.
			UF ufEncontrado = em.find(UF.class, uf.getId());
			System.out.println("Excluindo os dados de: " + uf.getNome());
			// Remove a pessoa da base de dados.
			em.remove(ufEncontrado);
			// Finaliza a transação.
			tx.commit();
		} finally {
			em.close();
		}
	}
	
	//Listar
	@SuppressWarnings("unchecked")
	public List<UF> lista() {
		
		if(this.ufs == null) {
			Query q = em.createQuery("select uf from UF uf",UF.class);
			this.ufs= q.getResultList();
		}	
		return ufs;
	
	}
	
	//Buscar
	public UF buscaUF(UF uf) {
	    return em.find(UF.class, uf.getId());
	}
	
	
	//Consulta por ID
	public UF consultarPorId(Long id) {
	    
	    UF uf = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      uf = em.find(UF.class, id);
	    } finally {
	      em.close();
	    }
	    return uf;
	}
	

	
	  
}  



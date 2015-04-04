package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.gaed.controladores.JPAUtil;
import edu.gaed.vo.UF;


@ManagedBean(name="UFBean")
public class UFBean {
	private UF uf = new UF();
	private List<UF> ufs;
	
	//getter e setter


	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}
	
	/*
	public List<UF> getUfs() {
		return ufs;
	}
	*/
	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

	
	public void salva(UF uf) {
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(uf);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<UF> getUfs() {
		
		if(this.ufs == null) {
			EntityManager em = JPAUtil.getEntityManager();
			Query q = em.createQuery("select uf from UF uf",UF.class);
			this.ufs= q.getResultList();
			em.close();
		}	
		return ufs;
	
	}
	

	
}

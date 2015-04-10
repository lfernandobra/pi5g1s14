package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.gaed.controladores.SimpleEntityManager;
import edu.gaed.dao.UFDao2;
import edu.gaed.vo.UF;


@ManagedBean(name="UFBean2")
public class UFBean2 {
    
	private UFDao2 dao;
	
	UF uf = new UF();
	 
	List<UF> ufs = new ArrayList<UF>(); 
     
    private SimpleEntityManager simpleEntityManager;
     
    public UFBean2(SimpleEntityManager simpleEntityManager){
        this.simpleEntityManager = simpleEntityManager;
        dao = new UFDao2(simpleEntityManager.getEntityManager());
    }
    
    public UFBean2() {
		super();
		// TODO Auto-generated constructor stub
	}
    
  //Métodos dos botões 
  	public void cadastrar(){
  		dao.save(uf);
  		ufs = dao.findAll();
  		uf = new UF();
  	}
   
  	public void alterar(){
  		dao.update(uf);
  		ufs = dao.findAll();
  		uf = new UF();
  	}
  	public void excluir(){
  		dao.delete(uf);;
  		ufs = dao.findAll();
  		uf = new UF();
  	}
   
  	//getters and setters
  	public UF getUF() {
  		return uf;
  	}
   
  	public void setUF(UF uf) {
  		this.uf = uf;
  	}
   
    
    public void save(UF uf){
        try{
            simpleEntityManager.beginTransaction();
            uf.validate();
            dao.save(uf);
            simpleEntityManager.commit();
        }catch(Exception e){
            e.printStackTrace();
            simpleEntityManager.rollBack();
        }
    }
     
    public List<UF> findAll(){
        return dao.findAll();
    }

	public UFDao2 getDao() {
		return dao;
	}

	public void setDao(UFDao2 dao) {
		this.dao = dao;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

	public SimpleEntityManager getSimpleEntityManager() {
		return simpleEntityManager;
	}

	public void setSimpleEntityManager(SimpleEntityManager simpleEntityManager) {
		this.simpleEntityManager = simpleEntityManager;
	}

}
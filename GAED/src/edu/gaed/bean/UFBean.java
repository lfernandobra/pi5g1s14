package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.gaed.dao.UFDao;
import edu.gaed.vo.UF;


@ManagedBean(name="UFBean")
public class UFBean {
	
	private UF uf = new UF();
	private List<UF> ufs;
    
	private UFDao dao = new UFDao();
    
    public UF getUf() {
		return uf;
	}


	public void setUf(UF uf) {
		this.uf = uf;
	}


	public UFDao getDao() {
		return dao;
	}


	public void setDao(UFDao dao) {
		this.dao = dao;
	}	

	public void salvar(){
        dao.add(uf);
    }
	
	public List<UF> lista() {
		return dao.lista();
	}
	
	public void excluir(UF uf){
		dao.excluir(uf);
	}

	public List<UF> getUfs() {
		return ufs;
	}

	public void setUfs(List<UF> ufs) {
		this.ufs = ufs;
	}

}

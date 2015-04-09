package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.gaed.dao.MunicipioDao;
import edu.gaed.vo.Municipio;

@ManagedBean(name="MunicipioBean")
public class MunicipioBean {
	
	private Municipio munic = new Municipio();
	private List<Municipio> munics; 
	private MunicipioDao dao = new MunicipioDao();
	
    //getters e setters
    public Municipio getUf() {
		return munic;
	}
    
	public void setUf(Municipio munic) {
		this.munic = munic;
	}
	
	public MunicipioDao getDao() {
		return dao;
	}
	
	public void setDao(MunicipioDao dao) {
		this.dao = dao;
	}	
	
	public List<Municipio> getUfs() {
		return munics;
	}

	public void setUfs(List<Municipio> munics) {
		this.munics = munics;
	}
	
	
	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(){
        dao.salvar(munic);
    }
	//Listar 
	public List<Municipio> lista() {
		return dao.lista();
	}
	//Excluir 
	public void excluir(Municipio munic){
		dao.excluir(munic);
	}
	//Alterar
	public void editar(Municipio munic){
		dao.editar(munic);
	}
	//Buscar
	public Municipio buscar(Municipio munic){
		return dao.buscaMunicipio(munic);
	}
}

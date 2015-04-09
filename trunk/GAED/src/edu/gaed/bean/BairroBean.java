package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.gaed.dao.BairroDao;
import edu.gaed.vo.Bairro;

@ManagedBean(name="BairroBean")
public class BairroBean {
	
	private Bairro bairro = new Bairro();
	private List<Bairro> bairros; 
	private BairroDao dao = new BairroDao();
	
    //getters e setters
    public Bairro getUf() {
		return bairro;
	}
    
	public void setUf(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public BairroDao getDao() {
		return dao;
	}
	
	public void setDao(BairroDao dao) {
		this.dao = dao;
	}	
	
	public List<Bairro> getUfs() {
		return bairros;
	}

	public void setUfs(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	
	
	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(){
        dao.salvar(bairro);
    }
	//Listar 
	public List<Bairro> lista() {
		return dao.lista();
	}
	//Excluir 
	public void excluir(Bairro bairro){
		dao.excluir(bairro);
	}
	//Alterar
	public void editar(Bairro bairro){
		dao.editar(bairro);
	}
	//Buscar
	public Bairro buscar(Bairro bairro){
		return dao.buscaBairro(bairro);
	}
}

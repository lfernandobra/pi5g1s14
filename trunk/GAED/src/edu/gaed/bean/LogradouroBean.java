package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import edu.gaed.dao.LogradouroDao;
import edu.gaed.vo.Logradouro;

@ManagedBean(name="LogradouroBean")
public class LogradouroBean {
	
	private Logradouro logradouro = new Logradouro();
	private List<Logradouro> logradouros; 
	private LogradouroDao dao = new LogradouroDao();
	
    //getters e setters
    public Logradouro getUf() {
		return logradouro;
	}
    
	public void setUf(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	
	public LogradouroDao getDao() {
		return dao;
	}
	
	public void setDao(LogradouroDao dao) {
		this.dao = dao;
	}	
	
	public List<Logradouro> getUfs() {
		return logradouros;
	}

	public void setUfs(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}
	
	
	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(){
        dao.salvar(logradouro);
    }
	//Listar 
	public List<Logradouro> lista() {
		return dao.lista();
	}
	//Excluir 
	public void excluir(Logradouro logradouro){
		dao.excluir(logradouro);
	}
	//Alterar
	public void editar(Logradouro logradouro){
		dao.editar(logradouro);
	}
	//Buscar
	public Logradouro buscar(Logradouro logradouro){
		return dao.buscaLogradouro(logradouro);
	}
}

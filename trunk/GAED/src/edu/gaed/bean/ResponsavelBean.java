package edu.gaed.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import edu.gaed.dao.ResponsavelDao;
import edu.gaed.vo.Responsavel;
import edu.gaed.vo.Usuario;


@ManagedBean(name="ResponsavelBean")
public class ResponsavelBean {
	
	private Responsavel responsavel = new Responsavel();
	private List<Usuario> responsaveis; 
	private ResponsavelDao dao = new ResponsavelDao();
	
    //getters e setters
	public Responsavel getResponsavel() {
		return (Responsavel) responsavel;
	}
	
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public ResponsavelDao getDao() {
		return dao;
	}
	
	public void setDao(ResponsavelDao dao) {
		this.dao = dao;
	}

	public List<Usuario> getResponsaveis() {
		return responsaveis;
	}
	public void setResponsaveis(List<Usuario> responsaveis) {
		this.responsaveis = responsaveis;
	}	
	
	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(){
        dao.salvar(responsavel);
    }
	//Listar 
	public List<Responsavel> lista() {
		return dao.lista();
	}
	//Excluir 
	public void excluir(Responsavel responsavel){
		dao.excluir(responsavel);
	}
	//Alterar
	public void editar(Responsavel responsavel){
		dao.editar(responsavel);
	}
	//Buscar
	public Responsavel buscar(){
		return dao.busca(responsavel);
	}
	
	
}

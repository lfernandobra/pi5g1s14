package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped; 




import edu.gaed.dao.LogradouroDao;
import edu.gaed.vo.Logradouro;


@ManagedBean(name="LogradouroBean")
@ViewScoped
public class LogradouroBean {
	
	Logradouro logradouro = new Logradouro();
	List<Logradouro> logradouros = new ArrayList<Logradouro>();
    
	public LogradouroBean(){
		logradouros = new LogradouroDao().lista();
		logradouro = new Logradouro();
	}
	
	@PostConstruct
    public void init(){
        logradouro = new Logradouro();
        logradouros = new LogradouroDao().lista();
    }
	
	//getters e setters
    	
	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(Logradouro logradouro) throws Exception{
		new LogradouroDao().salvar(logradouro);
		logradouros = new LogradouroDao().lista();
		logradouro = new Logradouro();
    }
		
	//Excluir 
	public void excluir(Logradouro logradouro) throws Exception{
		new LogradouroDao().excluir(logradouro);
		logradouros = new LogradouroDao().lista();
		logradouro = new Logradouro();
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}
	
	public String getLogradouroEscolhida(){
        return logradouro!=null && logradouro.getId()!=null ? logradouro.toString():"Classe não escolhida";
    }

}

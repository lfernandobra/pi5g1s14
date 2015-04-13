package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped; 




import edu.gaed.dao.BairroDao;
import edu.gaed.vo.Bairro;


@ManagedBean(name="BairroBean")
@ViewScoped
public class BairroBean {
	
	Bairro bairro = new Bairro();
	List<Bairro> bairros = new ArrayList<Bairro>();
    
	public BairroBean(){
		bairros = new BairroDao().lista();
		bairro = new Bairro();
	}
	
	@PostConstruct
    public void init(){
        bairro = new Bairro();
        bairros = new BairroDao().lista();
    }
	
	//getters e setters
    	
	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(Bairro bairro) throws Exception{
		new BairroDao().salvar(bairro);
		bairros = new BairroDao().lista();
		bairro = new Bairro();
    }
		
	//Excluir 
	public void excluir(Bairro bairro) throws Exception{
		new BairroDao().excluir(bairro);
		bairros = new BairroDao().lista();
		bairro = new Bairro();
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	
	public String getBairroEscolhida(){
        return bairro!=null && bairro.getId()!=null ? bairro.toString():"Classe não escolhida";
    }

}

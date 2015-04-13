package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped; 




import edu.gaed.dao.MunicipioDao;
import edu.gaed.vo.Municipio;


@ManagedBean(name="MunicipioBean")
@ViewScoped
public class MunicipioBean {
	
	Municipio munic = new Municipio();
	List<Municipio> munics = new ArrayList<Municipio>();
    
	public MunicipioBean(){
		munics = new MunicipioDao().lista();
		munic = new Municipio();
	}
	
	@PostConstruct
    public void init(){
        munic = new Municipio();
        munics = new MunicipioDao().lista();
    }
	public String getUFEscolhida(){
        return munic!=null && munic.getId()!=null ? munic.toString():"Classe não escolhida";
    }
	
	//getters e setters
    	
	public Municipio getMunic() {
		return munic;
	}

	public void setMunic(Municipio munic) {
		this.munic = munic;
	}

	//Métodos da classe CRUD
	
	//Salvar
	public void salvar(Municipio munic) throws Exception{
		System.out.println(munic);
		new MunicipioDao().salvar(munic);
		munics = new MunicipioDao().lista();
		munic = new Municipio();
    }
		
	//Excluir 
	public void excluir(Municipio munic) throws Exception{
		new MunicipioDao().excluir(munic);
		munics = new MunicipioDao().lista();
		munic = new Municipio();
	}

	public List<Municipio> getMunics() {
		return munics;
	}

	public void setMunics(List<Municipio> munics) {
		this.munics = munics;
	}

}

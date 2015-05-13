package edu.gaed.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import edu.gaed.vo.Bairro;
import edu.gaed.dao.BairroDao;
 
@ManagedBean(name="BairroBean")
@ViewScoped
public class BairroBean {
 
	Bairro bairro = new Bairro();
	 
	List<Bairro> bairros = new ArrayList<Bairro>(); 
	
	public BairroBean(Bairro bairro, List<Bairro> bairros) {
		super();
		this.bairro = new Bairro();
		this.bairros = new ArrayList<Bairro>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public BairroBean(){
		bairros = new BairroDao().listarTudo();
		bairro = new Bairro();
	}
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new BairroDao().salvar(bairro);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Cadastrado",  "Unidade Federativa: " + bairro.getNome() + " cadastrado com sucesso") );
		bairros = new BairroDao().listarTudo();
		bairro = new Bairro();
		
		
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new BairroDao().atualizar(bairro);;
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Alterado",  "Unidade Federativa: " + bairro.getNome() + " alterada com sucesso") );
		bairros = new BairroDao().listarTudo();
		bairro = new Bairro();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Bairro bairroex){
		new BairroDao().excluir(bairroex);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Excluido",  "Unidade Federativa: " + bairroex.getNome() + " excluida com sucesso") );
		bairros = new BairroDao().listarTudo();
		bairro = new Bairro();
	}
	
	//getters and setters
	

	public List<Bairro> getUfs() {
		return bairros;
	}

	public void setUfs(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro getUf() {
		return bairro;
	}

	public void setUf(Bairro bairro) {
		this.bairro = bairro;
	}
 
	// métodos reset
	
	
}

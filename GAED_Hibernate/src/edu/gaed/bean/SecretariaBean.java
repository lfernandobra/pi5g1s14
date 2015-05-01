package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Secretaria;
import edu.gaed.dao.SecretariaDao;
 
@ManagedBean(name="SecretariaBean")
@ViewScoped
public class SecretariaBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Secretaria secretaria = new Secretaria();
	 
	List<Secretaria> secretarias = new ArrayList<Secretaria>(); 
	
	public SecretariaBean(Secretaria secretaria, List<Secretaria> secretarias) {
		super();
		this.secretaria = new Secretaria();
		this.secretarias = new ArrayList<Secretaria>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public SecretariaBean(){
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
       
    }
	public String getSecretariaEscolhida(){
        return secretaria!=null && secretaria.getId()!=null ? secretaria.toString():"Classe n�o escolhida";
    }
 
	//M�todos dos bot�es 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new SecretariaDao().inserir(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new SecretariaDao().alterar(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Secretaria secretaria){
		new SecretariaDao().excluir(secretaria);
		secretarias = new SecretariaDao().listar();
		secretaria = new Secretaria();
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}

	public List<Secretaria> getSecretarias() {
		return secretarias;
	}

	public void setSecretarias(List<Secretaria> secretarias) {
		this.secretarias = secretarias;
	}
 
	//getters and setters
	
 
	
}

package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Imagem;
import edu.gaed.dao.ImagemDao;
 
@ManagedBean(name="ImagemBean")
@ViewScoped
public class ImagemBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Imagem imagem = new Imagem();
	 
	Set<Imagem> imagems = new HashSet<Imagem>(); 
	
	public ImagemBean(Imagem imagem, Set<Imagem> imagems) {
		super();
		this.imagem = new Imagem();
		this.imagems = new HashSet<Imagem>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public ImagemBean(){
		imagems = new ImagemDao().listar();
		imagem = new Imagem();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		imagems = new ImagemDao().listar();
		imagem = new Imagem();
       
    }
	public String getImagemEscolhida(){
        return imagem!=null && imagem.getId()!=null ? imagem.toString():"Classe não escolhida";
    }
 
	public Set<Imagem> getImagems() {
		return imagems;
	}

	public void setImagems(Set<Imagem> imagems) {
		this.imagems = imagems;
	}

	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new ImagemDao().inserir(imagem);
		imagems = new ImagemDao().listar();
		imagem = new Imagem();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Imagem imagem){
		new ImagemDao().alterar(imagem);
		imagems = new ImagemDao().listar();
		imagem = new Imagem();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new ImagemDao().excluir(imagem);
		imagems = new ImagemDao().listar();
		imagem = new Imagem();
	}

	public Imagem getImagem() {
		return imagem;
	}

	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	
 
	//getters and setters
	
 
	
}

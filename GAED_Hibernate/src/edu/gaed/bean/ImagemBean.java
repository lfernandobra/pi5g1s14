package edu.gaed.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	 
	List<Imagem> imagems = new ArrayList<Imagem>(); 
	
	public ImagemBean(Imagem imagem, List<Imagem> imagems) {
		super();
		this.imagem = new Imagem();
		this.imagems = new ArrayList<Imagem>();
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

	public List<Imagem> getImagems() {
		return imagems;
	}

	public void setImagems(List<Imagem> imagems) {
		this.imagems = imagems;
	}
 
	//getters and setters
	
 
	
}

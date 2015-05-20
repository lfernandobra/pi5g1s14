package edu.gaed.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import edu.gaed.vo.Serie;
import edu.gaed.dao.SerieDao;
 
@ManagedBean(name="SerieBean")
@ViewScoped
public class SerieBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Serie serie = new Serie();
	 
	Set<Serie> series = new HashSet<Serie>(); 
	
	public SerieBean(Serie serie, Set<Serie> series) {
		super();
		this.serie = new Serie();
		this.series = new HashSet<Serie>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public SerieBean(){
		series = new SerieDao().listar();
		serie = new Serie();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		series = new SerieDao().listar();
		serie = new Serie();
       
    }
	public String getSerieEscolhida(){
        return serie!=null && serie.getId()!=null ? serie.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new SerieDao().inserir(serie);
		series = new SerieDao().listar();
		serie = new Serie();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(){
		new SerieDao().alterar(serie);
		series = new SerieDao().listar();
		serie = new Serie();
	}
	@SuppressWarnings("unchecked")
	public void excluir(Serie serie){
		new SerieDao().excluir(serie);
		series = new SerieDao().listar();
		serie = new Serie();
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Set<Serie> getSeries() {
		return series;
	}

	public void setSeries(Set<Serie> series) {
		this.series = series;
	}

	
 
	//getters and setters
	
 
	
}

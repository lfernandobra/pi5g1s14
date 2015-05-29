package edu.gaed.bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

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
	
	public void fileUpload(FileUploadEvent event) throws IOException {
		try {
			// Instância objetos
			ImagemDao imagemDao = new ImagemDao();

			// Cria um arquivo UploadFile, para receber o arquivo do evento
			UploadedFile arq = event.getFile();
			// Transformar a imagem em bytes para salvar em banco de dados
			byte[] bimagem = event.getFile().getContents();
			imagem.setImagem(bimagem);
			imagem.setNome(arq.getFileName());
			imagemDao.inserir(imagem);

			FacesMessage msg = new FacesMessage("O Arquivo ", arq.getFileName()
					+ " salvo em banco de dados.");
			FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String verImagem(byte [] foto,String nome) {
		
		try {
            ServletContext sContext = (ServletContext) FacesContext
                    .getCurrentInstance().getExternalContext().getContext();
 
            File folder = new File(sContext.getRealPath("/temp"));
            if (!folder.exists()){
                folder.mkdirs();
 
            }
             String nomeArquivo = nome + ".png";
             String arquivo = sContext.getRealPath("/temp") + File.separator
                        + nomeArquivo;
             System.out.println(arquivo);
             System.out.println(foto);
             criaArquivo(foto, arquivo);
             
             return nomeArquivo;
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return null;	
    }

	private void criaArquivo(byte[] bytes, String arquivo) {
	    FileOutputStream fos;
	
	    try {
	        fos = new FileOutputStream(arquivo);
	        fos.write(bytes);
	
	        fos.flush();
	        fos.close();
	    } catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
 
}

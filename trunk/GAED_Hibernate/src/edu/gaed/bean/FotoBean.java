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

import edu.gaed.vo.Foto;
import edu.gaed.dao.FotoDao;
 
@ManagedBean(name="FotoBean")
@ViewScoped
public class FotoBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Foto foto = new Foto();
	 
	List<Foto> fotos = new ArrayList<Foto>(); 
	
	public FotoBean(Foto foto, List<Foto> fotos) {
		super();
		this.foto = new Foto();
		this.fotos = new ArrayList<Foto>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public FotoBean(){
		fotos = new FotoDao().listar();
		foto = new Foto();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		fotos = new FotoDao().listar();
		foto = new Foto();
       
    }
	public String getFotoEscolhida(){
        return foto!=null && foto.getId()!=null ? foto.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new FotoDao().inserir(foto);
		fotos = new FotoDao().listar();
		foto = new Foto();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Foto foto){
		new FotoDao().alterar(foto);
		fotos = new FotoDao().listar();
		foto = new Foto();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new FotoDao().excluir(foto);
		fotos = new FotoDao().listar();
		foto = new Foto();
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}
 
	//getters and setters
	public void fileUpload(FileUploadEvent event) throws IOException {
		try {
			// Instância objetos
			FotoDao fotoDao = new FotoDao();
			//Foto im = new Foto();

			// Cria um arquivo UploadFile, para receber o arquivo do evento
			UploadedFile arq = event.getFile();
			// Transformar a imagem em bytes para salvar em banco de dados
			byte[] bimagem = event.getFile().getContents();
			foto.setFoto(bimagem);
			foto.setNome(arq.getFileName());
			fotoDao.inserir(foto);

			// Essa parte comentada deve ser usada caso queira salvar
			// o arquivo em um local fisuco do servidor.
			/*
			 * InputStream in = new BufferedInputStream(arq.getInputstream());
			 * File file = new File("C://var//" + arq.getFileName()); //O método
			 * file.getAbsolutePath() fornece o caminho do arquivo criado //Pode
			 * ser usado para ligar algum objeto do banco ao arquivo enviado
			 * String caminho = file.getAbsolutePath(); FileOutputStream fout =
			 * new FileOutputStream(file); while(in.available() != 0) {
			 * fout.write(in.read()); } fout.close();
			 */
			FacesMessage msg = new FacesMessage("O Arquivo ", arq.getFileName()
					+ " salvo em banco de dados.");
			FacesContext.getCurrentInstance().addMessage("msgUpdate", msg);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void verFoto(byte [] foto,String nome) {
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
    
             
        } catch (Exception ex) {
            ex.printStackTrace();
        }	
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

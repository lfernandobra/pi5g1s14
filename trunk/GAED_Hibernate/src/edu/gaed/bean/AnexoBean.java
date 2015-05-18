package edu.gaed.bean;

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

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import edu.gaed.vo.Anexo;
import edu.gaed.dao.AnexoDao;
 
@ManagedBean(name="AnexoBean")
@ViewScoped
public class AnexoBean implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Anexo anexo = new Anexo();
	 
	List<Anexo> anexos = new ArrayList<Anexo>(); 
	
	public AnexoBean(Anexo anexo, List<Anexo> anexos) {
		super();
		this.anexo = new Anexo();
		this.anexos = new ArrayList<Anexo>();
	}
 
	//construtor
	@SuppressWarnings("unchecked")
	public AnexoBean(){
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
    public void init(){
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
       
    }
	public String getAnexoEscolhida(){
        return anexo!=null && anexo.getId()!=null ? anexo.toString():"Classe não escolhida";
    }
 
	//Métodos dos botões 
	@SuppressWarnings("unchecked")
	public void cadastrar(ActionEvent actionEvent){
		new AnexoDao().inserir(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
 
	@SuppressWarnings("unchecked")
	public void alterar(Anexo anexo){
		new AnexoDao().alterar(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}
	@SuppressWarnings("unchecked")
	public void excluir(ActionEvent actionEvent){
		new AnexoDao().excluir(anexo);
		anexos = new AnexoDao().listar();
		anexo = new Anexo();
	}

	public Anexo getAnexo() {
		return anexo;
	}

	public void setAnexo(Anexo anexo) {
		this.anexo = anexo;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
 
	//getters and setters
	public void fileUpload(FileUploadEvent event) throws IOException {
		try {
			// Instância objetos
			AnexoDao anexoDao = new AnexoDao();
			//anexo = new Anexo();

			// Cria um arquivo UploadFile, para receber o arquivo do evento
			UploadedFile arq = event.getFile();
			// Transformar a imagem em bytes para salvar em banco de dados
			byte[] bimagem = event.getFile().getContents();
			anexo.setAnexo(bimagem);
			anexo.setNome(arq.getFileName());
			anexoDao.inserir(anexo);

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
	
}

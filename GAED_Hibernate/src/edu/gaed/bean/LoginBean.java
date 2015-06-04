package edu.gaed.bean;
 
//import javax.faces.application.FacesMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.codec.digest.DigestUtils;

import edu.gaed.dao.LoginDao;
import edu.gaed.vo.Aluno;
import edu.gaed.vo.Gestor;
import edu.gaed.vo.Professor;
import edu.gaed.vo.Responsavel;
import edu.gaed.vo.Secretaria;
import edu.gaed.vo.Usuario;
 
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
     
	private Usuario usuario = new Usuario();
	private String login = new String();
	private String senha = new String();
	private Aluno aluno = new Aluno();
	private Gestor gestor = new Gestor();
	private Professor professor = new Professor();
	private Responsavel responsavel = new Responsavel();
	private Secretaria secretaria = new Secretaria();
	
	
	public LoginBean() {
		super();
	}

	
	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}     
     
    public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	

	public Gestor getGestor() {
		return gestor;
	}


	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public Responsavel getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}


	public Secretaria getSecretaria() {
		return secretaria;
	}


	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}


	public String verificarDatos() throws Exception {
		LoginDao usuDAO = new LoginDao();
		Usuario us;
		String resultado = null;
	
		try {
			String encript = DigestUtils.md5Hex(this.senha);
			//String encript = DigestUtils.sha1Hex(this.usuario.getSenha());
			//this.usuario.setSenha(encript);
			
			us = usuDAO.verificaDados(login,encript);
			
			this.usuario = us;
			if(us != null && us.getPerfil().isAluno()) {
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado "));
				this.aluno = (Aluno) usuario;
				resultado = "home";
			}
			else if(us != null && us.getPerfil().isGestor()){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado "));
				this.gestor = (Gestor) usuario;
				resultado = "home";
			}
			else if(us != null && us.getPerfil().isProfessor()){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado "));
				this.professor = (Professor) usuario;
				resultado = "home";
			}
			else if(us != null && us.getPerfil().isResponsavel()){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado "));
				this.responsavel = (Responsavel) usuario;
				resultado = "home";
			}
			else if(us != null && us.getPerfil().isResponsavel()){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado "));
				this.setSecretaria((Secretaria) usuario);
				resultado = "home";
			}
			else if(us == null){ 
				FacesContext context = FacesContext.getCurrentInstance();
		        context.addMessage(null, new FacesMessage("Autenticação falhou",  "Login ou Senha estão incorretos ") );
				resultado = "login";
				}
		} catch (Exception e) {
			throw e;
		}
		System.out.println(resultado);
		return resultado;
	}
    
    public boolean verificarSessao(){
    	boolean estado;
    	
    	if (FacesContext.getCurrentInstance().getExternalContext()
    			.getSessionMap().get("usuario") == null){
    		estado = false;
    	} else {
    		estado = true;
    	}
    	
    	return estado;
    	
    }
    
    
    public String encerrarSession(){
    	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    	return "login";
    }
    
    public String verFoto() {
		
    	try {
            ServletContext sContext = (ServletContext) FacesContext
                    .getCurrentInstance().getExternalContext().getContext();
 
            File folder = new File(sContext.getRealPath("/temp"));
            if (!folder.exists()){
                folder.mkdirs();
 
            }
             String nomeArquivo = usuario.getNome() + ".png";
             String arquivo = sContext.getRealPath("/temp") + File.separator
                        + nomeArquivo;
             System.out.println(arquivo);
             System.out.println(usuario.getFoto().getFoto());
             criaArquivo(usuario.getFoto().getFoto(), arquivo);
             
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
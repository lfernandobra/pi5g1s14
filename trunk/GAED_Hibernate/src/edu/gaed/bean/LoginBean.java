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
import edu.gaed.vo.Usuario;
 
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
     
	private Usuario usuario = new Usuario();
	
	public LoginBean() {
		super();
	}

	
	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}     
    
 
    public String verificarDatos() throws Exception {
		LoginDao usuDAO = new LoginDao();
		Usuario us;
		String resultado;
	
		try {
			String encript = DigestUtils.md5Hex(this.usuario.getSenha());
			//String encript = DigestUtils.sha1Hex(this.usuario.getSenha());
			this.usuario.setSenha(encript);
			
			us = usuDAO.verificaDados(this.usuario);
			this.usuario = us;
			if(us != null) {
				FacesContext.getCurrentInstance().getExternalContext()
						.getSessionMap().put("usuario",us);
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Autenticação realizada com sucesso",  "Autenticado ") );
				resultado = "home";
			} else { 
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
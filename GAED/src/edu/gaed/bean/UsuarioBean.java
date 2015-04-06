package edu.gaed.bean;

import javax.faces.bean.ManagedBean;

import edu.gaed.dao.UsuarioDAO;
import edu.gaed.vo.Usuario;

@ManagedBean(name="UsuarioBean")
public class UsuarioBean {
	
	private Usuario usr = new Usuario();
	private UsuarioDAO usrdao = new UsuarioDAO(); 
	
	
	public void procurar(){
        usrdao.procure(usr.getLogin());
    }
	
	public boolean valida(){
		return usrdao.valideUsuario(usr, usr.getSenha());
	}
	
	public void login(){
		if(usrdao.procure(usr.getLogin())){
			
		}
	}
	
	//getters e setters
	public Usuario getUsr() {
		return usr;
	}

	public void setUsr(Usuario usr) {
		this.usr = usr;
	}

	public UsuarioDAO getUsrdao() {
		return usrdao;
	}

	public void setUsrdao(UsuarioDAO usrdao) {
		this.usrdao = usrdao;
	}
	
}

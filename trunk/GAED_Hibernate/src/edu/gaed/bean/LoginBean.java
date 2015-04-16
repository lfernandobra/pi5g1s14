package edu.gaed.bean;
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.gaed.dao.LoginDao;
 
@ManagedBean(name="LoginBean")
@SessionScoped
public class LoginBean {
     
    public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	private String username;
     
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public String loginProject() {
        boolean result = LoginDao.login(username, password);
        if (result) {
        	return "home";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Login invalido!",
                    "Tente novamente!"));
            return "login";
        }
    }
}
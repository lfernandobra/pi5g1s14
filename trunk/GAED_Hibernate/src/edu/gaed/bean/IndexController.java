package edu.gaed.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class IndexController implements Serializable {
 	private static final long serialVersionUID = 1L;
 	private String pagina = "home.xhtml"; // página com conteúdo inicial
	

	public String getPagina() {
		return pagina;
	}


	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public void SetaPagina(String pagina) throws IOException{
		this.setPagina(pagina);
	}
}




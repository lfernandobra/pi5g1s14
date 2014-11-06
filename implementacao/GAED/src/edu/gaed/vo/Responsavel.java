package edu.gaed.vo;

public class Responsavel extends Usuario{
	
	private Usuario Usuario;
	private int ID_Responsavel;
	private String CPF;
	
	public Responsavel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public int getID_Responsavel() {
		return ID_Responsavel;
	}

	public void setID_Responsavel(int iD_Responsavel) {
		ID_Responsavel = iD_Responsavel;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	
}

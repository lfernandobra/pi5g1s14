package edu.gaed.vo;

import java.util.Date;

public class Secretaria extends Usuario{
	private Date DataAdmissao;

	public Date getDataAdmissao() {
		return DataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		DataAdmissao = dataAdmissao;
	}
}

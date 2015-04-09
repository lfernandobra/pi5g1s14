package edu.gaed.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="Da_Classe", discriminatorType=DiscriminatorType.STRING)

public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column(name="id_usuario", nullable=false)
	private int id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="datanasc")
	private Date datanasc;
	
	@Column(name="email")
	private String email;
	
	@Column(name="CPF")
	private String CPF;
	
	@Column(name="RG")
	private String RG;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="telefone")
	private String telefone;
		
	@Column(name="status")
	private boolean status;
	
	@Column(name="dataingresso")
	private Date dataIngresso;
	
	@Column(name="datasaida")
	private Date dataSaida;
	
	@ManyToOne
	@JoinColumn(name="id_logradouro", referencedColumnName="id_logradouro", foreignKey = @ForeignKey(name="fk_logradouro"))
	private Logradouro logradouro;
	
	@ManyToOne
	@JoinColumn(name="id_foto", referencedColumnName="id_foto", foreignKey = @ForeignKey(name="fk_foto"))
	private Foto foto;
	
	@ManyToOne
	@JoinColumn(name="id_perfil", referencedColumnName="id_value", foreignKey = @ForeignKey(name="fk_perfil"))
	private Perfil perfil;
	
	public Usuario(){
		super();
	}
	public Usuario(int id, String login, String senha, String nome,
			String sobrenome, String sexo, Date datanasc, String email,
			String cPF, String rG, String numero, String complemento,
			String telefone, boolean status, Date dataIngresso, Date dataSaida,
			Logradouro logradouro, Foto foto, Perfil perfil) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.datanasc = datanasc;
		this.email = email;
		CPF = cPF;
		RG = rG;
		this.numero = numero;
		this.complemento = complemento;
		this.telefone = telefone;
		this.status = status;
		this.dataIngresso = dataIngresso;
		this.dataSaida = dataSaida;
		this.logradouro = logradouro;
		this.foto = foto;
		this.perfil = perfil;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(Date datanasc) {
		
		this.datanasc = datanasc;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDataIngresso() {
		return dataIngresso;
	}

	public void setDataIngresso(Date dataIngresso) {
		this.dataIngresso = dataIngresso;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
}

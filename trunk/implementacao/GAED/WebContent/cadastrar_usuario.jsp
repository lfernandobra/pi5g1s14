<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.gaed.vo.Usuario"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro usuario</title>
	<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
<div class="container" id="main"> 
  <div class="row ">
  	<div class="col-sm-9">
  	    <div class="col xs-9 col-sm-5 col-sm-offset-1 ">
    	<div class="panel panel-default">

	<form id="usuario" method="post" action="adiciona_usuario.jsp" >
		<c:if test="${not empty usuario}">
			<input type="hidden" name="id" value="${usuario.id}"/>
		</c:if>
		<fieldset id = "identficacao">
        	<legend>Identificação</legend>
			<p>
			<label id="lbl_login" for="txt_login">Login:</label> 
            <input type="text" id="txt_login" name="login" value="${usuario.login}" tabindex="1"/>
			</p>
			<p>
			<label id="lbl_senha" for="txt_senha">Senha:</label>  
            <input type="password" id="txt_senha" name="senha" value="${usuario.senha}" tabindex="2"/>
			</p>
        </fieldset>
        <fieldset id = "usuario_dados">
        	<legend>Dados</legend>
			<p>
				<label id="lbl_nome" for="txt_nome">Nome:</label>  
                <input type="text" id="txt_nome" name="nome" value="${usuario.nome}" tabindex="3"/>
			</p>
			<p>
				<label id="lbl_sobrenome" for="txt_nome">Sobrenome:</label> 
                <input type="text" id="txt_sobrenome" name="sobrenome" value="${usuario.sobrenome}" tabindex="4"/>
			</p>
			
			<p>
				<label id="lbl_datanascimento" for="txt_data">Data de nascimento:</label>  
                <input type="text" id="txt_datanasc" name="datanasc" 
               	   	   onKeyPress="MascaraData(usuario.datanasc);"
                	   onBlur="ValidaData(usuario.datanasc);"
                	   value="${usuario.datanasc}" tabindex="4"/>
			</p>
			
			<p>
				<label id="lbl_sexo" for="txt_sexo">Sexo:</label>  
                
                <select id="txt_sexo" name="sexo" value="${usuario.sexo}" tabindex="5">
  					<option value="Feminino">Feminino</option>
  					<option value="Masculino">Masculino</option>
				</select>
			</p>
			<p>
				<label id="lbl_email" for="txt_email">Email:</label> 
                <input type="text" id="txt_email" name="email" value="${usuario.email}" tabindex="6"/>
			</p>
			<p>
				<label id="lbl_telefone" for="txt_telefone">Telefone:</label>  
                <input type="text" id="txt_telefone" name="telefone" value="${usuario.telefone}"
                			onKeyPress="MascaraTelefone(usuario.telefone);" 
   							maxlength="20" value="${usuario.telefone}" 
   							tabindex="7"  onBlur="ValidaTelefone(txt_telefone);"/>
			</p>
			<p>               
                <label id="lbl_rua" for="txt_rua">Rua:</label>  
                <input type="text" id="txt_rua" name="rua" value="${usuario.rua}" tabindex="8"/><p>
                <label id="lbl_numero" for="txt_numero">Numero:</label>  
                <input type="text" id="txt_numero" name="numero" value="${usuario.numero}" tabindex="9"/><p>
                <label id="lbl_bairro" for="txt_cidade">Bairro:</label>  
                <input type="text" id="txt_bairro" name="bairro" value="${usuario.bairro}" tabindex="10"/><p>
                <label id="lbl_cidade" for="txt_cidade">Cidade:</label>  
                <input type="text" id="txt_cidade" name="cidade" value="${usuario.cidade}" tabindex="11"/><p>
                <label id="lbl_estado" for="txt_estado">Estado:</label>  
                <input type="text" id="txt_estado" name="estado" value="${usuario.estado}" tabindex="12"/><p>
                
                <label id="lbl_CEP" for="txt_endereco">CEP :</label> 
                <input type="text" id="txt_CEP" name="CEP" value="${usuario.CEP}" tabindex="13"
                	   maxlength="10"
                	   onKeyPress="MascaraCep(usuario.CEP);"
                	   onBlur="ValidaCep(usuario.CEP);"
                />
			</p>
			
			</fieldset>
			<fieldset id = "botoes">
				<input type="submit" value="Salvar"></input><input type="reset" value="Resetar"></input>
			</fieldset>
        
	</form>
</div></div></div></div></div>
</body>
</html>
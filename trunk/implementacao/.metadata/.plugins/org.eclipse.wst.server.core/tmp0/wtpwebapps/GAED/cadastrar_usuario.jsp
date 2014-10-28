<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page import="edu.gaed.modelo.Usuario"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuario</title>
	<link href="styles/cadastro.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
	<form id="usuario" method="post" action="adiciona_usuario.jsp" onsubmit="return valida(this);">
		<c:if test="${not empty usuario}">
			<input type="hidden" name="id" value="${usuario.id}"/>
		</c:if>
		<fieldset id = "identficacao">
        	<legend>Identificação</legend>
			<p>
				<label id="lbl_login" for="txt_login">Login:</label> <br /> 
            	<input type="text" id="txt_login" name="login" value="${usuario.login}" tabindex="1"/>
			</p>
			<p>
				<label id="lbl_senha" for="txt_senha">Senha:</label> <br /> 
                <input type="password" id="txt_senha" name="senha" value="${usuario.senha}" tabindex="2"/>
			</p>
        </fieldset>
        <fieldset id = "usuario_dados">
         	<legend>Dados Entidade</legend>
			<p>
				<label id="lbl_nome" for="txt_nome">Nome:</label> <br /> 
            	<input type="text" id="txt_nome" name="nome" value="${usuario.nome}" tabindex="3"/>
			</p>
			<p>
				<label id="lbl_sobrenome" for="txt_sobrenome">Sobrenome:</label> <br /> 
            	<input type="text" id="txt_email" name="email" value="${usuario.sobrenome}" tabindex="4"/>
			</p>
			<p>
				<label id="lbl_sexo" for="txt_telefone">Sexo:</label> <br /> 
                <input type="text" id="txt_telefone" name="telefone" value="${usuario.sexo}"tabindex="5"/>
			</p>
			<!--  
			<p>
				<label id="lbl_endereco" for="txt_endereco">Data de nascimento:</label> <br /> 
                <input type="text" id="txt_endereco" name="endereco" value="${usuario.datanasc}" tabindex="6"/>
			</p>
			-->
	</fieldset>			
			<div id = "botoes">
				<input type="submit" value="Salvar"></input><input type="reset" value="Resetar"></input>
			</div>
			
           
	</form>

</body>
</html>
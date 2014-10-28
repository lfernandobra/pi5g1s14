<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles/layout.css" />
</head>
<body>
	<img src="images/banner_logo_gaed.png">
	<div id = "login_erro">
		<jsp:include page="erro.jsp" />
	</div>
	<div id="login">
	<!-- 
	<form action="${pageContext.request.contextPath}/LoginServlet" method="post"> 
		<fieldset class = "bor_login" >
			<legend class = "acesso">Acesso</legend>
			<center>
				<table>
				<tr><td><label>Usuário:</label></td></tr>
				<tr><td><input type="text" name="login" /></td></tr>
				<tr><td><label>Senha:</label></td></tr>
				<tr><td><input type="password" name="senha" /></td></tr>
				<tr><td><input type="submit" value="Entrar"></input>
				<input type="reset" value="Limpar"></input></td></tr>
				<tr><td> <label class="senha">Esqueci minha senha</label></td></tr>
				</table>
		</center>
		</fieldset>
	</form>
	-->
	</div>
	<c:choose>
  		<c:when test="${empty login}">
			<form action="LoginServlet" method="post">
	  		<fieldset>
	    	<p>
	      		<label for="login">Login</label>
	      		<br/>
	      		<input type="text" name="login" value="${param.login}"/>
	    	</p>
	    	<p>
	      	<label for="senha">Senha</label>
	      	<br/>
	      	<input type="password" name="senha" value="${param.senha}"/>
	    	</p>
	    	<input type="submit" value="Login"/>
	  		</fieldset>
			</form>
		</c:when>	
  	    <c:otherwise>
    		<p>Olá, ${login.nome}. <a href="LogoutServlet">(sair)</a></p>  
  		</c:otherwise>
	</c:choose>

	
	

	<div id="tabelas">
		<div id="noticias">
			<h2> Notícias</h2>
				<p><a href="#"> Festa junina teve quadrilha e pipoca</a> </p>
				<p><a href="#"> Famílias ligadas ao MTST invadem área em Carapicuíba</a> </p>
				<p><a href="#"> Bancários optam por greve dia 30</a> </p>
				<p><a href="#"> Festa junina teve quadrilha e pipoca</a> </p>
				<a href="#"> Leia mais</a>
		</div>
	
	<div id="documentos">
		<h2> Documentos</h2>
			<p><a href="#"> Documentos necessário para matricula escolar</a> </p>
			<p><a href="#"> Documentos para cadastro de bolsa escola</a> </p>
			<a href="#"> Leia mais</a>
	</div>
	
	<div id="help">
		<h2> Help</h2>
			<p><a href="#"> Como redefinir sua senha</a> </p>
			<p><a href="#"> Saiba como utilizar nosso sistema de uma forma ágil e fácil</a></p>
			<a href="#"> Leia mais</a>
	</div>
</div>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
<h1>
  GAED
</h1>

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
    <p>Olá, ${login.perfil} ${login.nome}. <a href="LogoutServlet">(sair)</a></p>  
  </c:otherwise>
</c:choose>
</div>

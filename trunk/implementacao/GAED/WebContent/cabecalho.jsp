<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-default  col-sm-offset-1 col-sm-10" role="navigation">
	  <div class="container">
	    <div class="navbar-header">
	      <div class="col-lg-10">
     		 <p class="nav navbar-nav "><img src ="images\logo_gaed_100px.png"></p>

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
			  
			  <div class="nav navbar-nav navbar-right" >
			    <p ><img src ="images\photo_avatar_100px.png"></p>  
			   
			  </div>
			  
			  <div class="col-lg-3 col-sm-offset-1 col-sm-4 navbar-right" >
			   <p>Olá, ${login.perfil} ${login.nome}. <a href="LogoutServlet">(sair)</a></p>
			  </div>
			  
			  
		  </c:otherwise>
		</c:choose>

		</div>
	</div>
</div>

</nav>
	


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-default col-sm-12" role="navigation">
	  <div class="container">
	    <div class="navbar-header">
	      <div class="col-lg-10 col-sm-offset-0 ">
     		 <p class="nav navbar-nav "><img src ="images\logo_gaed_150px_transp.png"></p>

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
			   <div class="col-lg-2 col-sm-offset-0 col-sm-3 navbar-right" >
			    <p><img src="${pageContext.request.contextPath}/FotoServlet?foto=${login.foto.id}" style="width:128px;height:128px"/></p>  
			  </div> 
			  </div>
			  
			  <div class="col-lg-4 col-sm-offset-0 col-sm-6 navbar-right" >
			   <p>Ol�, ${login.perfil} ${login.nome} ${login.sobrenome} <a href="LogoutServlet">(sair)</a></p>
			  </div>
			  
			  
		  </c:otherwise>
		</c:choose>

		</div>
	</div>
</div>

</nav>
	


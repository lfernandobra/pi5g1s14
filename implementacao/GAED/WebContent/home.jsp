<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  Diretiva Page Import -->
<%@ page import="edu.gaed.vo.*"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
    <script type="text/javascript" src="scripts/script.js"></script>
<title>GAED - Home</title>
</head>
<body>

<div class="container ">
	<div class="row">
	<div class="col-lg-12">
			<div id="cabecalho">
				<!--  Diretiva Include -->
				<%@include file="cabecalho.jsp"%>				
			</div>
	</div>	
	</div>
		
	 <hr>
	 		
	<div class="row">		
	<c:if test="${not empty login}">  
		 <div class="col-lg-2 col-sm-offset-1">
      		<div class="list-group navmenu-nav nav"> 
       			 <ul class="nav">
					<c:choose>
						<c:when test="${login.perfil.professor}">
							<li><a href="#" onclick="loadContent('conteudo_professor.jsp')"><span class="glyphicon glyphicon-home"></span> Home</a></li>
							<li><a href="#" onclick="loadContent('gerencia_boletins.jsp')"><span class="glyphicon glyphicon-file"></span> Boletim</a></li>
							<li><a href="#" onclick="loadContent('gerencia_ocorrencias.jsp')"><span class="glyphicon glyphicon-exclamation-sign"></span> Ocorr�ncias</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-book"></i> Tarefas </a></li>	
						</c:when>
						<c:when test="${login.perfil.secretaria}">
							<li><a href="#" onclick="loadContent('conteudo_secretaria.jsp')"><span class="glyphicon glyphicon-home"></span> Home</a></li>
							<li><a href="#" onclick="loadContent('gerencia_usuarios.jsp')"><i class="glyphicon glyphicon-user"></i> Usu�rios </a></li>
							<li><a href="#" onclick="loadContent('gerencia_boletins.jsp')"><i class="glyphicon glyphicon-file"></i> Boletins </a></li>
							<li><a href="#" onclick="loadContent('gerencia_ocorrencias.jsp')"><i class="glyphicon glyphicon-exclamation-sign"></i> Ocorr�ncias </a></li>
						</c:when>
						<c:when test="${login.perfil.responsavel}">
							<li><a href="#" onclick="loadContent('conteudo_responsavel.jsp')"><span class="glyphicon glyphicon-home"></span> Home</a></li>
							<li><a href="#" onclick="loadContent('gerencia_boletins.jsp')"><i class="glyphicon glyphicon-file"></i> Boletim</a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-book"></i> Tarefas </a></li>
							<li><a href="#" onclick="loadContent('gerencia_ocorrencias.jsp')"><i class="glyphicon glyphicon-exclamation-sign"></i> Ocorr�ncias </a></li>
						</c:when>
						<c:when test="${login.perfil.aluno}">
							<li><a href="#" onclick="loadContent('conteudo_aluno.jsp')"><span class="glyphicon glyphicon-home"></span> Home</a></li>
							<li><a href="#" onclick="loadContent('boletim.jsp')"><i class="glyphicon glyphicon-file"></i> Boletim </a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-book"></i> Tarefas </a></li>
						</c:when>
					</c:choose>	 				
				</ul>
			</div>	
			</div>
			
			 
			<div class="col-lg-9">	
			<div id="conteudo"> 
				
				<jsp:include page="${conteudo}"/>
				
			</div>
			</div>
			
	</c:if>	
	
</div>	

</div>	
</body>
</html>
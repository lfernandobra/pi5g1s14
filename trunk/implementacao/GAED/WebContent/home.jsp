<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
    
<title>GAED - Home</title>
</head>
<body>
	<div class="col-md-12">
			<div id="cabecalho">
				<!--  Diretiva Include -->
				<%@include file="cabecalho.jsp"%>				
			</div>
			
	<c:if test="${not empty login}">  
		 <div class="container ">
      		<div class="row row-offcanvas row-offcanvas-left">
       			 <div class="col-xs-6 col-sm-offset-0 col-sm-2 sidebar-offcanvas" id="sidebar" role="navigation"><br>
       			 <ul class="nav">
					<c:choose>
						<c:when test="${login.perfil.professor}">
							<li><a href="#" onclick="loadContent('')"><span class="glyphicon glyphicon-home"></span></i> Home</a></li>
							<li><a href="#" onclick="loadContent('ListaBoletimServlet')"><span class="glyphicon glyphicon-file"></span>Boletim</a></li>
							<li><a href="#" onclick="loadContent('ListaBoletimServlet')"><span class="glyphicon glyphicon-pencil"></span> Ocorrências <span class="badge badge-info">4</span></a></li>
							<li><a href="#" onclick="loadContent('tarefas.jsp')"><i class="glyphicon glyphicon-book"></i> Tarefas</a></li>

						</c:when>
						<c:otherwise>						
							<li><a href="#" onclick="loadContent('ListaBoletimServlet')"><span class="glyphicon glyphicon-file"></span>Boletim</a></li>
							<li><a href="#" onclick="loadContent('tarefas.jsp')"><i class="glyphicon glyphicon-book"></i> Tarefas</a></li>
						</c:otherwise>
					</c:choose>	 				
				</ul>
				</div>
			</div>
			<div id="container"> 
       			
				<!--  Diretiva Include -->
				<%@include file="conteudo_aluno.jsp"%>
			</div>
			
		</div>
	</c:if>	
	
	
</div>	
	
</body>
</html>
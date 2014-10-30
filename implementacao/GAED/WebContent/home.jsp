<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/layout.css" />
	<script type="text/javascript" src="scripts/script.js"></script>
<title>GAED - Home</title>
</head>
<body>
	<div id="pagina">
			<div id="cabecalho">
				<!--  Diretiva Include -->
				<%@include file="cabecalho.jsp"%>				
			</div>
			<c:if test="${not empty login}">  
			<div id="menu_dropdown">
				<ul>
					<c:choose>
						<c:when test="${login.perfil.professor}">
							<li><a href="#" onclick="loadContent('ListaBoletimServlet')">Boletim</a></li>
							<li><a href="#" onclick="loadContent('ocorrencias.jsp')">Ocorrências</a></li>
							<li><a href="#" onclick="loadContent('tarefas.jsp')">Tarefas</a></li>
						</c:when>
						<c:otherwise>						
							<li><a href="#" onclick="loadContent('ListaBoletimServlet')">Boletim</a></li>
							<li><a href="#" onclick="loadContent('tarefas.jsp')">Tarefas</a></li>
						</c:otherwise>
					</c:choose>	 				
				</ul>
			</div>
			<div id="conteudo">
				<!--  Diretiva Include -->
				<%@include file="conteudo_aluno.jsp"%>
			</div>
			</c:if>		
	</div>
</body>
</html>
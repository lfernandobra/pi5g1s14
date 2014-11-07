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
    <script type="text/javascript" src="scripts/script.js"></script>
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
					<li><a href="#" onclick="loadContent('')"><span class="glyphicon glyphicon-home"></span> Home</a></li>
					<c:choose>
						<c:when test="${login.perfil.professor}">
							
							<li>
								<form name=form1 action='ObterTurmaProfessor' method="post">
									<input type="hidden" class="form-control" name="id"  value="${login.id}"/>
									<a href="javascript:document.form1.submit()"><span class="glyphicon glyphicon-file"></span> Boletim - Turma</a> 
								</form>
								
							</li>
							<li>
								<form name=form2 action='' method="post">
									<input type="hidden" class="form-control" name="id"  value="${login.id}"/>
									<a href="javascript:document.form2.submit()"><span class="glyphicon glyphicon-exclamation-sign"></span> Ocorrências <span class="badge badge-info"> 4</span></a> 
								</form>
							</li>
							<li>
								<form name=form3 action='' method="post">
									<input type="hidden" class="form-control" name="id"  value="${login.id}"/>
									<a href="#" onclick="loadContent('tarefas.jsp')"><i class="glyphicon glyphicon-ok"></i> Tarefas <span class="badge badge-info"> 10</span></a>
								</form>
							</li>	
							
						</c:when>
						<c:when test="${login.perfil.secretaria}">
							<li><a href="#" onclick="loadContent('cadastrar_usuario.jsp')"><i class="glyphicon glyphicon-user"></i> Usuários </a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-book"></i> Boletins </a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-exclamation-sign"></i> Ocorrências </a></li>
						</c:when>
						<c:when test="${login.perfil.responsavel}">
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-book"></i> Boletim</a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-ok"></i> Tarefas </a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-exclamation-sign"></i> Ocorrências </a></li>
						</c:when>
						<c:when test="${login.perfil.aluno}">
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-book"></i> Boletim </a></li>
							<li><a href="#" onclick=""><i class="glyphicon glyphicon-ok"></i> Tarefas </a></li>
						</c:when>
					</c:choose>	 				
				</ul>
				</div>
			</div>
			<div id="conteudo"> 
       			
				<!--  Diretiva Include -->
				<%@include file="conteudo_aluno.jsp"%>
			</div>
			
		</div>
	</c:if>	
	
	
</div>	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Gerencia Ocorrencia</title>
</head>
<body>
	 <div class="container" id="main"> 
  		<div class="row ">
  			<div class="col-sm-5">
	    		<div class="panel panel-default">
    				<div class="panel-heading"> <h4>Ocorrências</h4></div>
    				<c:choose>
					<c:when test="${login.perfil.professor}">
						<fieldset class="fsStyle">
							<ul class="nav">
								<li><a href="#" onclick="loadContent('inserir_ocorrencia.jsp')"><i class="glyphicon glyphicon-pencil"></i> Inserir Ocorrência</a></li>
							</ul>
						</fieldset>
					</c:when>
					<c:when test="${login.perfil.secretaria}">
						<fieldset class="fsStyle">
							<ul class="nav">
								<li><a href="#" onclick="loadContent('inserir_ocorrencia.jsp')"><i class="glyphicon glyphicon-pencil"></i> Inserir Ocorrência</a></li>
								<li><a href="#" onclick="loadContent('ListaOcorrenciasServlet')"><i class="glyphicon glyphicon-eye-open"></i> Visualizar Ocorrências</a></li>
							</ul>
						</fieldset>
					</c:when>
					<c:when test="${login.perfil.responsavel}">
						<fieldset class="fsStyle">
							<ul class="nav">
								<li><a href="#" onclick="loadContent('ListaOcorrenciasServlet')"><i class="glyphicon glyphicon-eye-open"></i> Visualizar Ocorrências</a></li>
							</ul>
						</fieldset>
					</c:when>
					</c:choose>						
				</div>
			</div>
		</div>
	</div>			
</body>
</html>
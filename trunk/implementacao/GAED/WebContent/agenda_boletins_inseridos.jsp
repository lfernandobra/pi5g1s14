<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.vo.Inserido"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boletins</title>
</head>
<body>

<div class="row ">
			<div class="col-sm-7">	
	
	<c:choose>
		<c:when test="${empty boletins}">
			<p>Não há boletins cadastrados</p>
		</c:when>
	<c:otherwise>
	
	<fieldset class="fsStyle">
		<legend id = "legenda">Boletins inseridos</legend>
			<table class="table table-striped table-bordered">
			 	<thead>
				 	<tr class="info">
						<td>ID Boletim</td>
						<td>Data</td>
						<td>ID Aluno</td>
						<td>Nome</td>			
					</tr>
			</thead>
			
			<tbody>			
				<c:forEach var="linha" items="${boletins}">
				<tr>
					<td>${linha.boletim.ID}</td>
					<td>${linha.boletim.dataBoletim}</td>
					<td>${linha.aluno.ID}</td>
					<td>${linha.aluno.nome}</td>
					
					<td>
						<input type="hidden" name="id" value="${linha.boletim.ID}"/>
						<input type="submit" value="Editar" class="btn btn-primary btn-sm" />
						<input type="hidden" name="id" value="${linha.boletim.ID}"/>
						<input type="submit" value="Excluir" class="btn btn-default btn-sm" />
					</td>
				
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</fieldset>		
	</c:otherwise>
	</c:choose>
	
	
	</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.modelo.BoletimTurma"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boletim</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty boletim}">
			<p>N�o h� boletins cadastrados</p>
		</c:when>
	<c:otherwise>
		<fieldset>
		<legend id = "legenda">Boletim</legend>
		<table border="1">
			<thead>
				<tr>
					<td>Nome</td>
					<td>Turma</td>
					<td>Serie</td>
					<td>Bimestre</td>
					<td>Disciplina</td>
					<td>Nota</td>
					<td>Faltas</td>			
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="linha" items="${boletim}">
				<tr>
					<td>${linha.nomealuno}</td>
					<td>${linha.nometurma}</td>
					<td>${linha.serie}</td>
					<td>${linha.bimestre}</td>
					<td>${linha.nomedisciplina}</td>
					<td>${linha.nota}</td>
					<td>${linha.faltas}</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</fieldset>		
	</c:otherwise>
	</c:choose>

</body>
</html>
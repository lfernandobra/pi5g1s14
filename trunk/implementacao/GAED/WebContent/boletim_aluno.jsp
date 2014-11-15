<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="scripts/script.js"></script>
<title>Boletim</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty compoe}">
			<p>Não há boletins cadastrados</p>
		</c:when>
		<c:otherwise>
			<table border="1">	
			<thead>
				<tr>
					<td>Disciplina</td><td>Nota</td><td>Faltas</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="linha" items="${compoe}">
					<tr>
					<td>${linha.disciplina.nome}
					<td>${linha.nota}</td>
					<td>${linha.faltas}</td></tr>	
				</c:forEach>
			</tbody>				
		</table>
		</c:otherwise>
	</c:choose>
</body>
</html>
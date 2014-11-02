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
		<fieldset>
		<legend id = "legenda">Boletim</legend>
		<table border="1">
						
				<c:forEach var="linhainserido" items="${alunos}">
				<thead>
				<tr>
					<td>ID</td> 
					<td>Nome</td>
					<td>Sobrenome</td>
				</tr>
				</thead>
				<tr>
					<td>${linhainserido.aluno.ID}</td>
					<td>${linhainserido.aluno.nome}</td>
					<td>${linhainserido.aluno.sobrenome}</td>
				<tr>	
				<tbody>
				<tr>
					<td>ID Boletim</td>
					<td>Disciplina</td>
					<td>Notas</td>
					<td>Faltas</td>
				</tr>
					<c:forEach var="linha" items="${compoe}">
						<c:choose>
							<c:when test= "${linha.boletim.ID == linhainserido.boletim.ID}">
							<tr>
								<td>${linha.boletim.ID}</td>
								<td>${linha.disciplina.nome}</td>
								<td>${linha.nota}</td>
							    <td>${linha.faltas}</td>
							</tr>
						</c:when>
						</c:choose>
						
					</c:forEach>
				</c:forEach>
			
				
			</tbody>
			</table>
		</fieldset>		
	</c:otherwise>
	</c:choose>

</body>
</html>
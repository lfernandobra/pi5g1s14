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
						<td>RA</td><td>Nome Completo</td><td>Serie</td><td>Turma</td><td>Periodo</td><td>Nota</td><td>Faltas</td></tr>
				</thead>
					<c:forEach var="linhainserido" items="${alunos}"> 
					<tr><td>${linhainserido.aluno.ID}</td>
						<td>${linhainserido.aluno.nome} ${linhainserido.aluno.sobrenome}</td>
						<c:forEach var ="estudaturma" items="${turmas}">
							<c:choose> 
								<c:when test= "${linhainserido.aluno.ID == estudaturma.aluno.ID}">
									<td>${estudaturma.turma.serie}</td>
									<td>${estudaturma.turma.nome}</td>
									<td>${estudaturma.turma.periodo}</td>
								</c:when>
							</c:choose>
						</c:forEach>
						<c:forEach var="linha" items="${compoe}">
						<c:choose>
							<c:when test= "${linha.boletim.ID == linhainserido.boletim.ID && linha.disciplina.ID == 2}">
								<td>${linha.nota}</td>
							    <td>${linha.faltas}</td>
						</c:when>
						</c:choose>	
					</c:forEach>
					</c:forEach>	
			</table>
	</c:otherwise>
	</c:choose>

</body>
</html>
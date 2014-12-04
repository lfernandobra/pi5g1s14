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
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Boletim</title>
</head>
<body>

<div class="container" id="main"> 
		<div class="row ">
			<div class="col-sm-7">

	<c:choose>
		<c:when test="${empty compoe}">
			<p>Não há boletins cadastrados</p>
		</c:when>
		
		<c:otherwise>
			<fieldset>
				<legend id = "legenda">Boletim</legend>
					<table class="table table-bordered table-striped">
						<thead>
						<tr class="info">
							<td>Nome Completo : </td><td>${aluno.nome} ${aluno.sobrenome}</td>
						</tr>
						<tr>	
							<td>Turma</td><td>Periodo</td><td>Serie</td><td>Ano Letivo</td><td>Bimestre</td>
						</tr>
						<tr>	
							<td>${estudaTurma.turma.nome}</td>
							<td>${estudaTurma.turma.periodo}</td>
							<td>${estudaTurma.turma.serie}</td>
							<td>${estudaTurma.turma.ano}</td>
							<td>${estudaTurma.turma.bimestre}</td>
						</tr>
						<tr class="info">
							<td>Disciplina</td><td>Notas</td><td>Faltas</td>
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
				</fieldset>
		</c:otherwise>
	</c:choose>
	</div>
</div>
</div>

</body>
</html>
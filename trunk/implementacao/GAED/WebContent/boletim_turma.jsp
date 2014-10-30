<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.modelo.Boletim"%>

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
		<c:when test="${empty boletim}">
			<p>Não há boletins cadastrados</p>
		</c:when>
	<c:otherwise>
		<fieldset>
		<legend id = "legenda">Boletim</legend>
		<table border="1">
			<thead>
				<tr>
					<td>ID Boletim</td>
					<td>ID Aluno</td>
					<td>Nome</td>
					<td>Turma</td>
					<td>Serie</td>
					<td>Bimestre</td>
					<td>ID Disciplina</td>
					<td>Disciplina</td>
					<td>Nota</td>
					<td>Faltas</td>			
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="linha" items="${boletim}">
				<tr>
					<td>${linha.ID}</td>
					<td>${linha.aluno.ID}</td>
					<td>${linha.aluno.nome}</td>
					<td>${linha.turma.nome}</td>
					<td>${linha.turma.serie}</td>
					<td>${linha.bimestre}</td>
					<td>${linha.compoe.disciplina.ID}</td>
					<td>${linha.compoe.disciplina.nome}</td>
					<td>${linha.compoe.nota}</td>
					<td>${linha.compoe.faltas}</td>
					<td class="acao_agenda">
						<form action="ObterBoletim" method="post">
								<input type="hidden" name="idAluno" value="${linha.aluno.ID}"/>
								<input type="hidden" name="idBoletim" value="${linha.ID}"/>
								<input type="hidden" name="idDisciplina" value="${linha.compoe.disciplina.ID}"/>
								<input type="submit" value="Editar" class="botao_editar" />
						</form>							
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</fieldset>		
	</c:otherwise>
	</c:choose>

</body>
</html>
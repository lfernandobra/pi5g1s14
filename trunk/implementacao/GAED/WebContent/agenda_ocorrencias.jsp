<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.vo.Recebe"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Ocorrencias</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty ocorrencias}">
			<p>Não há ocorrencias cadastradas</p>
		</c:when>
	<c:otherwise>
		<fieldset>
			<legend id = "legenda">Ocorrencias cadastradas</legend>
			<table class="table table-bordered">
				<thead>
					<tr class="danger">
						<td>ID Ocorrência</td>
						<td>Assunto</td>
						<td>Descrição</td>
						<td>Data</td>
						<td>Nome</td>
						<td>Sobrenome</td>			
						</tr>
			</thead>
			<tbody>			
				<c:forEach var="linha" items="${ocorrencias}">
				<tr>
					<td>${linha.ocorrencia.ID}</td>
					<td>${linha.ocorrencia.assunto}</td>
					<td>${linha.ocorrencia.descricao}</td>
					<td>${linha.ocorrencia.data}</td>
					<td>${linha.aluno.nome}</td>
					<td>${linha.aluno.sobrenome}</td>
					
					<td class="acao_agenda">
					<form action="ObterOcorrencia" method="post">
						<input type="hidden" name="idAluno" value="${linha.aluno.ID}"/>
						<input type="hidden" name="idOcorrencia" value="${linha.ocorrencia.ID}"/>
						<input type="submit" value="Editar" class="btn btn-success btn-sm"/>
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
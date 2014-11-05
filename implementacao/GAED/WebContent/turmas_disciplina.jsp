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
<title>Turmas - Disciplina</title>
</head>
<body>
<body>
	<c:choose>
		<c:when test="${empty turmas}">
			<p>Não há turmas relacionadas a disciplina</p>
		</c:when>
	<c:otherwise>
		<table border="1">
				
				<thead>
					<tr>
						<td>ID</td><td>Turma</td><td>Periodo</td><td>Serie</td><td>Ano Letivo</td><td>Bimestre</td></tr>
				</thead>
					<c:forEach var="turma" items="${turmas}"> 
					<tr><td>${turma.ID}</td>
						<td>${turma.nome}</td>
						<td>${turma.periodo}</td>
						<td>${turma.serie}</td>
						<td>${turma.ano}</td>
						<td>${turma.bimestre}</td>
						<td><form class="form-horizontal" action="ListaBoletimServlet" method="post">
								<input type="hidden" class="form-control" name="idTurma"  value="${turma.ID}"/>
								<input type="hidden" class="form-control" name="idDisciplina"  value="${disciplina.ID}"/>
								<input type="submit" value="Visualizar">
							</form>
						</td>
					</tr>	
					</c:forEach>	
			</table>
	</c:otherwise>
	</c:choose>

</body>
</html>
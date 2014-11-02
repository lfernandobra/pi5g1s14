<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->

<%@ page import="edu.gaed.vo.Usuario"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agenda Usuários</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty usuarios}">
			<p>Não há usuarios cadastrados</p>
		</c:when>
	<c:otherwise>
		<fieldset>
		<legend id = "legenda">Usuarios</legend>
		<table border="1">
			<thead>
				<tr>
					<td>ID</td>
					<td>Login</td>
					<td>Nome</td>
					<td>Sobrenome</td>
					<td>Sexo</td>
					
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="usuario" items="${usuarios}">
				<tr>
					<td>${usuario.id}</td>
					<td>${usuario.login}</td>
					<td>${usuario.nome}</td>
					<td>${usuario.sobrenome}</td>
					<td>${usuario.sexo}</td>
					
					<td class="acao_agenda">
					<form action="Obterusuario" method="post">
						<input type="hidden" name="id" value="${usuario.id}"/>
						<input type="submit" value="Editar" class="botao_editar" />
					</form>
					<form action="Removerusuario" method="post">
						<input type="hidden" name="id" value="${usuario.id}"/>
						<input type="submit" value="Excluir" class="botao_excluir" />
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
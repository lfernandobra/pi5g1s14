<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Agenda Usuários</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty alunos}">
			<p>Não há alunos cadastrados</p>
		</c:when>
	<c:otherwise>
		<fieldset>
		<legend id = "legenda">Alunos</legend>
		<table class="table table-bordered">
			<thead>
				<tr class="warning">
					<td>Foto</td>
					<td>ID</td>
					<td>Nome</td>
					<td>Sobrenome</td>
					<td>Sexo</td>
					<td>Turma</td>
					<td>Peridodo</td>
					<td>Serie</td>
					<td>Ano</td>
					<td>Bimestre</td>					
				</tr>
			</thead>
			<tbody>			
				<c:forEach var="estuda" items="${alunos}">
				<tr>
					<td><img src="${pageContext.request.contextPath}/FotoServlet?foto=${estuda.aluno.foto.id}" style="width:128px;height:128px"/></td>
					<td>${estuda.aluno.ID}</td>
					<td>${estuda.aluno.nome}</td>
					<td>${estuda.aluno.sobrenome}</td>
					<td>${estuda.aluno.sexo}</td>
					<td>${estuda.turma.nome}</td>
					<td>${estuda.turma.periodo}</td>
					<td>${estuda.turma.serie}</td>
					<td>${estuda.turma.ano}</td>
					<td>${estuda.turma.bimestre}</td>

					<td class="acao_agenda">
					<form action="ObterAluno" method="post">
						<input type="hidden" name="id" value="${aluno.ID}"/>
						<input type="submit" value="Editar" class="btn btn-success btn-sm"/>
					</form>
					<form action="Removerusuario" method="post">
						<input type="hidden" name="id" value="${aluno.ID}"/>
						<input type="submit" value="Excluir" class="btn btn-default btn-sm"/>
					</form>							
					</td>
				</tr>
				</c:forEach>
			</tbody>
			</table>
		</fieldset>		
	</c:otherwise>
	</c:choose>

<div class="form-group last">
			<button type="submit" class="btn btn-primary" onclick="loadContent('gerencia_usuarios.jsp')">Voltar</button>
		</div>


</body>
</html>
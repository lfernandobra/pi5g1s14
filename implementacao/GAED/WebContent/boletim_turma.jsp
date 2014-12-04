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
			<div class="col-sm-6">
				<div class="alert alert-info" role="alert">
		  			<label>Não há boletins cadastrados!</label>
				</div>
			</div>
		</c:when>
	<c:otherwise>
	
	<fieldset>
		<legend id = "legenda">Boletim</legend>
		
		<div class="panel-footer clearfix">
    			<div class="panel-body">
					<p><label class=" control-label">Turma:</label> ${estudaTurma.turma.serie}${estudaTurma.turma.nome} ${estudaTurma.turma.periodo}</p>
					<p><label class=" control-label">Bimestre:</label> ${estudaTurma.turma.bimestre} </p>
					<p><label class=" control-label">Ano Letivo:</label> ${estudaTurma.turma.ano}</p>
				</div>
			</div>
			<br>
		
			<table class="table table-bordered table-striped">
				<thead>
					<tr class="info">
						<td>RA</td><td>Nome completo</td><td>Serie</td><td>Turma</td><td>Periodo</td><td>Nota</td><td>Faltas</td></tr>
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
						<c:when test= "${linha.boletim.ID == linhainserido.boletim.ID && linha.disciplina.ID == idDisciplina}">
							<td>${linha.nota}</td>
					    	<td>${linha.faltas}</td>
					    	<td class="acao_agenda">
					    	<form action = "ObterBoletim" method = "post">
								<input type="hidden" name="idAluno" value="${linhainserido.aluno.ID}"/>
								<input type="hidden" name="idBoletim" value="${linha.boletim.ID}"/>
								<input type="hidden" name="idDisciplina" value="${linha.disciplina.ID}"/>
								<input type="submit" value="Editar" class="btn btn-success btn-sm"/>
							</form>	
						</c:when>
					</c:choose>	
				</c:forEach>
				
			</c:forEach>	
			</table>
			</fieldset>
			
	</c:otherwise>
	</c:choose>

	</div> <!-- col-sm-7 -->
</div> <!-- Class row -->

				<div class="form-group last">
	 	 				<button type="submit" class="btn btn-primary" onclick="loadContent('ObterProfessor')">Voltar</button>
	 	 		</div>


</div> <!-- Class container /main -->



</body>
</html>
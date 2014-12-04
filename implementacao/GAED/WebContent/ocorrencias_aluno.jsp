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
<title>Ocorrencias</title>
</head>
<body>

<div class="container" id="main"> 
	<div class="row ">
			<div class="col-sm-7">

		<c:choose>
			<c:when test="${empty ocorrencias}">
			<div class="col-sm-7">
				<div class="alert alert-info" role="alert">
		  			<label>Não há ocorrencias inseridas para o aluno!</label>
				</div>
			</div>	
			</c:when>
			
			<c:otherwise>
				<fieldset>
					<legend id = "legenda">Boletim Escolar</legend>
				
					<div class="panel-footer clearfix">
		    			<div class="panel-body">
							<p><label>Aluno :</label> ${aluno.nome} ${aluno.sobrenome}</p>
							<p><label class=" control-label">Turma:</label> ${estudaTurma.turma.serie}${estudaTurma.turma.nome} ${estudaTurma.turma.periodo}</p>
							<p><label class=" control-label">Bimestre:</label> ${estudaTurma.turma.bimestre} </p>
							<p><label class=" control-label">Ano Letivo:</label> ${estudaTurma.turma.ano}</p>
						</div>
					</div>
					<br>
						<table class="table table-bordered table-striped">
							<thead>
							<tr class="info">
								<td>ID Ocorrencia</td><td>Assunto</td><td>Descrição</td><td>Data</td>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="linha" items="${ocorrencias}">
								<tr>
								<td>${linha.ocorrencia.ID}</td>
								<td>${linha.ocorrencia.assunto}</td>
								<td>${linha.ocorrencia.descricao}</td>
								<td>${linha.ocorrencia.data}</td>
								</tr>	
							</c:forEach>
						</tbody>				
					</table>
					</fieldset>
			</c:otherwise>
		  </c:choose>
		</div>  <!-- col-sm-7 -->
</div> <!-- Class row -->	
		<div class="col-sm-offset-0 col-sm-2">
		<div class="form-group last">
 	 		<button type="submit" class="btn btn-primary" onclick="loadContent('visualizar_ocorrencia.jsp')">Voltar</button>
 	 	</div>
	</div>
</div> <!-- Class container /main -->

</body>
</html>
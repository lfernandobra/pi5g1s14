<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Boletim</title>
	<script type="text/javascript" src="scripts/script.js"></script>
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
</head>
<body>
	<div id = "login_erro">
		<jsp:include page="erro.jsp" />
	</div>
	
	
	<div class="container" id="main"> 
		<div class="row ">
			<div class="col-sm-7">
			
		<form id="boletim" method="post" action="AtualizarBoletim" >
			<c:if test="${not empty compoe}">
				<input type="hidden" name="idBoletim" value="${compoe.boletim.ID}"/>
				<input type="hidden" name="idDisciplina" value="${compoe.disciplina.ID}"/>
			</c:if>
			
				<fieldset>
					<legend id = "legenda">Boletim</legend>
						<table class="table table-bordered">
							<thead>
								<tr class="info">
									<td>ID Boletim</td>
									<td>Disciplina</td>
									<td>Nota</td>
									<td>Faltas</td>			
								</tr>
							</thead>
							
						<tbody>			
							<tr>
			             		<td>${compoe.boletim.ID}</td>
								<td>${compoe.disciplina.nome}</td>
								
								<td><input class="form-control" type="text" id="txt_nota" name="nota" value="${compoe.nota}" tabindex="1"/></td>
								<td><input class="form-control" type="text" id="txt_faltas" name="faltas" value="${compoe.faltas}" tabindex="2"/></td>        			
								
			        		</tr>
			         	</tbody>
			         	
			        </table>
			        
			   </fieldset> 
			        
			        <fieldset id = "botoes">
						<input type="submit" value="Salvar" class="btn btn-success btn-sm"/>
			         	<input type="reset" value="Limpar" class="btn btn-default btn-sm"/>
					</fieldset> 		
				</form>
		</div>
	</div>	
</div>


</body>
</html>
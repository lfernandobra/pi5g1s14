<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Ocorrencia</title>
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
			
		<form id="boletim" method="post" action="AtualizaOcorrencia" >
			<c:if test="${not empty ocorrencia}">
				<input type="hidden" name="idOcorrencia" value="${ocorrencia.ID}"/>
			</c:if>
			
				<fieldset>
					<legend id = "legenda">Ocorrência</legend>
						<table class="table table-bordered">
							<thead>
								<tr class="info">
									<td>Assunto</td>
									<td>Descrição</td>
									<td>Data</td>			
								</tr>
							</thead>
							
						<tbody>			
							<tr>
								<td><input class="form-control" type="text" id="txt_nota" name="assunto" value="${ocorrencia.assunto}" tabindex="1"/></td>
								<td>
								<input class="form-control"id="txt_descricao" name="descricao" value="${ocorrencia.descricao}" tabindex="2"/>
								</td>
								<td><input class="form-control" type="text" id="txt_data" name="data" value="${ocorrencia.data}" tabindex="3"/></td>        			
								
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
<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Boletim</title>
	<link href="styles/cadastro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div id = "login_erro">
		<jsp:include page="erro.jsp" />
	</div>
	<form id="boletim" method="post" action="AtualizarBoletim" >
		<c:if test="${not empty compoe}">
			<input type="hidden" name="idBoletim" value="${compoe.boletim.ID}"/>
			<input type="hidden" name="idDisciplina" value="${compoe.disciplina.ID}"/>
		</c:if>
		<fieldset>
		<legend id = "legenda">Boletim</legend>
		<table border="1">
			<thead>
				<tr>
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
					
					<td><input type="text" id="txt_nota" name="nota" value="${compoe.nota}" tabindex="1"/></td>
					<td><input type="text" id="txt_faltas" name="faltas" value="${compoe.faltas}" tabindex="2"/></td>        			
					
        		</tr>
         	</tbody>
        </table>
        </fieldset> 
        <fieldset id = "botoes">
				<input type="submit" value="Salvar"></input><input type="reset" value="Resetar"></input>
		</fieldset> 		
	</form>

</body>
</html>
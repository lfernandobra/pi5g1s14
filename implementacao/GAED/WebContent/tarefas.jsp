<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Tarefas</title>
</head>
<body>
	<div class="container" id="main"> 
 		 <div class="row ">
			<div class="cold-md-7">
				<fieldset class="fsStyle">
					<legend>Dados da turma</legend>
						<table>
			  				<tr>
			  					<td>Escola : </td>
			  					<td>E.E. S�o Judas Tadeu</td>
			  				</tr>
			  				<tr>
			  					<td>Disciplina : </td>
			  					<td>Portugu�s</td>
			  				</tr>
			  				<tr>
			  					<td>Turma </td>
			  					<td>6� Ano Manh�</td>
			  				</tr>
			  				<tr>
			  					<td>Bimestre : </td>
			  					<td>1� Bimestre</td>
			  				</tr>	
			  			</table>
					</fieldset>
			</div>
		</div>
					
			
		
		<div class="row ">
			<div class="cold-md-7">
				<fieldset class="fsStyle">
					<legend>Anexar Tarefas</legend>
			  			<select>
			  				<option value="2011">Trabalhos</option>
			  				<option value="2012">Provas</option>
			  				<option value="2013">Reda��o</option>
						</select>
						<form action="demo_form.asp">
			  				Arquivo : <input type="file" name="arq">
			  				<input type="submit" name="Anexar">
						</form>
			 	</fieldset>
			 	<fieldset class = "fld_tarefas_anexada">
			  		<legend>Tarefas anexadas</legend>
			  			<a href =>Matem�tica - Exercicios de equa��es 2�grau</a>
			 	</fieldset>
		</div>
	</div>	
					
</div>

</body>
</html>
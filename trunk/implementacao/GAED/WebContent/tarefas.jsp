<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tarefas</title>
</head>
<body>
	<fieldset class = "fld_tarefas_turma">
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
 	<fieldset class = "fld_tarefas_anexar">
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


</body>
</html>
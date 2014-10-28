<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ocorrências</title>
</head>
<body>
	<button type="button" class = "btn_visualizar">Visualizar</button>
	<button type="button" class = "btn_inserir">Inserir</button>
	<fieldset class = "fld_ocorrencias_escola">
  		<legend>Escola</legend>
  			<select>
  				<option value="EESJ">E.E São Judas Tadeu</option>
  				<option value="EEML">E.E Maria de Lourdes</option>
			</select>
 	</fieldset>
 	<fieldset class = "fld_ocorrencias_turmas">
  		<legend>Turmas</legend>
  			<select>
  				<option value="A">Turma A</option>
  				<option value="B">Turma B</option>
  				<option value="C">Turma C</option>
  				<option value="D">Turma D</option>
			</select>
	</fieldset>
	<fieldset class = "fld_ocorrencias_aluno">
  		<legend>Aluno</legend>
  			<select>
  				<option value="A">Ana Paula</option>
  				<option value="B">Luis Fernando</option>
  				<option value="C">Luiza Helena</option>
  				<option value="D">Waldinei</option>
			</select>
	</fieldset>
	<fieldset class = "fld_txtarea_ocorrencia">
  		<legend>Digite a ocorrência :</legend>
  			<textarea rows="4" cols="50">
  			</textarea>
	</fieldset>
	<button type="button" class = "btn_salvar">Salvar</button>
</body>
</html>
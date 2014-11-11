<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!--  Diretiva Page Import -->
<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Boletim</title>
</head>
<body>
	
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed"
     user="root"  password=""/>
     
     <sql:query dataSource="${snapshot}" var="result">
		SELECT * from turma;
	 </sql:query>
     
     
	<fieldset class = "fld_turma">
  		<legend>Turma</legend>
  			<select>
  				<c:forEach var="row" items="${result.rows}">
  					<option value="$row.ID_Turma">Turma : ${row.Nome_Turma} - ${row.Bimestre}° Bimestre</option>
  				</c:forEach>
			</select>
 	</fieldset>
 	<fieldset class = "fld_bimestre">
  		<legend>Bimestre</legend>
  			<select>
  				<option value="1">1º Bimestre</option>
  				<option value="2">2º Bimestre</option>
  				<option value="3">3º Bimestre</option>
  				<option value="4">4º Bimestre</option>
			</select>
 	</fieldset>
 	<fieldset class = "fld_disciplina">
  		<legend>Disciplina</legend>
  			<select>
  				<option value="1">1º Bimestre</option>
  				<option value="2">2º Bimestre</option>
  				<option value="3">3º Bimestre</option>
  				<option value="4">4º Bimestre</option>
			</select>
	</fieldset>
	<div class="boletim">
	<table>
		<tr> 
			<th>Disciplinas</th>
			<th>Notas</th>
			<th>Faltas</th>
		</tr>
		<tr> 
			<td>Português</td>
			<td>10</td>
			<td>5</td>
		</tr>
		<tr> 
			<td>Matemática</td>
			<td>8</td>
			<td>3</td>
		</tr>
		<tr> 
			<td>História</td>
			<td>5</td>
			<td>8</td>
		</tr>
		<tr> 
			<td>Geográfia</td>
			<td>7</td>
			<td>5</td>
		</tr>
		<tr> 
			<td>Total de faltas</td>
			<td></td>
			<td>22</td>
		</tr>	
	</table>
	</div>

</body>
</html>
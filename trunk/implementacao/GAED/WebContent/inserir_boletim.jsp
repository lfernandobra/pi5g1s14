<!--  Diretiva Page Import -->
<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script type="text/javascript" src="scripts/script.js"></script>
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Inserir Boletim</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed_official"
     user="root"  password=""/>
     
     <sql:query dataSource="${snapshot}" var="resultAlunos">
		select a.ID_Aluno,a.ID_Usuario,u.Nome,u.Sobrenome from aluno a,usuario u,turma t,estuda e where a.ID_Usuario = u.ID_Usuario 
		and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma;
	 </sql:query>
	 
	 
	 <div class="container" id="main"> 
  		<div class="row ">
  			<div class="col-sm-7">
	    		<div class="panel panel-default">
    				<div class="panel-heading"> <h4>Inserir Boletim</h4></div>
    				<br>
		<fieldset class="fsStyle">
    		<form action = "InserirBoletim" method = "post" class="form-horizontal">
				<div class="form-group">
				<label class="col-sm-2 control-label" id="lbl_aluno" for="txt_aluno">Aluno :</label> 			
				<div class="col-sm-5"><select id="sel_turma" name="idAluno" class="form-control">
  					<c:forEach var="row" items="${resultAlunos.rows}">
  						<option value="${row.ID_Aluno}">${row.Nome} ${row.Sobrenome}</option>
  					</c:forEach>
					</select>
				</div>
				</div>
				
			<div class="form-group">		
			<label class="col-sm-2 control-label" id="lbl_bimestre" for="txt_bimestre">Bimestre :</label>	
				<div class="col-sm-3">
				<select id="sel_bimestre" name="idBimestre" class="form-control">
					<option value="1">1º Bimestre</option>
  					<option value="2">2º Bimestre</option>
  					<option value="3">3º Bimestre</option>
  					<option value="4">4º Bimestre</option>
				</select>
				</div>
			</div>	
				<div class="form-group last">
				 	<div class="col-sm-offset-3 col-sm-2">
				 		<button type="submit"  class="btn btn-success">Inserir Boletim</button>
	 			 	</div>
	 			</div> 		
 			</form>
 		</fieldset>
		</div> 
		</div>
		</div>
		</div>
</body>
</html>
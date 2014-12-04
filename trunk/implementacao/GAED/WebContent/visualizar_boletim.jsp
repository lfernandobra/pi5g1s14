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
<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Visualizar Boletim</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed_official"
     user="root"  password=""/>
     
     <sql:query dataSource="${snapshot}" var="resultAlunos">
		select a.ID_Aluno,a.ID_Responsavel,u.ID_Usuario,u.Nome,u.Sobrenome from aluno a,responsavel r,usuario u
		where u.ID_Usuario = a.ID_Usuario and a.ID_Responsavel = r.ID_Responsavel and r.ID_Usuario = ${login.id} 
		order by u.Nome;
	 </sql:query>
	 
	 <div class="container" id="main"> 
  		<div class="row ">
  			<div class="col-sm-6">
	    		<div class="panel panel-default">
    				<div class="panel-heading"> <h4>Visualizar Boletim</h4></div>
    				<br>
	 
	 <fieldset class="fsStyle">
    		<form action = "ObterBoletimAluno" method = "post" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-4 control-label" id="lbl_aluno" for="txt_aluno">Selecione o aluno :</label> 			
					<div class="col-sm-5">
					<select id="sel_alunos" name="idUsuario" class="form-control">
  						<c:forEach var="row" items="${resultAlunos.rows}">
  							<option value="${row.ID_Usuario}">${row.Nome} ${row.Sobrenome}</option>
  						</c:forEach>
					</select>
					</div>
				</div>
					<div class="form-group">
					<label class="col-sm-4 control-label" id="lbl_bimestre" for="txt_bimestre">Selecione o bimestre :</label>	
					<div class="col-sm-5"><select id="sel_bimestre" name="idBimestre" class="form-control">
							<option value="1">1º Bimestre</option>
  							<option value="2">2º Bimestre</option>
  							<option value="3">3º Bimestre</option>
  							<option value="4">4º Bimestre</option>
						</select>
					</div>
					</div>
					<div class="form-group last">
				 		<div class="col-sm-offset-8 col-sm-2">
				 			<button type="submit"  class="btn btn-success">Visualizar Boletim</button>
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
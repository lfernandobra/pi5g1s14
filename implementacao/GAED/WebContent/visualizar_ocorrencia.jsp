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
<title>Visualizar Ocorrencia</title>
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
   				<div class="panel-heading"> <h4>Visualizar Ocorrências</h4></div>
   				<br>
	 
				 <fieldset class="fsStyle">
			    		<form action = "ObterOcorrenciasAluno" method = "post" class="form-horizontal">
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
								<div class="form-group last">
							 		<div class="col-sm-offset-9 col-sm-2">
							 			<button type="submit"  class="btn btn-success">Buscar</button>
				 			 		</div>
						 		</div>
						</form>
				</fieldset>
			</div>
		</div>  <!-- col-sm-6 -->
</div> <!-- Class row -->

			<div class="form-group last">
 	 				<button type="submit" class="btn btn-primary" onclick="loadContent('gerencia_boletins.jsp')">Voltar</button>
 	 		</div>

</div> <!-- Class container /main -->
	
			
</body>
</html>
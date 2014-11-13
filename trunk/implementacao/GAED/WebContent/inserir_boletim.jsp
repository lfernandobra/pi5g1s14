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
<title>Insert title here</title>
</head>
<body>

		
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed"
     user="root"  password=""/>
     
     <sql:query dataSource="${snapshot}" var="resultAlunos">
		select a.ID_Aluno,a.ID_Usuario,u.Nome,u.Sobrenome from aluno a,usuario u,turma t,estuda e where a.ID_Usuario = u.ID_Usuario 
		and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma;
	 </sql:query>
	 
	<fieldset>
     	<legend>Inserir Boletim</legend>
    <form action = "InserirBoletim" method = "post">
		<p><label id="lbl_aluno" for="txt_aluno">Aluno :</label> 			
  				<select id="sel_turma" name="idAluno">
  					<c:forEach var="row" items="${resultAlunos.rows}">
  						<option value="${row.ID_Aluno}">${row.Nome} ${row.Sobrenome}</option>
  					</c:forEach>
				</select></p>
		<p><label id="lbl_bimestre" for="txt_bimestre">Bimestre :</label>	
				<select id="sel_bimestre" name="idBimestre">
  					<option value="1">1� Bimestre</option>
  					<option value="2">2� Bimestre</option>
  					<option value="3">3� Bimestre</option>
  					<option value="4">4� Bimestre</option>
				</select></p>
					 	
  		<p><input type = submit value = "Inserir Boletim"/></p>
 		
 		
 	</form>
 	</fieldset>
	

</body>
</html>
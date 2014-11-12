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
     
     <sql:query dataSource="${snapshot}" var="resultTurma">
		SELECT t.ID_Turma,t.Nome_Turma,t.Bimestre,t.Periodo,t.Serie from turma t,professor p,possui ps 
		where t.ID_Turma = ps.ID_Turma and ps.ID_Professor = p.ID_Professor and p.ID_Professor = ${professor.idProfessor};
	 </sql:query>
	 
	 <sql:query dataSource="${snapshot}" var="resultDisciplina">
			select d.ID_Disciplina,d.Nome_Disciplina,d.Conteudo_Disciplina from disciplina d,ministra m,professor p
			where d.ID_Disciplina =  m.ID_Disciplina and m.ID_Professor = p.ID_Professor and p.ID_Professor = ${professor.idProfessor};
	 </sql:query>
	 	
     <fieldset>
     	<legend>Visualizar Boletim</legend>
    <form action = "ObterBoletimTurma" method = "post">
		<p><label id="lbl_turma" for="txt_turma">Selecione a turma:</label> 			
  				<select id="sel_turma" name="idTurma" value="${turma.ID}">
  					<c:forEach var="rowT" items="${resultTurma.rows}">
  						<option value="${rowT.ID_Turma}">Turma : ${rowT.Nome_Turma} - ${rowT.Bimestre}° Bimestre - ${rowT.Periodo}</option>
  					</c:forEach>
				</select>	 	
  		<p><label id="lbl_disciplina" for="txt_disciplina">Selecione a disciplina:</label> 
  				<select id="sel_disciplina" name="idDisciplina" value="${disciplina.ID}">
  					<c:forEach var="rowD" items="${resultDisciplina.rows}">
  						<option value="${rowD.ID_Disciplina}"> ${rowD.Nome_Disciplina}</option>
  					</c:forEach>
				</select>
 		<p><input type = submit value = "Obter Boletim"/></p>
 		
 		
 	</form>
 	</fieldset>
</body>
</html>
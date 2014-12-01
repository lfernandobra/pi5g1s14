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
<script type="text/javascript" src="scripts/script.js"></script>
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Boletim</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed_official"
     user="root"  password=""/>
     <c:choose>
			<c:when test="${login.perfil.professor}">		
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
 		</c:when>
 		<c:when test="${login.perfil.responsavel}">
 			Teste
 			<sql:query dataSource="${snapshot}" var="resultResponsavelAluno">
					select a.ID_Aluno,r.ID_Responsavel from aluno a,responsavel r,usuario u 
					where a.ID_Responsavel = r.ID_Responsavel and r.ID_Usuario = u.ID_Usuario and u.ID_Usuario = ${login.id};
	 		</sql:query>
 			
 			
 		</c:when>
 		<c:when test="${login.perfil.aluno}">
 			<sql:query dataSource="${snapshot}" var="resultAluno">
					select d.nome_disciplina,b.bimestre,c.nota,c.faltas from
					usuario u,turma t,disciplina d,boletim b,compoe c,aluno a ,estuda e,inserido i 
					where a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and
					b.ID_Boletim = c.ID_Boletim and c.ID_Disciplina = d.ID_Disciplina 
					and b.ID_Boletim = i.ID_Boletim and i.ID_Aluno = a.ID_Aluno and a.ID_Usuario = u.ID_Usuario
					and u.ID_Usuario = ${login.id};
	 		</sql:query>
	 		
	 		<sql:query dataSource="${snapshot}" var="resultBimestre">
	 		
	 		select b.Bimestre,i.ID_Boletim,t.Ano_Letivo from aluno a,estuda e,turma t,usuario u,inserido i,boletim b
			where a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma and a.ID_Aluno = i.ID_Aluno and i.ID_Boletim = b.ID_Boletim
 			and a.ID_Usuario = u.ID_Usuario and u.ID_Usuario = ${login.id};
	 		
	 		</sql:query>
	 		
	 <div class="container" id="main"> 
		<div class="row ">
			<div class="col-sm-7">
	 		<div class="form-group">
	 		<form action = "VisualizarBoletimAluno" method = "post">
		 		<label class="col-sm-5 control-label" id="lbl_bimestre_boletim" for="txt_bimestre_boletim">Selecione o Bimestre - Ano :</label> 
	  				<div class="col-sm-4">
	  				<select id="sel_bimestre_boletim" name="idBoletim" value="${boletim.ID}" class="form-control">
	  					<c:forEach var="rowB" items="${resultBimestre.rows}">
	  						<option value="${rowB.ID_Boletim}">${rowB.Bimestre}º Bimestre - ${rowB.Ano_Letivo} </option>
	  					</c:forEach></select>
	  				</div>
	  				<div class="form-group last">
					 	<div class="col-sm-offset-0 col-sm-2">
					    	<input type = "submit" value = "Visualizar Boletim" class="btn btn-success"/>
		 			 	</div>
		 			</div>
		 	</form>		
	 		</div>
	 	</div>
	 </div>
	 		<br>
	 </div>	  		
		
 		</c:when>
 	</c:choose>
</body>
</html>
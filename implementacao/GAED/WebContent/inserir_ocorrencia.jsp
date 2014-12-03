<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.gaed.vo.*"%>
<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
	<title>Inserir Ocorrência</title>
	<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/bd_gaed_official"
     user="root"  password=""/>
	
	<div class="container" id="main"> 
 		<div class="row ">
 			<div class="col-sm-8">
    			<div class="panel panel-default">
    				<div class="panel-heading"><h3>Cadastrar Ocorrência</h3></div>
    				<br>
					<sql:query dataSource="${snapshot}" var="resultListaAluno">
						select a.ID_Aluno,u.Nome,u.Sobrenome,t.Nome_Turma,t.Serie from aluno a,usuario u,turma t,estuda e
						where a.ID_Usuario = u.ID_Usuario and a.ID_Aluno = e.ID_Aluno and e.ID_Turma = t.ID_Turma 
						order by a.ID_Aluno
	 				</sql:query>
					<form  class="form-horizontal" id="ocorrencia" method="post" action="adiciona_ocorrencia.jsp">
						<fieldset class="fsStyle">  				
  							<legend class="legendStyle">Ocorrência</legend>
			    			<div class="form-group">
			      				<label class="col-sm-2 control-label" for="txt_nome">Aluno:</label>
									<div class="col-sm-6"> <select id="sel_bimestre_boletim" name ="aluno" value="${param.IDAluno}" class="form-control">
		  								<c:forEach var="rowAluno" items="${resultListaAluno.rows}">
		  									<option value="${rowAluno.ID_Aluno}">${rowAluno.Nome} ${rowAluno.Sobrenome} - Serie ${rowAluno.Serie} -
		  									Turma : ${rowAluno.Nome_Turma}</option>
		  								</c:forEach></select>
			    					</div>
			    			</div>
			    	   		<div class="form-group">
			      				<label class="col-sm-2 control-label" for="txt_data">Data </label>
								<div class="col-sm-3"> 
									<input type="text" class="form-control" name="data" 
									  	 onKeyPress="MascaraData(ocorrencia.data);"
                	 				  	 onBlur="ValidaData(ocorrencia.data);" value="${param.data}"
                	 				  	 placeholder="DD/MM/AAAA" 
                	 				  	 tabindex="1"/></div>
								</div>	
			    	    		<div class="form-group">
			     					<label class="col-sm-2 control-label" for="login">Assunto</label>
			     					<div class="col-sm-6">
			     						<input type="text" 
			     							   class="form-control"
			     							   name="assunto" 
			     							   value="${param.assunto}"
			     							   tabindex="2"
			     							   placeholder="Assunto"/>
			     					</div> 
			   					</div>
			    	    		<div class="form-group">
			    	 				<label class="control-label col-sm-2" for="descricao">Descrição</label>
			       					<textarea class="col-xs-9" id="descricao" name="descricao" 
			       							  placeholder="Digite a ocorrência" rows="4"
			       							  value="${param.descricao}" 
			       							  tabindex="3"></textarea> 
			   					</div>
			    				<div class="form-group last">
			    		    		<div class="col-sm-offset-8 col-sm-9">
			         					<input type="submit" value="Salvar" class="btn btn-success "/>
			         					<input type="reset" value="Limpar" class="btn btn-default "/>
			        				</div>
			   					</div>
			    			</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
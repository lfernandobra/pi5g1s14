<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
<title>Gerencia Usuários</title>
</head>
<body>
<div class="container" id="main"> 
  <div class="row ">
  	<div class="col-sm-9">
  	    	<div class="col xs-8 col-sm-5 col-sm-offset-0 ">
	            <div class="panel panel-default">
	                <div class="panel-heading"> <h4>Aluno</h4></div>
							<ul class="nav">
								<li><a href="#" onclick="loadContent('inserir_aluno.jsp')"><i class="glyphicon glyphicon-pencil"></i> Inserir Aluno</a></li>
								<li><a href="#" onclick="loadContent('ListaAlunosServlet')"><i class="glyphicon glyphicon-eye-open"></i> Visualizar Alunos</a></li>
							</ul>
				</div>
			</div>  <!-- col xs-8 -->
			</div>  <!-- colsm9 -->
		</div> <!-- row -->	
			
		<div class="row ">
  			<div class="col-sm-9">
				<div class="col xs-8 col-sm-5 col-sm-offset-0 ">
			            <div class="panel panel-default">
			                <div class="panel-heading"> 
			               		 <h4>Responsável</h4>
			                </div>
							<ul class="nav">
								<li><a href="#" onclick="loadContent('inserir_responsavel.jsp')"><i class="glyphicon glyphicon-pencil"></i> Inserir  Responsável</a></li>
							</ul>
					    </div>
			
				
					</div>  <!-- colxs9 -->
				</div>  <!-- colsm9 -->
		  </div> <!-- row -->
	  
</div>  <!-- Container -->



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
    
</head>
<body>
    
    <div id = "login_erro">
		<jsp:include page="erro.jsp" />
	</div>

	<nav class="navbar navbar-default col-sm-offset-0 col-sm-12" role="navigation">
	  <div class="container ">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	    </div>

    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
 		  	<a class="nav navbar-nav navbar-right "><img src ="images\logo_gaed_1.png"></a>
		      <ul class="nav navbar-nav">
		        <li><a href="http://www.saopaulo.sp.gov.br/" target="_blank">Portal do Governo</a></li>
		        <li><a href="http://www.cidadao.sp.gov.br/" target="_blank">Cidadao SP</a></li>
		        <li><a href="http://www.investe.sp.gov.br/" target="_blank">Investe SP</a></li>
	       		 <form class="navbar-form navbar-left" role="Search">
		       
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Pesquisar">
		        </div>
		        <button type="submit" class="btn btn-default">Pesquisar</button>
	     	</form> 
	      </ul>
      	</div>  
    </div>
 </nav>
 
 <!-- Carousel -->
  <div class="container">
	<div class="row">
		<div class="col-md-8">
		    <div id="myCarousel" class="carousel slide">
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			  </ol>
					
				<div class="carousel-inner">
				    <div class="active item">
				        <a href="#"><img src="images/Escola_aberta.jpg" alt=""></a></div><!-- /Slide1 --> 
					
			    	<div class="item">
					    <a href="#"><img src="images/Saladeaula_itapevi.jpg" alt=""></a></div><!-- /Slide2 -->             
					
					<div class="item">
					     <a href="#"><img src="images/images.jpg" alt=""></a></div><!-- /Slide2 -->                      
					 
				</div>
					        
				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			  	<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
	</div>	
	   
		   <div class="col-md-4 ">
            <div class="panel panel-default">
                <div class="panel-heading"> <h4>Acesso</h4></div>
		
			 <c:choose>
			  		<c:when test="${empty login}">
			 			<div class="panel-body">
			         		 <form class="form-horizontal" action="LoginServlet" method="post">
			         		 
			              		 <div class="form-group">
			 						<label for="login" class="col-sm-3 control-label">Login</label>
			                            <div class="col-sm-9">
			                                <input type="text" class="form-control" name="login"  value="${param.login}"/>
			                            </div>
			 					</div>
			 					
			                    <div class="form-group">
			                         <label for="senha" class="col-sm-3 control-label">Senha</label>
			                            <div class="col-sm-9">
			                                <input type="password" class="form-control"  name="senha"  value="${param.senha}"/>
			                            </div>
			                    </div>
			 
			 				<div class="form-group">
			                     <div class="col-sm-offset-3 col-sm-9">
			                          <div class="checkbox">
			                               <label class="">
			                               <input type="checkbox" class="">Lembrar senha</label>
			                          </div>
			                     </div>
			                 </div>
			                 
			                 <div class="form-group last">
			                      <div class="col-sm-offset-3 col-sm-9">
			                         <input type="submit" value="Entrar" class="btn btn-success btn-sm"/>
			                          <input type="reset" value="Limpar" class="btn btn-default btn-sm"/>
			                      </div>
			                 </div>
			             </form>
			        </div>
			                
			             <div class="panel-footer">Esqueceu sua senha? <a href="#" class="">Clique aqui</a></div>
			  	  		
				</c:when>	
			
		  	    <c:otherwise>
		    		<p>Olá, ${login.nome}. <a href="LogoutServlet">(sair)</a></p>  
		  		</c:otherwise>
			</c:choose>
	</div>
		        
	</div><!-- /.col-md-8 -->          
</div><!-- /.row --> 
</div><!-- /.container -->


<div class="container">
	 <hr>
		<div class="row">
				
				<!--Noticias -->
					<div class="col-md-4">
			        	<div class="panel panel-default">
				            <div class="panel-heading"><h3>Noticias</h3></div>
				            <div class="panel-body">
								<p><a href="#"> Festa junina teve quadrilha e pipoca</a> </p>
								<p><a href="#"> Familias ligadas ao MTST invadem area em Carapicuiba</a> </p>
								<p><a href="#"> Bancarios optam por greve dia 30</a> </p>
								<a href="#" class="btn btn-default"> Leia mais >></a>
							</div>
						</div>
					</div>
	
				<!-- /.Noticias -->  
	
	<!--Documentos -->
		        <div class="col-md-4">
		          <div class="panel panel-default">
		            <div class="panel-heading"><h3>Documentos</h3></div>
		           		 <div class="panel-body">
							<p><a href="#"> Documentos necessario para matricula escolar</a> </p>
							<p><a href="#"> Documentos para cadastro ou renovacao de bolsa escola</a> </p>
							<p><a href="#"> Documentos para cadastro do Jovem Aprendiz</a> </p>
							<a href="#" class="btn btn-default"> Leia mais >></a>
						</div>
					</div>	
				</div>	
				
	<!--/. Documentos -->
	
	<!-- /.Help -->		
			<div class="col-md-4">
	        	<div class="panel panel-default">
	            	<div class="panel-heading"><h3>Help</h3></div>
			            <div class="panel-body">
							<p><a href="#"> Como redefinir sua senha</a> </p>
							<p><a href="#"> Saiba como utilizar nosso sistema de uma forma agil e facil</a></p>
							<p><a href="#"> Procure a escola mais perto de voca</a> </p>
							<a href="#" class="btn btn-default"> Leia mais >></a>
						</div>
				</div>	
			</div>
	<!--/.Help -->			
			
	</div>	
</div>

 
</body>
</html>

	





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
</head>
<body>
    
    <div id = "login_erro">
		<jsp:include page="erro.jsp" />
	</div>


	<nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	    </div>

    	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
 		  	<a class="navbar-brand"><img src ="images\logo_gaed_1.png"></a>
		      <ul class="nav navbar-nav">
		        <li><a href="http://www.saopaulo.sp.gov.br/" target="_blank">Portal do Governo</a></li>
		        <li><a href="http://www.cidadao.sp.gov.br/" target="_blank">Cidadão SP</a></li>
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
 
 <div class="container">
 	<div class="row">
        <div class="col-md-8">
            <div class="panel panel-default">
			  <div id="myCarousel" class="carousel slide">
				  <ol class="carousel-indicators">
					 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					 <li data-target="#myCarousel" data-slide-to="1"></li>
					 <li data-target="#myCarousel" data-slide-to="2"></li>
				  </ol>
				</div> 
        
  <div class="carousel-inner">
    <div class="item active">
      <img src="http://lorempixel.com/1500/600/abstract/1" class="img-responsive">
        <div class="carousel-caption">
          <h1>Bootstrap 3 Carousel Layout</h1>
          <pthis is="" an="" example="" layout="" with="" carousel="" that="" uses="" the="" bootstrap=""  styles="" small="">
          <p><a class="btn btn-lg btn-primary" href="http://getbootstrap.com">Learn More</a>
        </pthis></div>
      </div>
    </div>
    <div class="item">
      <img src="http://lorempixel.com/1500/600/abstract/1" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
          <h1>Changes to the Grid</h1>
          <p>Bootstrap 3 still features a 12-column grid, but many of the CSS class names have completely changed.</p>
          <p><a class="btn btn-large btn-primary" href="#">Learn more</a></p>
        </div>
      </div>
    </div>
    <div class="item">
      <img src="http://placehold.it/1500X500" class="img-responsive">
      <div class="container">
        <div class="carousel-caption">
          <h1>Percentage-based sizing</h1>
          <p>With "mobile-first" there is now only one percentage-based grid.</p>
          <p><a class="btn btn-large btn-primary" href="#">Browse gallery</a></p>
        </div>
      </div>
    </div>
  </div>
  <!-- Controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="icon-prev"></span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="icon-next"></span>
  </a>  
</div>      
        
 </div> 
		</div>
       
        
        
        
        
        
        
        
        
        
        
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
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
		</div>
	</div>
</div>


		<div class="container">
	  	<hr>
			<div class="row">
				<div class="col-md-4">
			        	<div class="panel panel-default">
				            <div class="panel-heading"><h3>Noticias</h3></div>
				            <div class="panel-body">
								<p><a href="#"> Festa junina teve quadrilha e pipoca</a> </p>
								<p><a href="#"> Famílias ligadas ao MTST invadem área em Carapicuíba</a> </p>
								<p><a href="#"> Bancários optam por greve dia 30</a> </p>
								<a href="#" class="btn btn-default"> Leia mais >></a>
						</div>
				</div>
			</div>
	  
		        <div class="col-md-4">
		          <div class="panel panel-default">
		            <div class="panel-heading"><h3>Documentos</h3></div>
		           		 <div class="panel-body">
							<p><a href="#"> Documentos necessário para matricula escolar</a> </p>
							<p><a href="#"> Documentos para cadastro ou renovação de bolsa escola</a> </p>
							<p><a href="#"> Documentos para cadastro do Jovem Aprendiz</a> </p>
							<a href="#" class="btn btn-default"> Leia mais >></a>
						</div>
					</div>	
				</div>	
			
			<div class="col-md-4">
	        	<div class="panel panel-default">
	            	<div class="panel-heading"><h3>Help</h3></div>
			            <div class="panel-body">
							<p><a href="#"> Como redefinir sua senha</a> </p>
							<p><a href="#"> Saiba como utilizar nosso sistema de uma forma ágil e fácil</a></p>
							<p><a href="#"> Procure a escola mais perto de você</a> </p>
							<a href="#" class="btn btn-default"> Leia mais >></a>
						</div>
				</div>	
			</div>
	</div>	
</div>	

		
</body>
</html>

	





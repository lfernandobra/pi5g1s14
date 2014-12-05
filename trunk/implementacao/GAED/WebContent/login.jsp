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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
    		$('#myCarousel').carousel({
    		//options here
    		});
		});
	</script> 
</head>
<body>
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
			    <li data-target="#myCarousel" data-slide-to="0"></li>
			    <li data-target="#myCarousel" data-slide-to="1" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			  </ol>
					
				<div class="carousel-inner">
				    <div class="item">
				        <a href="#"><img src="images/Escola_aberta.jpg" alt=""></a></div><!-- /Slide1 --> 
					
			    	<div class="active item">
					    <a href="#"><img src="images/ilustra_home.png" alt=""></a></div><!-- /Slide2 -->             
					
					<div class="item">
					     <a href="#"><img src="images/escola_democratica.jpg" alt=""></a></div><!-- /Slide2 -->                      
					 
				</div>
					        
				<a class="carousel-control left" href="#myCarousel" role = "button" data-slide="prev">&lsaquo;</a>
			  	<a class="carousel-control right" href="#myCarousel" role = "button" data-slide="next">&rsaquo;</a>
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
			                    <div id = "login_erro">
			                    <span class="label label-danger">${login_erro}</span>
									
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
		<script src="Bootstrap/js/jquery-1.9.1.min.js"></script>
    	<script src="Bootstrap/js/bootstrap.min.js"></script>
    	<script src="Bootstrap/js/docs.min.js"></script>
   	 <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    	<script src="ie10-viewport-bug-workaround.js"></script>
<	script type="text/javascript" src="Bootstrap/js/jssor.slider.mini.js"></script>
    <script>
        jQuery(document).ready(function ($) {

            var options = {
                $FillMode: 2,                                       //[Optional] The way to fill image in slide, 0 stretch, 1 contain (keep aspect ratio and put all inside slide), 2 cover (keep aspect ratio and cover whole slide), 4 actual size, 5 contain for large image, actual size for small image, default value is 0
                $AutoPlay: true,                                    //[Optional] Whether to auto play, to enable slideshow, this option must be set to true, default value is false
                $AutoPlayInterval: 3000,                            //[Optional] Interval (in milliseconds) to go for next slide since the previous stopped if the slider is auto playing, default value is 3000
                $PauseOnHover: 1,                                   //[Optional] Whether to pause when mouse over if a slider is auto playing, 0 no pause, 1 pause for desktop, 2 pause for touch device, 3 pause for desktop and touch device, 4 freeze for desktop, 8 freeze for touch device, 12 freeze for desktop and touch device, default value is 1

                $ArrowKeyNavigation: true,   			            //[Optional] Allows keyboard (arrow key) navigation or not, default value is false
                $SlideEasing: $JssorEasing$.$EaseOutQuint,          //[Optional] Specifies easing for right to left animation, default value is $JssorEasing$.$EaseOutQuad
                $SlideDuration: 250,                               //[Optional] Specifies default duration (swipe) for slide in milliseconds, default value is 500
                $MinDragOffsetToSlide: 20,                          //[Optional] Minimum drag offset to trigger slide , default value is 20
               // $SlideWidth: 600,                                 //[Optional] Width of every slide in pixels, default value is width of 'slides' container
                //$SlideHeight: 300,                                //[Optional] Height of every slide in pixels, default value is height of 'slides' container
                $SlideSpacing: 0, 					                //[Optional] Space between each slide in pixels, default value is 0
                $DisplayPieces: 1,                                  //[Optional] Number of pieces to display (the slideshow would be disabled if the value is set to greater than 1), the default value is 1
                $ParkingPosition: 0,                                //[Optional] The offset position to park slide (this options applys only when slideshow disabled), default value is 0.
                $UISearchMode: 1,                                   //[Optional] The way (0 parellel, 1 recursive, default value is 1) to search UI components (slides container, loading screen, navigator container, arrow navigator container, thumbnail navigator container etc).
                $PlayOrientation: 1,                                //[Optional] Orientation to play slide (for auto play, navigation), 1 horizental, 2 vertical, 5 horizental reverse, 6 vertical reverse, default value is 1
                $DragOrientation: 1,                                //[Optional] Orientation to drag slide, 0 no drag, 1 horizental, 2 vertical, 3 either, default value is 1 (Note that the $DragOrientation should be the same as $PlayOrientation when $DisplayPieces is greater than 1, or parking position is not 0)
              
                $BulletNavigatorOptions: {                          //[Optional] Options to specify and enable navigator or not
                    $Class: $JssorBulletNavigator$,                 //[Required] Class to create navigator instance
                    $ChanceToShow: 2,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 1,                                 //[Optional] Auto center navigator in parent container, 0 None, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1,                                      //[Optional] Steps to go for each navigation request, default value is 1
                    $Lanes: 1,                                      //[Optional] Specify lanes to arrange items, default value is 1
                    $SpacingX: 8,                                   //[Optional] Horizontal space between each item in pixel, default value is 0
                    $SpacingY: 8,                                   //[Optional] Vertical space between each item in pixel, default value is 0
                    $Orientation: 1,                                //[Optional] The orientation of the navigator, 1 horizontal, 2 vertical, default value is 1
                    $Scale: false,                                  //Scales bullets navigator or not while slider scale
                },

                $ArrowNavigatorOptions: {                           //[Optional] Options to specify and enable arrow navigator or not
                    $Class: $JssorArrowNavigator$,                  //[Requried] Class to create arrow navigator instance
                    $ChanceToShow: 1,                               //[Required] 0 Never, 1 Mouse Over, 2 Always
                    $AutoCenter: 2,                                 //[Optional] Auto center arrows in parent container, 0 No, 1 Horizontal, 2 Vertical, 3 Both, default value is 0
                    $Steps: 1                                       //[Optional] Steps to go for each navigation request, default value is 1
                }
            };

            //Make the element 'slider1_container' visible before initialize jssor slider.
            $("#slider1_container").css("display", "block");
            var jssor_slider1 = new $JssorSlider$("slider1_container", options);

            //responsive code begin
            //you can remove responsive code if you don't want the slider scales while window resizes
            function ScaleSlider() {
                var bodyWidth = document.body.clientWidth;
                if (bodyWidth)
                    jssor_slider1.$ScaleWidth(Math.min(bodyWidth, 1920));
                else
                    window.setTimeout(ScaleSlider, 30);
            }
            ScaleSlider();

            $(window).bind("load", ScaleSlider);
            $(window).bind("resize", ScaleSlider);
            $(window).bind("orientationchange", ScaleSlider);
            //responsive code end
        });
    </script>

 
</body>

</html>


	





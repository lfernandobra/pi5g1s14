<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.gaed.vo.*"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" media="screen" />
    <link href="Bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" />
	<title>Cadastro Aluno</title>
	<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
<div class="container" id="main"> 
  <div class="row ">
  	<div class="col-sm-7">
  	   
    		<div class="panel panel-default">
    			<div class="panel-heading"> <h4>Cadastro de Aluno</h4></div>
    			<br>

				<form  class="form-horizontal" id="aluno" method="post" action="adiciona_aluno.jsp" >
				
					<c:if test="${not empty aluno}">
						<input type="hidden" name="id" value="${aluno.id}"/>
					</c:if>
		 		
  				<fieldset class="fsStyle">  				
  				<legend class="legendStyle">Identificação</legend>
			    <div class="form-group">
			     <label class="col-sm-2 control-label" for="login">Login</label>
			     <div class="col-sm-6"><input type="text" class="form-control" name="login" value="${aluno.login}" tabindex="1"/> </div> 
			    </div>
			    
			    <div class="form-group">
			      <label class="col-sm-2 control-label" for="txt_senha">Senha</label>
			      <div class="col-sm-6"> <input type="password" class="form-control" name="senha" value="${aluno.senha}" tabindex="2"/> </div> 
			    </div>
			</fieldset>
			
				
		<fieldset class="fsStyle">  				
  				<legend class="legendStyle">Dados Pessoais</legend>
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_nome">Nome:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="nome" value="${aluno.nome}" tabindex="3"/> </div>
				</div>
		
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_sobrenome">Sobrenome:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="sobrenome" value="${aluno.sobrenome}" tabindex="4"/> </div>
				</div>
		
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_data">Data de Nascimento:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="datanasc" onKeyPress="MascaraData(aluno.datanasc);"
                	 onBlur="ValidaData(aluno.datanasc);" value="${aluno.datanasc}" tabindex="5"/></div>
				</div>
		
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_sexo">Sexo:</label>
					<div class="col-sm-6"><select id="txt_sexo" name="sexo" value="${aluno.sexo}" tabindex="6" class="form-control">
				      <option value="Feminino">Feminino</option>
				      <option value="Masculino">Masculino</option>
  					</select></div>
				</div>
		 		
		 		<div class="form-group">
			      	<label class="col-sm-2 control-label" for="inputEmail1">Email:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="email" value="${aluno.email}" tabindex="7"/> </div>
				</div>
		
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_data">Telefone:</label>
					<div class="col-sm-6"> <input type="text" class="form-control"  name="telefone" value="${aluno.telefone}"
                	onKeyPress="MascaraTelefone(aluno.telefone);" maxlength="20" value="${aluno.telefone}" 
   					tabindex="8"  onBlur="ValidaTelefone(txt_telefone);"/></div>
				</div>
		
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_rua">Rua:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="rua" value="${aluno.rua}" tabindex="9"/> </div>
				</div>
				
								
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txt_numero">Numero:</label>
					<div class="col-sm-2"> <input type="text" class="form-control" name="numero" value="${aluno.numero}" tabindex="10"/> </div>
			      	<label class="col-sm-1 control-label" for="txt_numero">Bairro:</label>
					<div class="col-sm-3"> <input type="text" class="form-control" name="bairro" value="${aluno.bairro}"  tabindex="11"/> </div>
				</div>
				
				<div class="form-group">
					<label class="col-sm-2 control-label" for="txt_numero">Cidade:</label>
					<div class="col-sm-3"> <input type="text" class="form-control" name="cidade" value="${aluno.cidade}" tabindex="12"/> </div>
			      	<label class="col-sm-1 control-label" for="txt_numero">Estado:</label>
					<div class="col-sm-2"> <input type="text" class="form-control" name="estado" value="${aluno.estado}"  tabindex="13"/> </div>
				</div>
				
				<div class="form-group">
			      	<label class="col-sm-2 control-label" for="txt_rua">CEP:</label>
					<div class="col-sm-6"> <input type="text" class="form-control" name="CEP" value="${aluno.CEP}" tabindex="13"
                	   maxlength="10" onKeyPress="MascaraCep(aluno.CEP);" onBlur="ValidaCep(aluno.CEP);"/> </div>
				</div>
				
				<div class="form-group last">
			        <div class="col-sm-offset-8 col-sm-9">
			         <input type="submit" value="Salvar" class="btn btn-success btn-sm"/>
			         <input type="reset" value="Limpar" class="btn btn-default btn-sm"/>
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
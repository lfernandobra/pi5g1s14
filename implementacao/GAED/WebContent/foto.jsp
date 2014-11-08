<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="edu.gaed.vo.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
		<title>Inserir Foto</title>	
	</head>
	<body>
		
		<form id="frm_foto" action="FotoServlet" enctype="multipart/form-data" method="post">
			<fieldset>
				<legend>Foto</legend>
				<label>Nome:</label>
		    	<input type="text" name="nome" value="${foto.nome}"/>
			    <br/>
			    
			    <label>Descrição:</label>
			    <textarea name="descricao" cols="70" rows="4">${foto.descricao}</textarea>
		    	<br/>
			    
			    <label>Imagem:</label>
		    	<input type="file" name="imagem"/>
		    	<br/>
			    <p>
					<c:choose>
		        	    <c:when test="${not empty foto}">
		                	<input type="hidden" name="id" value="${foto.id}"/>	                
		                	<input type="submit" name="sub_editarFoto" value="Editar"></input>
		               	</c:when>
		               	<c:otherwise>
			                <input type="submit" name="sub_adicionarFoto" value="Adicionar"></input>
		               	</c:otherwise>
		            </c:choose>
		        </p>
		    </fieldset>    
		</form>
	</body>
</html>
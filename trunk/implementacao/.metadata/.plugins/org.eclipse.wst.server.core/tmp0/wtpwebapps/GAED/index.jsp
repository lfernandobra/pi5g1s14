<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="estilos/estilo.css"/>
</head>
<body>  
  <%@include file="cabecalho.jsp" %>
  	<c:if test="${not empty login}">  
  	<ul>
    	<c:choose>
      			<c:when test="${login.perfil.admin}">
        			<li>
          				<a href="ListaUsuarios">Visualizar Usuarios</a>
         			</li>
       			</c:when>
       <c:otherwise>         
         <li>
          <a href="ListaUsuariosServlet">Visualizar Usuarios</a>
         </li>         
       </c:otherwise>      
     </c:choose>
  </ul>
  <c:if test="${login.perfil.professor}">  
    <form id="aluno" action="AlunoServlet" method="post">
      <!-- Se existir aluno na requisição, inclui o id no formulário -->
      <c:if test="${not empty aluno}">
        <input type="hidden" name="idAluno" value="${aluno.id}"/>
        <input type="hidden" name="idNota" value="${aluno.nota.id}"/>
      </c:if>
      <p>
        <label>Nome:</label>
        <br/>      
        <input type="text" name="nome" value="${empty aluno ? param.nome : aluno.nome}"/>
      </p>
      <p>
        <label>RA:</label>
        <br/>
        <input type="text" name="ra" value="${empty aluno ? param.ra : aluno.ra}"/>
      </p>
      <p>
        <label>Nota:</label>
        <br/>
        <input type="text" name="nota" value="${empty aluno ? param.nota : aluno.nota.valor}"/>
      </p>
      <p>
        <input type="submit" value="Salvar"/>
      </p>
    </form>
    </c:if>
</c:if>
</body>
</html>
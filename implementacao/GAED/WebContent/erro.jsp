<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${not empty param.mensagem_erro}">
		<c:set var="erro" scope="page" value="${param.mensagem_erro}"/>
	</c:when>
	<c:when test="${not empty mensagem_erro}">
		<c:set var="erro" scope="page" value="${mensagem_erro}"/>
	</c:when>
</c:choose>

<c:if test="${not empty erro}">
	<div class="col-sm-6">
		<div id="erro" class="alert alert-warning" role="alert">
		<label> Erro:
			${erro}</label>
		</div>
	</div>
</c:if>


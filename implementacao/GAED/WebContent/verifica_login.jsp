<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--  Diretiva Page Import -->
<%@ page import="edu.gaed.modelo.Usuario"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${empty login}">
	<jsp:forward page="login.jsp">
		<jsp:param name="mensagem_erro"
			value="É necessario informar o seu nome antes de começar." />
	</jsp:forward>
</c:if>
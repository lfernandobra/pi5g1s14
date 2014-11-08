<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="edu.gaed.vo.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<link href="./css/main.css" rel="stylesheet" type="text/css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
		<title>Album</title>
	</head>
	<body>
		
		<c:if test="${empty album}">
			<p>Nenhuma foto foi cadastrada!</p>
		</c:if>
		<c:if test="${not empty album}">
			<table>
				<thead>
					<tr>
						<td>Nome</td>
						<td>Descricao</td>
						<td>Imagem</td>
						<td>Editar</td>
						<td>Remover</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="foto" items="${album}">
						<tr>
							<td>${foto.nome}</td>
							<td>
								<c:choose>
									<c:when test="${not empty foto.descricao}">
										<p>${foto.descricao}</p>
									</c:when>
									<c:otherwise>
										N/A
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<img src="${pageContext.request.contextPath}/FotoServlet?foto=${foto.id}"/>
							</td>
							<td>
								<form id="edit_${foto.id}" action="${pageContext.request.contextPath}/EditarFotoServlet" method="post">
									<p>
										<input type="hidden" name="id" value="${foto.id}"/>
										<a href="#" onclick="document.getElementById('edit_${foto.id}').submit();">
											<img src="${pageContext.request.contextPath}/images/ico_edit.png" class="frm_img_edit"/>
										</a>
									</p>
								</form>
							</td>
							<td>
								<form id="remove_${foto.id}" action="${pageContext.request.contextPath}/RemoverFotoServlet" method="post">
									<p>
										<input type="hidden" name="id" value="${foto.id}"/>
										<a href="#" onclick="document.getElementById('remove_${foto.id}').submit();">
											<img src="${pageContext.request.contextPath}/images/ico_remove.png" class="frm_img_remove"/>
										</a>
									</p>
								</form>
							</td>
						</tr>			
					</c:forEach>	
				</tbody>
			</table>	
		</c:if>
	</body>
</html>
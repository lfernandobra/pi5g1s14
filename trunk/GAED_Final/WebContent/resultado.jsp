<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"
    	 import="edu.gaed.vo.Responsavel"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
	<%
		String mensagem = (String) session.getAttribute("mensagem");
		Livro livro = (Livro) session.getAttribute("objLivro");
	%>
	<p><%= mensagem %></p>
	<p>Livro <%= livro.getTitulo() %> (<%= livro.getAutor() %>)</p>
</body>
</html>
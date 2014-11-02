<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="usuario" class="edu.gaed.vo.Usuario"
	scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="usuario" />


<jsp:forward page="/SalvarUsuario" />

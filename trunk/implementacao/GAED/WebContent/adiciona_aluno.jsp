<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:useBean id="aluno" class="edu.gaed.vo.Aluno" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="aluno" />
<jsp:forward page="/SalvarAluno" />

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.gaed.vo.Responsavel"%>

<!--  Diretiva TagLib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Cadastro responsavel</title>
	<script type="text/javascript" src="scripts/script.js"></script>
</head>
<body>
	<form id="responsavel" method="post" action="adiciona_responsavel.jsp" >
		<c:if test="${not empty responsavel}">
			<input type="hidden" name="id" value="${responsavel.id}"/>
		</c:if>
		<fieldset id = "identficacao">
        	<legend>Identificação</legend>
			<p>
			<label id="lbl_login" for="txt_login">Login:</label> 
            <input type="text" id="txt_login" name="login" value="${responsavel.login}" tabindex="1"/>
			</p>
			<p>
			<label id="lbl_senha" for="txt_senha">Senha:</label>  
            <input type="password" id="txt_senha" name="senha" value="${responsavel.senha}" tabindex="2"/>
			</p>
        </fieldset>
        
        
        <fieldset id = "responsavel_dados">
        	<legend>Dados</legend>
			<p>
				<label id="lbl_nome" for="txt_nome">Nome:</label>  
                <input type="text" id="txt_nome" name="nome" value="${responsavel.nome}" tabindex="3"/>
			</p>
			<p>
				<label id="lbl_sobrenome" for="txt_nome">Sobrenome:</label> 
                <input type="text" id="txt_sobrenome" name="sobrenome" value="${responsavel.sobrenome}" tabindex="4"/>
			</p>
			
			<p>
				<label id="lbl_datanascimento" for="txt_data">Data de nascimento:</label>  
                <input type="text" id="txt_datanasc" name="datanasc" 
               	   	   onKeyPress="MascaraData(responsavel.datanasc);"
                	   onBlur="ValidaData(responsavel.datanasc);"
                	   value="${responsavel.datanasc}" tabindex="4"/>
			</p>
			
			<p>
				<label id="lbl_sexo" for="txt_sexo">Sexo:</label>  
                
                <select id="txt_sexo" name="sexo" value="${responsavel.sexo}" tabindex="5">
  					<option value="Feminino">Feminino</option>
  					<option value="Masculino">Masculino</option>
				</select>
			</p>
			<p>
				<label id="lbl_CPF" for="txt_CPF">CPF :</label> 
                <input type="text" id="txt_CPF" name="CPF" value="${responsavel.CPF}" tabindex="13"
                	   maxlength="14"
                	   onKeyPress="MascaraCPF(responsavel.CPF);"
                	   onBlur="ValidarCPF(responsavel.CPF);"
                />
			</p>
			<p>
				<label id="lbl_email" for="txt_email">Email:</label> 
                <input type="text" id="txt_email" name="email" value="${responsavel.email}" tabindex="6"/>
			</p>
			<p>
				<label id="lbl_telefone" for="txt_telefone">Telefone:</label>  
                <input type="text" id="txt_telefone" name="telefone" value="${responsavel.telefone}"
                			onKeyPress="MascaraTelefone(responsavel.telefone);" 
   							maxlength="20" value="${responsavel.telefone}" 
   							tabindex="7"  onBlur="ValidaTelefone(txt_telefone);"/>
			</p>
			<p>               
                <label id="lbl_rua" for="txt_rua">Rua:</label>  
                <input type="text" id="txt_rua" name="rua" value="${responsavel.rua}" tabindex="8"/><p>
                <label id="lbl_numero" for="txt_numero">Numero:</label>  
                <input type="text" id="txt_numero" name="numero" value="${responsavel.numero}" tabindex="9"/><p>
                <label id="lbl_bairro" for="txt_cidade">Bairro:</label>  
                <input type="text" id="txt_bairro" name="bairro" value="${responsavel.bairro}" tabindex="10"/><p>
                <label id="lbl_cidade" for="txt_cidade">Cidade:</label>  
                <input type="text" id="txt_cidade" name="cidade" value="${responsavel.cidade}" tabindex="11"/><p>
                <label id="lbl_estado" for="txt_estado">Estado:</label>  
                <input type="text" id="txt_estado" name="estado" value="${responsavel.estado}" tabindex="12"/><p>
                
                <label id="lbl_CEP" for="txt_endereco">CEP :</label> 
                <input type="text" id="txt_CEP" name="CEP" value="${responsavel.CEP}" tabindex="13"
                	   maxlength="10"
                	   onKeyPress="MascaraCep(responsavel.CEP);"
                	   onBlur="ValidaCep(responsavel.CEP);"
                />
			</p>
			
			</fieldset>
			<fieldset id = "botoes">
				<input type="submit" value="Salvar"></input><input type="reset" value="Resetar"></input>
			</fieldset>
        
	</form>

</body>
</html>
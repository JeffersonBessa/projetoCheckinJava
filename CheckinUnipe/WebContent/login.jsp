<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script> 
function validaLogin(){
	
	if(document.frm.username.value == "") {
		alert ( "Username e password são obrigatórios" ); 
		document.frm.login.focus(); 
		return false; 
	} 
	if (document.frm.password.value == "") {
		alert ( "Username e password são obrigatórios" ); 
		document.frm.senha.focus();  
		return false; 
		
	}
	
	document.frm.target = '';
	document.frm.submit();
	
} 
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckIn Unipe</title>
</head>
<body>

<%
	request.removeAttribute("usuarioLogado");
%>

<form name="frm" action="LoginServlet" method="post" >
	<table align="center">
		<tr>
			<td><h2>CheckIn Unipe</h2></td>
		</tr>
	</table>

	<table align="center">
		<tr>
			<td>Username:</td> 
			<td><input type="text" name="username" /></td>
		</tr>
		<tr>
			<td>Password:</td> 
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" name="btnLogar" value="Entrar" onclick="return validaLogin();" /></td>
		</tr>
		<tr>
			<td><a href="cadastrarUsuario.jsp">Cadastre-se</a><br></td>
		</tr>
	</table>
	
	
</form>
<%
	String msg = (String) request.getAttribute("msg");
	if(msg != null){
%>
	<table align="center">
		<tr>
			<td><h4><%= msg %></h4></td>
		</tr>
	</table>
	
<%		
	}
%>
</body>
</html>
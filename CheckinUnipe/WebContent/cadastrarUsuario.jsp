<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script> 
function validaForm(){
	if(document.frm.nome.value == ""
			|| document.frm.username.value == ""
			|| document.frm.password.value == ""
			|| document.frm.confirmaPassword.value == "") {
		
		alert ( "Todos os campos são obrigatórios" );
		return false; 
	}
	
	if(document.frm.password.value != document.frm.confirmaPassword.value){
		alert ( "Senhas são diferentes" );
		document.frm.password.value = "";
		document.frm.confirmaPassword.value = "";
		document.frm.password.focus(); 
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
<form name="frm" action="CadastroUsuarioServlet" method="post" >

	<table align="center">
		<tr>
			<td><h2>Cadastrar Usuário</h2></td>
		</tr>
	</table>
	<table align="center">
		<tr>
			<td align="center">Nome:</td> 
			<td><input type="text" name="nome" />*</td>
		</tr>
		<tr>
			<td align="center">Username:</td> 
			<td><input type="text" name="username" />*</td>
		</tr>
		<tr>
			<td align="center">Password:</td> 
			<td><input type="password" name="password" />*</td>
		</tr>
		<tr>
			<td align="center">Confirmar password:</td> 
			<td><input type="password" name="confirmaPassword" />*</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" name="btnCadastrar" value="Cadastrar" onclick="return validaForm();" /></td>
		</tr>
	</table>
</form>
</body>
</html>
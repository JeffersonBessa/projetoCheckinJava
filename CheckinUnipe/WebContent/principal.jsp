<%@page import="br.unipe.checkin.model.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CheckIn Unipe</title>
</head>
<body>

<%
	Usuario usuarioLogado= (Usuario) session.getAttribute("usuarioLogado");

	if(usuarioLogado != null){
%>
		<H2 align="center"> <%= usuarioLogado.getNome() %>, Seja bem vindo ao sistema de checkin da Unipe!</H2>
		
	<form name="frm" action="ManterVooServlet" method="post">
		<table align="center">
			<tr>
				<td colspan="2" align="center"> Escolha o assento </td>
			</tr>
			<tr>
				<td>Escolha a sua fileira</td>
				<td>
					<select name="fileira">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Escolha a sua poltrona</td>
				<td>
					<select name="poltrona">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td align="center"><input type="submit" name="btnEscolher" value="Escolher" /></td>
			</tr>
			
		</table>
		
		<table align="right">
			<tr>
				<td>
					<a href="login.jsp">Logout</a>
				</td>
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
	
<%
	}else {
%>
		<H2 align="center"> Acesso Restrito!</H2>
<%
	}
%>

</body>
</html>
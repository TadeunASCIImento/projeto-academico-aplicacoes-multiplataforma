<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="br.com.desaparecidos.entities.Usuario"%>
<%
	Usuario usuario = null;
if (session.getAttribute("usuario") != null) {
	usuario = (Usuario) session.getAttribute("usuario");
} else {
	session.invalidate();
	response.sendRedirect("login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sistema de auxílio na busca por desaparecidos versão
	1.0.0</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>
	<header></header>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="index.jsp">
					HOME </a></li>
			<li class="nav-item active"><a class="nav-link" href="login.jsp">
					ENTRAR </a>
		</ul>
	</nav>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>
	<div class="container">
		<header></header>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"> HOME </a></li>
			</ul>
		</nav>
		<section class="section-cad-usuar">
			<h4 style="text-align: center">Formulário de cadastro de
				usuários</h4>
			<div class="input-group mb-3">
				<form class="form-cad-usuar" method="POST"
					action="ServletController">
					<input id="form-input" class="form-control" type="text" name="nome"
						placeholder="Nome completo"> <input id="form-input"
						class="form-control" type="text" name="email"
						placeholder="Endereço de e-mail"> <input id="form-input"
						class="form-control" type="text" name="cpf"
						placeholder="Número de CPF"> <input id="form-input"
						class="form-control" type="password" name="senha"
						placeholder="Senha de ( 10 ) digítos letras e números"> <input
						type="hidden" name="acao" value="cadastrar"> <input
						id="btn" class="btn btn-secondary" type="submit" value="Cadastrar"
						name="btn-cadastrar">
				</form>
			</div>
		</section>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
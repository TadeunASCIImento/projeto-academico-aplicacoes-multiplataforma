<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<body>
	<div class="container">
		<header></header>
		<section class="section-login">
		<h4>Informe os dados de acesso</h4>
			<form method="POST" action="ServletController" class="form-login">
				<input id="form-input" class="form-control" type="text" name="email"
					placeholder="E-mail"> <input id="form-input"
					class="form-control" type="password" name="senha"
					placeholder="Senha"> <input id="btn"
					class="btn btn-secondary" type="submit" value="Entre"
					name="btn-entrar"> <input type="hidden" name="acao"
					value="entrar"> <a href="formulariocadastrousuario.jsp"><input
					id="btn" class="btn btn-secondary" type="button"
					name="btn-cadastrar" value="Cadastra-se"></a>
			</form>
		</section>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>





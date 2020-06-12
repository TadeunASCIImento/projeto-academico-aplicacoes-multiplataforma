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
				<li class="nav-item active"><a class="nav-link"
					href="login.jsp"> ENTRAR </a>
			</ul>
		</nav>
		<section class="section-index">
			<figure>
				<img id="img-desaparecidos" class="img-thumbnail"
					src="imagens/img_desaparecidos.jpg">
			</figure>
		</section>
		<aside class="aside-index">
			<p>
				Este site tem como objetivo, auxíliar a na busca de pessoas
				desaparecidas.<br> diminuindo o espaço de busca, realizando uma
				consulta em um banco de dados centralizado.<br> Contendo
				informações de registros de pessoas que possam ter dado entrada em
				orgãos públicos de saúde, segurança, além de institutos médico legal
				e serviços funerários.
			</p>
		</aside>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
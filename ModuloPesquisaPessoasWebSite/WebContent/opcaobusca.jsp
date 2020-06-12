<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<%
			if (request.getAttribute("mensagem") != null) {

			String mensagem = (String) request.getAttribute("mensagem");
			switch (mensagem) {
			case "sucesso_login":
		%>
		<section class="busc-nident">
			<figure class="figr-busc">
				<img class="img-busc" src="imagens/img_caract.jpg">
				<p class="prg-fig-busc">
					<b> <a class="lnk-busc"
						href="formulariobuscacaracteristicas.jsp">Buscar usando as
							caracteríticas</a>
					</b>
				</p>
			</figure>
		</section>
		<section class="busc-ident">
			<figure class="figr-busc">
				<img class="img-busc" src="imagens/img_rg.png">
				<p class="prg-fig-busc">
					<b> <a class="lnk-busc" href="formulariobuscaidentificacao.jsp">Buscar
							usando a identificação</a>
					</b>
				</p>
			</figure>
		</section>
		<%
			break;
			case "erro_login":
		%>
		<p>Erro ao autenticar usuário tente novamente.</p>
		<a href="login.jsp"><img alt="Logar novamente"
			src="imagens/icone_voltar.png"></a>
		<%
			break;
				case "erro_cadastro":
		%>
		<p>Erro ao cadastrar usuário tente novamente.</p>
		<a href="login.jsp"><img alt="Logar novamente"
			src="imagens/icone_voltar.png"></a>
		<%
			break;
				}

			} else {

			}
		%>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
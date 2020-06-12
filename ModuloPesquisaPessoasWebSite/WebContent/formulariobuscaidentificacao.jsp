<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>

	<div class="container">

		<%@ include file="header.jsp"%>

		<section class="section-identific">
			<h4>Informe a identificação da pessoa</h4>
			<div class="input-group mb-3">

				<form class="form-identific" method="Get"
					action="ServletController">

					<input id="form-input" class="form-control" type="text"
						name="documento" placeholder="Número do documento">
					<!--  -->
					<input id="form-input" class="form-control" type="text" name="nome"
						placeholder="Nome completo">
					<!--  -->
					<input id="form-input" class="form-control" type="text"
						name="nomepai" placeholder="Filiação( pai )">
					<!--  -->
					<input id="form-input" class="form-control" type="text"
						name="nomemae" placeholder="Filiação ( mãe )">
						<input type="hidden"name="acao" value="buscaridentificacao">
					<!--  -->
					<input class="btn-loc" type="image" name="btn-localizar">

				</form>
			</div>

		</section>

		<%@include file="footer.jsp"%>

	</div>

</body>
</html>
<%@page import="br.com.desaparecidos.utils.ConverterData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="br.com.desaparecidos.entities.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<h3>
			<b>Registros Encontrados</b>
		</h3>

		<%
			if (request.getAttribute("exibir") != null || request.getAttribute("lista") != null) {
			String exibir = (String) request.getAttribute("exibir");
			List<Entitie> listaEntities = (List<Entitie>) request.getAttribute("lista");
			List<Endereco> listaEndereco = new ArrayList<>();
			List<Instituicao> listaInstituicao = new ArrayList<>();
			List<Identificacao> listaIdentificacao = new ArrayList<>();
			List<Caracteristica> listaCaracteristicas = new ArrayList<>();
			if (exibir.equalsIgnoreCase("identificacao")) {
				for (Entitie entitie : listaEntities) {
			if (entitie instanceof Identificacao)
				listaIdentificacao.add((Identificacao) entitie);
			if (entitie instanceof Instituicao)
				listaInstituicao.add((Instituicao) entitie);
			if (entitie instanceof Endereco)
				listaEndereco.add((Endereco) entitie);
				}
				for (int i = 0; i < listaIdentificacao.size(); i++) {
			Integer idIdentificacao = listaIdentificacao.get(i).getIdIdentificacao();
			String data = new ConverterData().converteDataString(listaIdentificacao.get(i).getDataRegistro());
			String documento = listaIdentificacao.get(i).getDocumento();
			String nome = listaIdentificacao.get(i).getNome();
			String nomePai = listaIdentificacao.get(i).getNomePai();
			String nomeMae = listaIdentificacao.get(i).getNomeMae();
			String instituicao = listaInstituicao.get(i).getNome();
			String endereco = listaEndereco.get(i).getLogradouro();
			String cep = listaEndereco.get(i).getCep();
			String telefone = listaInstituicao.get(i).getTelefone();
			String bairro = listaEndereco.get(i).getBairro();
			String cidade = listaEndereco.get(i).getCidade();
			String observacao = listaIdentificacao.get(i).getObservacao();
		%>
		<section class="section-resp">
			<img class="img-foto"
				src="ServletControllerImagem?acao=identificacao&idIdentificacao=<%=idIdentificacao%>">
			<p style="padding: 20px;">
				<b>Código do registro:</b><%=idIdentificacao%><br> <b>Data
					de registro:</b><%=data%><br> <b>Documento de identificação:</b><%=documento%><br>
				<b>Nome Completo:</b><%=nome%><br> <b>Filiação(pai):</b><%=nomePai%><br>
				<b>Filiação(mãe):</b><%=nomeMae%><br> <b>Nome da
					instituição:</b><%=instituicao%><br> <b>Endereço da
					instituição:</b><%=endereco%><br> <b>Cep:</b><%=cep%><br> <b>Telefone
					da instituição:</b><%=telefone%><br> <b>Bairro:</b><%=bairro%><br>
				<b> Cidade:</b><%=cidade%><br> <b>Obervações:</b>
				<%=observacao%>
			</p>
		</section>
		<%
			}
		} else if (exibir.equalsIgnoreCase("caracteristicas")) {
			for (Entitie entitie : listaEntities) {
				if (entitie instanceof Caracteristica)
			listaCaracteristicas.add((Caracteristica) entitie);
				if (entitie instanceof Instituicao)
			listaInstituicao.add((Instituicao) entitie);
				if (entitie instanceof Endereco)
			listaEndereco.add((Endereco) entitie);
			}
			for (int i = 0; i < listaCaracteristicas.size(); i++) {
				Integer idCaracteristica = listaCaracteristicas.get(i).getIdCaracteristica();
				String data = new ConverterData().converteDataString(listaCaracteristicas.get(i).getDataRegistro());
				String instituicao = listaInstituicao.get(i).getNome();
				String endereco = listaEndereco.get(i).getLogradouro();
				String cep = listaEndereco.get(i).getCep();
				String telefone = listaInstituicao.get(i).getTelefone();
				String bairro = listaEndereco.get(i).getBairro();
				String cidade = listaEndereco.get(i).getCidade();
				String observacao = listaCaracteristicas.get(i).getObservacao();
		%>
		<section class="section-resp">
			<img class="img-foto"
				src="ServletControllerImagem?acao=caracteristicas&idCaracteristica=<%=idCaracteristica%>">
			<p style="padding: 20px;">
				<b>Código do registro:</b><%=idCaracteristica%><br> <b>Data
					de registro:</b><%=data%><br> <b>Instituição:</b><%=instituicao%><br>
				<b>Endereço da instituição:</b><%=endereco%><br> <b>Cep:</b><%=cep%><br>
				<b>Telefone da instituição:</b><%=telefone%><br> <b>Bairro:</b><%=bairro%><br>
				<b> Cidade:</b><%=cidade%><br> <b>Obervações:</b>
				<%=observacao%>
			</p>
		</section>
		<%
			}
		}

		} else {

		}
		%>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
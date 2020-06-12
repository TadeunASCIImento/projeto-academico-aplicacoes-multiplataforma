<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel='stylesheet' type='text/css' href="css/estilo.css">
<script src='main.js'></script>
<body>
	<div class="container">
		<%@ include file="header.jsp"%>
		<section class="section-caract">
			<h4>Selecione as características da pessoa</h4>
			<div class="input-group mb-3">
				<form method="GET" action="ServletController">
					<select name="sexo">
						<option selected>Genêro</option>
						<option value="Masculino">Masculino</option>
						<option value="Feminino">Feminino</option>
					</select> <select name="pele">
						<option selected>Cor da pele</option>
						<option value="Amarela">Amarela</option>
						<option value="Branca">Branca</option>
						<option value="Negra">Negra</option>
						<option value="Parda">Parda</option>
						<option value="Vermelha">Vermelha</option>
						<option value="Indefinida">Indefinida</option>
					</select> <select name="olhos">
						<option selected>Cor dos olhos</option>
						<option value="Azuis">Azuis</option>
						<option value="Verdes">Castanhos claros</option>
						<option value="Castanhos escuros">Castanhos escuros</option>
						<option value="Cinzentos">Cinzentos</option>
						<option value="Pretos">Pretos</option>
						<option value="Desiguais">Desiguais</option>
						<option value="Verdes">Verdes</option>
						<option value="Outros">Outros</option>
					</select> <select name="corCabelo">
						<option selected>Cor dos cabelos</option>
						<option value="Castanhos claros">Castanhos claros</option>
						<option value="Castanhos escuros">Castanhos escuros</option>
						<option value="Pretos">Pretos</option>
						<option value="Brancos">Brancos</option>
						<option value="Grisalho total">Grisalho total</option>
						<option value="Grisalho parcial">Grisalho parcial</option>
						<option value="Louros">Louros</option>
						<option value="Ruivos">Ruivos</option>
					</select> <select name="tipoCabelo">
						<option selected>Tipo cabelo</option>
						<option value="Calvície total">Calvície total</option>
						<option value="Calvície parcial">Calvície parcial</option>
						<option value="Carapinha">Carapinha</option>
						<option value="Liso">Liso</option>
						<option value="Encaracolado">Encaracolado</option>
						<option value="Ondulado">Ondulado</option>
						<option value="Carapinha">Carapinha</option>
						<option value="Outro">Outro</option>
					</select><select name="fisico">
						<option selected>Porte fisíco</option>
						<option value="Forte">Forte</option>
						<option value="Magro">Magro</option>
						<option value="Gordo">Gordo</option>
						<option value="Atlético">Atlético</option>
					</select> <select name="altura">
						<option selected>Altura</option>
						<option value="1.20">1,20</option>
						<option value="1.30">1,30</option>
						<option value="1.40">1,40</option>
						<option value="1.50">1,50</option>
						<option value="1.60">1,60</option>
						<option value="1.70">1,70</option>
						<option value="1.80">1,80</option>
						<option value="1.90">1,90</option>
						<option value="2.00">2,00</option>
						<option value="2.10">2,10</option>
						<option value="2.20">2,20</option>
					</select> <select name="barba">
						<option selected>Barba</option>
						<option value="Sem barba">Sem barba</option>
						<option value="Não se aplica">Não se aplica</option>
						<option value="Barba cheia">Barba cheia</option>
						<option value="Bigode">Bigode</option>
						<option value="Barba por fazer">Barba por fazer</option>
						<option value="Cavanhaque">Cavanhaque</option>
					</select> <select name="tatuagens">
						<option selected>Tatuagens</option>
						<option value="Sem tatuagens">Sem tatuagens</option>
						<option value="Abdômen">Abdômen</option>
						<option value="Cabeça">Cabeça</option>
						<option value="Pescoço">Pescoço</option>
						<option value="Costas">Costas</option>
						<option value="Perna direita">Perna direita</option>
						<option value="Perna esquerda">Perna direita</option>
						<option value="Braço direito">Braço direito</option>
						<option value="Braço esquerdo">Braço esquerdo</option>
						<option value="Dedos mão direita">Dedos mão direita</option>
						<option value="Dedos mão esquerda">Dedos mão esquerda</option>
						<option value="Mão direita">Mão direita</option>
						<option value="Mão esquerda">Mão esquerda</option>
						<option value="Pé direito">Pé direito</option>
						<option value="Pé esquerdo">Pé esquerdo</option>
					</select> <select name="cicatrizes">
						<option selected>Cicatrizes</option>
						<option value="Sem cicatrizes">Sem cicatrizes</option>
						<option value="Abdômen">Abdômen</option>
						<option value="Cabeça">Cabeça</option>
						<option value="Pescoço">Pescoço</option>
						<option value="Costas">Costas</option>
						<option value="Perna direita">Perna direita</option>
						<option value="Perna esquerda">Perna direita</option>
						<option value="Braço direito">Braço direito</option>
						<option value="Braço esquerdo">Braço esquerdo</option>
						<option value="Dedos mão direita">Dedos mão direita</option>
						<option value="Dedos mão esquerda">Dedos mão esquerda</option>
						<option value="Mão direita">Mão direita</option>
						<option value="Mão esquerda">Mão esquerda</option>
						<option value="Pé direito">Pé direito</option>
						<option value="Pé esquerdo">Pé esquerdo</option>
					</select> <select name="deficiencias">
						<option selected>Deficiências</option>
						<option value="Sem deficiência">Sem deficiências</option>
						<option value="Abdômen">Abdômen</option>
						<option value="Cabeça">Cabeça</option>
						<option value="Pescoço">Pescoço</option>
						<option value="Costas">Costas</option>
						<option value="Perna direita">Perna direita</option>
						<option value="Perna esquerda">Perna direita</option>
						<option value="Braço direito">Braço direito</option>
						<option value="Braço esquerdo">Braço esquerdo</option>
						<option value="Dedos mão direita">Dedos mão direita</option>
						<option value="Dedos mão esquerda">Dedos mão esquerda</option>
						<option value="Mão direita">Mão direita</option>
						<option value="Mão esquerda">Mão esquerda</option>
						<option value="Pé direito">Pé direito</option>
						<option value="Pé esquerdo">Pé esquerdo</option>
					</select> <select name="idade">
						<option selected>Idade aproxímada</option>
						<option value="5">05 anos</option>
						<option value="10">10 anos</option>
						<option value="15">15 anos</option>
						<option value="20">20 anos</option>
						<option value="25">25 anos</option>
						<option value="30">30 anos</option>
						<option value="35">35 anos</option>
						<option value="40">40 anos</option>
						<option value="45">45 anos</option>
						<option value="50">50 anos</option>
						<option value="55">55 anos</option>
						<option value="60">60 anos</option>
						<option value="65">65 anos</option>
						<option value="70">70 anos</option>
						<option value="75">75 anos</option>
						<option value="80">80 anos</option>
						<option value="85">85 anos</option>
						<option value="90">90 anos</option>
						<option value="95">95 anos</option>
					</select> <input type="hidden" name="acao" value="buscarcaracteristicas">
					<input class="btn-loc" type="image" name="btn-localizar">
				</form>
			</div>
		</section>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
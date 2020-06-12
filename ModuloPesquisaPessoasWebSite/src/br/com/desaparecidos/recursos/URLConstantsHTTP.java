package br.com.desaparecidos.recursos;

public interface URLConstantsHTTP {

	final String HOST = "http://localhost:8080/WebServiceRestJerseyDesaparecidos/rest";

	final String URL_VALIDAR_USUARIO = HOST.concat("/usuario/validar");

	final String URL_CADASTRAR_USUARIO = HOST.concat("/usuario/cadastrar");

	final String URL_BUSCAR_IDENTIFICACAO = HOST.concat("/identificacao/buscar");

	final String URL_FOTO_IDENTIFICACAO = HOST.concat("/identificacao/foto");

	final String URL_BUSCAR_CARACTERISTICAS = HOST.concat("/caracteristica/buscar");

	final String URL_FOTO_CARACTERISTICA = HOST.concat("/caracteristica/foto");

	final String URL_BUSCAR_ENDERECO = HOST.concat("/endereco/buscar");

	final String URL_BUSCAR_INSTITUICAO = HOST.concat("/instituicao/buscar");
}

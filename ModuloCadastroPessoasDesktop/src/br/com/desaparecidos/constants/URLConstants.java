package br.com.desaparecidos.constants;

public interface URLConstants {

	final String HOST = "http://localhost:8080/WebServiceRestJerseyDesaparecidos/rest";
		
	final String URL_VALIDAR_USUARIO = HOST.concat("/usuario/validar");
	
	final String URL_CADASTRAR_IDENTIFICACAO = HOST.concat("/identificacao/cadastrar");
	
	final String URL_CADASTRAR_CARACTERISTICAS = HOST.concat("/caracteristica/cadastrar");

}

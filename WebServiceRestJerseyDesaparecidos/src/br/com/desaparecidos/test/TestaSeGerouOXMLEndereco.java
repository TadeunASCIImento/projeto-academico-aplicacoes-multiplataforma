package br.com.desaparecidos.test;

import javax.xml.bind.JAXB;

import br.com.desaparecidos.entities.Endereco;

public class TestaSeGerouOXMLEndereco {

	public static void main(String[] args) {

		Endereco endereco = new Endereco();
		endereco.setCep("1329000");
		endereco.setLogradouro("Rua, dos Ingleses, 258");
		endereco.setBairro("Bela Vista");
		endereco.setCidade("São Paulo");
		endereco.setIdEndereco(1);
		JAXB.marshal(endereco, System.out);

	}

}

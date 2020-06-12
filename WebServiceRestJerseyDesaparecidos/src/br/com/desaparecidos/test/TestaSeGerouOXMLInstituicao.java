package br.com.desaparecidos.test;

import javax.xml.bind.JAXB;

import org.junit.jupiter.api.Test;

import br.com.desaparecidos.entities.Instituicao;

public class TestaSeGerouOXMLInstituicao {

	@Test
	void test() {

		Instituicao instituicao = new Instituicao();
		instituicao.setIdEnderecofk(26);
		instituicao.setIdInstituicao(26);
		instituicao.setNomeInstituicao("Hospital Municipal Infantil Menino Jesus");
		instituicao.setTelefone("3253-5200");
		JAXB.marshal(instituicao, System.out);
		
	  

	}

}

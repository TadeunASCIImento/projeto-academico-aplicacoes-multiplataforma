package br.com.desaparecidos.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoIdentificacao;

class TestaBuscarImagemBase64 {

	@Test
	void test() {

		Assert.assertNotNull(new DaoIdentificacao().findImage(3));

	}

}

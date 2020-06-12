package br.com.desaparecidos.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoConnection;

class TestaSeAConexaoComObanco extends DaoConnection {

	@Test
	void test() {
		Assert.assertTrue(conectarComOBanco());
	}

	boolean conectarComOBanco() {
		this.conn = this.obterConexao();
		if (this.conn != null)
			return true;
		else
			return false;
	}

}

package br.com.desaparecidos.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoUsuario;
import br.com.desaparecidos.entities.Usuario;

class TestaSeOUsuarioEvalido {

	@Test
	void testaSeOretornoDoUsuarioNaoEnulo() {
		Usuario usuario = new Usuario(1, null, null, "tadeunascimento@gmail.com", "destroyer");
		Usuario usu = new DaoUsuario().validate(usuario);
		Assert.assertNotNull(usu);

	}

}

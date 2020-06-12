package br.com.desaparecidos.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoIdentificacao;
import br.com.desaparecidos.entities.Identificacao;

public class TestaListarIdentificacao {

	@Test
	void testaBuscaPorIdentificacaoNoBanco() {

		Identificacao identificacao = new Identificacao();
		identificacao.setDocumento("32471527846");
		identificacao.setNome("Tadeu do Nascimento");
		identificacao.setNomePai("Edilson do Nascimento");
		identificacao.setNomeMae("Adelice Francisca de Oliveira");
		List<Identificacao> listaIdentificacao = new ArrayList<>();
		listaIdentificacao = (List<Identificacao>) (List<?>) new DaoIdentificacao().findAll(identificacao);
		Assert.assertNotNull(listaIdentificacao);
	}

}

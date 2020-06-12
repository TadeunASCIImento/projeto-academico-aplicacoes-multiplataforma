package br.com.desaparecidos.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoCaracteristica;
import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Entitie;

class TestaSeAListaDeCaracteristicasRetornouOsValores {

	@Test
	void test() {

		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setSexo("Masculino");
		caracteristica.setAltura(1.80);
		caracteristica.setBarba("Barba por fazer");
		caracteristica.setCicatrizes("Sem cicatrizes");
		caracteristica.setCorCabelo("Castanhos escuros");
		caracteristica.setDeficiencia("Sem deficiência");
		caracteristica.setFisico("Magro");
		caracteristica.setIdade(35);
		caracteristica.setOlhos("Castanhos escuros");
		caracteristica.setTatuagens("Sem tatuagens");
		caracteristica.setPele("Parda");
		caracteristica.setTipoCabelo("Carapinha");
		List<Entitie> listaEntitie = new ArrayList<Entitie>();
		listaEntitie = new DaoCaracteristica().findAll(caracteristica);

		Assert.assertTrue(listaEntitie.isEmpty());

	}

}

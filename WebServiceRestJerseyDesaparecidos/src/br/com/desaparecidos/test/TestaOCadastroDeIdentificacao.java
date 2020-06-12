package br.com.desaparecidos.test;

import java.io.File;

import javax.swing.JFileChooser;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.desaparecidos.daos.DaoIdentificacao;
import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.utils.ConversoraImagem;

class TestaOCadastroDeIdentificacao {

	@Test
	void test() {

		Identificacao identificacao = new Identificacao();
		identificacao.setDocumento("32471527850");
		identificacao.setNome("Tadeu do Nascimento");
		identificacao.setNomePai("Edilson do Nascimento");
		identificacao.setNomeMae("Adelice Francisca de Oliveira");
		identificacao.setIdInstituicaofk(26);

		StringBuffer buffer = new StringBuffer();
		buffer.append("Localizado na rua Amador Bueno da Veiga,");
		buffer.append("próximo a Universidade Nove de Julho");
		buffer.append("O mesmo estava babando no canto da boca depois,");
		buffer.append("após a aula de Data Science");
		identificacao.setObservacao(buffer.toString());

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		ConversoraImagem conversoraImagem = new ConversoraImagem();
		byte[] foto = conversoraImagem.convertImageToByte(file.getAbsolutePath());
		String base64 = conversoraImagem.convertByteArrayToBase64String(foto);
		identificacao.setFotoBase64(base64);
		Assert.assertTrue(new DaoIdentificacao().add(identificacao));
	}

}

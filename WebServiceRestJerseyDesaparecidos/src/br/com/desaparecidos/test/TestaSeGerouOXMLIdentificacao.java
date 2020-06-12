package br.com.desaparecidos.test;

import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXB;

import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.entities.Usuario;
import br.com.desaparecidos.utils.ConversoraImagem;

public class TestaSeGerouOXMLIdentificacao {

	public static void main(String[] args) {

		Usuario usuario = new Usuario();
		usuario.setCpf("32471527845");
		usuario.setNome("Tadeu do Nascimento");
		usuario.setEmail("tadeunascimento@gmail.com");
		usuario.setSenha("destroyer");
		JAXB.marshal(usuario, System.out);
		System.out.println("\n\n");

		Identificacao identificacao = new Identificacao();
		identificacao.setDocumento("32471527853");
		identificacao.setNome("Tadeu do Nascimento");
		identificacao.setNomePai("Edilson do Nascimento");
		identificacao.setNomeMae("Adelice Francisca de Oliveira");
		identificacao.setIdIdentificacao(3);
		identificacao.setIdInstituicaofk(26);

		StringBuffer buffer = new StringBuffer();
		buffer.append("Localizado na rua Amador Bueno da Veiga,");
		buffer.append(" próximo a Universidade Nove de Julho.\n");
		buffer.append("O mesmo estava babando no canto da boca depois, ");
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
		
		JAXB.marshal(identificacao, System.out);
		
	

	}
	
	

}

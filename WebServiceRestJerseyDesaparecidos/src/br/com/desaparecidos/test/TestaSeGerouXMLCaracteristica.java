package br.com.desaparecidos.test;

import java.io.File;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXB;

import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.utils.ConversoraImagem;

public class TestaSeGerouXMLCaracteristica {

	public static void main(String[] args) {

		Caracteristica caracteristica = new Caracteristica();
		caracteristica.setIdCaracteristica(1);
		caracteristica.setSexo("Masculino");
		caracteristica.setAltura(1.17);
		caracteristica.setBarba("Barba por fazer");
		caracteristica.setCicatrizes("Sem cicatrizes");
		caracteristica.setCorCabelo("Castanhos escuros");
		caracteristica.setDeficiencia("Sem deficiência");
		caracteristica.setFisico("Magro");
		caracteristica.setIdade(35);
		caracteristica.setIdInstituicaofk(26);
		caracteristica.setOlhos("Castanhos escuros");
		caracteristica.setTatuagens("Sem tatuagens");
		caracteristica.setPele("Parda");
		caracteristica.setTipoCabelo("Carapinha");

		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.showOpenDialog(null);
		File file = chooser.getSelectedFile();
		ConversoraImagem conversoraImagem = new ConversoraImagem();
		byte[] foto = conversoraImagem.convertImageToByte(file.getAbsolutePath());
		String base64 = conversoraImagem.convertByteArrayToBase64String(foto);
		caracteristica.setFotoBase64(base64);

		JAXB.marshal(caracteristica, System.out);

	}

}

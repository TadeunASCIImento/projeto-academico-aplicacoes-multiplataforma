package br.com.desaparecidos.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Conversor {

	public byte[] convertImageToByte(String caminho) {
		Path path = FileSystems.getDefault().getPath(caminho);
		byte[] imagem = null;
		try {
			imagem = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagem;
	}

	
	
	public byte[] convertBase64StringToByteArray(String imagem) {
		byte[] retorno = null;

		try {
			BASE64Decoder decoder = new BASE64Decoder();
			retorno = decoder.decodeBuffer(imagem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retorno;

	}

	public String convertByteArrayToBase64String(byte[] imagem) {

		String retorno = "";

		try {
			BASE64Encoder encoder = new BASE64Encoder();
			retorno = encoder.encode(imagem);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return retorno;
	}

}

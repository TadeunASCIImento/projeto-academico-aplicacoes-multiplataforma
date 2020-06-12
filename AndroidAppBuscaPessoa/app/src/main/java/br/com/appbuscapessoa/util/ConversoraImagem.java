package br.com.appbuscapessoa.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class ConversoraImagem {


	public byte[] convertBase64StringToByteArray(String base64) {
		byte[] retorno = null;
		try {
			retorno = Base64.decode(base64, Base64.DEFAULT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}



	public Bitmap toBitmap(byte[] imagem){

		Bitmap decode =
				BitmapFactory.decodeByteArray (imagem,0,imagem.length);
       return decode;
	}



}

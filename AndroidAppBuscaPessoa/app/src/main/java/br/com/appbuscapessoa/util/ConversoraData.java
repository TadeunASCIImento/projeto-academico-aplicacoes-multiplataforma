package br.com.appbuscapessoa.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversoraData {

	public Date converteStringData(String stringData) {
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date data = new Date(formato.parse(stringData).getTime());
			return data;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public String inverteData(Date data) {
		if (!data.equals(null)) {
			int dia, mes, ano;
			String stringData;
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			dia = calendario.get(Calendar.DAY_OF_MONTH);
			mes = calendario.get(Calendar.MONTH);
			ano = calendario.get(Calendar.YEAR);
			stringData = ano + "-" + mes + "-" + dia;
			return stringData;
		} else
			return "null";
	}

	public String converteDataString(Date data) {
		String stringData;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		try {
			stringData = formato.format(data);
			return stringData;
		} catch (Exception e) {
			e.printStackTrace();
			return "null";
		}
	}

	public int dataDia(Date data) {
		if (!data.equals(null)) {
			int dia;
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			dia = calendario.get(Calendar.DAY_OF_MONTH) + 1;
			return dia;
		} else
			return 0;
	}

	public int dataMes(Date data) {
		if (!data.equals(null)) {
			int mes;
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			mes = calendario.get(Calendar.MONTH) + 2;
			return mes;
		} else
			return 0;
	}

	public int dataAno(Date data) {
		if (!data.equals(null)) {
			int ano;
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			ano = calendario.get(Calendar.YEAR);
			return ano;
		} else
			return 0;
	}

	public String[] getDataFormat(Date date) {
		ConversoraData conversao = new ConversoraData();
		String dia = String.valueOf(conversao.dataDia(date));
		String mes = String.valueOf(conversao.dataMes(date));
		String ano = String.valueOf(conversao.dataAno(date));
		String[] data = { dia, mes, ano };
		return data;
	}

	public String setDataFormat(String strdata) {
		ConversoraData conversoraData = new ConversoraData();
		Date data;
		String sdata = "";
		try {
			data = conversoraData.converteStringData(strdata);
			if (!(data.equals(null)))
				sdata = conversoraData.inverteData(data);
			else
				sdata = "null";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdata;
	}
}

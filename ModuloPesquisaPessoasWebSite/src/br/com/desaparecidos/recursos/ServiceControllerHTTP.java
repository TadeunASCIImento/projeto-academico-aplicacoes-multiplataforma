package br.com.desaparecidos.recursos;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Endereco;
import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.entities.Instituicao;
import br.com.desaparecidos.utils.XmlConversor;

public class ServiceControllerHTTP implements URLConstantsHTTP {

	public String sendPOST(String url, String xml) throws MinhaException {
		try {
			HttpURLConnection request = (HttpURLConnection) new URL(url).openConnection();
			try {
				request.setDoOutput(true);
				request.setDoInput(true);
				request.setRequestProperty("Content-Type", "application/xml");
				request.setRequestMethod("POST");
				request.connect();
				try (OutputStream outputStream = request.getOutputStream()) {
					outputStream.write(xml.getBytes("UTF-8"));
				}

				return readResponse(request);
			} finally {
				request.disconnect();
			}
		} catch (IOException ex) {
			throw new MinhaException(ex);
		}
	}

	private String readResponse(HttpURLConnection request) throws IOException {
		ByteArrayOutputStream os;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "cp1252"))) {
			os = new ByteArrayOutputStream();
			int b;
			while ((b = br.read()) != -1) {
				os.write(b);
			}
		}
		return new String(os.toByteArray());
	}

	public static class MinhaException extends Exception {
		private static final long serialVersionUID = 3172087335197611109L;

		public MinhaException(Throwable cause) {
			super(cause);
		}
	}

	public LinkedList<Entitie> localizarRegistros(List<Entitie> listaEntitie) {

		List<Endereco> listaEnderecos = new ArrayList<>();
		List<Instituicao> listaInstituicoes = new ArrayList<>();
		List<Identificacao> listaIdentificacoes = new ArrayList<>();
		List<Caracteristica> listaCaracaterisitcas = new ArrayList<>();
		
		LinkedList<Entitie> linkedListEntitie = new LinkedList<Entitie>();
		
		Instituicao instituicao = new Instituicao();
		
		for (Entitie entities : listaEntitie) {
			
			if (entities instanceof Identificacao) {
				listaIdentificacoes.add((Identificacao) entities);
				instituicao.setIdInstituicao(((Identificacao) entities).getIdInstituicaofk());
			
			} else if (entities instanceof Caracteristica) {
				listaCaracaterisitcas.add((Caracteristica) entities);
				instituicao.setIdInstituicao(((Caracteristica) entities).getIdInstituicaofk());
			}

			String idInstituicaoXml = new XmlConversor().toXML(instituicao);
			try {
				String respostaInstituicao = new ServiceControllerHTTP().sendPOST(URL_BUSCAR_INSTITUICAO,
						idInstituicaoXml);
				instituicao = new XmlConversor().xmlToObject(Instituicao.class, respostaInstituicao);
			} catch (MinhaException e) {
				e.printStackTrace();
			}
			listaInstituicoes.add(instituicao);
		}

		for (Instituicao instituicoes : listaInstituicoes) {
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(instituicoes.getIdEnderecofk());
			String enderecoXml = new XmlConversor().toXML(endereco);
			try {
				String xmlRespostaEndereco = new ServiceControllerHTTP().sendPOST(URL_BUSCAR_ENDERECO, enderecoXml);
				endereco = new XmlConversor().xmlToObject(Endereco.class, xmlRespostaEndereco);
			} catch (MinhaException e) {
				e.printStackTrace();
			}
			listaEnderecos.add(endereco);
		}

		linkedListEntitie.addAll(listaIdentificacoes);
		linkedListEntitie.addAll(listaCaracaterisitcas);
		linkedListEntitie.addAll(listaEnderecos);
		linkedListEntitie.addAll(listaInstituicoes);

		return linkedListEntitie;
	}
}

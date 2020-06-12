package br.com.controllers;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.recursos.ServiceControllerHTTP;
import br.com.desaparecidos.recursos.ServiceControllerHTTP.MinhaException;
import br.com.desaparecidos.recursos.URLConstantsHTTP;
import br.com.desaparecidos.utils.Conversor;
import br.com.desaparecidos.utils.XmlConversor;

@WebServlet("/ServletControllerImagem")
public class ServletControllerImagem extends HttpServlet implements URLConstantsHTTP {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		byte[] imagem = null;
		if (acao.equalsIgnoreCase("identificacao")) {
			Integer idIdentificacao = Integer.parseInt(request.getParameter("idIdentificacao"));
			Identificacao identificacao = new Identificacao();
			identificacao.setIdIdentificacao(idIdentificacao);
			String idIdentificacaoXml = new XmlConversor().toXML(identificacao);
			try {
				String respostaBase64 = new ServiceControllerHTTP().sendPOST(URL_FOTO_IDENTIFICACAO,
						idIdentificacaoXml);
				Conversor conversor = new Conversor();
				imagem = conversor.convertBase64StringToByteArray(respostaBase64);
			} catch (MinhaException e) {
				e.printStackTrace();
			}
		} else if (acao.equalsIgnoreCase("caracteristicas")) {
			Integer idCaracteristica = Integer.parseInt(request.getParameter("idCaracteristica"));
			Caracteristica caracteristica = new Caracteristica();
			caracteristica.setIdCaracteristica(idCaracteristica);
			String idCaracteristicaXml = new XmlConversor().toXML(caracteristica);
			try {
				String respostaBase64 = new ServiceControllerHTTP().sendPOST(URL_FOTO_CARACTERISTICA,
						idCaracteristicaXml);
				Conversor conversor = new Conversor();
				imagem = conversor.convertBase64StringToByteArray(respostaBase64);
			} catch (MinhaException e) {
				e.printStackTrace();
			}
		}
		response.setContentType("image/jpeg");
		OutputStream output = response.getOutputStream();
		output.write(imagem);
		output.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

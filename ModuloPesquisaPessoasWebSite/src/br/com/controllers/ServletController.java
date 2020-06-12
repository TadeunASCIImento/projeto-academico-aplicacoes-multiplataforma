package br.com.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.desaparecidos.entities.Caracteristica;
import br.com.desaparecidos.entities.Caracteristicas;
import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Identificacao;
import br.com.desaparecidos.entities.Identificacoes;
import br.com.desaparecidos.entities.Usuario;
import br.com.desaparecidos.recursos.ServiceControllerHTTP;
import br.com.desaparecidos.recursos.ServiceControllerHTTP.MinhaException;
import br.com.desaparecidos.recursos.URLConstantsHTTP;
import br.com.desaparecidos.utils.XmlConversor;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet implements URLConstantsHTTP {
	private static final long serialVersionUID = -399343535263063118L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");
		if (acao.equalsIgnoreCase("buscaridentificacao")) {
			String documento = request.getParameter("documento");
			String nome = request.getParameter("nome");
			String nomePai = request.getParameter("nomepai");
			String nomeMae = request.getParameter("nomemae");
			Identificacao identificacao = new Identificacao();
			identificacao.setDocumento(documento);
			identificacao.setNome(nome);
			identificacao.setNomePai(nomePai);
			identificacao.setNomeMae(nomeMae);
			List<Entitie> listaIdentificacoes = new ArrayList<>();
			try {
				Identificacoes identificacoes = new Identificacoes();
				String identificacaoXml = new XmlConversor().toXML(identificacao);
				String resposta = new ServiceControllerHTTP().sendPOST(URL_BUSCAR_IDENTIFICACAO, identificacaoXml);
				identificacoes = new XmlConversor().xmlToObject(Identificacoes.class, resposta);
				listaIdentificacoes.addAll(identificacoes.getIdentificacoes());
			} catch (MinhaException e) {
				e.printStackTrace();
			}
			LinkedList<Entitie> lista = new ServiceControllerHTTP().localizarRegistros(listaIdentificacoes);
			request.setAttribute("lista", lista);
			request.setAttribute("exibir", "identificacao");
			RequestDispatcher dispatcher = request.getRequestDispatcher("respostabusca.jsp");
			dispatcher.forward(request, response);
		} else if (acao.equalsIgnoreCase("buscarcaracteristicas")) {
			String sexo = request.getParameter("sexo");
			String pele = request.getParameter("pele");
			String olhos = request.getParameter("olhos");
			String corCabelo = request.getParameter("corCabelo");
			String tipoCabelo = request.getParameter("tipoCabelo");
			String fisico = request.getParameter("fisico");
			Double altura = Double.parseDouble(request.getParameter("altura"));
			String barba = request.getParameter("barba");
			String tatuagens = request.getParameter("tatuagens");
			String cicatrizes = request.getParameter("cicatrizes");
			String deficiencias = request.getParameter("deficiencias");
			Integer idade = Integer.parseInt(request.getParameter("idade"));
			Caracteristica caracteristica = new Caracteristica();
			caracteristica.setSexo(sexo);
			caracteristica.setPele(pele);
			caracteristica.setOlhos(olhos);
			caracteristica.setCorCabelo(corCabelo);
			caracteristica.setTipoCabelo(tipoCabelo);
			caracteristica.setFisico(fisico);
			caracteristica.setAltura(altura);
			caracteristica.setBarba(barba);
			caracteristica.setTatuagens(tatuagens);
			caracteristica.setCicatrizes(cicatrizes);
			caracteristica.setDeficiencia(deficiencias);
			caracteristica.setIdade(idade);
			List<Entitie> listaCaracteristicas = new ArrayList<>();
			try {
				Caracteristicas caracteristicas = new Caracteristicas();
				String caracteristicaXml = new XmlConversor().toXML(caracteristica);
				String resposta = new ServiceControllerHTTP().sendPOST(URL_BUSCAR_CARACTERISTICAS, caracteristicaXml);
				caracteristicas = new XmlConversor().xmlToObject(Caracteristicas.class, resposta);
				listaCaracteristicas.addAll(caracteristicas.getCaracteristicas());
			} catch (MinhaException e) {
				e.printStackTrace();
			}
			LinkedList<Entitie> lista = new ServiceControllerHTTP().localizarRegistros(listaCaracteristicas);
			request.setAttribute("lista", lista);
			request.setAttribute("exibir", "caracteristicas");
			RequestDispatcher dispatcher = request.getRequestDispatcher("respostabusca.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if (acao.equalsIgnoreCase("entrar")) {
			Usuario usuario = new Usuario();
			String usuarioXml = null;
			String resposta = null;
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			if (email.equalsIgnoreCase("") | senha.equalsIgnoreCase("")) {
				request.setAttribute("mensagem", "erro_login");
			} else {
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuarioXml = new XmlConversor().toXML(usuario);
				try {
					resposta = new ServiceControllerHTTP().sendPOST(URL_VALIDAR_USUARIO, usuarioXml);
					usuario = new XmlConversor().xmlToObject(Usuario.class, resposta);
				} catch (MinhaException e) {
					e.printStackTrace();
				}
				HttpSession session = request.getSession();
				if (resposta.contains(email) && resposta.contains(senha)) {
					session.setAttribute("usuario", usuario);
					request.setAttribute("mensagem", "sucesso_login");
					request.getRequestDispatcher("opcaobusca.jsp").forward(request, response);
				} else {
					request.setAttribute("mensagem", "erro_login");
					session.invalidate();
				}
			}
		} else if (acao.equalsIgnoreCase("cadastrar")) {
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setCpf(cpf);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			try {
				String usuarioXml = new XmlConversor().toXML(usuario);
				String respostaUsuario = new ServiceControllerHTTP().sendPOST(URL_CADASTRAR_USUARIO, usuarioXml);
				if (respostaUsuario.equals("true"))
					request.setAttribute("mensagem", "sucesso_cadastro");
				else
					request.setAttribute("mensagem", "erro_cadastro");
			} catch (MinhaException e) {
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/opcaobusca.jsp").forward(request, response);
	}
}

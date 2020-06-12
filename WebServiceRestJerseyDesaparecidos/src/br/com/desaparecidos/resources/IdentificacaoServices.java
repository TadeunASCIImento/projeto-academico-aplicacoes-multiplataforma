	package br.com.desaparecidos.resources;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.desaparecidos.daos.DaoIdentificacao;
import br.com.desaparecidos.entities.Entitie;
import br.com.desaparecidos.entities.Identificacao;

@Path("/identificacao")
public class IdentificacaoServices {

	@POST
	@Path(value = "/buscar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Identificacao> listarIdentificadas(//
			@PathParam("identificacao") Identificacao identificacao) {
		List<Identificacao> listaIdentificacao = new ArrayList<>();
		List<Entitie> listaEntitie = new DaoIdentificacao().findAll(identificacao);
		for (Entitie entitie : listaEntitie) {
			if (entitie instanceof Identificacao)
				listaIdentificacao.add((Identificacao) entitie);
		}
		return listaIdentificacao;
	}

	@POST
	@Path(value = "/cadastrar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String cadastrarIdentificada(//
			@PathParam("identificacao") Identificacao identificacao) {
		if (new DaoIdentificacao().add(identificacao))
			return "true";
		else
			return "false";
	}

	@POST
	@Path(value = "/foto")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String buscarImagemIdentificada(//
			@PathParam("identificacao") Identificacao identificacao) {
		String strBase64 = new DaoIdentificacao().findImage(//
				identificacao.getIdIdentificacao());
		return strBase64;

	}

}

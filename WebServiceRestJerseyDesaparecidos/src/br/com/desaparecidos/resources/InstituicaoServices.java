package br.com.desaparecidos.resources;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.desaparecidos.daos.DaoInstituicao;
import br.com.desaparecidos.entities.Instituicao;

@Path("/instituicao")
public class InstituicaoServices {

	@POST
	@Path(value = "/buscar")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Instituicao localizarInstituicao(//
			@PathParam("idInstiuticao") Instituicao idInstituicao) {
		return (Instituicao) new DaoInstituicao().findOne(idInstituicao);

	}

}

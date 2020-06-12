package br.com.desaparecidos.resources;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.desaparecidos.daos.DaoEndereco;
import br.com.desaparecidos.entities.Endereco;

@Path("/endereco")
public class EnderecoServices {

	@POST
	@Path("/buscar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Endereco localizarEndereco(//
			@PathParam("idInsituicao") Endereco idEnderecofk) {
		return (Endereco) new DaoEndereco().findOne(idEnderecofk);
	}

}

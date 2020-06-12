package br.com.desaparecidos.resources;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.desaparecidos.daos.DaoCaracteristica;
import br.com.desaparecidos.entities.Caracteristica;

@Path("/caracteristica")
public class CaracterisiticaServices {

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public String cadastrarPessoaNaoIdentificada(//
			@PathParam("caracteristica") Caracteristica caracteristica) {
		if (new DaoCaracteristica().add(caracteristica))
			return "true";
		else
			return "false";
	}

	@POST
	@Path("/buscar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public List<Caracteristica> buscarPessoaNaoIdentificada(
			@PathParam("caracteristica") Caracteristica caracteristica) {
		List<Caracteristica> lstCaracteristicas = (List<Caracteristica>)(List<?>)
				new DaoCaracteristica().findAll(caracteristica);
		return lstCaracteristicas;
	}

	@POST
	@Path(value = "/foto")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String buscarFotoPessoaNaoIdentificada(//
			@PathParam("idICaracteristicas") Caracteristica caracteristica) {
		String strBase64 = new DaoCaracteristica().findImage(caracteristica.getIdCaracteristica());
		return strBase64;
	}

}

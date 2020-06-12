package br.com.desaparecidos.resources;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.desaparecidos.daos.DaoUsuario;
import br.com.desaparecidos.entities.Usuario;

@Path("/usuario")
public class UsuarioServices {

	@POST
	@Path(value = "/validar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Usuario validarUsuario(
			@PathParam("usuario") Usuario usuario) {
		return new DaoUsuario().validate(usuario);
	}

	@POST
	@Path(value = "/cadastrar")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String cadastrarUsuario(
			@PathParam("usuario") Usuario usuario) {
		if (new DaoUsuario().add(usuario))
			return "true";
		else
			return "false";

	}
	

}

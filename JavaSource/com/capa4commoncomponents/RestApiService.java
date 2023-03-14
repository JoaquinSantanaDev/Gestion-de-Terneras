package com.capa4commoncomponents;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.capa1entities.Ternera;
import com.capa1entities.Usuario;
import com.capa2businesslogic.GestionTerneraService;
import com.capa2businesslogic.GestionUsuariosService;
import com.bean.*;
@Path("usuarios")
public class RestApiService {
	
	@EJB
	GestionUsuariosService gestionUsuarioService;
	
	@GET
	@Path("obtenerUsuario/{id}")
	@Produces("application/json")
	public Usuario obtenerUsuario(@PathParam("id") Long id){
		try {
			 Usuario usuario = gestionUsuarioService.buscarUsuario(id);
			 if (usuario==null) {
				 return new Usuario();
			 }
			 return usuario;
		}catch(Exception e) {
			e.printStackTrace();
			return new Usuario(); 
		}
	}
	@GET
	@Path("listarUsuarios")
	@Produces("application/json")
	public List<Usuario> listarUsuarios(){
		try {
			 List<Usuario> listaUsuarios = gestionUsuarioService.seleccionarUsuarios();
			 return listaUsuarios;
		}catch(Exception e) {
			e.printStackTrace();
			return  new ArrayList<Usuario>(); 
		}
		
	}
	
	
	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response iniciarsesion(@FormParam("user") String user,@FormParam("pass") String pass){
		try {
			Usuario usu = gestionUsuarioService.validarUsuario(user, pass);			
			 return Response.ok().entity(usu).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}
		
	}
	
}
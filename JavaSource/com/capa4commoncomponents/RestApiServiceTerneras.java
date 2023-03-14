package com.capa4commoncomponents;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
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

import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

@Path("terneras")
public class RestApiServiceTerneras {
	
	@EJB
	GestionTerneraService gestionTerneraService;
	
	@POST
	@Path("crearTernera")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearTernera(Ternera ternera) {
		try {

			System.out.println("Padre: "+ternera.getId_padre());
			System.out.println("Madre: "+ternera.getId_madre());
						
			
			  //Timestamp ts = new Timestamp(ternera.getFecha_nto().getTime());
	          //ternera.setFecha_nto(ts);
			
			gestionTerneraService.crearTernera(ternera);	
			
			return Response.ok().entity(ternera).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}
		
	}
	
	

	@GET
	@Path("listarTernera")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ternera> listarTerneras(){
		try {
			 List<Ternera> listaTerneras = gestionTerneraService.listarTernera(0);
			 return listaTerneras;
		}catch(Exception e) {
			e.printStackTrace();
			return  new ArrayList<Ternera>(); 
		}
		
	}	
	
	public String body(List<InputPart> listInputPart) {
		String body = new String();
		for (InputPart i : listInputPart){
			try {
				body = i.getBodyAsString();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return body;
	}
}

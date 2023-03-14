package com.capa4commoncomponents;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
@Path("hola")
public class RestApiTern {
	
		@Produces("text/plain") //como voy a retornar texto plano pongo esta anotacion.
		//Si no pongo nada retorna html
	    @GET
	    @Path("saludar/{nombre}")
	    public String saludar(@PathParam("nombre") String nombre){
			return "Hola "+nombre;
	    }
		
	    @GET
	    @Path("saludar")
	    public String saludar(){
    		return "HOLA";
	    }
}





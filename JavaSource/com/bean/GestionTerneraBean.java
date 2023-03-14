package com.bean;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.capa1entities.Ternera;
import com.capa1entities.Usuario;
import com.capa2businesslogic.GestionTerneraService;
import com.capa3persistence.exceptions.PersistenceException;
import com.capa4commoncomponents.ExceptionTools;

@Named("gestionTerneraBean")
@SessionScoped
public class GestionTerneraBean implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionTerneraService gestionTerneraService;
	
	private List<Ternera> terneraList;
	private Ternera terneraSelecc;
	private Integer id;
	private String modalidad;
	private Boolean modoEdicion;
	
	@PostConstruct
	public void init() {
		id			  = 0;
		terneraSelecc = new Ternera();
	}
	
	
	public String crearTernera() {
    	try {
    		System.out.println("Id_Ternera"+terneraSelecc.getId_ternera());
    		System.out.println("Caravama"+terneraSelecc.getCaravana_snig());
    		if(terneraSelecc.getCaravana_snig() == null ||  terneraSelecc.getCaravana_snig() == "0" ||  terneraSelecc.getCaravana_snig() == "") {
    			FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Debe ingresar una caravana para la ternera.",""));
    		}else {

			gestionTerneraService.crearTernera(terneraSelecc);
			seleccionarTerneras();
    		}
    		
		} catch (PersistenceException e) {
			
			//FacesContext.getCurrentInstance().addMessage(null, 
			//		new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(),""));
			
				Throwable rootException=ExceptionTools.getCause(e);
				String msg1=e.getMessage();
				String msg2=ExceptionTools.formatedMsg(e.getCause());
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		} catch (EJBTransactionRolledbackException e ) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		
    	return "";
	}
	
	public String borrarTernera(Ternera ternera) {
		try {
			gestionTerneraService.borrarTerneraSeleccionada(ternera);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado la Ternera.",""));
			seleccionarTerneras();
		} catch (PersistenceException e) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);

		}
		
		return "";
	}
	
	public String modificarTernera() {
		
		try {
			gestionTerneraService.modificTernera(terneraSelecc);
		} catch (PersistenceException e) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		return"";
	}

	
	public Ternera cargarDatosTernera(Ternera ternera) {
		terneraSelecc.setId_ternera(ternera.getId_ternera());
		terneraSelecc.setCaravana_snig(ternera.getCaravana_snig());
		terneraSelecc.setId_guachera(ternera.getId_guachera());
		terneraSelecc.setId_padre(ternera.getId_padre());
		terneraSelecc.setId_madre(ternera.getId_madre());
		terneraSelecc.setFecha_nto(ternera.getFecha_nto());
		terneraSelecc.setPeso_al_nacer(ternera.getPeso_al_nacer());
		terneraSelecc.setRaza(ternera.getRaza());
		terneraSelecc.setTipo_de_parto(ternera.getTipo_de_parto());
		terneraSelecc.setEstado(ternera.getEstado());
		return terneraSelecc;
		
	}
	
	public Ternera limpiarDatosTernera() {
		System.out.println("Prueba1");
		
		terneraSelecc.setId_ternera(0);
		terneraSelecc.setCaravana_snig("");
		terneraSelecc.setId_guachera(0);
		terneraSelecc.setId_padre(0);
		terneraSelecc.setId_madre(0);
		terneraSelecc.setFecha_nto(null);
		terneraSelecc.setPeso_al_nacer(0);
		terneraSelecc.setRaza("");
		terneraSelecc.setTipo_de_parto("");
		terneraSelecc.setEstado(0);
		return terneraSelecc;
		
		
		
	}
	
	public List<Ternera> seleccionarTerneras() throws PersistenceException {
		int idAux = Integer.parseInt(id.toString());
		System.out.println("En el bean"+ id);
		terneraList = gestionTerneraService.listarTernera(idAux);
		return terneraList;
	}
	
	public List<String> getRazaList() throws PersistenceException {
		List<Ternera> terneraListAux = gestionTerneraService.listarTernera(0);
		List<String> listaRazas = new LinkedList();
		for(Ternera ternera : terneraListAux) {
			listaRazas.add(ternera.getRaza());
		}
		
		List<String> listaRazasAux = listaRazas.stream().distinct().collect(Collectors.toList());		
		return listaRazasAux;
	}
	
	public List<Ternera> getTerneraList() throws PersistenceException {
		List<Ternera> terneraList = gestionTerneraService.listarTernera(id);
		
		
		return terneraList;
	}

	public void setTerneraList(List<Ternera> terneraList) {
		this.terneraList = terneraList;
	}
	
	public void cargarDatos(Ternera m) {
		this.terneraSelecc = m;
	}

	public Ternera getTerneraSelecc() {
		return terneraSelecc;
	}
	public void setTerneraSelecc(Ternera terneraSelecc) {
		this.terneraSelecc = terneraSelecc;
	}
	public Integer getId() {
		if(id==null) {
			id = 0;
		}
		return id;
	}
	public void setId(Integer id) {
		if(id==null) {
			id = 0;
		}
		this.id = id;
	}
	
	
	

}

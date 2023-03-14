package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.capa1entities.AlimTernera;
import com.capa1entities.Alimento;
import com.capa1entities.Ternera;
import com.capa2businesslogic.GestionAlimTerneraService;
import com.capa3persistence.exceptions.PersistenceException;
import com.capa4commoncomponents.ExceptionTools;

/**
 * Session Bean implementation class GestionAlimTerneraBean
 */
@Named("gestionAlimTerneraBean")
@SessionScoped
public class GestionAlimTerneraBean implements Serializable {

    /**
	 *
	 */		
	private static final long serialVersionUID = 1L;

	@EJB
	GestionAlimTerneraService gestionAimTerneraService;
	
	private Ternera terneraSelecc;
	private List<AlimTernera> alimTerneraList;
	private AlimTernera alimTerneraSelecc;
	private Integer id;
	private String caravanaSnig;
	
	@PostConstruct
	public void init() {
		alimTerneraSelecc = new AlimTernera();
		terneraSelecc 	  = new Ternera();
		
		if (alimTerneraSelecc.getCaravana_ternera() != null){
			caravanaSnig = alimTerneraSelecc.getCaravana_ternera();
		}
	}
	
	public String crearAlimTernera() {
    	try {
    		System.out.println(alimTerneraSelecc.getId_alim_ternera());
    		gestionAimTerneraService.crearAlimTernera(alimTerneraSelecc);;
			
		} catch (PersistenceException e) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
    	return "";
    }
	
	public String borrarTernera() {
		try {
			gestionAimTerneraService.borrarAlimTerneraSeleccionada(alimTerneraSelecc);;
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado el alimento a al ternera.",""));
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
			gestionAimTerneraService.modificAlimTernera(alimTerneraSelecc);;
		} catch (PersistenceException e) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
		
		return"";
	}


	public AlimTernera obtengoTernera(Ternera ternera) {
		alimTerneraSelecc.setCaravana_ternera(ternera.getCaravana_snig());
		System.out.println(ternera.getCaravana_snig());
		System.out.println("ALimentSelecc" + alimTerneraSelecc.getCaravana_ternera());
		return alimTerneraSelecc;
			
	}
		
	public GestionAlimTerneraService getGestionAimTerneraService() {
		return gestionAimTerneraService;
	}

	public void setGestionAimTerneraService(GestionAlimTerneraService gestionAimTerneraService) {
		this.gestionAimTerneraService = gestionAimTerneraService;
	}

	public List<AlimTernera> getAlimTerneraList() {
		return alimTerneraList;
	}

	public void setAlimTerneraList(List<AlimTernera> alimTerneraList) {
		this.alimTerneraList = alimTerneraList;
	}

	public AlimTernera getAlimTerneraSelecc() {
		return alimTerneraSelecc;
	}

	public void setAlimTerneraSelecc(AlimTernera alimTerneraSelecc) {
		this.alimTerneraSelecc = alimTerneraSelecc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}

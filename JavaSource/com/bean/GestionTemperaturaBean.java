package com.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

import com.capa1entities.AlimTernera;
import com.capa1entities.Temperatura;
import com.capa1entities.Ternera;
import com.capa2businesslogic.GestionTemperaturaService;
import com.capa3persistence.exceptions.PersistenceException;
import com.capa4commoncomponents.ExceptionTools;

/**
 * Session Bean implementation class GestionTemperaturaBean
 */
@Named("gestionTemperaturaBean")
@SessionScoped
public class GestionTemperaturaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionTemperaturaService gestTempServ;
	
	private Temperatura tempSelecc;
	private Ternera terneraSelecc;
	private String caravanaSnig;
    /**
     * Default constructor. 
     */
    public GestionTemperaturaBean() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
	public void init() {
    	tempSelecc 			= new Temperatura();
		terneraSelecc 	  	= new Ternera();
		
		if (tempSelecc.getCaravana() != null){
			caravanaSnig = tempSelecc.getCaravana();
		}
	}
    
    public String tomarTemperatura() {
    	try {
    		System.out.println(tempSelecc.getCaravana());
    		gestTempServ.crearTemperatura(tempSelecc);;
			
		} catch (PersistenceException e) {
			Throwable rootException=ExceptionTools.getCause(e);
			String msg1=e.getMessage();
			String msg2=ExceptionTools.formatedMsg(e.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}catch (ConstraintViolationException ce) {
			Throwable rootException=ExceptionTools.getCause(ce);
			String msg1=ce.getMessage();
			String msg2=ExceptionTools.formatedMsg(ce.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}catch (Exception ex) {
			Throwable rootException=ExceptionTools.getCause(ex);
			String msg1=ex.getMessage();
			String msg2=ExceptionTools.formatedMsg(ex.getCause());
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		}
    	return "";
    }

    public Temperatura obtengoTernera(Ternera ternera) {
    	tempSelecc.setCaravana(ternera.getCaravana_snig());
		System.out.println(ternera.getCaravana_snig());
		System.out.println("ALimentSelecc" + tempSelecc.getCaravana());
		return tempSelecc;
			
	}
    
	public GestionTemperaturaService getGestTempServ() {
		return gestTempServ;
	}

	public void setGestTempServ(GestionTemperaturaService gestTempServ) {
		this.gestTempServ = gestTempServ;
	}

	public Temperatura getTempSelecc() {
		return tempSelecc;
	}

	public void setTempSelecc(Temperatura tempSelecc) {
		this.tempSelecc = tempSelecc;
	}

	public Ternera getTerneraSelecc() {
		return terneraSelecc;
	}

	public void setTerneraSelecc(Ternera terneraSelecc) {
		this.terneraSelecc = terneraSelecc;
	}

	public String getCaravanaSnig() {
		return caravanaSnig;
	}

	public void setCaravanaSnig(String caravanaSnig) {
		this.caravanaSnig = caravanaSnig;
	}
	
    
    
}

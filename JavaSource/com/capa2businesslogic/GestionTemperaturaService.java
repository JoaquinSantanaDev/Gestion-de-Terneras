package com.capa2businesslogic;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.capa1entities.Temperatura;
import com.capa1entities.Ternera;
import com.capa3persistence.dao.TemperaturaDAO;
import com.capa3persistence.entities.TemperaturaEntity;
import com.capa3persistence.exceptions.PersistenceException;

/**
 * Session Bean implementation class GestionTemperaturaService
 */
@Stateless
@LocalBean
public class GestionTemperaturaService {
	
	
	@EJB
	TemperaturaDAO tempDAO;
	
    /**
     * Default constructor. 
     */
    public GestionTemperaturaService() {
        // TODO Auto-generated constructor stub
    }
    
    public Temperatura fromTemperaturaEnt(TemperaturaEntity te) {
    	Temperatura temp = new Temperatura();
    	temp.setCaravana(te.getCaravana());
    	temp.setTemp(te.getTemp());
    	temp.setFecha(te.getFecha());
    	temp.setUsuario(te.getUsuario());
    	
    	return temp;
    }
    
    public TemperaturaEntity toTemperaturaEnt(Temperatura te) {
    	TemperaturaEntity temp = new TemperaturaEntity();
    	temp.setCaravana(te.getCaravana());
    	temp.setTemp(te.getTemp());
    	temp.setFecha(te.getFecha());
    	temp.setUsuario(te.getUsuario());
    	
    	return temp;
    }

    
public void crearTemperatura(Temperatura temp) throws PersistenceException {
    	
	try {
		tempDAO.altaAlimTernera(toTemperaturaEnt(temp));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	
    }
}

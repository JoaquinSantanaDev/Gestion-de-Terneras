package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.capa1entities.AlimTernera;
import com.capa1entities.Alimento;
import com.capa1entities.Ternera;
import com.capa2businesslogic.GestionAlimentoService;

/**
 * Session Bean implementation class GestionAlimentoBean
 */
@Named("gestionAlimtoBean")
@SessionScoped
public class GestionAlimentoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionAlimentoService gestionAlimentoService;
	
	private Alimento alimentoSelecc;

	
	@PostConstruct
	public void init() {
		alimentoSelecc = new Alimento();

	}
    /**
     * Default constructor. 
     */
    public GestionAlimentoBean() {
        // TODO Auto-generated constructor stub
    }
    
    
    public List<Alimento> obtenerAlimento() {
    	List<Alimento> alimento = gestionAlimentoService.listarAlimentos();
    	return alimento;
    	
    }
}

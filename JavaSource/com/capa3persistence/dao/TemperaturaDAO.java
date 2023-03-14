package com.capa3persistence.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capa3persistence.entities.AlimTerneraEntity;
import com.capa3persistence.entities.TemperaturaEntity;
import com.capa3persistence.exceptions.PersistenceException;

/**
 * Session Bean implementation class TemperaturaDAO
 */
@Stateless
@LocalBean
public class TemperaturaDAO {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public TemperaturaDAO() {
        // TODO Auto-generated constructor stub
    }

    
    public void altaAlimTernera(TemperaturaEntity temperatura) throws Exception {
		try {
			em.persist(temperatura);
			em.flush();
			
		} catch (Exception e) {
			throw new Exception(
					"Error al alimentar la ternera => " + e.getMessage());
			
		}
	}
    
}

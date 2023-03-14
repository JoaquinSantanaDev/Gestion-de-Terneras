package com.capa3persistence.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.capa3persistence.entities.AlimTerneraEntity;
import com.capa3persistence.entities.AlimentoEntity;
import com.capa3persistence.entities.TerneraEntity;

/**
 * Session Bean implementation class AlimentoDAO
 */
@Stateless
@LocalBean
public class AlimentoDAO {
	
	
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public AlimentoDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public List<AlimentoEntity> mostrarAlimentos(){
    	
    	String query = "Select a from AlimentoEntity a";
    	try {
    		List<AlimentoEntity> alimentoEntity = (List<AlimentoEntity>) em.createQuery(query,AlimentoEntity.class)
				 .getResultList();
    		return  alimentoEntity;
    		

		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
		}
	}
    
    
    public AlimentoEntity seleccionarAlimento(AlimentoEntity alimento) throws PersistenceException {
			try {
				AlimentoEntity alimentoEncontrado = em.find(AlimentoEntity.class, alimento.getId_alimento());
				return alimentoEncontrado;	
			}catch(PersistenceException e) {
				throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}
	
 }


package com.capa3persistence.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.capa3persistence.entities.AlimTerneraEntity;

/**
 * Session Bean implementation class AlimTerneraDAO
 */
@Stateless
@LocalBean
public class AlimTerneraDAO {
	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AlimTerneraDAO() {
        // TODO Auto-generated constructor stub
    }
    
    
    public void altaAlimTernera(AlimTerneraEntity alimTernera) throws Exception {
		try {
			em.persist(alimTernera);
			em.flush();
			
		} catch (Exception e) {
			throw new Exception(
					"Error al alimentar la ternera => " + e.getMessage());
			
		}
	}
    
    
    public void modificarAlimTernera(AlimTerneraEntity alimTernera) throws Exception {
		try {
			em.merge(alimTernera);
			em.flush();
			
		} catch (Exception e) {
			throw new Exception(
					"Error al modificar la alimentacion para la ternera => " + e.getMessage());
			
		}
	}
    
    public boolean bajaAlimTernera(AlimTerneraEntity alimTernera) throws PersistenceException {
		
    	AlimTerneraEntity alimTerneraEntity = em.find(AlimTerneraEntity.class,alimTernera.getId_alim_ternera());
    	
		if (alimTerneraEntity==null) {
			throw new PersistenceException("No existe el usuario a borrar. Id=" + alimTernera.getId_alim_ternera());
		}
		try {
			em.remove(alimTernera);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("Error al Eliminar la alimentacion => " + e.getMessage());
			return false;
		}
	}
    
    public List<AlimTerneraEntity> seleccionarAlimTernera(int id_alimento,
			int costo_alim, Date fecha_alim) throws PersistenceException {
		try {
			
			String query= 	"Select a from ALIM_TERNERA a";
			String queryCriterio="";
			if (id_alimento != 0) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(a.id_alimento) like '%"+id_alimento+"%' ";
			} 
			if (costo_alim != 0) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(a.costo_alim) like '%"+costo_alim+"%' ";
			} 
			if (fecha_alim != null) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(a.fecha_alim) like '%"+fecha_alim+"%' ";
			} 
			
			List<AlimTerneraEntity> resultList = (List<AlimTerneraEntity>) em.createQuery(query,AlimTerneraEntity.class)
								 .getResultList();
				return  resultList;
			}catch(PersistenceException e) {
				throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}


}

package com.capa3persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.capa1entities.Ternera;
import com.capa3persistence.entities.TerneraEntity;
import com.capa3persistence.entities.UsuarioEmpresa;

@Stateless
@LocalBean
public class TerneraDAO {

	@PersistenceContext
	EntityManager em;
	
	//Se crean las distintas terneras
	public TerneraEntity crearTernera(TerneraEntity ternera) throws PersistenceException {
		
		
		System.out.println("Padre: "+ternera.getId_padre());
		System.out.println("Padre: "+ternera.getId_madre());
		
		TerneraEntity terneraPadre = em.find(TerneraEntity.class, ternera.getId_padre());

		TerneraEntity terneraMadre = em.find(TerneraEntity.class, ternera.getId_madre());

		if(terneraPadre==null) {
			throw new PersistenceException("El id madre no corresponde a ninguna ternera.");
		}
		
		if(terneraMadre==null) {
			throw new PersistenceException("El id padre no corresponde a ninguna ternera.");
		}
		
		ternera.setEstado(1);
		
		try {	
			TerneraEntity terneraEntity = em.merge(ternera);
			em.flush();
			return ternera;
		} catch (PersistenceException e) {
			throw new PersistenceException("No se pudo agregar la ternera." + e.getMessage(), e);
		}
		finally {
			
		}
	}
	
	//Baja logica de la ternera
   public TerneraEntity bajaTernera(TerneraEntity ternera) {
	   TerneraEntity terneraSelec = em.find(TerneraEntity.class, ternera.getId_ternera());
		if (terneraSelec == null) {
			throw new PersistenceException("No existe la ternera a borrar. Id=" + ternera.getId_ternera());
		}
		try {
			ternera.setEstado(0);
			terneraSelec = em.merge(ternera);
			em.flush();		
			return terneraSelec;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo borrar la ternera. Id=" + ternera.getId_ternera());
		}
	}
   //Alta de una ternera ya dada de baja
   public TerneraEntity restaurarTernera(TerneraEntity ternera) {
	   TerneraEntity terneraSelec = em.find(TerneraEntity.class, ternera.getId_ternera());
		if (terneraSelec == null) {
			throw new PersistenceException("No existe la ternera a restaurar. Id=" + ternera.getId_ternera());
		}
		try {
			ternera.setEstado(1);
			terneraSelec = em.merge(ternera);
			em.flush();
			return terneraSelec;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo restaurar la ternera. Id=" + ternera.getId_ternera());
		}
	}

	public TerneraEntity modificarTernera(TerneraEntity ternera) {
		try {	
			TerneraEntity terneraEntity = em.merge(ternera);
			em.flush();
			return ternera;
		} catch (PersistenceException e) {
			throw new PersistenceException("No se pudo modificar la ternera." + e.getMessage(), e);
		}
		
	}

	public List<TerneraEntity> seleccionarTernera(String caravana_snig) throws PersistenceException {
		try {
			
			String query= 	"Select e from Terneras e";
			String queryCriterio="";
			if (caravana_snig !=null && ! caravana_snig.contentEquals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(e.caravana_snig) like '%"+caravana_snig.toLowerCase() +"%' ";
			} 

			List<TerneraEntity> resultList = (List<TerneraEntity>) em.createQuery(query,TerneraEntity.class).getResultList();
				return  resultList;
			}catch(PersistenceException e) {
				throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}
	
	
	public List<TerneraEntity> buscarTerneras(int id) throws PersistenceException {
		try {
			String query= 	"Select t from TerneraEntity t";
			String queryCriterio="";
			
			if(id != 0) {
				queryCriterio+=" lower(t.id_ternera) like '%"+id+"%' ";
			}
			
			System.out.println(id);
			System.out.println(queryCriterio);
			
			if (queryCriterio != "" ) {
				query+=" where "+queryCriterio;
			}
			
			System.out.println(query);
			
			List<TerneraEntity> resultList = (List<TerneraEntity>) em.createQuery(query,TerneraEntity.class)
			.getResultList();
			return  resultList;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
		}
		
	}
	
}

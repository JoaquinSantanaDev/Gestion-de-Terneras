package com.capa3persistence.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.capa3persistence.entities.MedicamentosEntity;


@Stateless
@LocalBean
public class MedicamentoDAO{

	@PersistenceContext
	private EntityManager em;

	public MedicamentoDAO() {
	}

	public void altaMedicamento(MedicamentosEntity medicamento) throws Exception {
		try {
			em.persist(medicamento);
			em.flush();
			//Usuario.getIdMedicamento();
			
		} catch (Exception e) {
			throw new Exception(
					"Error al Crear Medicamento => " + e.getMessage());
			
		}
	}

	public boolean bajaMedicamento(MedicamentosEntity medicamento) throws PersistenceException {
		
		MedicamentosEntity medicamentoEntity = em.find(MedicamentosEntity.class,medicamento.getId_medicamento());
		if (medicamentoEntity==null) {
			throw new PersistenceException("No existe el usuario a borrar. Id=" + medicamento.getId_medicamento());
		}
		try {
			em.remove(medicamento);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("Error al Eliminar Medicamento => " + e.getMessage());
			return false;
		}
	}


	public boolean modificarMedicamento(MedicamentosEntity medicamento) {
		try {
			em.merge(medicamento);
			em.flush();
			return true;
		} catch (Exception e) {
			System.out.println("Error al Modificar Medicamento => " + e.getMessage());
			return false;
		}

	}

	public List<MedicamentosEntity> listarTodos() {
		try {
			return em.createQuery("SELECT e FROM Medicamento e").getResultList();
		} catch (Exception e) {
			System.out.println("Error al listarTodos Medicamentos => " + e.getMessage());
			return new ArrayList<MedicamentosEntity>();
		}
	}


	public List<MedicamentosEntity> seleccionarMedicamento(String producto,
			String marca, Integer dosis, Integer costo) throws PersistenceException {
		try {
			
			String query= 	"Select m from Medicamento m";
			String queryCriterio="";
			if (producto !=null && ! producto.contentEquals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(m.producto) like '%"+producto.toLowerCase() +"%' ";
			} 
			if (marca!=null && ! marca.equals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" m.marca='"+marca+"'  " ;
			}
			
			
			if (!queryCriterio.contentEquals("")) {
				query+=" where "+queryCriterio;
			}
			List<MedicamentosEntity> resultList = (List<MedicamentosEntity>) em.createQuery(query,MedicamentosEntity.class)
								 .getResultList();
				return  resultList;
			}catch(PersistenceException e) {
				throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}




}

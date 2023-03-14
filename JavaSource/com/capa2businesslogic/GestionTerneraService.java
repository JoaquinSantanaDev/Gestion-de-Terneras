package com.capa2businesslogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.capa1entities.Ternera;
import com.capa1entities.Usuario;
import com.capa3persistence.dao.TerneraDAO;
import com.capa3persistence.entities.TerneraEntity;
import com.capa3persistence.entities.UsuarioEmpresa;
import com.capa3persistence.exceptions.PersistenceException;

/**
 * Session Bean implementation class GestionTerneraService
 */
@Stateless
@LocalBean
public class GestionTerneraService {
	
	@EJB
	TerneraDAO terneraDAO;
	
    /**
     * Default constructor. 
     */
    public GestionTerneraService() {
        // TODO Auto-generated constructor stub
    }

	public Ternera fromTerneraEntity(TerneraEntity te) {
		Ternera ternera =new Ternera ();
		ternera.setId_ternera(te.getId_ternera());
		ternera.setCaravana_snig(te.getCaravana_snig());
		ternera.setId_guachera(te.getId_guachera());
		ternera.setId_padre(te.getId_padre());
		ternera.setId_madre(te.getId_madre());
		ternera.setFecha_nto(te.getFecha_nto());
		ternera.setPeso_al_nacer(te.getPeso_al_nacer());
		ternera.setRaza(te.getRaza());
		ternera.setTipo_de_parto(te.getTipo_de_parto());
		ternera.setEstado(te.getEstado());
		return ternera ;
	}
	
	public TerneraEntity toTerneraEntity(Ternera u) {
		TerneraEntity urneraEntity=new TerneraEntity();
		urneraEntity.setId_ternera(u.getId_ternera()!=null?u.getId_ternera():null);
		urneraEntity.setCaravana_snig(u.getCaravana_snig());
		urneraEntity.setId_guachera(u.getId_guachera());
		urneraEntity.setId_padre(u.getId_padre());
		urneraEntity.setId_madre(u.getId_madre());
		urneraEntity.setFecha_nto(u.getFecha_nto());
		urneraEntity.setPeso_al_nacer(u.getPeso_al_nacer());
		urneraEntity.setRaza(u.getRaza());
		urneraEntity.setTipo_de_parto(u.getTipo_de_parto());
		urneraEntity.setEstado(u.getEstado());
		return urneraEntity;
	}
	
	
    public void crearTernera(Ternera tern) throws PersistenceException {
    	
    	terneraDAO.crearTernera(toTerneraEntity(tern));
    	
    }
    
   
    
    public void modificTernera(Ternera tern) throws PersistenceException {

    	terneraDAO.modificarTernera(toTerneraEntity(tern));
    	
    }
    
	public void borrarTerneraSeleccionada(Ternera terneraSeleccionado) throws PersistenceException {
		System.out.println("b");
		TerneraEntity t = terneraDAO.bajaTernera(toTerneraEntity(terneraSeleccionado));
		terneraDAO.bajaTernera(t);
	}
    
	public Ternera buscarTernera(Integer id) throws PersistenceException{
		
		Ternera ternera = new Ternera();
		
		List<TerneraEntity> ue = terneraDAO.buscarTerneras(id);
		
		for (TerneraEntity terneraEntity : ue) {
			if (ternera.getId_ternera()==id) {
					ternera = fromTerneraEntity(terneraEntity);
		}
		
		}
		
		return ternera;
	}
	
    public List<Ternera> listarTernera(int id) throws PersistenceException {
    	List<TerneraEntity> listaTerneraEntity = terneraDAO.buscarTerneras(id);
    	System.out.println("En el Servicio"+id);
    	List<Ternera> listaTerneras=new ArrayList<Ternera>();

		for (TerneraEntity terneraEntity : listaTerneraEntity) {
			if(terneraEntity.getEstado()==1) {
				listaTerneras.add(fromTerneraEntity(terneraEntity));
			}
		}
		return listaTerneras;
    }
    
 
    
    
}

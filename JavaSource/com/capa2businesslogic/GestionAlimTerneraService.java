package com.capa2businesslogic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.capa1entities.AlimTernera;
import com.capa1entities.Ternera;
import com.capa1entities.Usuario;
import com.capa3persistence.dao.AlimTerneraDAO;
import com.capa3persistence.entities.AlimTerneraEntity;
import com.capa3persistence.entities.TerneraEntity;
import com.capa3persistence.entities.UsuarioEmpresa;
import com.capa3persistence.exceptions.PersistenceException;

/**
 * Session Bean implementation class GestionAlimTerneraService
 */
@Stateless
@LocalBean
public class GestionAlimTerneraService {

	@EJB
	AlimTerneraDAO alimTerneraDAO;
    /**
     * Default constructor. 
     */
    public GestionAlimTerneraService() {
        // TODO Auto-generated constructor stub
    }

    	
    
    public AlimTernera fromAlimTerneraEntity(AlimTerneraEntity ue) {
		AlimTernera alimTernera=new AlimTernera();
		alimTernera.setId_alim_ternera(ue.getId_alim_ternera());
		alimTernera.setCantidad(ue.getCantidad());
		alimTernera.setCaravana_ternera(ue.getCaravana_ternera());
		alimTernera.setId_alimento(ue.getId_alimento());
		alimTernera.setFecha_alim(ue.getFecha_alim());;
		alimTernera.setUsuario(ue.getUsuario());
		alimTernera.setCantidad(ue.getCantidad());
		return alimTernera;
	}
    
    
	public AlimTerneraEntity toAlimTernera(AlimTernera u) {
		AlimTerneraEntity alimTerneraEntity=new AlimTerneraEntity();
		alimTerneraEntity.setId_alim_ternera(u.getId_alim_ternera());
		alimTerneraEntity.setCantidad(u.getCantidad());
		alimTerneraEntity.setCaravana_ternera(u.getCaravana_ternera());
		alimTerneraEntity.setId_alimento(u.getId_alimento());
		alimTerneraEntity.setFecha_alim(u.getFecha_alim());;
		alimTerneraEntity.setUsuario(u.getUsuario());
		alimTerneraEntity.setCantidad(u.getCantidad());
		return alimTerneraEntity;
	}
	
	
	
	
	 public void crearAlimTernera(AlimTernera alimTernera) throws PersistenceException {

		 try {
			alimTerneraDAO.altaAlimTernera(toAlimTernera(alimTernera));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
	    }
	    
	   
	    
	    public void modificAlimTernera(AlimTernera alimTernera) throws PersistenceException {
	    	System.out.println('b');
	    	try {
				alimTerneraDAO.modificarAlimTernera(toAlimTernera(alimTernera));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
		public void borrarAlimTerneraSeleccionada(AlimTernera alimTernera) throws PersistenceException {
			System.out.println('b');
			alimTerneraDAO.bajaAlimTernera(toAlimTernera(alimTernera));
		}
	    
	    public List<AlimTernera> listarAlimTernera() throws PersistenceException {
	    	List<AlimTerneraEntity> listaAlimTerneraEntity = alimTerneraDAO.seleccionarAlimTernera(0, 0, null);
	    	
	    	List<AlimTernera> listaAlimTernera=new ArrayList<AlimTernera>();

	    	for (AlimTerneraEntity terneraEntity : listaAlimTerneraEntity) {
	    		listaAlimTernera.add(fromAlimTerneraEntity(terneraEntity));
			}
			return listaAlimTernera;
	    }
	    
}

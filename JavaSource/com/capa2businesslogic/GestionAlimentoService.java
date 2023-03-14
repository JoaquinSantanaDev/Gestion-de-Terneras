package com.capa2businesslogic;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.capa1entities.Alimento;
import com.capa3persistence.dao.AlimentoDAO;
import com.capa3persistence.entities.AlimentoEntity;

/**
 * Session Bean implementation class GestionAlimentoService
 */
@Stateless
@LocalBean
public class GestionAlimentoService {
	
	@EJB
	AlimentoDAO alimentoDAO;
	
    /**
     * Default constructor. 
     */
    public GestionAlimentoService() {
        // TODO Auto-generated constructor stub
    }

    public Alimento fromAlimentoEntity(AlimentoEntity ue) {
    	Alimento alimento=new Alimento();
    	alimento.setId_alimento(ue.getId_alimento());
    	alimento.setNombre(ue.getNombre());
    	alimento.setCosto(ue.getCosto());
    	alimento.setCantidad(ue.getCantidad());
    	alimento.setEstado(ue.getEstado());
    	alimento.setMarca(ue.getMarca());
    	return alimento;
    }


    public AlimentoEntity toAlimentoEntity(Alimento u) {
    	AlimentoEntity alimentoEntity=new AlimentoEntity();
    	alimentoEntity.setId_alimento(u.getId_alimento());
    	alimentoEntity.setNombre(u.getNombre());
    	alimentoEntity.setCosto(u.getCosto());
    	alimentoEntity.setCantidad(u.getCantidad());
    	alimentoEntity.setEstado(u.getEstado());
    	alimentoEntity.setMarca(u.getMarca());
    	return alimentoEntity;
    }
    
    
    public List<Alimento> listarAlimentos(){
    	
    	List<Alimento> alimentos = new ArrayList<Alimento>();
    	List<AlimentoEntity> listAlim  = alimentoDAO.mostrarAlimentos();
    	
    	for(AlimentoEntity lstAlimEnt : listAlim) {
    		alimentos.add(fromAlimentoEntity(lstAlimEnt));
    	}
    	return alimentos;
    	
    }
    
    public Alimento obtenerAlimento(Alimento alimento) {
    	
    	AlimentoEntity alimentoSelecc = alimentoDAO.seleccionarAlimento(toAlimentoEntity(alimento));
    	Alimento alim2 = fromAlimentoEntity(alimentoSelecc);
    	
    	return alim2;
    }
    	
}

package com.bean;

import javax.ejb.Remote;
import com.capa1entities.Usuario;
import com.capa3persistence.exceptions.PersistenceException;

@Remote
public interface GestionUsuarioBeanRemote {

	public String validarUsuario();
	
}

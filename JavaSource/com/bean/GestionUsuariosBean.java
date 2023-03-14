package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.capa1entities.Usuario;
import com.capa2businesslogic.GestionUsuariosService;
import com.capa3persistence.exceptions.PersistenceException;


@Named(value="gestionUsuarios")
@SessionScoped
public class GestionUsuariosBean implements Serializable{

	@EJB
	GestionUsuariosService gestionUsuarioService;

//	@Inject
//	PersistenciaBean persistenciaBean;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String criterioNombre;
	private String criterioTipo;
	private String criterioEstado;
	
	private List<Usuario> usuariosSeleccionados;
	private Usuario usuarioSeleccionado;
	public GestionUsuariosBean() {
		super();
	}
	
	// ********Acciones****************************
	public String seleccionarUsuarios() throws PersistenceException {
		System.out.print("Prueba1");
		usuariosSeleccionados=gestionUsuarioService.seleccionarUsuarios(criterioNombre, criterioTipo, criterioEstado);
		return "";
	}
	
	
	public String verDatosUsuario() {
		return "DatosUsuario";
	}
	
	public List<Usuario> listarUsuarios() throws PersistenceException {
		System.out.print("Prueba1");
		usuariosSeleccionados=gestionUsuarioService.seleccionarUsuarios(criterioNombre, criterioTipo, criterioEstado);
		return usuariosSeleccionados;
	}

	// ******** Getters & Setters****************************
	
	public String getCriterioNombre() {
		return criterioNombre;
	}

	public void setCriterioNombre(String criterioNombre) {
		this.criterioNombre = criterioNombre;
	}

	public String getCriterioTipo() {
		return criterioTipo;
	}

	public void setCriterioTipo(String criterioTipo) {
		this.criterioTipo = criterioTipo;
	}

	public String getCriterioEstado() {
		return criterioEstado;
	}

	public void setCriterioEstado(String criterioEstado) {
		this.criterioEstado = criterioEstado;
	}

	public List<Usuario> getUsuariosSeleccionados() {
		return usuariosSeleccionados;
	}

	public void setUsuariosSeleccionados(List<Usuario> usuariosSeleccionados) {
		this.usuariosSeleccionados = usuariosSeleccionados;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	
}

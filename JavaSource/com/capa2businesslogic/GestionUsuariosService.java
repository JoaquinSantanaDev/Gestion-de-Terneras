package com.capa2businesslogic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.capa1entities.Usuario;
import com.capa3persistence.dao.UsuarioEmpresaDAO;
import com.capa3persistence.entities.UsuarioEmpresa;
import com.capa3persistence.exceptions.PersistenceException;


@Stateless
@LocalBean

public class GestionUsuariosService implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	UsuarioEmpresaDAO usuarioPersistenciaDAO;
	
	
	public Usuario fromUsuarioEmpresa(UsuarioEmpresa ue) {
		Usuario usuario=new Usuario();
		usuario.setId(ue.getId().longValue());
		usuario.setNombre(ue.getNombre());
		usuario.setApellido(ue.getApellido());
		usuario.setNombre_usuario(ue.getNombre_usuario());
		usuario.setContrasenia(ue.getContrasenia());
		usuario.setEstado(ue.isEstado());
		usuario.setTipo(ue.getTipo());
		usuario.setDato(ue.getDato());
		return usuario;
	}
	public UsuarioEmpresa toUsuarioEmpresa(Usuario u) {
		UsuarioEmpresa usuarioEmpresa=new UsuarioEmpresa();
		usuarioEmpresa.setId(u.getId()!=null?u.getId().longValue():null);
		usuarioEmpresa.setNombre(u.getNombre());
		usuarioEmpresa.setApellido(u.getApellido());
		usuarioEmpresa.setNombre_usuario(u.getNombre_usuario());
		usuarioEmpresa.setContrasenia(u.getContrasenia());
		usuarioEmpresa.setEstado(u.getEstado());
		usuarioEmpresa.setTipo(u.getTipo());
		usuarioEmpresa.setDato(u.getDato());
		return usuarioEmpresa;
	}

	public List<Usuario> seleccionarUsuarios() throws PersistenceException {

		List<UsuarioEmpresa> listaUsuariosEmpresa = usuarioPersistenciaDAO.buscarUsuarios();
		
		List<Usuario> listaUsuarios=new ArrayList<Usuario>();
		for (UsuarioEmpresa empleadoEmpresa : listaUsuariosEmpresa) {
			listaUsuarios.add(fromUsuarioEmpresa(empleadoEmpresa));
		}
		return listaUsuarios;
	}


	public List<Usuario> seleccionarUsuarios(String criterioNombre,String criterioTipo,String criterioEstado) throws PersistenceException {

		List<UsuarioEmpresa> listaUsuariosEmpresa = usuarioPersistenciaDAO.seleccionarUsuarios(criterioNombre,criterioTipo,criterioEstado);

		List<Usuario> listaUsuarios=new ArrayList<Usuario>();

		for (UsuarioEmpresa usuarioEmpresa : listaUsuariosEmpresa) {
			listaUsuarios.add(fromUsuarioEmpresa(usuarioEmpresa));
		}
		return listaUsuarios;
		
	}
	
	public void borrarUsuarioSeleccionado(Usuario usuarioSeleccionado) throws PersistenceException {
		System.out.println("b");
		UsuarioEmpresa e = usuarioPersistenciaDAO.borrarUsuario(toUsuarioEmpresa(usuarioSeleccionado));
		usuarioPersistenciaDAO.borrarUsuario(e);
	}
	
	public void restaurarUsuarioSeleccionado(Usuario usuarioSeleccionado) throws PersistenceException {
		UsuarioEmpresa e = usuarioPersistenciaDAO.restaurarUsuario(toUsuarioEmpresa(usuarioSeleccionado));
		usuarioPersistenciaDAO.restaurarUsuario(e);
	}
	
	public Usuario buscarUsuarioEmpresa (Long id) {
		UsuarioEmpresa e = usuarioPersistenciaDAO.buscarUsuario(id);
		return fromUsuarioEmpresa(e);
	}

	public Usuario buscarUsuario(Long i) {
		UsuarioEmpresa e = usuarioPersistenciaDAO.buscarUsuario(i);
		return fromUsuarioEmpresa(e);
	}
	
	public boolean comprobarUsuarioPorNomUsuario(String usName) {
		List<UsuarioEmpresa> e = usuarioPersistenciaDAO.buscarUsuarioPorNomUsuario(usName);
		boolean res = false;
		if (e.isEmpty()) {
			res = true;
		}
		return res;
	}
	
	public Usuario agregarUsuario(Usuario usuarioSeleccionado) throws PersistenceException   {
		UsuarioEmpresa e = null;
		if(usuarioSeleccionado.getTipo().equals("ADMINISTRADOR") || usuarioSeleccionado.getTipo().equals("PERSONAL")) {
			if(parseUsuarios(usuarioSeleccionado)) {
				e = usuarioPersistenciaDAO.agregarUsuario(toUsuarioEmpresa(usuarioSeleccionado));
			}
		}else {
				e = usuarioPersistenciaDAO.agregarUsuario(toUsuarioEmpresa(usuarioSeleccionado));
		}
		return fromUsuarioEmpresa(e);
	}

	public void actualizarUsuario(Usuario usuarioSeleccionado) throws PersistenceException   {
		UsuarioEmpresa u = usuarioPersistenciaDAO.modificarUsuario(toUsuarioEmpresa(usuarioSeleccionado));
	}
	
	public Usuario validarUsuario(String usName, String usPass) {
		System.out.println(usName+usPass);
		List<UsuarioEmpresa> ue = usuarioPersistenciaDAO.buscarUsuarios();
		Usuario u = new Usuario();
		for (UsuarioEmpresa usuarioEmpresa : ue) {
			if (usuarioEmpresa.getNombre_usuario().equals(usName)) {
				if(usuarioEmpresa.getContrasenia().equals(usPass)) {
					u = fromUsuarioEmpresa(usuarioEmpresa);
				}
			}
		}
		return u;
	}
	
	public boolean parseUsuarios(Usuario u) {
		boolean res = false;
		try {
			int a = Integer.parseInt(u.getDato());
			res = true;
			return res;
		}catch(Exception e) {
			System.out.println(e);
			res = false;
			return res;
		}
	}
}

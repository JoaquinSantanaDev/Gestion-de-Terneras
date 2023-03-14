package com.capa3persistence.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.capa3persistence.entities.UsuarioEmpresa;


@Stateless
@LocalBean
public class UsuarioEmpresaDAO {
	@PersistenceContext
	private EntityManager em;
	
	public UsuarioEmpresa agregarUsuario(UsuarioEmpresa usuario) throws PersistenceException {
		try {
			UsuarioEmpresa usuarioEmpresa = em.merge(usuario);
			em.flush();
			return usuarioEmpresa;
		} 
		catch (PersistenceException e) {
			throw new PersistenceException("No se pudo agregar el usuario." + e.getMessage(), e);
		}
		finally {
			
		}
	}

	public UsuarioEmpresa borrarUsuario(UsuarioEmpresa usuario) throws PersistenceException {
		System.out.println("c");
		UsuarioEmpresa usuarioEmpresa = em.find(UsuarioEmpresa.class, usuario.getId());
		if (usuarioEmpresa == null) {
			throw new PersistenceException("No existe el usuario a borrar. Id=" + usuario.getId());
		}
		try {
			usuario.setEstado(0);
			usuarioEmpresa = em.merge(usuario);
			em.flush();
			return usuarioEmpresa;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo borrar el usuario. Id=" + usuario.getId());
		}
	}
	public UsuarioEmpresa restaurarUsuario(UsuarioEmpresa usuario) throws PersistenceException {
		UsuarioEmpresa usuarioEmpresa = em.find(UsuarioEmpresa.class, usuario.getId());
		if (usuarioEmpresa == null) {
			throw new PersistenceException("No se encontro al usuario. Id=" + usuario.getId());
		}
		try {
			usuario.setEstado(1);
			usuarioEmpresa = em.merge(usuario);
			em.flush();
			return usuarioEmpresa;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo restaurar el usuario. Id=" + usuario.getId());
		}
	}
	
	public UsuarioEmpresa modificarUsuario(UsuarioEmpresa usuario) throws PersistenceException {

		try {
			UsuarioEmpresa usuarioEmpresa = em.merge(usuario);
			em.flush();
			return usuarioEmpresa;
		} catch (PersistenceException e) {
			throw new PersistenceException("No se pudo modificar el usuario." + e.getMessage(), e);
		}
	}

	public UsuarioEmpresa buscarUsuario(Long id) {
		UsuarioEmpresa usuarioEmpresa = em.find(UsuarioEmpresa.class, id);
		return usuarioEmpresa;
	}
	public List<UsuarioEmpresa> buscarUsuarioPorNomUsuario(String usName) {
		String query= 	"Select u from UsuarioEmpresa u where nombre_usuario='"+usName+"'";
		List<UsuarioEmpresa> resultList = (List<UsuarioEmpresa>) em.createQuery(query,UsuarioEmpresa.class)
							 .getResultList();
		return resultList;
	}

	public List<UsuarioEmpresa> buscarUsuarios() throws PersistenceException {
		try {
		
		String query= 	"Select u from UsuarioEmpresa u";
		List<UsuarioEmpresa> resultList = (List<UsuarioEmpresa>) em.createQuery(query,UsuarioEmpresa.class)
							 .getResultList();
		return  resultList;
		}catch(PersistenceException e) {
			throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
		}
		
	}


	public List<UsuarioEmpresa> seleccionarUsuarios(String criterioNombre,
			String criterioTipo, String criterioActivo) throws PersistenceException {
		try {
			
			String query= 	"Select u from UsuarioEmpresa u";
			String queryCriterio="";
			if (criterioNombre!=null && ! criterioNombre.contentEquals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+ " lower(u.nombre) like '%"+criterioNombre.toLowerCase() +"%' ";
			} 
			if (criterioTipo!=null && ! criterioTipo.equals("")) {
				queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" u.tipo='"+criterioTipo+"'  " ;
			}
			
			if (criterioActivo!=null) {
				if (criterioActivo.equals("Activo")) {
					queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" u.estado = 1 " ;
				}else {
					queryCriterio+=(!queryCriterio.isEmpty()?" and ":"")+" u.estado = 0 " ;
				}
			}
			if (!queryCriterio.contentEquals("")) {
				query+=" where "+queryCriterio;
			}
			List<UsuarioEmpresa> resultList = (List<UsuarioEmpresa>) em.createQuery(query,UsuarioEmpresa.class)
								 .getResultList();
				return  resultList;
			}catch(PersistenceException e) {
				throw new PersistenceException("No se pudo hacer la consulta." + e.getMessage(),e);
			}
	}
	
}

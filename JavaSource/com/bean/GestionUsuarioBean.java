package com.bean;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import com.capa1entities.Usuario;
import com.capa2businesslogic.GestionUsuariosService;
import com.capa3persistence.exceptions.PersistenceException;
import com.capa4commoncomponents.ExceptionTools;
import com.capa4commoncomponents.Session;

@Named(value="gestionUsuario")
@SessionScoped
public class GestionUsuarioBean implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@EJB
	GestionUsuariosService gestionUsuarioService;

	private String tipo;
	private Long id;
	private String modalidad;
	private Session session;
	private Usuario usuarioSeleccionado;
	private String usName;
	private String usPass;
	private boolean modoEdicion=false;
	public GestionUsuarioBean() {
		super();
	}
	@PostConstruct
	public void init() {
		//usuarioSeleccionado=new Usuario();
	}
	
	//se ejecuta antes de desplegar la vista
	public void preRenderViewListener() {
		
		if (id!=null) {
			usuarioSeleccionado=gestionUsuarioService.buscarUsuario(id);
		} else {
			usuarioSeleccionado=new Usuario();
		}
		if (modalidad.contentEquals("view")) {
			modoEdicion=false;
		}else if (modalidad.contentEquals("update")) {
			modoEdicion=true;
		}else if (modalidad.contentEquals("insert")) {
			modoEdicion=true;
		}else if (modalidad.contentEquals("drop")) {
			modoEdicion=false;
		}else if (modalidad.contentEquals("restore")) {
			modoEdicion=false;
		}else {
			modoEdicion=false;
			modalidad="view";
		}
	}			
	//acciones
	public String cambiarModalidadUpdate() throws CloneNotSupportedException {
		//this.modalidad="update";
		return "DatosUsuario?faces-redirect=true&includeViewParams=true";
		
	}
	
	public String salvarCambios() {
		
		if (usuarioSeleccionado.getId()==null) {
			usuarioSeleccionado.setEstado(1);
			Usuario usuarioNuevo;
			
			if (gestionUsuarioService.comprobarUsuarioPorNomUsuario(usuarioSeleccionado.getNombre_usuario())) {
				if (usuarioSeleccionado.getTipo().equals("ADMINISTRADOR")) {
					
					if (isNumeric(usuarioSeleccionado.getDato().toString()) == true && usuarioSeleccionado.getDato().length() == 8) {
						try {
							usuarioNuevo = (Usuario) gestionUsuarioService.agregarUsuario(usuarioSeleccionado);
							this.id=usuarioNuevo.getId();
							
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo Usuario", "");
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="view";
							
						} catch (PersistenceException e) {
							
							Throwable rootException=ExceptionTools.getCause(e);
							String msg1=e.getMessage();
							String msg2=ExceptionTools.formatedMsg(rootException);
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="update";
							
							e.printStackTrace();
						}
			        } else {
			        	FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Debe colocar correctamente la cédula", "");
						FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			        }
				}else if (usuarioSeleccionado.getTipo().equals("ENCARGADO")) {
					if (isNumeric(usuarioSeleccionado.getDato().toString()) == true) {
						try {
							usuarioNuevo = (Usuario) gestionUsuarioService.agregarUsuario(usuarioSeleccionado);
							this.id=usuarioNuevo.getId();
							
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo Usuario", "");
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="view";
						
							
						} catch (PersistenceException e) {
							
							Throwable rootException=ExceptionTools.getCause(e);
							String msg1=e.getMessage();
							String msg2=ExceptionTools.formatedMsg(rootException);
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="update";
							
							e.printStackTrace();
						}
			        } else {
			            
			        }
				}else if (usuarioSeleccionado.getTipo().equals("PERSONAL")) {
					if (isNumeric(usuarioSeleccionado.getDato().toString()) == true) {
						try {
							usuarioNuevo = (Usuario) gestionUsuarioService.agregarUsuario(usuarioSeleccionado);
							this.id=usuarioNuevo.getId();
							
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha agregado un nuevo Usuario", "");
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="view";
						
							
						} catch (PersistenceException e) {
							
							Throwable rootException=ExceptionTools.getCause(e);
							String msg1=e.getMessage();
							String msg2=ExceptionTools.formatedMsg(rootException);
							//mensaje de actualizacion correcta
							FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
							FacesContext.getCurrentInstance().addMessage(null, facesMsg);
							
							this.modalidad="update";
							
							e.printStackTrace();
						}
			        } else {
			        	FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Debe colocar correctamente la cantidad de horas", "");
						FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			        }
				}
				
			}else {
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ya existe", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			}
			
		} else if (modalidad.equals("update")) {
			
			try {
				if (usuarioSeleccionado.getTipo().equals("ADMINISTRADOR")) {
					
					if (isNumeric(usuarioSeleccionado.getDato().toString()) == true && usuarioSeleccionado.getDato().length() == 8) {
						gestionUsuarioService.actualizarUsuario(usuarioSeleccionado);

						FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado Usuario.",""));
					} else {
						FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Debe colocar correctamente la cédula", "");
						FacesContext.getCurrentInstance().addMessage(null, facesMsg);
					}
					
				} else if (usuarioSeleccionado.getTipo().equals("ENCARGADO")) {
					
					gestionUsuarioService.actualizarUsuario(usuarioSeleccionado);
					
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado Usuario.",""));
					
				}else if (usuarioSeleccionado.getTipo().equals("PERSONAL")) {
					
					if (isNumeric(usuarioSeleccionado.getDato().toString()) == true) {
						gestionUsuarioService.actualizarUsuario(usuarioSeleccionado);

						FacesContext.getCurrentInstance().addMessage(null, 
								new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha modificado Usuario.",""));
					} else {
						FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Debe colocar correctamente la cantidad de horas", "");
						FacesContext.getCurrentInstance().addMessage(null, facesMsg);
					}
					
				}
				
			} catch (PersistenceException e) {

				Throwable rootException=ExceptionTools.getCause(e);
				String msg1=e.getMessage();
				String msg2=ExceptionTools.formatedMsg(e.getCause());
				//mensaje de actualizacion correcta
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			
				this.modalidad="update";
			
				e.printStackTrace();
			}
		}
		else if (modalidad.equals("drop")) {
			System.out.println("a");
			try {
				gestionUsuarioService.borrarUsuarioSeleccionado(usuarioSeleccionado);
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha eliminado Usuario.",""));
			} catch (PersistenceException e) {
				Throwable rootException=ExceptionTools.getCause(e);
				String msg1=e.getMessage();
				String msg2=ExceptionTools.formatedMsg(e.getCause());
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				
				this.modalidad="view";
			}
		}
		else if (modalidad.equals("restore")) {
			try {
				gestionUsuarioService.restaurarUsuarioSeleccionado(usuarioSeleccionado);
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Se ha restaurado Usuario.",""));
			} catch (PersistenceException e) {
				Throwable rootException=ExceptionTools.getCause(e);
				String msg1=e.getMessage();
				String msg2=ExceptionTools.formatedMsg(e.getCause());
				FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg1, msg2);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
				
				this.modalidad="view";
			}
		}
		return "";
	}
	public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
	public String validarUsuario() {
		Usuario u = gestionUsuarioService.validarUsuario(usName, usPass);
		try {
			if (usName.contains("@")) {
				String resultado = GestionUsuarioBean.autenticacionToAD(usName, usPass);
				
				switch (resultado) {
				//FLOPEZ
				 case "Credenciales incorrectas":
	            	 FacesMessage message2 = new FacesMessage("Nombre de usuario o contrase�a incorrecta");
		   			 FacesContext context2 = FacesContext.getCurrentInstance();
		   			 context2.addMessage("loginForm", message2);
		   			 return null;
		   			 
	            case "Dado de Baja":
	            	 FacesMessage message = new FacesMessage("Este usuario se encuentra dado de baja.");
		   			 FacesContext context = FacesContext.getCurrentInstance();
		   			 context.addMessage("loginForm", message);
		   			 return null;
	            
	            case "Administrador":
	            	u.setNombre_usuario("administrador");
	            	u.setContrasenia("administrador");
	            	u.setTipo("Admin");
	            	session.getCurrentInstance().setLoggedUser(u.getNombre_usuario());
					session.getCurrentInstance().setUserType(u.getTipo());
	            	return "index";
	 
	            
	            case "Encargado":
	            	u.setNombre_usuario("encargado");
	            	u.setContrasenia("encargado123");
	            	u.setTipo("Encargado");
	            	session.getCurrentInstance().setLoggedUser(u.getNombre_usuario());
					session.getCurrentInstance().setUserType(u.getTipo());
	            	return "index";
	            	
	            
	            case "Personal":
	            	u.setNombre_usuario("personal");
	            	u.setContrasenia("personal123");
	            	u.setTipo("Personal");
	            	session.getCurrentInstance().setLoggedUser(u.getNombre_usuario());
					session.getCurrentInstance().setUserType(u.getTipo());
	            	
	            }		
	            	return null;
				
				}else{
				
			if (u.getId()==null) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o Contraseña incorrectos.",""));
			}else {
				if (u.getEstado()==1) {
					session.getCurrentInstance().setLoggedUser(u.getNombre_usuario());
					session.getCurrentInstance().setUserType(u.getTipo());
					return "index";
				}else {
					FacesContext.getCurrentInstance().addMessage(null, 
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario inactivo.",""));
				}
			}
			return "";
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Error desconocido.",""));
			return "";
		}
	}
		
	
	public String cerrarSesion() {
		try {
			session.getCurrentInstance().setLoggedUser(null);
			session.getCurrentInstance().setUserType(null);
			return "/login";
		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	public static String autenticacionToAD (String user, String pass) {
	       DirContext ctx;
	       Integer corteString = user.indexOf("@");
	       String userName = user.substring(0, corteString);
	       Attribute estadoUsuario;
	       Attribute tpoUsuario;
	       Properties env = new Properties();
	       env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	       env.put(Context.PROVIDER_URL,"ldap://192.168.10.7"); 
	       env.put(Context.SECURITY_PRINCIPAL,user);
	       env.put(Context.SECURITY_CREDENTIALS,pass);
	       
	     
	       try {
	    	   ctx = new InitialDirContext(env);
	           SearchControls searchControls =  new SearchControls();
	           searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
	           String ldap_search_context = "CN=Users,DC=theboys,DC=com,DC=uy";
		       NamingEnumeration answer = ctx.search(ldap_search_context, "sAMAccountName=" + userName, searchControls);
	           while(answer.hasMore()) {SearchResult sr = (SearchResult) answer.next();
	           Attributes attributes = sr.getAttributes(); 
	           //estadoUsuario = attributes.get("estadoUsuario"); 
	           tpoUsuario = attributes.get("tipousuario"); 
	               if(tpoUsuario.get().equals("Administrador")) {
	                   return "Administrador";
	               } else if(tpoUsuario.get().equals("Encargado"))                                                                                                                                                                                                                                                                                                                              {
	                   return "Encargado";
	               } else {
	                   return "Personal";
	               }
	       
	        
	           }
	           
	       }catch(Exception e) {
	           System.out.println(e.getMessage());
	       }
	       return "Credenciales incorrectas";
	       }
	
	
	public String detalles(Long id) {
		modalidad="view";
		setId(id);
		preRenderViewListener();
		return "DatosUsuario";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}
	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}
	public boolean getModoEdicion() {
		return modoEdicion;
	}
	public boolean isModoEdicion() {
		return modoEdicion;
	}
	public void setModoEdicion(boolean modoEdicion) {
		this.modoEdicion = modoEdicion;
	}
	public String getUsName() {
		return usName;
	}
	public void setUsName(String usName) {
		this.usName = usName;
	}
	public String getUsPass() {
		return usPass;
	}
	public void setUsPass(String usPass) {
		this.usPass = usPass;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}

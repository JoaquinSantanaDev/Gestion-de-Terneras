package com.capa4commoncomponents;


import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.capa1entities.Usuario;

@SuppressWarnings("cdi-ambiguous-dependency")
@Named(value="gestionSesison")
@SessionScoped
public final class Session implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static Session session;

    private String loggedUser;
    
    private String userType;
    
    private Session() {
    	super();
    }
    
    public static Session getCurrentInstance() {
        if (session == null) {
            session = new Session();
        }
        return session;
    }
    public void setLoggedUser(String user) {
        loggedUser = user;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

	public String getUserType() {
		return userType;
	}

	public void setUserType(String type) {
		userType = type;
	}
}

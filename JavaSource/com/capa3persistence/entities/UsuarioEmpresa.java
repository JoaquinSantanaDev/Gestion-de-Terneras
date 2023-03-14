package com.capa3persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.wildfly.common.annotation.Nullable;

@Entity
@Table(name =  "USUARIOS")
public class UsuarioEmpresa implements Serializable{
private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUsu")
	@SequenceGenerator(name="seqUsu", sequenceName = "SEQ_ID_USUARIO")
	private Long id_usuario;
	private String nombre;
	private String apellido;
	@Column(unique=true)
	private String nombre_usuario;
	private String contrasenia;
	private int estado;
	private String tipo;
	private String dato;
	
	public UsuarioEmpresa() {
		super();
	}


	public Long getId() {
		return id_usuario;
	}


	public void setId(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEstado() {
		return estado;
	}


	public String getNombre_usuario() {
		return nombre_usuario;
	}


	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public int isEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDato() {
		return dato;
	}
	
	public void setDato(String dato) {
		this.dato = dato;
	}



	public UsuarioEmpresa(String nombre, String apellido, String nombre_usuario, String contrasenia, int estado, String tipo, String dato) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_usuario = nombre_usuario;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.tipo = tipo;
		this.dato = dato;
	}

}

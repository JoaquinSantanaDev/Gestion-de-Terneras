package com.capa1entities;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Usuario {

	@NotNull
	private Long id_usuario;
	@NotNull
	@Length(min=1,	max=50)
	private String nombre;
	@NotNull
	@Length(min=1,	max=50)
	private String apellido;
	@NotNull
	@Length(min=8,	max=50)
	private String nombre_usuario;
	@NotNull
	@Length(min=8,	max=50)
	private String contrasenia;
	private int estado;
	@NotNull
	private String tipo;
	@NotNull
	@Length(min=1,	max=50)
	private String dato;

	public Usuario() {
		super();
	}

	public Long getId() {
		return id_usuario;
	}

	public void setId(Long id) {
		this.id_usuario = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getEstado() {
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


	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Usuario(Long id_usuario, String nombre, String apellido,
			String nombre_usuario,
			String contrasenia, int estado, String tipo,  String dato) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nombre_usuario = nombre_usuario;
		this.contrasenia = contrasenia;
		this.estado = estado;
		this.tipo = tipo;
		this.dato = dato;
	}
	
}

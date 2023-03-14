package com.capa3persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AlimentoEntity
 *
 */
@Entity
@Table(name="ALIMENTO")
public class AlimentoEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAli")
	@SequenceGenerator(name="seqAli", sequenceName = "SEQ_ID_ALIMENTO")
	private int id_alimento;
	private String nombre;
	private int costo;
	private int cantidad;
	private int estado;
	private String marca;
	

	public AlimentoEntity() {
		super();
	}


	public int getId_alimento() {
		return id_alimento;
	}


	public void setId_alimento(int id_alimento) {
		this.id_alimento = id_alimento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public AlimentoEntity(int id_alimento, String nombre, int costo, int cantidad, int estado, String marca) {
		super();
		this.id_alimento = id_alimento;
		this.nombre = nombre;
		this.costo = costo;
		this.cantidad = cantidad;
		this.estado = estado;
		this.marca = marca;
	}
	
	
   
}

package com.capa3persistence.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MedicamentosEntity
 *
 */
@Entity
@Table(name="Medicamento")

public class MedicamentosEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMed")
	@SequenceGenerator(name="seqMed", sequenceName = "SEQ_ID_MEDICAMENTO")
	private int id_medicamento;
	private int nro_medicamento;
	private String marca;
	private int costo;
	private int dosis;
	private String tipo;
	private String producto;
	private int estado;
	
	
	public MedicamentosEntity() {
		super();
	}


	public int getId_medicamento() {
		return id_medicamento;
	}


	public void setId_medicamento(int id_medicamento) {
		this.id_medicamento = id_medicamento;
	}


	public int getNro_medicamento() {
		return nro_medicamento;
	}


	public void setNro_medicamento(int nro_medicamento) {
		this.nro_medicamento = nro_medicamento;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public int getDosis() {
		return dosis;
	}


	public void setDosis(int dosis) {
		this.dosis = dosis;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getProducto() {
		return producto;
	}


	public void setProducto(String producto) {
		this.producto = producto;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public MedicamentosEntity(int nro_medicamento, String marca, int costo, int dosis, String tipo,
			String producto, int estado) {
		super();
		this.nro_medicamento = nro_medicamento;
		this.marca = marca;
		this.costo = costo;
		this.dosis = dosis;
		this.tipo = tipo;
		this.producto = producto;
		this.estado = estado;
	}
	
	
	
	
   
}

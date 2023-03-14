package com.capa3persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AlimTerneraEntity
 *
 */
@Entity
@Table(name="ALIM_TERNERA")
public class AlimTerneraEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlT")
	@SequenceGenerator(name="seqAlT", sequenceName = "SEQ_ID_ALIM_TERNERA")
	private int id_alim_ternera;
	private String caravana_ternera;
	private int id_alimento;
	private int costo_alim;
	private Date fecha_alim;
	private String usuario;
	private int cantidad;
	
	public AlimTerneraEntity() {
		super();
	}

	public int getId_alim_ternera() {
		return id_alim_ternera;
	}

	public void setId_alim_ternera(int id_alim_ternera) {
		this.id_alim_ternera = id_alim_ternera;
	}

	public String getCaravana_ternera() {
		return caravana_ternera;
	}

	public void setCaravana_ternera(String caravana_ternera) {
		this.caravana_ternera = caravana_ternera;
	}

	public int getId_alimento() {
		return id_alimento;
	}

	public void setId_alimento(int id_alimento) {
		this.id_alimento = id_alimento;
	}

	public int getCosto_alim() {
		return costo_alim;
	}

	public void setCosto_alim(int costo_alim) {
		this.costo_alim = costo_alim;
	}

	public Date getFecha_alim() {
		return fecha_alim;
	}

	public void setFecha_alim(Date fecha_alim) {
		this.fecha_alim = fecha_alim;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public AlimTerneraEntity(int id_alim_ternera, String caravana_ternera, int id_alimento, int costo_alim,
			Date fecha_alim, String usuario, int cantidad) {
		super();
		this.id_alim_ternera = id_alim_ternera;
		this.caravana_ternera = caravana_ternera;
		this.id_alimento = id_alimento;
		this.costo_alim = costo_alim;
		this.fecha_alim = fecha_alim;
		this.usuario = usuario;
		this.cantidad = cantidad;
	}
	
	
   
}

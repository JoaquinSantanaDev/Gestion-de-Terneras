package com.capa1entities;

import java.util.Date;

public class AlimTernera {

	private int id_alim_ternera;
	private String caravana_ternera;
	private int id_alimento;
	private int costo_alim;
	private Date fecha_alim;
	private String usuario;
	private int cantidad;


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
	
	
	
}

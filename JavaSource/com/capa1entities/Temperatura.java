package com.capa1entities;

import java.util.Date;

public class Temperatura {

	private int id_historico_tt;
	private int temp;
	private Date fecha;
	private String caravana;
	private String usuario;
	
	public Temperatura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_historico_tt() {
		return id_historico_tt;
	}

	public void setId_historico_tt(int id_historico_tt) {
		this.id_historico_tt = id_historico_tt;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCaravana() {
		return caravana;
	}

	public void setCaravana(String caravana) {
		this.caravana = caravana;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}

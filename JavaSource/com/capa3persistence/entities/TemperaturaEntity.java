package com.capa3persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TemperaturaEntity
 *
 */
@Entity
@Table(name="REGISTRO_TERNERA_TEMPERATURA")
public class TemperaturaEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTemp")
	@SequenceGenerator(name="seqTemp", sequenceName = "SEQ_ID_HISTORICO_TT")
	private int id_historico_tt;
	private int temp;
	private Date fecha;
	private String caravana;
	private String usuario;
	
	public TemperaturaEntity() {
		super();
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

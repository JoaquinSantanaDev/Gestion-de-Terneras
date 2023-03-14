package com.capa3persistence.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TerneraEntity
 *
 */
@Entity
@Table(name="TERNERAS")
public class TerneraEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTer")
	@SequenceGenerator(name="seqTer", sequenceName = "SEQ_ID_TERNERA")
	private Integer id_ternera;
	private String caravana_snig;
	private int id_guachera;
	private int id_padre;
	private int id_madre;
	private Date fecha_nto;
	private int peso_al_nacer;
	private String raza;
	private String tipo_de_parto;
	private int estado;
	

	public TerneraEntity() {
		super();
	}   
	public Integer getId_ternera() {
		return this.id_ternera;
	}

	public void setId_ternera(Integer id_ternera) {
		this.id_ternera = id_ternera;
	}   
	public String getCaravana_snig() {
		return this.caravana_snig;
	}

	public void setCaravana_snig(String caravana_snig) {
		this.caravana_snig = caravana_snig;
	}   
	public int getId_guachera() {
		return this.id_guachera;
	}

	public void setId_guachera(int id_guachera) {
		this.id_guachera = id_guachera;
	}   
	public int getId_madre() {
		return this.id_madre;
	}

	public void setId_madre(int id_madre) {
		this.id_madre = id_madre;
	}   
	public int getId_padre() {
		return this.id_padre;
	}

	public void setId_padre(int id_padre) {
		this.id_padre = id_padre;
	}   
	public int getPeso_al_nacer() {
		return this.peso_al_nacer;
	}

	public void setPeso_al_nacer(int peso_al_nacer) {
		this.peso_al_nacer = peso_al_nacer;
	}   
	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	public Date getFecha_nto() {
		return fecha_nto;
	}
	public void setFecha_nto(Date fecha_nto) {
		this.fecha_nto = fecha_nto;
	}
	public String getTipo_de_parto() {
		return tipo_de_parto;
	}
	public void setTipo_de_parto(String tipo_de_parto) {
		this.tipo_de_parto = tipo_de_parto;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

	public TerneraEntity(Integer id_ternera, String caravana_snig, int id_guachera, int id_padre, int id_madre,
			Date fecha_nto, int peso_al_nacer, String raza, String tipo_de_parto, int estado) {
		super();
		this.caravana_snig = caravana_snig;
		this.id_guachera = id_guachera;
		this.id_padre = id_padre;
		this.id_madre = id_madre;
		this.fecha_nto = fecha_nto;
		this.peso_al_nacer = peso_al_nacer;
		this.raza = raza;
		this.tipo_de_parto = tipo_de_parto;
		this.estado = estado;
	}
	
	
   
	
}

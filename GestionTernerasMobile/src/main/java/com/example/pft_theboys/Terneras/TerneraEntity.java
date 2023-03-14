package com.example.pft_theboys.Terneras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TerneraEntity {
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


    public Integer getId_ternera() {
        return id_ternera;
    }

    public void setId_ternera(Integer id_ternera) {
        this.id_ternera = id_ternera;
    }

    public String getCaravana_snig() {
        return caravana_snig;
    }

    public void setCaravana_snig(String caravana_snig) {
        this.caravana_snig = caravana_snig;
    }

    public int getId_guachera() {
        return id_guachera;
    }

    public void setId_guachera(int id_guachera) {
        this.id_guachera = id_guachera;
    }

    public int getId_padre() {
        return id_padre;
    }

    public void setId_padre(int id_padre) {
        this.id_padre = id_padre;
    }

    public int getId_madre() {
        return id_madre;
    }

    public void setId_madre(int id_madre) {
        this.id_madre = id_madre;
    }

    public Date getFecha_nto() {
        return fecha_nto;
    }

    public void setFecha_nto(Date fecha_nto) {
        this.fecha_nto = fecha_nto;
    }

    public int getPeso_al_nacer() {
        return peso_al_nacer;
    }

    public void setPeso_al_nacer(int peso_al_nacer) {
        this.peso_al_nacer = peso_al_nacer;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
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
}

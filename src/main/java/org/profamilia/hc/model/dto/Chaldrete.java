package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import javax.faces.model.SelectItem;


/** @author Hibernate CodeGenerator */
public class Chaldrete implements Serializable {

    /** identifier field */
    private ChaldretePK id;

    /** nullable persistent field */
    private Long hallusuario;

    /** nullable persistent field */
    private Integer halnactividad;

    /** nullable persistent field */
    private Integer halnrespiracio;

    /** nullable persistent field */
    private Integer halncirculacio;

    /** nullable persistent field */
    private Integer halnestadconci;

    /** nullable persistent field */
    private Integer halnsaturoxige;

    /** nullable persistent field */
    private String halcpacieambul;
    
    /** nullable persistent field */
    private Integer halnambulacion; 

    /** nullable persistent field */
    private Integer halndolor;

    /** nullable persistent field */
    private Integer halnsangrposqu;

    /** nullable persistent field */
    private Integer halntolerliqui;

    /** nullable persistent field */
    private Integer halnelimiurina;

    /** nullable persistent field */
    private Integer halnclinica;

    /** nullable persistent field */
    private String halcestado;

    /** nullable persistent field */
    private Date haldfecregistr;

    /** nullable persistent field */
    private Date haldfechaactiv;

    /** nullable persistent field */
    private String halcoperador;

    /** nullable persistent field */
    private Integer version;
    
    private Integer halnescalbroma; 
    
    private String halctipoescal;
    
    private String halcdescraldet;
    
    

  
    /** default constructor */
    public Chaldrete() {
        id = new ChaldretePK(); 
    }


    /**
     * @param id
     */
    public void setId(ChaldretePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChaldretePK getId() {
        return id;
    }

    /**
     * @param hallusuario
     */
    public void setHallusuario(Long hallusuario) {
        this.hallusuario = hallusuario;
    }

    /**
     * @return
     */
    public Long getHallusuario() {
        return hallusuario;
    }

    /**
     * @param halnactividad
     */
    public void setHalnactividad(Integer halnactividad) {
        this.halnactividad = halnactividad;
    }

    /**
     * @return
     */
    public Integer getHalnactividad() {
        return halnactividad;
    }

    /**
     * @param halnrespiracio
     */
    public void setHalnrespiracio(Integer halnrespiracio) {
        this.halnrespiracio = halnrespiracio;
    }

    /**
     * @return
     */
    public Integer getHalnrespiracio() {
        return halnrespiracio;
    }

    /**
     * @param halncirculacio
     */
    public void setHalncirculacio(Integer halncirculacio) {
        this.halncirculacio = halncirculacio;
    }

    /**
     * @return
     */
    public Integer getHalncirculacio() {
        return halncirculacio;
    }

    /**
     * @param halnestadconci
     */
    public void setHalnestadconci(Integer halnestadconci) {
        this.halnestadconci = halnestadconci;
    }

    /**
     * @return
     */
    public Integer getHalnestadconci() {
        return halnestadconci;
    }

    /**
     * @param halnsaturoxige
     */
    public void setHalnsaturoxige(Integer halnsaturoxige) {
        this.halnsaturoxige = halnsaturoxige;
    }

    /**
     * @return
     */
    public Integer getHalnsaturoxige() {
        return halnsaturoxige;
    }

    /**
     * @param halcpacieambul
     */
    public void setHalcpacieambul(String halcpacieambul) {
        this.halcpacieambul = halcpacieambul;
    }

    /**
     * @return
     */
    public String getHalcpacieambul() {
        return halcpacieambul;
    }

    /**
     * @param halnambulacion
     */
    public void setHalnambulacion(Integer halnambulacion) {
        this.halnambulacion = halnambulacion;
    }

    /**
     * @return
     */
    public Integer getHalnambulacion() {
        return halnambulacion;
    }

    /**
     * @param halndolor
     */
    public void setHalndolor(Integer halndolor) {
        this.halndolor = halndolor;
    }

    /**
     * @return
     */
    public Integer getHalndolor() {
        return halndolor;
    }

    /**
     * @param halnsangrposqu
     */
    public void setHalnsangrposqu(Integer halnsangrposqu) {
        this.halnsangrposqu = halnsangrposqu;
    }

    /**
     * @return
     */
    public Integer getHalnsangrposqu() {
        return halnsangrposqu;
    }

    /**
     * @param halntolerliqui
     */
    public void setHalntolerliqui(Integer halntolerliqui) {
        this.halntolerliqui = halntolerliqui;
    }

    /**
     * @return
     */
    public Integer getHalntolerliqui() {
        return halntolerliqui;
    }

    /**
     * @param halnelimiurina
     */
    public void setHalnelimiurina(Integer halnelimiurina) {
        this.halnelimiurina = halnelimiurina;
    }

    /**
     * @return
     */
    public Integer getHalnelimiurina() {
        return halnelimiurina;
    }

    /**
     * @param halnclinica
     */
    public void setHalnclinica(Integer halnclinica) {
        this.halnclinica = halnclinica;
    }

    /**
     * @return
     */
    public Integer getHalnclinica() {
        return halnclinica;
    }

    /**
     * @param halcestado
     */
    public void setHalcestado(String halcestado) {
        this.halcestado = halcestado;
    }

    /**
     * @return
     */
    public String getHalcestado() {
        return halcestado;
    }

    /**
     * @param haldfecregistr
     */
    public void setHaldfecregistr(Date haldfecregistr) {
        this.haldfecregistr = haldfecregistr;
    }

    /**
     * @return
     */
    public Date getHaldfecregistr() {
        return haldfecregistr;
    }

    /**
     * @param haldfechaactiv
     */
    public void setHaldfechaactiv(Date haldfechaactiv) {
        this.haldfechaactiv = haldfechaactiv;
    }

    /**
     * @return
     */
    public Date getHaldfechaactiv() {
        return haldfechaactiv;
    }

    /**
     * @param halcoperador
     */
    public void setHalcoperador(String halcoperador) {
        this.halcoperador = halcoperador;
    }

    /**
     * @return
     */
    public String getHalcoperador() {
        return halcoperador;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param halnescalbroma
     */
    public void setHalnescalbroma(Integer halnescalbroma) {
        this.halnescalbroma = halnescalbroma;
    }

    /**
     * @return
     */
    public Integer getHalnescalbroma() {
        return halnescalbroma;
    }

    public void setHalctipoescal(String halctipoescal) {
        this.halctipoescal = halctipoescal;
    }

    public String getHalctipoescal() {
        return halctipoescal;
    }

    public void setHalcdescraldet(String halcdescraldet) {
        this.halcdescraldet = halcdescraldet;
    }

    public String getHalcdescraldet() {
        halcdescraldet = ""; 
        if(halnescalbroma != null){
            if(halnescalbroma.equals(0)){
                halcdescraldet = "No par�lisis";
            } else if(halnescalbroma.equals(1)){
                halcdescraldet = "Incapacidad para levantar los miembros superiores en extensi�n";
            }else if(halnescalbroma.equals(2)){
                halcdescraldet = "Incapacidad para flejar la rodilla ";
            }else if(halnescalbroma.equals(3)){
                halcdescraldet = "Incapacidad para flejar el tobillo";
            }
        }
    
    
        return halcdescraldet;
    }
}

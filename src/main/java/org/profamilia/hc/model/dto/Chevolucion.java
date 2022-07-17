package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chevolucion implements Serializable {

    /** identifier field */
    private ChevolucionPK id;

    /** nullable persistent field */
    private Long hevlusuario;
 
    /** nullable persistent field */
    private String hevcnotapacien;

    /** nullable persistent field */
    private Date hevdfecevoluci;

    /** nullable persistent field */
    private Date hevdfecregistr;

    /** nullable persistent field */
    private String hevcoperador;

    /** nullable persistent field */
    private Integer version;
        
    /** nullable persistent field */
    private String hevcestado;
    
     /** nullable persistent field */
     private String hevcrefiedolor; 
    
    /** nullable persistent field */
    private Integer hevnescaladolo;
    
    /** nullable persistent field */
    private Integer hevnduradolor;

    /** nullable persistent field */
    private String hevcdudointen;


    /** default constructor */
    public Chevolucion() {
    }


    /**
     * @param id
     */
    public void setId(ChevolucionPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChevolucionPK getId() {
        return id;
    }

    /**
     * @param hevlusuario
     */
    public void setHevlusuario(Long hevlusuario) {
        this.hevlusuario = hevlusuario;
    }

    /**
     * @return
     */
    public Long getHevlusuario() {
        return hevlusuario;
    }


    /**
     * @param hevcnotapacien
     */
    public void setHevcnotapacien(String hevcnotapacien) {
        this.hevcnotapacien = hevcnotapacien;
    }

    /**
     * @return
     */
    public String getHevcnotapacien() {
        return hevcnotapacien;
    }

    /**
     * @param hevdfecevoluci
     */
    public void setHevdfecevoluci(Date hevdfecevoluci) {
        this.hevdfecevoluci = hevdfecevoluci;
    }

    /**
     * @return
     */
    public Date getHevdfecevoluci() {
        return hevdfecevoluci;
    }

    /**
     * @param hevdfecregistr
     */
    public void setHevdfecregistr(Date hevdfecregistr) {
        this.hevdfecregistr = hevdfecregistr;
    }

    /**
     * @return
     */
    public Date getHevdfecregistr() {
        return hevdfecregistr;
    }

    /**
     * @param hevcoperador
     */
    public void setHevcoperador(String hevcoperador) {
        this.hevcoperador = hevcoperador;
    }

    /**
     * @return
     */
    public String getHevcoperador() {
        return hevcoperador;
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
     * @param hevcestado
     */
    public void setHevcestado(String hevcestado) {
        this.hevcestado = hevcestado;
    }

    /**
     * @return
     */
    public String getHevcestado() {
        return hevcestado;
    }

    public void setHevcrefiedolor(String hevcrefiedolor) {
        this.hevcrefiedolor = hevcrefiedolor;
    }

    public String getHevcrefiedolor() {
        return hevcrefiedolor;
    }

    public void setHevnescaladolo(Integer hevnescaladolo) {
        this.hevnescaladolo = hevnescaladolo;
    }

    public Integer getHevnescaladolo() {
        return hevnescaladolo;
    }

    public void setHevnduradolor(Integer hevnduradolor) {
        this.hevnduradolor = hevnduradolor;
    }

    public Integer getHevnduradolor() {
        return hevnduradolor;
    }

    public void setHevcdudointen(String hevcdudointen) {
        this.hevcdudointen = hevcdudointen;
    }

    public String getHevcdudointen() {
        return hevcdudointen;
    }
}

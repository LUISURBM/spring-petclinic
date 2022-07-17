package org.profamilia.hc.model.dto;

import java.util.Date;


/**
 * Cpsalaespe generated by hbm2java
 */
public class

Cpsalaespe implements java.io.Serializable {


    private CpsalaespeId id;
    private String cslcdescri;
    private String cslcusuar;
    private Date csldfecreg;
    private Integer cslnprogra;
    private String cslcgenero;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }
    // Constructors

    /** default constructor */
    public Cpsalaespe() {
    }

    /** constructor with id */
    public
    // HS == CpsalaespeId


    Cpsalaespe(CpsalaespeId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public CpsalaespeId getId() {
        return this.id;
    }

    public void setId(CpsalaespeId id) {
        this.id = id;
    }


    public String getCslcdescri() {
        return this.cslcdescri;
    }

    public void setCslcdescri(String cslcdescri) {
        this.cslcdescri = cslcdescri;
    }


    public String getCslcusuar() {
        return this.cslcusuar;
    }

    public void setCslcusuar(String cslcusuar) {
        this.cslcusuar = cslcusuar;
    }


    public Date getCsldfecreg() {
        return this.csldfecreg;
    }

    public void setCsldfecreg(Date csldfecreg) {
        this.csldfecreg = csldfecreg;
    }


    public Integer getCslnprogra() {
        return this.cslnprogra;
    }

    public void setCslnprogra(Integer cslnprogra) {
        this.cslnprogra = cslnprogra;
    }


    public String getCslcgenero() {
        return this.cslcgenero;
    }

    public void setCslcgenero(String cslcgenero) {
        this.cslcgenero = cslcgenero;
    }


    public Integer getCslnclinic() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCslnclinic();
    }

    public void setCslnclinic(Integer cslnclinic) {
        if (this.id == null) {
            this.id = new CpsalaespeId();
        }
        this.id.setCslnclinic(cslnclinic);
    }

    public Integer getCslnnumero() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCslnnumero();
    }

    public void setCslnnumero(Integer cslnnumero) {
        if (this.id == null) {
            this.id = new CpsalaespeId();
        }
        this.id.setCslnnumero(cslnnumero);
    }


}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.sql.Clob;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcontrvasec implements Serializable {

    /** identifier field */
    private ChcontrvasecPK id;

    /** nullable persistent field */
    private String hcvcdescripcio;

    /** nullable persistent field */
    private String hcvcoperador;

    /** nullable persistent field */
    private Date hcvdfecregistr;

    /** persistent field */
    private String hcvctiposervi;

    /** nullable persistent field */
    private Integer version;

   

    /** default constructor */
    public Chcontrvasec() {
        id = new ChcontrvasecPK();
    }

    /**
     * @param id
     */
    public void setId(ChcontrvasecPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontrvasecPK getId() {
        return id;
    }




    /**
     * @param hcvcdescripcio
     */
    public void setHcvcdescripcio(String hcvcdescripcio) {
        this.hcvcdescripcio = hcvcdescripcio;
    }

    /**
     * @return
     */
    public String getHcvcdescripcio() {
        return hcvcdescripcio;
    }

    /**
     * @param hcvcoperador
     */
    public void setHcvcoperador(String hcvcoperador) {
        this.hcvcoperador = hcvcoperador;
    }

    /**
     * @return
     */
    public String getHcvcoperador() {
        return hcvcoperador;
    }

    /**
     * @param hcvdfecregistr
     */
    public void setHcvdfecregistr(Date hcvdfecregistr) {
        this.hcvdfecregistr = hcvdfecregistr;
    }

    /**
     * @return
     */
    public Date getHcvdfecregistr() {
        return hcvdfecregistr;
    }

    /**
     * @param hcvctiposervi
     */
    public void setHcvctiposervi(String hcvctiposervi) {
        this.hcvctiposervi = hcvctiposervi;
    }

    /**
     * @return
     */
    public String getHcvctiposervi() {
        return hcvctiposervi;
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
}

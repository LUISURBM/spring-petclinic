package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chplantilla implements Serializable {

    /** identifier field */
    private ChplantillaPK id;

    /** persistent field */
    private String hplcdescripcio;

    /** persistent field */
    private String hplcnombrplant;

    /** persistent field */
    private Date hpldfecregistr;

    /** persistent field */
    private String hplcoperador;
    
    /** persistent field */
    private String hplchallazgos;
    

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chplantilla() {
    }


    /**
     * @param id
     */
    public void setId(ChplantillaPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChplantillaPK getId() {
        return id;
    }

    /**
     * @param hplcdescripcio
     */
    public void setHplcdescripcio(String hplcdescripcio) {
        this.hplcdescripcio = hplcdescripcio;
    }

    /**
     * @return
     */
    public String getHplcdescripcio() {
        return hplcdescripcio;
    }

    /**
     * @param hplcnombrplant
     */
    public void setHplcnombrplant(String hplcnombrplant) {
        this.hplcnombrplant = hplcnombrplant;
    }

    /**
     * @return
     */
    public String getHplcnombrplant() {
        return hplcnombrplant;
    }

    /**
     * @param hpldfecregistr
     */
    public void setHpldfecregistr(Date hpldfecregistr) {
        this.hpldfecregistr = hpldfecregistr;
    }

    /**
     * @return
     */
    public Date getHpldfecregistr() {
        return hpldfecregistr;
    }

    /**
     * @param hplcoperador
     */
    public void setHplcoperador(String hplcoperador) {
        this.hplcoperador = hplcoperador;
    }

    /**
     * @return
     */
    public String getHplcoperador() {
        return hplcoperador;
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

    public void setHplchallazgos(String hplchallazgos) {
        this.hplchallazgos = hplchallazgos;
    }

    public String getHplchallazgos() {
        return hplchallazgos;
    }
}

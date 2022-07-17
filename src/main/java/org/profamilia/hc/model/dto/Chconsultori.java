package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chconsultori implements Serializable {

    /** identifier field */
    private ChconsultoriPK id;

    /** persistent field */
    private Date hcodfecregistr;

    /** persistent field */
    private String hcocoperador;

    /** persistent field */
    private String hcocdescripcio;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hcocestado;

    /** default constructor */
    public Chconsultori() {
    }


    /**
     * @param id
     */
    public void setId(ChconsultoriPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChconsultoriPK getId() {
        return id;
    }

    /**
     * @param hcodfecregistr
     */
    public void setHcodfecregistr(Date hcodfecregistr) {
        this.hcodfecregistr = hcodfecregistr;
    }

    /**
     * @return
     */
    public Date getHcodfecregistr() {
        return hcodfecregistr;
    }

    /**
     * @param hcocoperador
     */
    public void setHcocoperador(String hcocoperador) {
        this.hcocoperador = hcocoperador;
    }

    /**
     * @return
     */
    public String getHcocoperador() {
        return hcocoperador;
    }

    /**
     * @param hcocdescripcio
     */
    public void setHcocdescripcio(String hcocdescripcio) {
        this.hcocdescripcio = hcocdescripcio;
    }

    /**
     * @return
     */
    public String getHcocdescripcio() {
        return hcocdescripcio;
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


    public void setHcocestado(String hcocestado) {
        this.hcocestado = hcocestado;
    }

    public String getHcocestado() {
        return hcocestado;
    }
}

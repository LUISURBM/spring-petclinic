package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcontrolcon implements Serializable {

    /** identifier field */
    private ChcontrolconPK id;

    /** nullable persistent field */
    private String hcccdescripcio;

    /** nullable persistent field */
    private String hcccoperador;

    /** nullable persistent field */
    private Date hccdfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chcontrolcon() {
    }


    public void setId(ChcontrolconPK id) {
        this.id = id;
    }

    public ChcontrolconPK getId() {
        return id;
    }

    public void setHcccdescripcio(String hcccdescripcio) {
        this.hcccdescripcio = hcccdescripcio;
    }

    public String getHcccdescripcio() {
        return hcccdescripcio;
    }

    public void setHcccoperador(String hcccoperador) {
        this.hcccoperador = hcccoperador;
    }

    public String getHcccoperador() {
        return hcccoperador;
    }

    public void setHccdfecregistr(Date hccdfecregistr) {
        this.hccdfecregistr = hccdfecregistr;
    }

    public Date getHccdfecregistr() {
        return hccdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

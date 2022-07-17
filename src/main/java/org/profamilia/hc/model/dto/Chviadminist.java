package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chviadminist implements Serializable {

    /** identifier field */
    private String hvancodigo;

    /** nullable persistent field */
    private String hvacdescripcio;

    /** nullable persistent field */
    private Date hvadfecregistr;

    /** nullable persistent field */
    private String hvacoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chviadminist() {
    }


    public void setHvancodigo(String hvancodigo) {
        this.hvancodigo = hvancodigo;
    }

    public String getHvancodigo() {
        return hvancodigo;
    }

    public void setHvacdescripcio(String hvacdescripcio) {
        this.hvacdescripcio = hvacdescripcio;
    }

    public String getHvacdescripcio() {
        return hvacdescripcio;
    }

    public void setHvadfecregistr(Date hvadfecregistr) {
        this.hvadfecregistr = hvadfecregistr;
    }

    public Date getHvadfecregistr() {
        return hvadfecregistr;
    }

    public void setHvacoperador(String hvacoperador) {
        this.hvacoperador = hvacoperador;
    }

    public String getHvacoperador() {
        return hvacoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

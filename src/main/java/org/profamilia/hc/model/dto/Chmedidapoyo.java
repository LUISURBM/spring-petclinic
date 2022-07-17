package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chmedidapoyo implements Serializable {

    /** identifier field */
    private ChmedidapoyoPK id;

    /** nullable persistent field */
    private String hmatdescripcio;

    /** nullable persistent field */
    private Date hmadfecregistr;

    /** nullable persistent field */
    private String hmacoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chmedidapoyo() {
    }


    public void setId(ChmedidapoyoPK id) {
        this.id = id;
    }

    public ChmedidapoyoPK getId() {
        return id;
    }

    public void setHmatdescripcio(String hmatdescripcio) {
        this.hmatdescripcio = hmatdescripcio;
    }

    public String getHmatdescripcio() {
        return hmatdescripcio;
    }

    public void setHmadfecregistr(Date hmadfecregistr) {
        this.hmadfecregistr = hmadfecregistr;
    }

    public Date getHmadfecregistr() {
        return hmadfecregistr;
    }

    public void setHmacoperador(String hmacoperador) {
        this.hmacoperador = hmacoperador;
    }

    public String getHmacoperador() {
        return hmacoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chtipoantece implements Serializable {

    /** identifier field */
    private Integer htancodigo;

    /** persistent field */
    private String htacdescripcio;

    /** nullable persistent field */
    private Integer htanorden;

    /** nullable persistent field */
    private String htacclaseantec;

    /** nullable persistent field */
    private Date htadfecregistr;

    /** nullable persistent field */
    private String htacoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chtipoantece() {
    }

    public void setHtancodigo(Integer htancodigo) {
        this.htancodigo = htancodigo;
    }

    public Integer getHtancodigo() {
        return htancodigo;
    }

    public void setHtacdescripcio(String htacdescripcio) {
        this.htacdescripcio = htacdescripcio;
    }

    public String getHtacdescripcio() {
        return htacdescripcio;
    }

    public void setHtanorden(Integer htanorden) {
        this.htanorden = htanorden;
    }

    public Integer getHtanorden() {
        return htanorden;
    }

    public void setHtacclaseantec(String htacclaseantec) {
        this.htacclaseantec = htacclaseantec;
    }

    public String getHtacclaseantec() {
        return htacclaseantec;
    }

    public void setHtadfecregistr(Date htadfecregistr) {
        this.htadfecregistr = htadfecregistr;
    }

    public Date getHtadfecregistr() {
        return htadfecregistr;
    }

    public void setHtacoperador(String htacoperador) {
        this.htacoperador = htacoperador;
    }

    public String getHtacoperador() {
        return htacoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

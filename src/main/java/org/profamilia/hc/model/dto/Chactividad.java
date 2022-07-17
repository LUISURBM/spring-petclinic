package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chactividad implements Serializable {

    /** identifier field */
    private Integer hacncodigo;

    /** nullable persistent field */
    private String haccdescripcio;

    /** nullable persistent field */
    private Integer hacntipohistor;

    /** nullable persistent field */
    private String haccoperador;

    /** nullable persistent field */
    private Date hacdfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chactividad() {
    }


    public Integer getHacncodigo() {
        return this.hacncodigo;
    }

    public void setHacncodigo(Integer hacncodigo) {
        this.hacncodigo = hacncodigo;
    }

    public String getHaccdescripcio() {
        return this.haccdescripcio;
    }

    public void setHaccdescripcio(String haccdescripcio) {
        this.haccdescripcio = haccdescripcio;
    }

    public Integer getHacntipohistor() {
        return this.hacntipohistor;
    }

    public void setHacntipohistor(Integer hacntipohistor) {
        this.hacntipohistor = hacntipohistor;
    }

    public String getHaccoperador() {
        return this.haccoperador;
    }

    public void setHaccoperador(String haccoperador) {
        this.haccoperador = haccoperador;
    }

    public Date getHacdfecregistr() {
        return this.hacdfecregistr;
    }

    public void setHacdfecregistr(Date hacdfecregistr) {
        this.hacdfecregistr = hacdfecregistr;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

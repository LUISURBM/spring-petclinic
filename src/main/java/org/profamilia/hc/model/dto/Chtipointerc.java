package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chtipointerc implements Serializable {

    /** identifier field */
    private String hticcodigo;

    /** nullable persistent field */
    private String hticdescripcio;

    /** nullable persistent field */
    private Date htidfecregistr;

    /** nullable persistent field */
    private String htioperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hticestado; 


    /** default constructor */
    public Chtipointerc() {
    }


    public void setHticcodigo(String hticcodigo) {
        this.hticcodigo = hticcodigo;
    }

    public String getHticcodigo() {
        return hticcodigo;
    }

    public void setHticdescripcio(String hticdescripcio) {
        this.hticdescripcio = hticdescripcio;
    }

    public String getHticdescripcio() {
        return hticdescripcio;
    }

    public void setHtidfecregistr(Date htidfecregistr) {
        this.htidfecregistr = htidfecregistr;
    }

    public Date getHtidfecregistr() {
        return htidfecregistr;
    }

    public void setHtioperador(String htioperador) {
        this.htioperador = htioperador;
    }

    public String getHtioperador() {
        return htioperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }


    public void setHticestado(String hticestado) {
        this.hticestado = hticestado;
    }

    public String getHticestado() {
        return hticestado;
    }
}

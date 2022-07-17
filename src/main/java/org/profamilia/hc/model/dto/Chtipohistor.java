package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chtipohistor implements Serializable {

    /** identifier field */
    private Integer hthncodigo;

    /** persistent field */
    private String hthcdescripcio;

    /** nullable persistent field */
    private Date hthdfecregistr;

    /** nullable persistent field */
    private String hthcoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chtipohistor() {
    }


    public Integer getHthncodigo() {
        return this.hthncodigo;
    }

    public void setHthncodigo(Integer hthncodigo) {
        this.hthncodigo = hthncodigo;
    }

    public String getHthcdescripcio() {
        return this.hthcdescripcio;
    }

    public void setHthcdescripcio(String hthcdescripcio) {
        this.hthcdescripcio = hthcdescripcio;
    }

    public Date getHthdfecregistr() {
        return this.hthdfecregistr;
    }

    public void setHthdfecregistr(Date hthdfecregistr) {
        this.hthdfecregistr = hthdfecregistr;
    }

    public String getHthcoperador() {
        return this.hthcoperador;
    }

    public void setHthcoperador(String hthcoperador) {
        this.hthcoperador = hthcoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

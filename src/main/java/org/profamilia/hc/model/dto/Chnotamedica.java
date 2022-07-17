package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chnotamedica implements Serializable {

    /** identifier field */
    private ChnotamedicaPK id;

    /** nullable persistent field */
    private String hnmcdescripc;

    /** nullable persistent field */
    private String hnmcoperador;

    /** nullable persistent field */
    private Date hnmdfecregistr;

    /** nullable persistent field */
    private Integer hnmnactividad;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chnotamedica() {
    }


    public void setId(ChnotamedicaPK id) {
        this.id = id;
    }

    public ChnotamedicaPK getId() {
        return id;
    }

    public void setHnmcdescripc(String hnmcdescripc) {
        this.hnmcdescripc = hnmcdescripc;
    }

    public String getHnmcdescripc() {
        return hnmcdescripc;
    }

    public void setHnmcoperador(String hnmcoperador) {
        this.hnmcoperador = hnmcoperador;
    }

    public String getHnmcoperador() {
        return hnmcoperador;
    }

    public void setHnmdfecregistr(Date hnmdfecregistr) {
        this.hnmdfecregistr = hnmdfecregistr;
    }

    public Date getHnmdfecregistr() {
        return hnmdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHnmnactividad(Integer hnmnactividad) {
        this.hnmnactividad = hnmnactividad;
    }

    public Integer getHnmnactividad() {
        return hnmnactividad;
    }
}

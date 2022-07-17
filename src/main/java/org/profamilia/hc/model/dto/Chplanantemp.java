package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chplanantemp implements Serializable {

    /** identifier field */
    private Integer hptccodigo;

    /** nullable persistent field */
    private String hptcdescripci;

    /** nullable persistent field */
    private Integer hptnorden;

    /** nullable persistent field */
    private String hptcoperador;

    /** nullable persistent field */
    private Date hptdfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chplanantemp() {
    }


    public void setHptccodigo(Integer hptccodigo) {
        this.hptccodigo = hptccodigo;
    }

    public Integer getHptccodigo() {
        return hptccodigo;
    }

    public void setHptcdescripci(String hptcdescripci) {
        this.hptcdescripci = hptcdescripci;
    }

    public String getHptcdescripci() {
        return hptcdescripci;
    }

    public void setHptnorden(Integer hptnorden) {
        this.hptnorden = hptnorden;
    }

    public Integer getHptnorden() {
        return hptnorden;
    }

    public void setHptcoperador(String hptcoperador) {
        this.hptcoperador = hptcoperador;
    }

    public String getHptcoperador() {
        return hptcoperador;
    }

    public void setHptdfecregistr(Date hptdfecregistr) {
        this.hptdfecregistr = hptdfecregistr;
    }

    public Date getHptdfecregistr() {
        return hptdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

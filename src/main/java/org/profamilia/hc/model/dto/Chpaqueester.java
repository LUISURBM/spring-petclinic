package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chpaqueester implements Serializable {

    /** identifier field */
    private Integer hpencodigo;

    /** nullable persistent field */
    private String hpecdescripcio;

    /** nullable persistent field */
    private String hpecestado;

    /** nullable persistent field */
    private Date hpedfecregistr;

    /** nullable persistent field */
    private String hpecoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chpaqueester() {
    }


    /**
     * @param hpencodigo
     */
    public void setHpencodigo(Integer hpencodigo) {
        this.hpencodigo = hpencodigo;
    }

    /**
     * @return
     */
    public Integer getHpencodigo() {
        return hpencodigo;
    }

    /**
     * @param hpecdescripcio
     */
    public void setHpecdescripcio(String hpecdescripcio) {
        this.hpecdescripcio = hpecdescripcio;
    }

    /**
     * @return
     */
    public String getHpecdescripcio() {
        return hpecdescripcio;
    }

    /**
     * @param hpecestado
     */
    public void setHpecestado(String hpecestado) {
        this.hpecestado = hpecestado;
    }

    /**
     * @return
     */
    public String getHpecestado() {
        return hpecestado;
    }

    /**
     * @param hpedfecregistr
     */
    public void setHpedfecregistr(Date hpedfecregistr) {
        this.hpedfecregistr = hpedfecregistr;
    }

    /**
     * @return
     */
    public Date getHpedfecregistr() {
        return hpedfecregistr;
    }

    /**
     * @param hpecoperador
     */
    public void setHpecoperador(String hpecoperador) {
        this.hpecoperador = hpecoperador;
    }

    /**
     * @return
     */
    public String getHpecoperador() {
        return hpecoperador;
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
}

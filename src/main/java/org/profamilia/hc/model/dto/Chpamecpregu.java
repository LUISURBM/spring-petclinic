package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chpamecpregu implements Serializable {

    /** identifier field */
    private ChpamecpreguPK id;

    /** persistent field */
    private String hppcdescripcio;

    /** nullable persistent field */
    private String hppcestado;

    /** nullable persistent field */
    private Date hppdfecregistr;

    /** nullable persistent field */
    private String hppcoperador;

    /** nullable persistent field */
    private Integer version;



    /** default constructor */
    public Chpamecpregu() {
        id = new ChpamecpreguPK();
    }


    /**
     * @param id
     */
    public void setId(ChpamecpreguPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChpamecpreguPK getId() {
        return id;
    }

    /**
     * @param hppcdescripcio
     */
    public void setHppcdescripcio(String hppcdescripcio) {
        this.hppcdescripcio = hppcdescripcio;
    }

    /**
     * @return
     */
    public String getHppcdescripcio() {
        return hppcdescripcio;
    }

    /**
     * @param hppcestado
     */
    public void setHppcestado(String hppcestado) {
        this.hppcestado = hppcestado;
    }

    /**
     * @return
     */
    public String getHppcestado() {
        return hppcestado;
    }

    /**
     * @param hppdfecregistr
     */
    public void setHppdfecregistr(Date hppdfecregistr) {
        this.hppdfecregistr = hppdfecregistr;
    }

    /**
     * @return
     */
    public Date getHppdfecregistr() {
        return hppdfecregistr;
    }

    /**
     * @param hppcoperador
     */
    public void setHppcoperador(String hppcoperador) {
        this.hppcoperador = hppcoperador;
    }

    /**
     * @return
     */
    public String getHppcoperador() {
        return hppcoperador;
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

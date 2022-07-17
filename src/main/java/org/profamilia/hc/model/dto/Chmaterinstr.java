package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chmaterinstr implements Serializable {

    /** identifier field */
    private Integer hmincodigo;

    /** nullable persistent field */
    private String hmicdescripcio;

    /** nullable persistent field */
    private String hmicestado;

    /** nullable persistent field */
    private Date hmidfecregistr;

    /** nullable persistent field */
    private String hmicoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chmaterinstr() {
    }


    /**
     * @param hmincodigo
     */
    public void setHmincodigo(Integer hmincodigo) {
        this.hmincodigo = hmincodigo;
    }

    /**
     * @return
     */
    public Integer getHmincodigo() {
        return hmincodigo;
    }

    /**
     * @param hmicdescripcio
     */
    public void setHmicdescripcio(String hmicdescripcio) {
        this.hmicdescripcio = hmicdescripcio;
    }

    /**
     * @return
     */
    public String getHmicdescripcio() {
        return hmicdescripcio;
    }

    /**
     * @param hmicestado
     */
    public void setHmicestado(String hmicestado) {
        this.hmicestado = hmicestado;
    }

    /**
     * @return
     */
    public String getHmicestado() {
        return hmicestado;
    }

    /**
     * @param hmidfecregistr
     */
    public void setHmidfecregistr(Date hmidfecregistr) {
        this.hmidfecregistr = hmidfecregistr;
    }

    /**
     * @return
     */
    public Date getHmidfecregistr() {
        return hmidfecregistr;
    }

    /**
     * @param hmicoperador
     */
    public void setHmicoperador(String hmicoperador) {
        this.hmicoperador = hmicoperador;
    }

    /**
     * @return
     */
    public String getHmicoperador() {
        return hmicoperador;
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

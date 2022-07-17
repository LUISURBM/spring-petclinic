package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chmetodoplan implements Serializable {

    /** identifier field */
    private String hmpccodigo;

    /** nullable persistent field */
    private String hmpcdescripcio;
    
    /** nullable persistent field */
    private String hmpcsexoaplic; 

    /** nullable persistent field */
    private String hmpcoperador;

    /** nullable persistent field */
    private Date hmpdfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hmpcestado;


    /** default constructor */
    public Chmetodoplan() {
    }


    /**
     * @param hmpccodigo
     */
    public void setHmpccodigo(String hmpccodigo) {
        this.hmpccodigo = hmpccodigo;
    }

    /**
     * @return
     */
    public String getHmpccodigo() {
        return hmpccodigo;
    }

    /**
     * @param hmpcdescripcio
     */
    public void setHmpcdescripcio(String hmpcdescripcio) {
        this.hmpcdescripcio = hmpcdescripcio;
    }

    /**
     * @return
     */
    public String getHmpcdescripcio() {
        return hmpcdescripcio;
    }

    /**
     * @param hmpcsexoaplic
     */
    public void setHmpcsexoaplic(String hmpcsexoaplic) {
        this.hmpcsexoaplic = hmpcsexoaplic;
    }

    /**
     * @return
     */
    public String getHmpcsexoaplic() {
        return hmpcsexoaplic;
    }

    /**
     * @param hmpcoperador
     */
    public void setHmpcoperador(String hmpcoperador) {
        this.hmpcoperador = hmpcoperador;
    }

    /**
     * @return
     */
    public String getHmpcoperador() {
        return hmpcoperador;
    }

    /**
     * @param hmpdfecregistr
     */
    public void setHmpdfecregistr(Date hmpdfecregistr) {
        this.hmpdfecregistr = hmpdfecregistr;
    }

    /**
     * @return
     */
    public Date getHmpdfecregistr() {
        return hmpdfecregistr;
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


    public void setHmpcestado(String hmpcestado) {
        this.hmpcestado = hmpcestado;
    }

    public String getHmpcestado() {
        return hmpcestado;
    }
}

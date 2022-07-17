package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chinstrument implements Serializable {

    /** identifier field */
    private Long hinlcirugia;

    /** nullable persistent field */
    private String hincpaqueester;

    /** nullable persistent field */
    private String hincrealiconte;

    /** nullable persistent field */
    private String hincestado;

    /** nullable persistent field */
    private Date hindfecregistr;

    /** nullable persistent field */
    private String hincoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chinstrument() {
    }


    /**
     * @param hinlcirugia
     */
    public void setHinlcirugia(Long hinlcirugia) {
        this.hinlcirugia = hinlcirugia;
    }

    /**
     * @return
     */
    public Long getHinlcirugia() {
        return hinlcirugia;
    }

    /**
     * @param hincpaqueester
     */
    public void setHincpaqueester(String hincpaqueester) {
        this.hincpaqueester = hincpaqueester;
    }

    /**
     * @return
     */
    public String getHincpaqueester() {
        return hincpaqueester;
    }

    /**
     * @param hincrealiconte
     */
    public void setHincrealiconte(String hincrealiconte) {
        this.hincrealiconte = hincrealiconte;
    }

    /**
     * @return
     */
    public String getHincrealiconte() {
        return hincrealiconte;
    }

    /**
     * @param hincestado
     */
    public void setHincestado(String hincestado) {
        this.hincestado = hincestado;
    }

    /**
     * @return
     */
    public String getHincestado() {
        return hincestado;
    }

    /**
     * @param hindfecregistr
     */
    public void setHindfecregistr(Date hindfecregistr) {
        this.hindfecregistr = hindfecregistr;
    }

    /**
     * @return
     */
    public Date getHindfecregistr() {
        return hindfecregistr;
    }

    /**
     * @param hincoperador
     */
    public void setHincoperador(String hincoperador) {
        this.hincoperador = hincoperador;
    }

    /**
     * @return
     */
    public String getHincoperador() {
        return hincoperador;
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

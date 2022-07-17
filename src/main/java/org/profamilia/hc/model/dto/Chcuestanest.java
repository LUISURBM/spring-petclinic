package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcuestanest implements Serializable {

    /** identifier field */
    private ChcuestanestPK id;

    /** nullable persistent field */
    private Integer hcanpregunta;

    /** nullable persistent field */
    private String hcacrespuesta;

    /** nullable persistent field */
    private Date hcadfecregistr;

    /** nullable persistent field */
    private String hcacoperador;

    /** nullable persistent field */
    private String hcacanotacion;

    /** nullable persistent field */
    private String hcacobservacio;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chcuestanest() {
    }


    /**
     * @param id
     */
    public void setId(ChcuestanestPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcuestanestPK getId() {
        return id;
    }

    /**
     * @param hcanpregunta
     */
    public void setHcanpregunta(Integer hcanpregunta) {
        this.hcanpregunta = hcanpregunta;
    }

    /**
     * @return
     */
    public Integer getHcanpregunta() {
        return hcanpregunta;
    }

    /**
     * @param hcacrespuesta
     */
    public void setHcacrespuesta(String hcacrespuesta) {
        this.hcacrespuesta = hcacrespuesta;
    }

    /**
     * @return
     */
    public String getHcacrespuesta() {
        return hcacrespuesta;
    }

    /**
     * @param hcadfecregistr
     */
    public void setHcadfecregistr(Date hcadfecregistr) {
        this.hcadfecregistr = hcadfecregistr;
    }

    /**
     * @return
     */
    public Date getHcadfecregistr() {
        return hcadfecregistr;
    }

    /**
     * @param hcacoperador
     */
    public void setHcacoperador(String hcacoperador) {
        this.hcacoperador = hcacoperador;
    }

    /**
     * @return
     */
    public String getHcacoperador() {
        return hcacoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }


    /**
     * @param hcacanotacion
     */
    public void setHcacanotacion(String hcacanotacion) {
        this.hcacanotacion = hcacanotacion;
    }

    /**
     * @return
     */
    public String getHcacanotacion() {
        return hcacanotacion;
    }

    /**
     * @param hcacobservacio
     */
    public void setHcacobservacio(String hcacobservacio) {
        this.hcacobservacio = hcacobservacio;
    }

    /**
     * @return
     */
    public String getHcacobservacio() {
        return hcacobservacio;
    }
}

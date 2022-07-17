package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chvalorprean implements Serializable {

    /** identifier field */
    private ChvalorpreanPK id;

    /** nullable persistent field */
    private String hvpccirujano;

    /** nullable persistent field */
    private String hvpcintervenci;

    /** nullable persistent field */
    private Date hvpdfecregistr;

    /** nullable persistent field */
    private String hvpcoperador;
    
    /** nullable persistent field */
    private String hvpcinterpopue;
    
    

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chvalorprean() {
    }

    /**
     * @param id
     */
    public void setId(ChvalorpreanPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChvalorpreanPK getId() {
        return id;
    }

    /**
     * @param hvpccirujano
     */
    public void setHvpccirujano(String hvpccirujano) {
        this.hvpccirujano = hvpccirujano;
    }

    /**
     * @return
     */
    public String getHvpccirujano() {
        return hvpccirujano;
    }

    /**
     * @param hvpcintervenci
     */
    public void setHvpcintervenci(String hvpcintervenci) {
        this.hvpcintervenci = hvpcintervenci;
    }

    /**
     * @return
     */
    public String getHvpcintervenci() {
        return hvpcintervenci;
    }

    /**
     * @param hvpdfecregistr
     */
    public void setHvpdfecregistr(Date hvpdfecregistr) {
        this.hvpdfecregistr = hvpdfecregistr;
    }

    /**
     * @return
     */
    public Date getHvpdfecregistr() {
        return hvpdfecregistr;
    }

    /**
     * @param hvpcoperador
     */
    public void setHvpcoperador(String hvpcoperador) {
        this.hvpcoperador = hvpcoperador;
    }

    /**
     * @return
     */
    public String getHvpcoperador() {
        return hvpcoperador;
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

    public void setHvpcinterpopue(String hvpcinterpopue) {
        this.hvpcinterpopue = hvpcinterpopue;
    }

    public String getHvpcinterpopue() {
        return hvpcinterpopue;
    }
}

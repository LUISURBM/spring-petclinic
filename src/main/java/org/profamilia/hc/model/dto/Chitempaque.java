package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chitempaque implements Serializable {

    /** identifier field */
    private ChitempaquePK id;

    /** nullable persistent field */
    private String hipctipoester;

    /** nullable persistent field */
    private Date hipdfechaester;

    /** nullable persistent field */
    private Date hipdfechavenci;

    /** nullable persistent field */
    private Integer hipnnumercarga;

    /** nullable persistent field */
    private Integer hipnnumerauto;

    /** nullable persistent field */
    private String hipcindicquimi;
    
    
    private String descrindicquimi; 

    /** nullable persistent field */
    private String hipcdescripcio;

    /** nullable persistent field */
    private String hipcestado;

    /** nullable persistent field */
    private Date hipdfecregistr;

    /** nullable persistent field */
    private String hipcoperador;

    /** nullable persistent field */
    private Integer version;

   
    /** default constructor */
    public Chitempaque() {
        id = new ChitempaquePK(); 
    }


    /**
     * @param id
     */
    public void setId(ChitempaquePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChitempaquePK getId() {
        return id;
    }

    /**
     * @param hipctipoester
     */
    public void setHipctipoester(String hipctipoester) {
        this.hipctipoester = hipctipoester;
    }

    /**
     * @return
     */
    public String getHipctipoester() {
        return hipctipoester;
    }

    /**
     * @param hipdfechaester
     */
    public void setHipdfechaester(Date hipdfechaester) {
        this.hipdfechaester = hipdfechaester;
    }

    /**
     * @return
     */
    public Date getHipdfechaester() {
        return hipdfechaester;
    }

    /**
     * @param hipdfechavenci
     */
    public void setHipdfechavenci(Date hipdfechavenci) {
        this.hipdfechavenci = hipdfechavenci;
    }

    /**
     * @return
     */
    public Date getHipdfechavenci() {
        return hipdfechavenci;
    }

    /**
     * @param hipnnumercarga
     */
    public void setHipnnumercarga(Integer hipnnumercarga) {
        this.hipnnumercarga = hipnnumercarga;
    }

    /**
     * @return
     */
    public Integer getHipnnumercarga() {
        return hipnnumercarga;
    }

    /**
     * @param hipnnumerauto
     */
    public void setHipnnumerauto(Integer hipnnumerauto) {
        this.hipnnumerauto = hipnnumerauto;
    }

    /**
     * @return
     */
    public Integer getHipnnumerauto() {
        return hipnnumerauto;
    }

    /**
     * @param hipcindicquimi
     */
    public void setHipcindicquimi(String hipcindicquimi) {
        this.hipcindicquimi = hipcindicquimi;
    }

    /**
     * @return
     */
    public String getHipcindicquimi() {
        return hipcindicquimi;
    }

    /**
     * @param hipcdescripcio
     */
    public void setHipcdescripcio(String hipcdescripcio) {
        this.hipcdescripcio = hipcdescripcio;
    }

    /**
     * @return
     */
    public String getHipcdescripcio() {
        return hipcdescripcio;
    }

    /**
     * @param hipcestado
     */
    public void setHipcestado(String hipcestado) {
        this.hipcestado = hipcestado;
    }

    /**
     * @return
     */
    public String getHipcestado() {
        return hipcestado;
    }

    /**
     * @param hipdfecregistr
     */
    public void setHipdfecregistr(Date hipdfecregistr) {
        this.hipdfecregistr = hipdfecregistr;
    }

    /**
     * @return
     */
    public Date getHipdfecregistr() {
        return hipdfecregistr;
    }

    /**
     * @param hipcoperador
     */
    public void setHipcoperador(String hipcoperador) {
        this.hipcoperador = hipcoperador;
    }

    /**
     * @return
     */
    public String getHipcoperador() {
        return hipcoperador;
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

    public void setDescrindicquimi(String descrindicquimi) {
        this.descrindicquimi = descrindicquimi;
    }

    public String getDescrindicquimi() {
        descrindicquimi = ""; 
    if(hipcindicquimi != null){
        if(hipcindicquimi.equals("S")){
            descrindicquimi = "Si"; 
        }else if(hipcindicquimi.equals("N")){
            descrindicquimi = "No"; 
        }
    }
        return descrindicquimi;
    }
}

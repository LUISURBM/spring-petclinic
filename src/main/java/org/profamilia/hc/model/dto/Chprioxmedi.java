package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chprioxmedi implements Serializable {

    /** identifier field */
    private ChprioxmediPK id;

    /** persistent field */
    private String hpmcnombre;

    /** persistent field */
    private Long hpmacedula;

    /** persistent field */
    private String hpmcoperador;

    /** persistent field */
    private Date hpmdfecharegis;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chprioxmedi() {
    }


    /**
     * @param id
     */
    public void setId(ChprioxmediPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChprioxmediPK getId() {
        return id;
    }

    /**
     * @param hpmcoperador
     */
    public void setHpmcoperador(String hpmcoperador) {
        this.hpmcoperador = hpmcoperador;
    }

    /**
     * @return
     */
    public String getHpmcoperador() {
        return hpmcoperador;
    }

    /**
     * @param hpmdfecharegis
     */
    public void setHpmdfecharegis(Date hpmdfecharegis) {
        this.hpmdfecharegis = hpmdfecharegis;
    }

    /**
     * @return
     */
    public Date getHpmdfecharegis() {
        return hpmdfecharegis;
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

    /**
     * @param hpmcnombre
     */
    public void setHpmcnombre(String hpmcnombre) {
        this.hpmcnombre = hpmcnombre;
    }

    /**
     * @return
     */
    public String getHpmcnombre() {
        return hpmcnombre;
    }

    /**
     * @param hpmacedula
     */
    public void setHpmacedula(Long hpmacedula) {
        this.hpmacedula = hpmacedula;
    }

    /**
     * @return
     */
    public Long getHpmacedula() {
        return hpmacedula;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chitemmater implements Serializable {

    /** identifier field */
    private ChitemmaterPK id;

    /** nullable persistent field */
    private Integer himnprimeconte;

    /** nullable persistent field */
    private Integer himnadiciones;

    /** nullable persistent field */
    private Integer himnsegunconte;

    /** nullable persistent field */
    private String himcobservacio;

    /** nullable persistent field */
    private String himcestado;

    /** nullable persistent field */
    private Date himdfecregistr;

    /** nullable persistent field */
    private String himcoperador;

    /** nullable persistent field */
    private Integer version;



    /** default constructor */
    public Chitemmater() {
        id = new ChitemmaterPK(); 
    }


    /**
     * @param id
     */
    public void setId(ChitemmaterPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChitemmaterPK getId() {
        return id;
    }

    /**
     * @param himnprimeconte
     */
    public void setHimnprimeconte(Integer himnprimeconte) {
        this.himnprimeconte = himnprimeconte;
    }

    /**
     * @return
     */
    public Integer getHimnprimeconte() {
        return himnprimeconte;
    }

    /**
     * @param himnadiciones
     */
    public void setHimnadiciones(Integer himnadiciones) {
        this.himnadiciones = himnadiciones;
    }

    /**
     * @return
     */
    public Integer getHimnadiciones() {
        return himnadiciones;
    }

    /**
     * @param himnsegunconte
     */
    public void setHimnsegunconte(Integer himnsegunconte) {
        this.himnsegunconte = himnsegunconte;
    }

    /**
     * @return
     */
    public Integer getHimnsegunconte() {
        return himnsegunconte;
    }

    /**
     * @param himcobservacio
     */
    public void setHimcobservacio(String himcobservacio) {
        this.himcobservacio = himcobservacio;
    }

    /**
     * @return
     */
    public String getHimcobservacio() {
        return himcobservacio;
    }

    /**
     * @param himcestado
     */
    public void setHimcestado(String himcestado) {
        this.himcestado = himcestado;
    }

    /**
     * @return
     */
    public String getHimcestado() {
        return himcestado;
    }

    /**
     * @param himdfecregistr
     */
    public void setHimdfecregistr(Date himdfecregistr) {
        this.himdfecregistr = himdfecregistr;
    }

    /**
     * @return
     */
    public Date getHimdfecregistr() {
        return himdfecregistr;
    }

    /**
     * @param himcoperador
     */
    public void setHimcoperador(String himcoperador) {
        this.himcoperador = himcoperador;
    }

    /**
     * @return
     */
    public String getHimcoperador() {
        return himcoperador;
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

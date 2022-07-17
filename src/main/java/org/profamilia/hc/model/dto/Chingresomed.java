package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chingresomed implements Serializable {

    /** identifier field */
    private ChingresomedPK id;

    /** nullable persistent field */
    private Long himlusuario;

    /** nullable persistent field */
    private String himcintervenci;

    /** nullable persistent field */
    private String himcobservacio;

    /** nullable persistent field */
    private String himcalergias;

    /** nullable persistent field */
    private Date himdfecregistr;

    /** nullable persistent field */
    private String himcoperador;

    /** nullable persistent field */
    private String himcestado;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chingresomed() {
    }


    /**
     * @param id
     */
    public void setId(ChingresomedPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChingresomedPK getId() {
        return id;
    }

    /**
     * @param himlusuario
     */
    public void setHimlusuario(Long himlusuario) {
        this.himlusuario = himlusuario;
    }

    /**
     * @return
     */
    public Long getHimlusuario() {
        return himlusuario;
    }


    /**
     * @param himcintervenci
     */
    public void setHimcintervenci(String himcintervenci) {
        this.himcintervenci = himcintervenci;
    }

    /**
     * @return
     */
    public String getHimcintervenci() {
        return himcintervenci;
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
     * @param himcalergias
     */
    public void setHimcalergias(String himcalergias) {
        this.himcalergias = himcalergias;
    }

    /**
     * @return
     */
    public String getHimcalergias() {
        return himcalergias;
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
}

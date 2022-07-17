package org.profamilia.hc.model.dto;

import java.util.Date;


/**
 * Cptipocont generated by hbm2java
 */
public class Cptipocont implements java.io.Serializable {


    private Integer ctcnnumero;
    private String ctccdescri;
    private String ctccpagnom;
    private String ctccconnom;
    private Date ctcdfecreg;
    private Date ctcthorreg;
    private String ctccusuar;
    private String ctccestado;
    private String ctccdestaj;
    private String ctccporhor;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }
    // Constructors

    /** default constructor */
    public Cptipocont() {
    }

    /** constructor with id */
    public
    // HS == short


    Cptipocont(Integer ctcnnumero) {
        this.ctcnnumero = ctcnnumero;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public Integer getCtcnnumero() {
        return this.ctcnnumero;
    }

    public void setCtcnnumero(Integer ctcnnumero) {
        this.ctcnnumero = ctcnnumero;
    }


    public String getCtccdescri() {
        return this.ctccdescri;
    }

    public void setCtccdescri(String ctccdescri) {
        this.ctccdescri = ctccdescri;
    }


    public String getCtccpagnom() {
        return this.ctccpagnom;
    }

    public void setCtccpagnom(String ctccpagnom) {
        this.ctccpagnom = ctccpagnom;
    }


    public String getCtccconnom() {
        return this.ctccconnom;
    }

    public void setCtccconnom(String ctccconnom) {
        this.ctccconnom = ctccconnom;
    }


    public Date getCtcdfecreg() {
        return this.ctcdfecreg;
    }

    public void setCtcdfecreg(Date ctcdfecreg) {
        this.ctcdfecreg = ctcdfecreg;
    }


    public Date getCtcthorreg() {
        return this.ctcthorreg;
    }

    public void setCtcthorreg(Date ctcthorreg) {
        this.ctcthorreg = ctcthorreg;
    }


    public String getCtccusuar() {
        return this.ctccusuar;
    }

    public void setCtccusuar(String ctccusuar) {
        this.ctccusuar = ctccusuar;
    }


    public String getCtccestado() {
        return this.ctccestado;
    }

    public void setCtccestado(String ctccestado) {
        this.ctccestado = ctccestado;
    }


    public String getCtccdestaj() {
        return this.ctccdestaj;
    }

    public void setCtccdestaj(String ctccdestaj) {
        this.ctccdestaj = ctccdestaj;
    }

    public String getCtccporhor() {
        return this.ctccporhor;
    }

    public void setCtccporhor(String ctccporhor) {
        this.ctccporhor = ctccporhor;
    }


    // no tiene llave compuesta.


}

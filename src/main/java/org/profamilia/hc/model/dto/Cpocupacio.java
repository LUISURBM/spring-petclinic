package org.profamilia.hc.model.dto;

import java.util.Date;


/**
 * Cpocupacio generated by hbm2java
 */
public class

Cpocupacio implements java.io.Serializable {


    private Integer cocncodigo;
    private String coccdescri;
    private String coccusuari;
    private Date cocdfecreg;
    private String coccestado; 

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
    public Cpocupacio() {
    }

    /** constructor with id */
    public
    // HS == short


    Cpocupacio(Integer cocncodigo) {
        this.cocncodigo = cocncodigo;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public Integer getCocncodigo() {
        return this.cocncodigo;
    }

    public void setCocncodigo(Integer cocncodigo) {
        this.cocncodigo = cocncodigo;
    }


    public String getCoccdescri() {
        return this.coccdescri;
    }

    public void setCoccdescri(String coccdescri) {
        this.coccdescri = coccdescri;
    }


    public String getCoccusuari() {
        return this.coccusuari;
    }

    public void setCoccusuari(String coccusuari) {
        this.coccusuari = coccusuari;
    }


    public Date getCocdfecreg() {
        return this.cocdfecreg;
    }

    public void setCocdfecreg(Date cocdfecreg) {
        this.cocdfecreg = cocdfecreg;
    }


    // no tiene llave compuesta.


    /**
     * @param coccestado
     */
    public void setCoccestado(String coccestado) {
        this.coccestado = coccestado;
    }

    /**
     * @return
     */
    public String getCoccestado() {
        return coccestado;
    }
}

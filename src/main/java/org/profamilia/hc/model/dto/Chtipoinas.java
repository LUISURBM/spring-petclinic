package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chtipoinas implements Serializable {

    /** identifier field */
    private Integer htinnumero;

    /** persistent field */
    private String hticdescri;

    /** persistent field */
    private Date htidfecreg;

    /** persistent field */
    private String hticusuar;
    
    /** persistent field */
    private Integer  htindepen;

    /** persistent field */
    private String hticestado; 


    /** nullable persistent field */
    private Integer version;

   

    /** default constructor */
    public Chtipoinas() {
    }


    /**
     * @param htinnumero
     */
    public void setHtinnumero(Integer htinnumero) {
        this.htinnumero = htinnumero;
    }

    /**
     * @return
     */
    public Integer getHtinnumero() {
        return htinnumero;
    }

    /**
     * @param hticdescri
     */
    public void setHticdescri(String hticdescri) {
        this.hticdescri = hticdescri;
    }

    /**
     * @return
     */
    public String getHticdescri() {
        return hticdescri;
    }

    /**
     * @param htidfecreg
     */
    public void setHtidfecreg(Date htidfecreg) {
        this.htidfecreg = htidfecreg;
    }

    /**
     * @return
     */
    public Date getHtidfecreg() {
        return htidfecreg;
    }

    /**
     * @param hticusuar
     */
    public void setHticusuar(String hticusuar) {
        this.hticusuar = hticusuar;
    }

    /**
     * @return
     */
    public String getHticusuar() {
        return hticusuar;
    }

    /**
     * @param htindepen
     */
    public void setHtindepen(Integer htindepen) {
        this.htindepen = htindepen;
    }

    /**
     * @return
     */
    public Integer getHtindepen() {
        return htindepen;
    }

    /**
     * @param hticestado
     */
    public void setHticestado(String hticestado) {
        this.hticestado = hticestado;
    }

    /**
     * @return
     */
    public String getHticestado() {
        return hticestado;
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

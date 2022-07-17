package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Nlis */
public class Cptipoiden implements Serializable {

    /** identifier field */
    private String cticcodigo;

    /** nullable persistent field */
    private String cticdescri;

    /** nullable persistent field */
    private Date ctidfecreg;

    /** nullable persistent field */
    private String cticusuari;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Cptipoiden() {
    }

    /** default constructor with pk*/
    public Cptipoiden(String cticcodigo) {
        this.cticcodigo = cticcodigo;
    }


    public void setCticcodigo(String cticcodigo) {
        this.cticcodigo = cticcodigo;
    }

    public String getCticcodigo() {
        return cticcodigo;
    }

    public void setCticdescri(String cticdescri) {
        this.cticdescri = cticdescri;
    }

    public String getCticdescri() {
        return cticdescri;
    }

    public void setCtidfecreg(Date ctidfecreg) {
        this.ctidfecreg = ctidfecreg;
    }

    public Date getCtidfecreg() {
        return ctidfecreg;
    }

    public void setCticusuari(String cticusuari) {
        this.cticusuari = cticusuari;
    }

    public String getCticusuari() {
        return cticusuari;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

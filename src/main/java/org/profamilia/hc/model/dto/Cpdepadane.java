package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Nlis */
public class Cpdepadane implements Serializable {

    /** identifier field */
    private Integer cddncodigo;

    /** nullable persistent field */
    private String cddcdescri;

    /** nullable persistent field */
    private Date cdddfecreg;

    /** nullable persistent field */
    private String cddcusuari;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Cpdepadane() {
    }

    /** default constructor with pk*/
    public Cpdepadane(Integer cddncodigo) {
        this.cddncodigo = cddncodigo;
    }


    public void setCddncodigo(Integer cddncodigo) {
        this.cddncodigo = cddncodigo;
    }

    public Integer getCddncodigo() {
        return cddncodigo;
    }

    public void setCddcdescri(String cddcdescri) {
        this.cddcdescri = cddcdescri;
    }

    public String getCddcdescri() {
        return cddcdescri;
    }

    public void setCdddfecreg(Date cdddfecreg) {
        this.cdddfecreg = cdddfecreg;
    }

    public Date getCdddfecreg() {
        return cdddfecreg;
    }

    public void setCddcusuari(String cddcusuari) {
        this.cddcusuari = cddcusuari;
    }

    public String getCddcusuari() {
        return cddcusuari;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

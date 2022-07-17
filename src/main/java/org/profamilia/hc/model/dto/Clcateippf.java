package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Clcateippf implements Serializable {

    /** identifier field */
    private Integer ccincodigo;

    /** nullable persistent field */
    private String ccicdescri;

    /** nullable persistent field */
    private String ccicusuari;

    /** nullable persistent field */
    private Date ccidfeccre;

    /** full constructor */
    public Clcateippf(Integer ccincodigo, String ccicdescri, String ccicusuari, Date ccidfeccre) {
        this.ccincodigo = ccincodigo;
        this.ccicdescri = ccicdescri;
        this.ccicusuari = ccicusuari;
        this.ccidfeccre = ccidfeccre;
    }

    /** default constructor */
    public Clcateippf() {
    }

    /** minimal constructor */
    public Clcateippf(Integer ccincodigo) {
        this.ccincodigo = ccincodigo;
    }


    public void setCcincodigo(Integer ccincodigo) {
        this.ccincodigo = ccincodigo;
    }

    public Integer getCcincodigo() {
        return ccincodigo;
    }

    public void setCcicdescri(String ccicdescri) {
        this.ccicdescri = ccicdescri;
    }

    public String getCcicdescri() {
        return ccicdescri;
    }

    public void setCcicusuari(String ccicusuari) {
        this.ccicusuari = ccicusuari;
    }

    public String getCcicusuari() {
        return ccicusuari;
    }

    public void setCcidfeccre(Date ccidfeccre) {
        this.ccidfeccre = ccidfeccre;
    }

    public Date getCcidfeccre() {
        return ccidfeccre;
    }
}

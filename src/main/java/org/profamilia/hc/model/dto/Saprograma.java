package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Saprograma implements Serializable {

    /** identifier field */
    private String spgcnombre;

    /** persistent field */
    private String spgcdescri;

    /** nullable persistent field */
    private String spgcaplica;

    /** persistent field */
    private Date spgdfecing;

    /** persistent field */
    private String spgcetapa;

    /** nullable persistent field */
    private BigDecimal version;



    /** default constructor */
    public Saprograma() {
    }


    public String getSpgcnombre() {
        return this.spgcnombre;
    }

    public void setSpgcnombre(String spgcnombre) {
        this.spgcnombre = spgcnombre;
    }

    public String getSpgcdescri() {
        return this.spgcdescri;
    }

    public void setSpgcdescri(String spgcdescri) {
        this.spgcdescri = spgcdescri;
    }

    public String getSpgcaplica() {
        return this.spgcaplica;
    }

    public void setSpgcaplica(String spgcaplica) {
        this.spgcaplica = spgcaplica;
    }

    public Date getSpgdfecing() {
        return this.spgdfecing;
    }

    public void setSpgdfecing(Date spgdfecing) {
        this.spgdfecing = spgdfecing;
    }

    public String getSpgcetapa() {
        return this.spgcetapa;
    }

    public void setSpgcetapa(String spgcetapa) {
        this.spgcetapa = spgcetapa;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this).append("spgcnombre", 
                                                getSpgcnombre()).toString();
    }


}

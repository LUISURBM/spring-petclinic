package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chparavrqui implements Serializable {

    /** nullable persistent field */
    private Integer hpqnconsec;

    /** nullable persistent field */
    private String hpqcliteral;

    /** nullable persistent field */
    private Integer hpqnnumeral;

    /** nullable persistent field */
    private String hpqcdescri;

    /** nullable persistent field */
    private String hpqcanesgen;

    /** nullable persistent field */
    private String hpqcanesreg;

    /** nullable persistent field */
    private String hpqcanesloc;

    /** nullable persistent field */
    private String hpqcreganeste;

    /** nullable persistent field */
    private String hpqcnoaplica;

    /** nullable persistent field */
    private String hpqcestado;

    /** nullable persistent field */
    private Date hpqdfecreg;

    /** nullable persistent field */
    private String hpqcusureg;

    /** nullable persistent field */
    private Date hpqdfecmod;

    /** nullable persistent field */
    private String hpqcusumod;

    /** nullable persistent field */
    private String hpqcetapa;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chparavrqui() {
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHpqcdescri(String hpqcdescri) {
        this.hpqcdescri = hpqcdescri;
    }

    public String getHpqcdescri() {
        return hpqcdescri;
    }

    public void setHpqcreganeste(String hpqcreganeste) {
        this.hpqcreganeste = hpqcreganeste;
    }

    public String getHpqcreganeste() {
        return hpqcreganeste;
    }

    public void setHpqcnoaplica(String hpqcnoaplica) {
        this.hpqcnoaplica = hpqcnoaplica;
    }

    public String getHpqcnoaplica() {
        return hpqcnoaplica;
    }

    public void setHpqcestado(String hpqcestado) {
        this.hpqcestado = hpqcestado;
    }

    public String getHpqcestado() {
        return hpqcestado;
    }

    public void setHpqdfecreg(Date hpqdfecreg) {
        this.hpqdfecreg = hpqdfecreg;
    }

    public Date getHpqdfecreg() {
        return hpqdfecreg;
    }

    public void setHpqcusureg(String hpqcusureg) {
        this.hpqcusureg = hpqcusureg;
    }

    public String getHpqcusureg() {
        return hpqcusureg;
    }

    public void setHpqdfecmod(Date hpqdfecmod) {
        this.hpqdfecmod = hpqdfecmod;
    }

    public Date getHpqdfecmod() {
        return hpqdfecmod;
    }

    public void setHpqcusumod(String hpqcusumod) {
        this.hpqcusumod = hpqcusumod;
    }

    public String getHpqcusumod() {
        return hpqcusumod;
    }


    public void setHpqcanesgen(String hpqcanesgen) {
        this.hpqcanesgen = hpqcanesgen;
    }

    public String getHpqcanesgen() {
        return hpqcanesgen;
    }

    public void setHpqcanesreg(String hpqcanesreg) {
        this.hpqcanesreg = hpqcanesreg;
    }

    public String getHpqcanesreg() {
        return hpqcanesreg;
    }

    public void setHpqcanesloc(String hpqcanesloc) {
        this.hpqcanesloc = hpqcanesloc;
    }

    public String getHpqcanesloc() {
        return hpqcanesloc;
    }


    public void setHpqnconsec(Integer hpqnconsec) {
        this.hpqnconsec = hpqnconsec;
    }

    public Integer getHpqnconsec() {
        return hpqnconsec;
    }

    public void setHpqcliteral(String hpqcliteral) {
        this.hpqcliteral = hpqcliteral;
    }

    public String getHpqcliteral() {
        return hpqcliteral;
    }

    public void setHpqnnumeral(Integer hpqnnumeral) {
        this.hpqnnumeral = hpqnnumeral;
    }

    public Integer getHpqnnumeral() {
        return hpqnnumeral;
    }


    public void setHpqcetapa(String hpqcetapa) {
        this.hpqcetapa = hpqcetapa;
    }

    public String getHpqcetapa() {
        return hpqcetapa;
    }
}

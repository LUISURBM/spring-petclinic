package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chtecnianest implements Serializable {

    /** identifier field */
    private ChtecnianestPK id;

    /** nullable persistent field */
    private String htacanestlocal;

    /** nullable persistent field */
    private String htacanestgener;

    /** nullable persistent field */
    private String htacanestregio;

    /** nullable persistent field */
    private String htactiponeuroa;

    /** nullable persistent field */
    private String htacdescrproce;

    /** nullable persistent field */
    private String htacinducagent;

    /** nullable persistent field */
    private String htacmanteagent;

    /** nullable persistent field */
    private BigDecimal htanconcentrac;

    /** nullable persistent field */
    private BigDecimal htancambiconce;

    /** nullable persistent field */
    private String htacobservacio;

    /** nullable persistent field */
    private Integer htanclinica;

    /** nullable persistent field */
    private String htacoperador;

    /** nullable persistent field */
    private String htactipoanegen;

    /** nullable persistent field */
    private String htactipoanereg;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private BigDecimal htanoxigeno;

    /** nullable persistent field */
    private BigDecimal htanoxidonitro;

    /** nullable persistent field */
    private BigDecimal htanmanteconce;

    /** nullable persistent field */
    private String htaccambiconce;

    /** nullable persistent field */
    private Date htadfechininit;

    /** nullable persistent field */
    private Date htadfechfinnit;

    /** nullable persistent field */
    private Date htadfechacambi;

    /** nullable persistent field */
    private Date htadfecregistr;

    /** nullable persistent field */
    private Date htadfechfinoxi;

    /** nullable persistent field */
    private Date htadfechfininh;

    /** nullable persistent field */
    private Date htadfechiniinh;

    /** nullable persistent field */
    private Date htadfechinioxi;


    /** default constructor */
    public Chtecnianest() {
    }


    /**
     * @param id
     */
    public void setId(ChtecnianestPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChtecnianestPK getId() {
        return id;
    }


    /**
     * @param htactiponeuroa
     */
    public void setHtactiponeuroa(String htactiponeuroa) {
        this.htactiponeuroa = htactiponeuroa;
    }

    /**
     * @return
     */
    public String getHtactiponeuroa() {
        return htactiponeuroa;
    }

    /**
     * @param htacdescrproce
     */
    public void setHtacdescrproce(String htacdescrproce) {
        this.htacdescrproce = htacdescrproce;
    }

    /**
     * @return
     */
    public String getHtacdescrproce() {
        return htacdescrproce;
    }


    /**
     * @param htacinducagent
     */
    public void setHtacinducagent(String htacinducagent) {
        this.htacinducagent = htacinducagent;
    }

    /**
     * @return
     */
    public String getHtacinducagent() {
        return htacinducagent;
    }


    /**
     * @param htacmanteagent
     */
    public void setHtacmanteagent(String htacmanteagent) {
        this.htacmanteagent = htacmanteagent;
    }

    /**
     * @return
     */
    public String getHtacmanteagent() {
        return htacmanteagent;
    }

    /**
     * @param htanconcentrac
     */
    public void setHtanconcentrac(BigDecimal htanconcentrac) {
        this.htanconcentrac = htanconcentrac;
    }

    /**
     * @return
     */
    public BigDecimal getHtanconcentrac() {
        return htanconcentrac;
    }

    /**
     * @param htancambiconce
     */
    public void setHtancambiconce(BigDecimal htancambiconce) {
        this.htancambiconce = htancambiconce;
    }

    /**
     * @return
     */
    public BigDecimal getHtancambiconce() {
        return htancambiconce;
    }

    /**
     * @param htadfechacambi
     */
    public void setHtadfechacambi(Date htadfechacambi) {
        this.htadfechacambi = htadfechacambi;
    }

    /**
     * @return
     */
    public Date getHtadfechacambi() {
        return htadfechacambi;
    }

    /**
     * @param htacobservacio
     */
    public void setHtacobservacio(String htacobservacio) {
        this.htacobservacio = htacobservacio;
    }

    /**
     * @return
     */
    public String getHtacobservacio() {
        return htacobservacio;
    }

    /**
     * @param htanclinica
     */
    public void setHtanclinica(Integer htanclinica) {
        this.htanclinica = htanclinica;
    }

    /**
     * @return
     */
    public Integer getHtanclinica() {
        return htanclinica;
    }

    /**
     * @param htadfecregistr
     */
    public void setHtadfecregistr(Date htadfecregistr) {
        this.htadfecregistr = htadfecregistr;
    }

    /**
     * @return
     */
    public Date getHtadfecregistr() {
        return htadfecregistr;
    }

    /**
     * @param htacoperador
     */
    public void setHtacoperador(String htacoperador) {
        this.htacoperador = htacoperador;
    }

    /**
     * @return
     */
    public String getHtacoperador() {
        return htacoperador;
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
     * @param htacanestlocal
     */
    public void setHtacanestlocal(String htacanestlocal) {
        this.htacanestlocal = htacanestlocal;
    }

    /**
     * @return
     */
    public String getHtacanestlocal() {
        return htacanestlocal;
    }

    /**
     * @param htacanestgener
     */
    public void setHtacanestgener(String htacanestgener) {
        this.htacanestgener = htacanestgener;
    }

    /**
     * @return
     */
    public String getHtacanestgener() {
        return htacanestgener;
    }

    /**
     * @param htacanestregio
     */
    public void setHtacanestregio(String htacanestregio) {
        this.htacanestregio = htacanestregio;
    }

    /**
     * @return
     */
    public String getHtacanestregio() {
        return htacanestregio;
    }

    /**
     * @param htactipoanegen
     */
    public void setHtactipoanegen(String htactipoanegen) {
        this.htactipoanegen = htactipoanegen;
    }

    /**
     * @return
     */
    public String getHtactipoanegen() {
        return htactipoanegen;
    }

    /**
     * @param htactipoanereg
     */
    public void setHtactipoanereg(String htactipoanereg) {
        this.htactipoanereg = htactipoanereg;
    }

    /**
     * @return
     */
    public String getHtactipoanereg() {
        return htactipoanereg;
    }

    /**
     * @param htanoxigeno
     */
    public void setHtanoxigeno(BigDecimal htanoxigeno) {
        this.htanoxigeno = htanoxigeno;
    }

    /**
     * @return
     */
    public BigDecimal getHtanoxigeno() {
        return htanoxigeno;
    }

    /**
     * @param htanoxidonitro
     */
    public void setHtanoxidonitro(BigDecimal htanoxidonitro) {
        this.htanoxidonitro = htanoxidonitro;
    }

    /**
     * @return
     */
    public BigDecimal getHtanoxidonitro() {
        return htanoxidonitro;
    }

    /**
     * @param htanmanteconce
     */
    public void setHtanmanteconce(BigDecimal htanmanteconce) {
        this.htanmanteconce = htanmanteconce;
    }

    /**
     * @return
     */
    public BigDecimal getHtanmanteconce() {
        return htanmanteconce;
    }

    /**
     * @param htaccambiconce
     */
    public void setHtaccambiconce(String htaccambiconce) {
        this.htaccambiconce = htaccambiconce;
    }

    /**
     * @return
     */
    public String getHtaccambiconce() {
        return htaccambiconce;
    }

    /**
     * @param htadfechininit
     */
    public void setHtadfechininit(Date htadfechininit) {
        this.htadfechininit = htadfechininit;
    }

    /**
     * @return
     */
    public Date getHtadfechininit() {
        return htadfechininit;
    }

    /**
     * @param htadfechfinnit
     */
    public void setHtadfechfinnit(Date htadfechfinnit) {
        this.htadfechfinnit = htadfechfinnit;
    }

    /**
     * @return
     */
    public Date getHtadfechfinnit() {
        return htadfechfinnit;
    }

    /**
     * @param htadfechfinoxi
     */
    public void setHtadfechfinoxi(Date htadfechfinoxi) {
        this.htadfechfinoxi = htadfechfinoxi;
    }

    /**
     * @return
     */
    public Date getHtadfechfinoxi() {
        return htadfechfinoxi;
    }

    /**
     * @param htadfechfininh
     */
    public void setHtadfechfininh(Date htadfechfininh) {
        this.htadfechfininh = htadfechfininh;
    }

    /**
     * @return
     */
    public Date getHtadfechfininh() {
        return htadfechfininh;
    }

    /**
     * @param htadfechiniinh
     */
    public void setHtadfechiniinh(Date htadfechiniinh) {
        this.htadfechiniinh = htadfechiniinh;
    }

    /**
     * @return
     */
    public Date getHtadfechiniinh() {
        return htadfechiniinh;
    }

    /**
     * @param htadfechinioxi
     */
    public void setHtadfechinioxi(Date htadfechinioxi) {
        this.htadfechinioxi = htadfechinioxi;
    }

    /**
     * @return
     */
    public Date getHtadfechinioxi() {
        return htadfechinioxi;
    }
}

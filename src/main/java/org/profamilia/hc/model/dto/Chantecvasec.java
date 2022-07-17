package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantecvasec implements Serializable {

    /** identifier field */
    private Long havlconsulta;

    /** nullable persistent field */
    private String havcvaseante;

    /** nullable persistent field */
    private Integer havnvaseprev;

    /** nullable persistent field */
    private String havcrazoproc;

    /** nullable persistent field */
    private String havcrazocual;

    /** nullable persistent field */
    private Integer havnbiolpaci;

    /** nullable persistent field */
    private Integer havnbiolpare;

    /** nullable persistent field */
    private Integer havnbioljunt;

    /** nullable persistent field */
    private String havcmetoplan;

    /** nullable persistent field */
    private Date havdfecregistr;

    /** nullable persistent field */
    private String havcoperador;
    
    /** nullable persistent field */
    private String havcotrometo;

    /** nullable persistent field */
    private Integer version;

 
    /** default constructor */
    public Chantecvasec() {
    }


    public void setHavlconsulta(Long havlconsulta) {
        this.havlconsulta = havlconsulta;
    }

    public Long getHavlconsulta() {
        return havlconsulta;
    }

    public void setHavcvaseante(String havcvaseante) {
        this.havcvaseante = havcvaseante;
    }

    public String getHavcvaseante() {
        return havcvaseante;
    }

    public void setHavnvaseprev(Integer havnvaseprev) {
        this.havnvaseprev = havnvaseprev;
    }

    public Integer getHavnvaseprev() {
        return havnvaseprev;
    }

    public void setHavcrazoproc(String havcrazoproc) {
        this.havcrazoproc = havcrazoproc;
    }

    public String getHavcrazoproc() {
        return havcrazoproc;
    }

    public void setHavcrazocual(String havcrazocual) {
        this.havcrazocual = havcrazocual;
    }

    public String getHavcrazocual() {
        return havcrazocual;
    }

    public void setHavnbiolpaci(Integer havnbiolpaci) {
        this.havnbiolpaci = havnbiolpaci;
    }

    public Integer getHavnbiolpaci() {
        return havnbiolpaci;
    }

    public void setHavnbiolpare(Integer havnbiolpare) {
        this.havnbiolpare = havnbiolpare;
    }

    public Integer getHavnbiolpare() {
        return havnbiolpare;
    }

    public void setHavnbioljunt(Integer havnbioljunt) {
        this.havnbioljunt = havnbioljunt;
    }

    public Integer getHavnbioljunt() {
        return havnbioljunt;
    }

    public void setHavcmetoplan(String havcmetoplan) {
        this.havcmetoplan = havcmetoplan;
    }

    public String getHavcmetoplan() {
        return havcmetoplan;
    }

    public void setHavdfecregistr(Date havdfecregistr) {
        this.havdfecregistr = havdfecregistr;
    }

    public Date getHavdfecregistr() {
        return havdfecregistr;
    }

    public void setHavcoperador(String havcoperador) {
        this.havcoperador = havcoperador;
    }

    public String getHavcoperador() {
        return havcoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHavcotrometo(String havcotrometo) {
        this.havcotrometo = havcotrometo;
    }

    public String getHavcotrometo() {
        return havcotrometo;
    }
}

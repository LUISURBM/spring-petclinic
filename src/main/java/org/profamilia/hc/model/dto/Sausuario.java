package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Sausuario implements Serializable {

    /** identifier field */
    private String susclogin;

    /** persistent field */
    private String suscnombre;

    /** nullable persistent field */
    private String suscdescri;

    /** persistent field */
    private Date susdfecing;

    /** persistent field */
    private String suscgrulog;

    /** persistent field */
    private String suscprnout;

    /** persistent field */
    private String suscetapa;

    /** nullable persistent field */
    private Date susdfecfin;

    /** nullable persistent field */
    private String suscpath1;

    /** nullable persistent field */
    private String suscpath2;

    /** nullable persistent field */
    private String suscpath3;

    /** nullable persistent field */
    private BigDecimal version;

    /** nullable persistent field */
    private Integer susndiexp;

    /** full constructor */
    public Sausuario(String susclogin, String suscnombre, String suscdescri, 
                     Date susdfecing, String suscgrulog, String suscprnout, 
                     String suscetapa, Date susdfecfin, String suscpath1, 
                     String suscpath2, String suscpath3, BigDecimal version, 
                     Integer susndiexp) {
        this.susclogin = susclogin;
        this.suscnombre = suscnombre;
        this.suscdescri = suscdescri;
        this.susdfecing = susdfecing;
        this.suscgrulog = suscgrulog;
        this.suscprnout = suscprnout;
        this.suscetapa = suscetapa;
        this.susdfecfin = susdfecfin;
        this.suscpath1 = suscpath1;
        this.suscpath2 = suscpath2;
        this.suscpath3 = suscpath3;
        this.version = version;
        this.susndiexp = susndiexp;
    }

    /** default constructor */
    public Sausuario() {
    }

    /** minimal constructor */
    public Sausuario(String susclogin, String suscnombre, Date susdfecing, 
                     String suscgrulog, String suscprnout, String suscetapa) {
        this.susclogin = susclogin;
        this.suscnombre = suscnombre;
        this.susdfecing = susdfecing;
        this.suscgrulog = suscgrulog;
        this.suscprnout = suscprnout;
        this.suscetapa = suscetapa;
    }

    public String getSusclogin() {
        return this.susclogin;
    }

    public void setSusclogin(String susclogin) {
        this.susclogin = susclogin;
    }

    public String getSuscnombre() {
        return this.suscnombre;
    }

    public void setSuscnombre(String suscnombre) {
        this.suscnombre = suscnombre;
    }

    public String getSuscdescri() {
        return this.suscdescri;
    }

    public void setSuscdescri(String suscdescri) {
        this.suscdescri = suscdescri;
    }

    public Date getSusdfecing() {
        return this.susdfecing;
    }

    public void setSusdfecing(Date susdfecing) {
        this.susdfecing = susdfecing;
    }

    public String getSuscgrulog() {
        return this.suscgrulog;
    }

    public void setSuscgrulog(String suscgrulog) {
        this.suscgrulog = suscgrulog;
    }

    public String getSuscprnout() {
        return this.suscprnout;
    }

    public void setSuscprnout(String suscprnout) {
        this.suscprnout = suscprnout;
    }

    public String getSuscetapa() {
        return this.suscetapa;
    }

    public void setSuscetapa(String suscetapa) {
        this.suscetapa = suscetapa;
    }

    public Date getSusdfecfin() {
        return this.susdfecfin;
    }

    public void setSusdfecfin(Date susdfecfin) {
        this.susdfecfin = susdfecfin;
    }

    public String getSuscpath1() {
        return this.suscpath1;
    }

    public void setSuscpath1(String suscpath1) {
        this.suscpath1 = suscpath1;
    }

    public String getSuscpath2() {
        return this.suscpath2;
    }

    public void setSuscpath2(String suscpath2) {
        this.suscpath2 = suscpath2;
    }

    public String getSuscpath3() {
        return this.suscpath3;
    }

    public void setSuscpath3(String suscpath3) {
        this.suscpath3 = suscpath3;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public Integer getSusndiexp() {
        return this.susndiexp;
    }

    public void setSusndiexp(Integer susndiexp) {
        this.susndiexp = susndiexp;
    }

    public String toString() {
        return new ToStringBuilder(this).append("susclogin", 
                                                getSusclogin()).toString();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cplistprec implements Serializable {

    /** identifier field */
    private Long clpnnumero;

    /** persistent field */
    private String clpcdescri;

    /** nullable persistent field */
    private String clpcobserv;

    /** persistent field */
    private Date clpdfecini;

    /** persistent field */
    private Date clpdfecfin;

    /** persistent field */
    private String clpadescto;

    /** nullable persistent field */
    private Long clpnlistor;

    /** persistent field */
    private String clpdusumod;

    /** persistent field */
    private Date clpdfecmod;

    /** nullable persistent field */
    private Long version;

    /** persistent field */
    private String clpcestado;

    /** persistent field */
    private Long clpaincrem;

    /** full constructor */
    public Cplistprec(Long clpnnumero, String clpcdescri, String clpcobserv, Date clpdfecini, Date clpdfecfin, String clpadescto, Long clpnlistor, String clpdusumod, Date clpdfecmod, Long version, String clpcestado, Long clpaincrem) {
        this.clpnnumero = clpnnumero;
        this.clpcdescri = clpcdescri;
        this.clpcobserv = clpcobserv;
        this.clpdfecini = clpdfecini;
        this.clpdfecfin = clpdfecfin;
        this.clpadescto = clpadescto;
        this.clpnlistor = clpnlistor;
        this.clpdusumod = clpdusumod;
        this.clpdfecmod = clpdfecmod;
        this.version = version;
        this.clpcestado = clpcestado;
        this.clpaincrem = clpaincrem;
    }

    /** default constructor */
    public Cplistprec() {
    }

    /** minimal constructor */
    public Cplistprec(Long clpnnumero, String clpcdescri, Date clpdfecini, Date clpdfecfin, String clpadescto, String clpdusumod, Date clpdfecmod, String clpcestado, Long clpaincrem) {
        this.clpnnumero = clpnnumero;
        this.clpcdescri = clpcdescri;
        this.clpdfecini = clpdfecini;
        this.clpdfecfin = clpdfecfin;
        this.clpadescto = clpadescto;
        this.clpdusumod = clpdusumod;
        this.clpdfecmod = clpdfecmod;
        this.clpcestado = clpcestado;
        this.clpaincrem = clpaincrem;
    }

    public Long getClpnnumero() {
        return this.clpnnumero;
    }

    public void setClpnnumero(Long clpnnumero) {
        this.clpnnumero = clpnnumero;
    }

    public String getClpcdescri() {
        return this.clpcdescri;
    }

    public void setClpcdescri(String clpcdescri) {
        this.clpcdescri = clpcdescri;
    }

    public String getClpcobserv() {
        return this.clpcobserv;
    }

    public void setClpcobserv(String clpcobserv) {
        this.clpcobserv = clpcobserv;
    }

    public Date getClpdfecini() {
        return this.clpdfecini;
    }

    public void setClpdfecini(Date clpdfecini) {
        this.clpdfecini = clpdfecini;
    }

    public Date getClpdfecfin() {
        return this.clpdfecfin;
    }

    public void setClpdfecfin(Date clpdfecfin) {
        this.clpdfecfin = clpdfecfin;
    }

    public String getClpadescto() {
        return this.clpadescto;
    }

    public void setClpadescto(String clpadescto) {
        this.clpadescto = clpadescto;
    }

    public Long getClpnlistor() {
        return this.clpnlistor;
    }

    public void setClpnlistor(Long clpnlistor) {
        this.clpnlistor = clpnlistor;
    }

    public String getClpdusumod() {
        return this.clpdusumod;
    }

    public void setClpdusumod(String clpdusumod) {
        this.clpdusumod = clpdusumod;
    }

    public Date getClpdfecmod() {
        return this.clpdfecmod;
    }

    public void setClpdfecmod(Date clpdfecmod) {
        this.clpdfecmod = clpdfecmod;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getClpcestado() {
        return this.clpcestado;
    }

    public void setClpcestado(String clpcestado) {
        this.clpcestado = clpcestado;
    }

    public Long getClpaincrem() {
        return this.clpaincrem;
    }

    public void setClpaincrem(Long clpaincrem) {
        this.clpaincrem = clpaincrem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("clpnnumero", getClpnnumero())
            .toString();
    }

}

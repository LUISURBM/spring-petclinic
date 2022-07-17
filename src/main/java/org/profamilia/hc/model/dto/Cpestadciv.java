package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpestadciv implements Serializable {

    /** identifier field */
    private String cecccodigo;

    /** persistent field */
    private String ceccdescri;

    /** persistent field */
    private String ceccestado;

    /** persistent field */
    private String ceccusuari;

    /** persistent field */
    private Date cecdfecreg;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Cpestadciv(String cecccodigo, String ceccdescri, String ceccestado, String ceccusuari, Date cecdfecreg, Integer version) {
        this.cecccodigo = cecccodigo;
        this.ceccdescri = ceccdescri;
        this.ceccestado = ceccestado;
        this.ceccusuari = ceccusuari;
        this.cecdfecreg = cecdfecreg;
        this.version = version;
    }

    /** default constructor */
    public Cpestadciv() {
    }

    /** minimal constructor */
    public Cpestadciv(String cecccodigo, String ceccdescri, String ceccestado, String ceccusuari, Date cecdfecreg) {
        this.cecccodigo = cecccodigo;
        this.ceccdescri = ceccdescri;
        this.ceccestado = ceccestado;
        this.ceccusuari = ceccusuari;
        this.cecdfecreg = cecdfecreg;
    }

    public String getCecccodigo() {
        return this.cecccodigo;
    }

    public void setCecccodigo(String cecccodigo) {
        this.cecccodigo = cecccodigo;
    }

    public String getCeccdescri() {
        return this.ceccdescri;
    }

    public void setCeccdescri(String ceccdescri) {
        this.ceccdescri = ceccdescri;
    }

    public String getCeccestado() {
        return this.ceccestado;
    }

    public void setCeccestado(String ceccestado) {
        this.ceccestado = ceccestado;
    }

    public String getCeccusuari() {
        return this.ceccusuari;
    }

    public void setCeccusuari(String ceccusuari) {
        this.ceccusuari = ceccusuari;
    }

    public Date getCecdfecreg() {
        return this.cecdfecreg;
    }

    public void setCecdfecreg(Date cecdfecreg) {
        this.cecdfecreg = cecdfecreg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cecccodigo", getCecccodigo())
            .toString();
    }

}

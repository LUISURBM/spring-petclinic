package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Sapermiso implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.SapermisoPK comp_id;

    /** persistent field */
    private Date spmdfecdef;

    /** nullable persistent field */
    private Date spmdfecfin;

    /** nullable persistent field */
    private BigDecimal version;

    /** nullable persistent field */
    private String spmcoperac;

    /** nullable persistent field */
    private org.profamilia.hc.model.dto.Saprograma saprograma;

    /** full constructor */
    public Sapermiso(org.profamilia.hc.model.dto.SapermisoPK comp_id, 
                     Date spmdfecdef, Date spmdfecfin, BigDecimal version, 
                     String spmcoperac) {
        this.comp_id = comp_id;
        this.spmdfecdef = spmdfecdef;
        this.spmdfecfin = spmdfecfin;
        this.version = version;
        this.spmcoperac = spmcoperac;
    }

    /** default constructor */
    public Sapermiso() {
    }

    /** minimal constructor */
    public Sapermiso(org.profamilia.hc.model.dto.SapermisoPK comp_id, 
                     Date spmdfecdef) {
        this.comp_id = comp_id;
        this.spmdfecdef = spmdfecdef;
    }

    public org.profamilia.hc.model.dto.SapermisoPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.SapermisoPK comp_id) {
        this.comp_id = comp_id;
    }

    public Date getSpmdfecdef() {
        return this.spmdfecdef;
    }

    public void setSpmdfecdef(Date spmdfecdef) {
        this.spmdfecdef = spmdfecdef;
    }

    public Date getSpmdfecfin() {
        return this.spmdfecfin;
    }

    public void setSpmdfecfin(Date spmdfecfin) {
        this.spmdfecfin = spmdfecfin;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getSpmcoperac() {
        return this.spmcoperac;
    }

    public void setSpmcoperac(String spmcoperac) {
        this.spmcoperac = spmcoperac;
    }

    public String toString() {
        return new ToStringBuilder(this).append("comp_id", 
                                                getComp_id()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof Sapermiso))
            return false;
        Sapermiso castOther = (Sapermiso)other;
        return new EqualsBuilder().append(this.getComp_id(), 
                                          castOther.getComp_id()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getComp_id()).toHashCode();
    }

    public void setSaprograma(Saprograma saprograma) {
        this.saprograma = saprograma;
    }

    public Saprograma getSaprograma() {
        return saprograma;
    }
}

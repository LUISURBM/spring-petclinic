package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpdetalipr implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CpdetaliprPK comp_id;

    /** persistent field */
    private String cdlcswpaqu;

    /** persistent field */
    private Double cdlavalser;

    /** persistent field */
    private Double cdlavaldsc;

    /** persistent field */
    private String cdlcestado;

    /** persistent field */
    private String cdldusumod;

    /** persistent field */
    private Date cdldfecmod;

    /** nullable persistent field */
    private Long version;

    /** full constructor */
    public Cpdetalipr(org.profamilia.hc.model.dto.CpdetaliprPK comp_id, String cdlcswpaqu, Double cdlavalser, Double cdlavaldsc, String cdlcestado, String cdldusumod, Date cdldfecmod, Long version) {
        this.comp_id = comp_id;
        this.cdlcswpaqu = cdlcswpaqu;
        this.cdlavalser = cdlavalser;
        this.cdlavaldsc = cdlavaldsc;
        this.cdlcestado = cdlcestado;
        this.cdldusumod = cdldusumod;
        this.cdldfecmod = cdldfecmod;
        this.version = version;
    }

    /** default constructor */
    public Cpdetalipr() {
    }

    /** minimal constructor */
    public Cpdetalipr(org.profamilia.hc.model.dto.CpdetaliprPK comp_id, String cdlcswpaqu, Double cdlavalser, Double cdlavaldsc, String cdlcestado, String cdldusumod, Date cdldfecmod) {
        this.comp_id = comp_id;
        this.cdlcswpaqu = cdlcswpaqu;
        this.cdlavalser = cdlavalser;
        this.cdlavaldsc = cdlavaldsc;
        this.cdlcestado = cdlcestado;
        this.cdldusumod = cdldusumod;
        this.cdldfecmod = cdldfecmod;
    }

    public org.profamilia.hc.model.dto.CpdetaliprPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CpdetaliprPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCdlcswpaqu() {
        return this.cdlcswpaqu;
    }

    public void setCdlcswpaqu(String cdlcswpaqu) {
        this.cdlcswpaqu = cdlcswpaqu;
    }

    public Double getCdlavalser() {
        return this.cdlavalser;
    }

    public void setCdlavalser(Double cdlavalser) {
        this.cdlavalser = cdlavalser;
    }

    public Double getCdlavaldsc() {
        return this.cdlavaldsc;
    }

    public void setCdlavaldsc(Double cdlavaldsc) {
        this.cdlavaldsc = cdlavaldsc;
    }

    public String getCdlcestado() {
        return this.cdlcestado;
    }

    public void setCdlcestado(String cdlcestado) {
        this.cdlcestado = cdlcestado;
    }

    public String getCdldusumod() {
        return this.cdldusumod;
    }

    public void setCdldusumod(String cdldusumod) {
        this.cdldusumod = cdldusumod;
    }

    public Date getCdldfecmod() {
        return this.cdldfecmod;
    }

    public void setCdldfecmod(Date cdldfecmod) {
        this.cdldfecmod = cdldfecmod;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cpdetalipr) ) return false;
        Cpdetalipr castOther = (Cpdetalipr) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

}

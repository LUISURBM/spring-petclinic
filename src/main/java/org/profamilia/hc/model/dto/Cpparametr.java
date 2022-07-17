package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpparametr implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CpparametrPK comp_id;

    /** persistent field */
    private String cpcdescrip;

    /** persistent field */
    private String cpcvalor;

    /** persistent field */
    private String cpcestado;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Cpparametr(org.profamilia.hc.model.dto.CpparametrPK comp_id, String cpcdescrip, String cpcvalor, String cpcestado, Integer version) {
        this.comp_id = comp_id;
        this.cpcdescrip = cpcdescrip;
        this.cpcvalor = cpcvalor;
        this.cpcestado = cpcestado;
        this.version = version;
    }

    /** default constructor */
    public Cpparametr() {
    }

    /** minimal constructor */
    public Cpparametr(org.profamilia.hc.model.dto.CpparametrPK comp_id, String cpcdescrip, String cpcvalor, String cpcestado) {
        this.comp_id = comp_id;
        this.cpcdescrip = cpcdescrip;
        this.cpcvalor = cpcvalor;
        this.cpcestado = cpcestado;
    }

    public org.profamilia.hc.model.dto.CpparametrPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CpparametrPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCpcdescrip() {
        return this.cpcdescrip;
    }

    public void setCpcdescrip(String cpcdescrip) {
        this.cpcdescrip = cpcdescrip;
    }

    public String getCpcvalor() {
        return this.cpcvalor;
    }

    public void setCpcvalor(String cpcvalor) {
        this.cpcvalor = cpcvalor;
    }

    public String getCpcestado() {
        return this.cpcestado;
    }

    public void setCpcestado(String cpcestado) {
        this.cpcestado = cpcestado;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cpparametr) ) return false;
        Cpparametr castOther = (Cpparametr) other;
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

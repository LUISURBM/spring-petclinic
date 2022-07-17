package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChconfiserviPK implements Serializable {

    /** identifier field */
    private Long hcslconsulta;

    /** identifier field */
    private String hcsctiposervi;

    /** full constructor */
    public ChconfiserviPK(Long hcslconsulta, String hcsctiposervi) {
        this.hcslconsulta = hcslconsulta;
        this.hcsctiposervi = hcsctiposervi;
    }

    /** default constructor */
    public ChconfiserviPK() {
    }

    public Long getHcslconsulta() {
        return this.hcslconsulta;
    }

    public void setHcslconsulta(Long hcslconsulta) {
        this.hcslconsulta = hcslconsulta;
    }

    public String getHcsctiposervi() {
        return this.hcsctiposervi;
    }

    public void setHcsctiposervi(String hcsctiposervi) {
        this.hcsctiposervi = hcsctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcslconsulta", getHcslconsulta())
            .append("hcsctiposervi", getHcsctiposervi())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChconfiserviPK) ) return false;
        ChconfiserviPK castOther = (ChconfiserviPK) other;
        return new EqualsBuilder()
            .append(this.getHcslconsulta(), castOther.getHcslconsulta())
            .append(this.getHcsctiposervi(), castOther.getHcsctiposervi())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHcslconsulta())
            .append(getHcsctiposervi())
            .toHashCode();
    }

}

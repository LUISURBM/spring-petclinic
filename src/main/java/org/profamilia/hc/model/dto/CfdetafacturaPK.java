package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CfdetafacturaPK implements Serializable {

    /** identifier field */
    private Long cdfnnumitem;

    /** identifier field */
    private Long cdfnconsfact;

    /** full constructor */
    public CfdetafacturaPK(Long cdfnnumitem, Long cdfnconsfact) {
        this.cdfnnumitem = cdfnnumitem;
        this.cdfnconsfact = cdfnconsfact;
    }

    /** default constructor */
    public CfdetafacturaPK() {
    }

    public Long getCdfnnumitem() {
        return this.cdfnnumitem;
    }

    public void setCdfnnumitem(Long cdfnnumitem) {
        this.cdfnnumitem = cdfnnumitem;
    }

    public Long getCdfnconsfact() {
        return this.cdfnconsfact;
    }

    public void setCdfnconsfact(Long cdfnconsfact) {
        this.cdfnconsfact = cdfnconsfact;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdfnnumitem", getCdfnnumitem())
            .append("cdfnconsfact", getCdfnconsfact())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CfdetafacturaPK) ) return false;
        CfdetafacturaPK castOther = (CfdetafacturaPK) other;
        return new EqualsBuilder()
            .append(this.getCdfnnumitem(), castOther.getCdfnnumitem())
            .append(this.getCdfnconsfact(), castOther.getCdfnconsfact())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdfnnumitem())
            .append(getCdfnconsfact())
            .toHashCode();
    }

}

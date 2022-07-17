package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CtwsdetsolentPK implements Serializable {

    /** identifier field */
    private Long cdsennumero;

    /** identifier field */
    private Integer cdsenitem;

    /** full constructor */
    public CtwsdetsolentPK(Long cdsennumero, Integer cdsenitem) {
        this.cdsennumero = cdsennumero;
        this.cdsenitem = cdsenitem;
    }

    /** default constructor */
    public CtwsdetsolentPK() {
    }

    public Long getCdsennumero() {
        return this.cdsennumero;
    }

    public void setCdsennumero(Long cdsennumero) {
        this.cdsennumero = cdsennumero;
    }

    public Integer getCdsenitem() {
        return this.cdsenitem;
    }

    public void setCdsenitem(Integer cdsenitem) {
        this.cdsenitem = cdsenitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdsennumero", getCdsennumero())
            .append("cdsenitem", getCdsenitem())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CtwsdetsolentPK) ) return false;
        CtwsdetsolentPK castOther = (CtwsdetsolentPK) other;
        return new EqualsBuilder()
            .append(this.getCdsennumero(), castOther.getCdsennumero())
            .append(this.getCdsenitem(), castOther.getCdsenitem())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdsennumero())
            .append(getCdsenitem())
            .toHashCode();
    }

}

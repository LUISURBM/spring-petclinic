package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpcontratoPK implements Serializable {

    /** identifier field */
    private Long ccnnclinic;

    /** identifier field */
    private Long ccnnnumero;

    /** full constructor */
    public CpcontratoPK(Long ccnnclinic, Long ccnnnumero) {
        this.ccnnclinic = ccnnclinic;
        this.ccnnnumero = ccnnnumero;
    }

    /** default constructor */
    public CpcontratoPK() {
    }

    public Long getCcnnclinic() {
        return this.ccnnclinic;
    }

    public void setCcnnclinic(Long ccnnclinic) {
        this.ccnnclinic = ccnnclinic;
    }

    public Long getCcnnnumero() {
        return this.ccnnnumero;
    }

    public void setCcnnnumero(Long ccnnnumero) {
        this.ccnnnumero = ccnnnumero;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccnnclinic", getCcnnclinic())
            .append("ccnnnumero", getCcnnnumero())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpcontratoPK) ) return false;
        CpcontratoPK castOther = (CpcontratoPK) other;
        return new EqualsBuilder()
            .append(this.getCcnnclinic(), castOther.getCcnnclinic())
            .append(this.getCcnnnumero(), castOther.getCcnnnumero())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcnnclinic())
            .append(getCcnnnumero())
            .toHashCode();
    }

}

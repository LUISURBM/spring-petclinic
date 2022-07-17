package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CfdetapagoPK implements Serializable {

    /** identifier field */
    private Long cdpncodigo;

    /** identifier field */
    private Long cdpncodadm;

    /** full constructor */
    public CfdetapagoPK(Long cdpncodigo, Long cdpncodadm) {
        this.cdpncodigo = cdpncodigo;
        this.cdpncodadm = cdpncodadm;
    }

    /** default constructor */
    public CfdetapagoPK() {
    }

    public Long getCdpncodigo() {
        return this.cdpncodigo;
    }

    public void setCdpncodigo(Long cdpncodigo) {
        this.cdpncodigo = cdpncodigo;
    }

    public Long getCdpncodadm() {
        return this.cdpncodadm;
    }

    public void setCdpncodadm(Long cdpncodadm) {
        this.cdpncodadm = cdpncodadm;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdpncodigo", getCdpncodigo())
            .append("cdpncodadm", getCdpncodadm())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CfdetapagoPK) ) return false;
        CfdetapagoPK castOther = (CfdetapagoPK) other;
        return new EqualsBuilder()
            .append(this.getCdpncodigo(), castOther.getCdpncodigo())
            .append(this.getCdpncodadm(), castOther.getCdpncodadm())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdpncodigo())
            .append(getCdpncodadm())
            .toHashCode();
    }

}

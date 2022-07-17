package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CfdetaadmisionPK implements Serializable {

    /** identifier field */
    private Long cdannumadm;

    /** identifier field */
    private Long cdanconsec;

    /** full constructor */
    public CfdetaadmisionPK(Long cdannumadm, Long cdanconsec) {
        this.cdannumadm = cdannumadm;
        this.cdanconsec = cdanconsec;
    }

    /** default constructor */
    public CfdetaadmisionPK() {
    }

    public Long getCdannumadm() {
        return this.cdannumadm;
    }

    public void setCdannumadm(Long cdannumadm) {
        this.cdannumadm = cdannumadm;
    }

    public Long getCdanconsec() {
        return this.cdanconsec;
    }

    public void setCdanconsec(Long cdanconsec) {
        this.cdanconsec = cdanconsec;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdannumadm", getCdannumadm())
            .append("cdanconsec", getCdanconsec())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CfdetaadmisionPK) ) return false;
        CfdetaadmisionPK castOther = (CfdetaadmisionPK) other;
        return new EqualsBuilder()
            .append(this.getCdannumadm(), castOther.getCdannumadm())
            .append(this.getCdanconsec(), castOther.getCdanconsec())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdannumadm())
            .append(getCdanconsec())
            .toHashCode();
    }

}

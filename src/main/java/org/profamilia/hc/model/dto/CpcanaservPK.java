package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpcanaservPK implements Serializable {

    /** identifier field */
    private String ccsccanasta;

    /** identifier field */
    private String ccscservic;

    /** full constructor */
    public CpcanaservPK(String ccsccanasta, String ccscservic) {
        this.ccsccanasta = ccsccanasta;
        this.ccscservic = ccscservic;
    }

    /** default constructor */
    public CpcanaservPK() {
    }

    public String getCcsccanasta() {
        return this.ccsccanasta;
    }

    public void setCcsccanasta(String ccsccanasta) {
        this.ccsccanasta = ccsccanasta;
    }

    public String getCcscservic() {
        return this.ccscservic;
    }

    public void setCcscservic(String ccscservic) {
        this.ccscservic = ccscservic;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("ccsccanasta", getCcsccanasta())
            .append("ccscservic", getCcscservic())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpcanaservPK) ) return false;
        CpcanaservPK castOther = (CpcanaservPK) other;
        return new EqualsBuilder()
            .append(this.getCcsccanasta(), castOther.getCcsccanasta())
            .append(this.getCcscservic(), castOther.getCcscservic())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCcsccanasta())
            .append(getCcscservic())
            .toHashCode();
    }

}

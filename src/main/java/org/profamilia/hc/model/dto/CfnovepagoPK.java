package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CfnovepagoPK implements Serializable {

    /** identifier field */
    private Long cnpnnovedad;

    /** identifier field */
    private Long cnpnitem;

    /** full constructor */
    public CfnovepagoPK(Long cnpnnovedad, Long cnpnitem) {
        this.cnpnnovedad = cnpnnovedad;
        this.cnpnitem = cnpnitem;
    }

    /** default constructor */
    public CfnovepagoPK() {
    }

    public Long getCnpnnovedad() {
        return this.cnpnnovedad;
    }

    public void setCnpnnovedad(Long cnpnnovedad) {
        this.cnpnnovedad = cnpnnovedad;
    }

    public Long getCnpnitem() {
        return this.cnpnitem;
    }

    public void setCnpnitem(Long cnpnitem) {
        this.cnpnitem = cnpnitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cnpnnovedad", getCnpnnovedad())
            .append("cnpnitem", getCnpnitem())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CfnovepagoPK) ) return false;
        CfnovepagoPK castOther = (CfnovepagoPK) other;
        return new EqualsBuilder()
            .append(this.getCnpnnovedad(), castOther.getCnpnnovedad())
            .append(this.getCnpnitem(), castOther.getCnpnitem())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCnpnnovedad())
            .append(getCnpnitem())
            .toHashCode();
    }

}

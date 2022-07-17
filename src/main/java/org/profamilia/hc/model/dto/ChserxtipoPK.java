package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChserxtipoPK implements Serializable {

    /** identifier field */
    private Integer hstncoditipo;

    /** identifier field */
    private String hstccodiserv;

    /** full constructor */
    public ChserxtipoPK(Integer hstncoditipo, String hstccodiserv) {
        this.hstncoditipo = hstncoditipo;
        this.hstccodiserv = hstccodiserv;
    }

    /** default constructor */
    public ChserxtipoPK() {
    }

    public Integer getHstncoditipo() {
        return this.hstncoditipo;
    }

    public void setHstncoditipo(Integer hstncoditipo) {
        this.hstncoditipo = hstncoditipo;
    }

    public String getHstccodiserv() {
        return this.hstccodiserv;
    }

    public void setHstccodiserv(String hstccodiserv) {
        this.hstccodiserv = hstccodiserv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hstncoditipo", getHstncoditipo())
            .append("hstccodiserv", getHstccodiserv())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChserxtipoPK) ) return false;
        ChserxtipoPK castOther = (ChserxtipoPK) other;
        return new EqualsBuilder()
            .append(this.getHstncoditipo(), castOther.getHstncoditipo())
            .append(this.getHstccodiserv(), castOther.getHstccodiserv())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHstncoditipo())
            .append(getHstccodiserv())
            .toHashCode();
    }

}

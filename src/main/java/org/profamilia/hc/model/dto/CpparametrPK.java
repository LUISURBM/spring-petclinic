package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpparametrPK implements Serializable {

    /** identifier field */
    private String cpccampo;

    /** identifier field */
    private Integer cpnconsec;

    /** full constructor */
    public CpparametrPK(String cpccampo, Integer cpnconsec) {
        this.cpccampo = cpccampo;
        this.cpnconsec = cpnconsec;
    }

    /** default constructor */
    public CpparametrPK() {
    }

    public String getCpccampo() {
        return this.cpccampo;
    }

    public void setCpccampo(String cpccampo) {
        this.cpccampo = cpccampo;
    }

    public Integer getCpnconsec() {
        return this.cpnconsec;
    }

    public void setCpnconsec(Integer cpnconsec) {
        this.cpnconsec = cpnconsec;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpccampo", getCpccampo())
            .append("cpnconsec", getCpnconsec())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpparametrPK) ) return false;
        CpparametrPK castOther = (CpparametrPK) other;
        return new EqualsBuilder()
            .append(this.getCpccampo(), castOther.getCpccampo())
            .append(this.getCpnconsec(), castOther.getCpnconsec())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCpccampo())
            .append(getCpnconsec())
            .toHashCode();
    }

}

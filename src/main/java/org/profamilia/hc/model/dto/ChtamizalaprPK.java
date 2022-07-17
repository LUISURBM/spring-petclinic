package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChtamizalaprPK implements Serializable {

    /** identifier field */
    private Long htllconsulta;

    /** identifier field */
    private String htlctiposervi;

    /** full constructor */
    public ChtamizalaprPK(Long htllconsulta, String htlctiposervi) {
        this.htllconsulta = htllconsulta;
        this.htlctiposervi = htlctiposervi;
    }

    /** default constructor */
    public ChtamizalaprPK() {
    }

    public Long getHtllconsulta() {
        return this.htllconsulta;
    }

    public void setHtllconsulta(Long htllconsulta) {
        this.htllconsulta = htllconsulta;
    }

    public String getHtlctiposervi() {
        return this.htlctiposervi;
    }

    public void setHtlctiposervi(String htlctiposervi) {
        this.htlctiposervi = htlctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("htllconsulta", 
                                                getHtllconsulta()).append("htlctiposervi", 
                                                                          getHtlctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChtamizalaprPK))
            return false;
        ChtamizalaprPK castOther = (ChtamizalaprPK)other;
        return new EqualsBuilder().append(this.getHtllconsulta(), 
                                          castOther.getHtllconsulta()).append(this.getHtlctiposervi(), 
                                                                              castOther.getHtlctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHtllconsulta()).append(getHtlctiposervi()).toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChanteginecoPK implements Serializable {

    /** identifier field */
    private Long haglconsulta;

    /** identifier field */
    private String hagctiposervi;

    /** full constructor */
    public ChanteginecoPK(Long haglconsulta, String hagctiposervi) {
        this.haglconsulta = haglconsulta;
        this.hagctiposervi = hagctiposervi;
    }

    /** default constructor */
    public ChanteginecoPK() {
    }

    public Long getHaglconsulta() {
        return this.haglconsulta;
    }

    public void setHaglconsulta(Long haglconsulta) {
        this.haglconsulta = haglconsulta;
    }

    public String getHagctiposervi() {
        return this.hagctiposervi;
    }

    public void setHagctiposervi(String hagctiposervi) {
        this.hagctiposervi = hagctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("haglconsulta", 
                                                getHaglconsulta()).append("hagctiposervi", 
                                                                          getHagctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChanteginecoPK))
            return false;
        ChanteginecoPK castOther = (ChanteginecoPK)other;
        return new EqualsBuilder().append(this.getHaglconsulta(), 
                                          castOther.getHaglconsulta()).append(this.getHagctiposervi(), 
                                                                              castOther.getHagctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHaglconsulta()).append(getHagctiposervi()).toHashCode();
    }

}

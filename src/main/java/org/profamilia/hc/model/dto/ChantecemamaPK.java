package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecemamaPK implements Serializable {

    /** identifier field */
    private Long hamlconsulta;

    /** identifier field */
    private String hamctiposervi;

    /** full constructor */
    public ChantecemamaPK(Long hamlconsulta, String hamctiposervi) {
        this.hamlconsulta = hamlconsulta;
        this.hamctiposervi = hamctiposervi;
    }

    /** default constructor */
    public ChantecemamaPK() {
    }

    public Long getHamlconsulta() {
        return this.hamlconsulta;
    }

    public void setHamlconsulta(Long hamlconsulta) {
        this.hamlconsulta = hamlconsulta;
    }

    public String getHamctiposervi() {
        return this.hamctiposervi;
    }

    public void setHamctiposervi(String hamctiposervi) {
        this.hamctiposervi = hamctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hamlconsulta", 
                                                getHamlconsulta()).append("hamctiposervi", 
                                                                          getHamctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecemamaPK))
            return false;
        ChantecemamaPK castOther = (ChantecemamaPK)other;
        return new EqualsBuilder().append(this.getHamlconsulta(), 
                                          castOther.getHamlconsulta()).append(this.getHamctiposervi(), 
                                                                              castOther.getHamctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHamlconsulta()).append(getHamctiposervi()).toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChexafismamaPK implements Serializable {

    /** identifier field */
    private Long hemlconsulta;

    /** identifier field */
    private String hemctiposervi;

    /** full constructor */
    public ChexafismamaPK(Long hemlconsulta, String hemctiposervi) {
        this.hemlconsulta = hemlconsulta;
        this.hemctiposervi = hemctiposervi;
    }

    /** default constructor */
    public ChexafismamaPK() {
    }

    public Long getHemlconsulta() {
        return this.hemlconsulta;
    }

    public void setHemlconsulta(Long hemlconsulta) {
        this.hemlconsulta = hemlconsulta;
    }

    public String getHemctiposervi() {
        return this.hemctiposervi;
    }

    public void setHemctiposervi(String hemctiposervi) {
        this.hemctiposervi = hemctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hemlconsulta", 
                                                getHemlconsulta()).append("hemctiposervi", 
                                                                          getHemctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChexafismamaPK))
            return false;
        ChexafismamaPK castOther = (ChexafismamaPK)other;
        return new EqualsBuilder().append(this.getHemlconsulta(), 
                                          castOther.getHemlconsulta()).append(this.getHemctiposervi(), 
                                                                              castOther.getHemctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHemlconsulta()).append(getHemctiposervi()).toHashCode();
    }

}

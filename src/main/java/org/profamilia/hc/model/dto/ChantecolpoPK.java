package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecolpoPK implements Serializable {

    /** identifier field */
    private Long haclconsulta;

    /** identifier field */
    private String hacctiposervi;

    /** full constructor */
    public ChantecolpoPK(Long haclconsulta, String hacctiposervi) {
        this.haclconsulta = haclconsulta;
        this.hacctiposervi = hacctiposervi;
    }

    /** default constructor */
    public ChantecolpoPK() {
    }

    public Long getHaclconsulta() {
        return this.haclconsulta;
    }

    public void setHaclconsulta(Long haclconsulta) {
        this.haclconsulta = haclconsulta;
    }

    public String getHacctiposervi() {
        return this.hacctiposervi;
    }

    public void setHacctiposervi(String hacctiposervi) {
        this.hacctiposervi = hacctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("haclconsulta", 
                                                getHaclconsulta()).append("hacctiposervi", 
                                                                          getHacctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecolpoPK))
            return false;
        ChantecolpoPK castOther = (ChantecolpoPK)other;
        return new EqualsBuilder().append(this.getHaclconsulta(), 
                                          castOther.getHaclconsulta()).append(this.getHacctiposervi(), 
                                                                              castOther.getHacctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHaclconsulta()).append(getHacctiposervi()).toHashCode();
    }

}

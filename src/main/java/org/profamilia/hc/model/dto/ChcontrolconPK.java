package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcontrolconPK implements Serializable {

    /** identifier field */
    private Long hcclconsulta;

    /** identifier field */
    private String hccctiposervi;

    /** full constructor */
    public ChcontrolconPK(Long hcclconsulta, String hccctiposervi) {
        this.hcclconsulta = hcclconsulta;
        this.hccctiposervi = hccctiposervi;
    }

    /** default constructor */
    public ChcontrolconPK() {
    }

    public Long getHcclconsulta() {
        return this.hcclconsulta;
    }

    public void setHcclconsulta(Long hcclconsulta) {
        this.hcclconsulta = hcclconsulta;
    }

    public String getHccctiposervi() {
        return this.hccctiposervi;
    }

    public void setHccctiposervi(String hccctiposervi) {
        this.hccctiposervi = hccctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hcclconsulta", 
                                                getHcclconsulta()).append("hccctiposervi", 
                                                                          getHccctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChcontrolconPK))
            return false;
        ChcontrolconPK castOther = (ChcontrolconPK)other;
        return new EqualsBuilder().append(this.getHcclconsulta(), 
                                          castOther.getHcclconsulta()).append(this.getHccctiposervi(), 
                                                                              castOther.getHccctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHcclconsulta()).append(getHccctiposervi()).toHashCode();
    }

}

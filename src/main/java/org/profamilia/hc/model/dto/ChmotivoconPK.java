package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChmotivoconPK implements Serializable {

    /** identifier field */
    private Long hmclconsulta;

    /** identifier field */
    private String hmcctiposervi;

    /** full constructor */
    public ChmotivoconPK(Long hmclconsulta, String hmcctiposervi) {
        this.hmclconsulta = hmclconsulta;
        this.hmcctiposervi = hmcctiposervi;
    }

    /** default constructor */
    public ChmotivoconPK() {
    }

    public Long getHmclconsulta() {
        return this.hmclconsulta;
    }

    public void setHmclconsulta(Long hmclconsulta) {
        this.hmclconsulta = hmclconsulta;
    }

    public String getHmcctiposervi() {
        return this.hmcctiposervi;
    }

    public void setHmcctiposervi(String hmcctiposervi) {
        this.hmcctiposervi = hmcctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hmclconsulta", 
                                                getHmclconsulta()).append("hmcctiposervi", 
                                                                          getHmcctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChmotivoconPK))
            return false;
        ChmotivoconPK castOther = (ChmotivoconPK)other;
        return new EqualsBuilder().append(this.getHmclconsulta(), 
                                          castOther.getHmclconsulta()).append(this.getHmcctiposervi(), 
                                                                              castOther.getHmcctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHmclconsulta()).append(getHmcctiposervi()).toHashCode();
    }

}

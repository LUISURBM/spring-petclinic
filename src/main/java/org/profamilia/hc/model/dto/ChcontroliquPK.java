package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcontroliquPK implements Serializable {

    /** identifier field */
    private Long hcllnumero;

    /** identifier field */
    private Integer hclnconsecutiv;

    /** identifier field */
    private String hclctiposervi;

    /** full constructor */
    public ChcontroliquPK(Long hcllnumero, Integer hclnconsecutiv, 
                          String hclctiposervi) {
        this.hcllnumero = hcllnumero;
        this.hclnconsecutiv = hclnconsecutiv;
        this.hclctiposervi = hclctiposervi;
    }

    /** default constructor */
    public ChcontroliquPK() {
    }

    public Long getHcllnumero() {
        return this.hcllnumero;
    }

    public void setHcllnumero(Long hcllnumero) {
        this.hcllnumero = hcllnumero;
    }

    public Integer getHclnconsecutiv() {
        return this.hclnconsecutiv;
    }

    public void setHclnconsecutiv(Integer hclnconsecutiv) {
        this.hclnconsecutiv = hclnconsecutiv;
    }

    public String getHclctiposervi() {
        return this.hclctiposervi;
    }

    public void setHclctiposervi(String hclctiposervi) {
        this.hclctiposervi = hclctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hcllnumero", 
                                                getHcllnumero()).append("hclnconsecutiv", 
                                                                        getHclnconsecutiv()).append("hclctiposervi", 
                                                                                                    getHclctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChcontroliquPK))
            return false;
        ChcontroliquPK castOther = (ChcontroliquPK)other;
        return new EqualsBuilder().append(this.getHcllnumero(), 
                                          castOther.getHcllnumero()).append(this.getHclnconsecutiv(), 
                                                                            castOther.getHclnconsecutiv()).append(this.getHclctiposervi(), 
                                                                                                                  castOther.getHclctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHcllnumero()).append(getHclnconsecutiv()).append(getHclctiposervi()).toHashCode();
    }

}

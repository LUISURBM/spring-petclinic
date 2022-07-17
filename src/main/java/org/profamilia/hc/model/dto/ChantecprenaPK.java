package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecprenaPK implements Serializable {

    /** identifier field */
    private Long haplconsulta;

    /** identifier field */
    private String hapctiposervi;

    /** full constructor */
    public ChantecprenaPK(Long haplconsulta, String hapctiposervi) {
        this.haplconsulta = haplconsulta;
        this.hapctiposervi = hapctiposervi;
    }

    /** default constructor */
    public ChantecprenaPK() {
    }

    public Long getHaplconsulta() {
        return this.haplconsulta;
    }

    public void setHaplconsulta(Long haplconsulta) {
        this.haplconsulta = haplconsulta;
    }

    public String getHapctiposervi() {
        return this.hapctiposervi;
    }

    public void setHapctiposervi(String hapctiposervi) {
        this.hapctiposervi = hapctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("haplconsulta", 
                                                getHaplconsulta()).append("hapctiposervi", 
                                                                          getHapctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecprenaPK))
            return false;
        ChantecprenaPK castOther = (ChantecprenaPK)other;
        return new EqualsBuilder().append(this.getHaplconsulta(), 
                                          castOther.getHaplconsulta()).append(this.getHapctiposervi(), 
                                                                              castOther.getHapctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHaplconsulta()).append(getHapctiposervi()).toHashCode();
    }

}

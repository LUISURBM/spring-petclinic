package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChpediexamenPK implements Serializable {

    /** identifier field */
    private Long hpelconsulta;

    /** identifier field */
    private String hpectiposervi;

    /** full constructor */
    public ChpediexamenPK(Long hpelconsulta, String hpectiposervi) {
        this.hpelconsulta = hpelconsulta;
        this.hpectiposervi = hpectiposervi;
    }

    /** default constructor */
    public ChpediexamenPK() {
    }

    public Long getHpelconsulta() {
        return this.hpelconsulta;
    }

    public void setHpelconsulta(Long hpelconsulta) {
        this.hpelconsulta = hpelconsulta;
    }

    public String getHpectiposervi() {
        return this.hpectiposervi;
    }

    public void setHpectiposervi(String hpectiposervi) {
        this.hpectiposervi = hpectiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hpelconsulta", 
                                                getHpelconsulta()).append("hpectiposervi", 
                                                                          getHpectiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChpediexamenPK))
            return false;
        ChpediexamenPK castOther = (ChpediexamenPK)other;
        return new EqualsBuilder().append(this.getHpelconsulta(), 
                                          castOther.getHpelconsulta()).append(this.getHpectiposervi(), 
                                                                              castOther.getHpectiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHpelconsulta()).append(getHpectiposervi()).toHashCode();
    }

}

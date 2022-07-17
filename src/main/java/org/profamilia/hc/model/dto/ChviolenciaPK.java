package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChviolenciaPK implements Serializable {

    /** identifier field */
    private Long hvilconsulta;

    /** identifier field */
    private String hvictiposervi;

    /** full constructor */
    public ChviolenciaPK(Long hvilconsulta, String hvictiposervi) {
        this.hvilconsulta = hvilconsulta;
        this.hvictiposervi = hvictiposervi;
    }

    /** default constructor */
    public ChviolenciaPK() {
    }

    public Long getHvilconsulta() {
        return this.hvilconsulta;
    }

    public void setHvilconsulta(Long hvilconsulta) {
        this.hvilconsulta = hvilconsulta;
    }

    public String getHvictiposervi() {
        return this.hvictiposervi;
    }

    public void setHvictiposervi(String hvictiposervi) {
        this.hvictiposervi = hvictiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hvilconsulta", 
                                                getHvilconsulta()).append("hvictiposervi", 
                                                                          getHvictiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChviolenciaPK))
            return false;
        ChviolenciaPK castOther = (ChviolenciaPK)other;
        return new EqualsBuilder().append(this.getHvilconsulta(), 
                                          castOther.getHvilconsulta()).append(this.getHvictiposervi(), 
                                                                              castOther.getHvictiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHvilconsulta()).append(getHvictiposervi()).toHashCode();
    }

}

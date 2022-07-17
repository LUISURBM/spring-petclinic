package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChriesgomamaPK implements Serializable {

    /** identifier field */
    private Long hrmlconsulta;

    /** identifier field */
    private String hrmctiposervi;

    /** full constructor */
    public ChriesgomamaPK(Long hrmlconsulta, String hrmctiposervi) {
        this.hrmlconsulta = hrmlconsulta;
        this.hrmctiposervi = hrmctiposervi;
    }

    /** default constructor */
    public ChriesgomamaPK() {
    }

    public Long getHrmlconsulta() {
        return this.hrmlconsulta;
    }

    public void setHrmlconsulta(Long hrmlconsulta) {
        this.hrmlconsulta = hrmlconsulta;
    }

    public String getHrmctiposervi() {
        return this.hrmctiposervi;
    }

    public void setHrmctiposervi(String hrmctiposervi) {
        this.hrmctiposervi = hrmctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hrmlconsulta", 
                                                getHrmlconsulta()).append("hrmctiposervi", 
                                                                          getHrmctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChriesgomamaPK))
            return false;
        ChriesgomamaPK castOther = (ChriesgomamaPK)other;
        return new EqualsBuilder().append(this.getHrmlconsulta(), 
                                          castOther.getHrmlconsulta()).append(this.getHrmctiposervi(), 
                                                                              castOther.getHrmctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHrmlconsulta()).append(getHrmctiposervi()).toHashCode();
    }

}

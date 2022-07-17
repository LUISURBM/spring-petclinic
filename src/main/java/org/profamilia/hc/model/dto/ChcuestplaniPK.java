package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcuestplaniPK implements Serializable {

    /** identifier field */
    private Long hcplconsulta;

    /** identifier field */
    private String hcpctiposervi;

    /** full constructor */
    public ChcuestplaniPK(Long hcplconsulta, String hcpctiposervi) {
        this.hcplconsulta = hcplconsulta;
        this.hcpctiposervi = hcpctiposervi;
    }

    /** default constructor */
    public ChcuestplaniPK() {
    }

    public Long getHcplconsulta() {
        return this.hcplconsulta;
    }

    public void setHcplconsulta(Long hcplconsulta) {
        this.hcplconsulta = hcplconsulta;
    }

    public String getHcpctiposervi() {
        return this.hcpctiposervi;
    }

    public void setHcpctiposervi(String hcpctiposervi) {
        this.hcpctiposervi = hcpctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hcplconsulta", 
                                                getHcplconsulta()).append("hcpctiposervi", 
                                                                          getHcpctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChcuestplaniPK))
            return false;
        ChcuestplaniPK castOther = (ChcuestplaniPK)other;
        return new EqualsBuilder().append(this.getHcplconsulta(), 
                                          castOther.getHcplconsulta()).append(this.getHcpctiposervi(), 
                                                                              castOther.getHcpctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHcplconsulta()).append(getHcpctiposervi()).toHashCode();
    }

}

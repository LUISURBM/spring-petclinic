package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChlecttuberPK implements Serializable {

    /** identifier field */
    private Long hltlconsulta;

    /** identifier field */
    private String hltctiposervi;

    /** full constructor */
    public ChlecttuberPK(Long hltlconsulta, String hltctiposervi) {
        this.hltlconsulta = hltlconsulta;
        this.hltctiposervi = hltctiposervi;
    }

    /** default constructor */
    public ChlecttuberPK() {
    }

    public Long getHltlconsulta() {
        return this.hltlconsulta;
    }

    public void setHltlconsulta(Long hltlconsulta) {
        this.hltlconsulta = hltlconsulta;
    }

    public String getHltctiposervi() {
        return this.hltctiposervi;
    }

    public void setHltctiposervi(String hltctiposervi) {
        this.hltctiposervi = hltctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hltlconsulta", getHltlconsulta())
            .append("hltctiposervi", getHltctiposervi())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChlecttuberPK) ) return false;
        ChlecttuberPK castOther = (ChlecttuberPK) other;
        return new EqualsBuilder()
            .append(this.getHltlconsulta(), castOther.getHltlconsulta())
            .append(this.getHltctiposervi(), castOther.getHltctiposervi())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHltlconsulta())
            .append(getHltctiposervi())
            .toHashCode();
    }

}

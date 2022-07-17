package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChinfopsicoPK implements Serializable {

    /** identifier field */
    private Long hiplconsulta;

    /** identifier field */
    private Long hipnconsecuti;

    /** full constructor */
    public ChinfopsicoPK(Long hiplconsulta, Long hipnconsecuti) {
        this.hiplconsulta = hiplconsulta;
        this.hipnconsecuti = hipnconsecuti;
    }

    /** default constructor */
    public ChinfopsicoPK() {
    }

    public Long getHiplconsulta() {
        return this.hiplconsulta;
    }

    public void setHiplconsulta(Long hiplconsulta) {
        this.hiplconsulta = hiplconsulta;
    }

    public Long getHipnconsecuti() {
        return this.hipnconsecuti;
    }

    public void setHipnconsecuti(Long hipnconsecuti) {
        this.hipnconsecuti = hipnconsecuti;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hiplconsulta", getHiplconsulta())
            .append("hipnconsecuti", getHipnconsecuti())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChinfopsicoPK) ) return false;
        ChinfopsicoPK castOther = (ChinfopsicoPK) other;
        return new EqualsBuilder()
            .append(this.getHiplconsulta(), castOther.getHiplconsulta())
            .append(this.getHipnconsecuti(), castOther.getHipnconsecuti())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHiplconsulta())
            .append(getHipnconsecuti())
            .toHashCode();
    }

}

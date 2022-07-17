package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChreginsumoPK implements Serializable {

    /** identifier field */
    private Long hrinconsulta;

    /** identifier field */
    private Long hrinconsecuti;

    /** full constructor */
    public ChreginsumoPK(Long hrinconsulta, Long hrinconsecuti) {
        this.hrinconsulta = hrinconsulta;
        this.hrinconsecuti = hrinconsecuti;
    }

    /** default constructor */
    public ChreginsumoPK() {
    }

    public Long getHrinconsulta() {
        return this.hrinconsulta;
    }

    public void setHrinconsulta(Long hrinconsulta) {
        this.hrinconsulta = hrinconsulta;
    }

    public Long getHrinconsecuti() {
        return this.hrinconsecuti;
    }

    public void setHrinconsecuti(Long hrinconsecuti) {
        this.hrinconsecuti = hrinconsecuti;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hrinconsulta", getHrinconsulta())
            .append("hrinconsecuti", getHrinconsecuti())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChreginsumoPK) ) return false;
        ChreginsumoPK castOther = (ChreginsumoPK) other;
        return new EqualsBuilder()
            .append(this.getHrinconsulta(), castOther.getHrinconsulta())
            .append(this.getHrinconsecuti(), castOther.getHrinconsecuti())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHrinconsulta())
            .append(getHrinconsecuti())
            .toHashCode();
    }

}

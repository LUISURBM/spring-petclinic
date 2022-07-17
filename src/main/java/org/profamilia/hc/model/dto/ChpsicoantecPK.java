package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChpsicoantecPK implements Serializable {

    /** identifier field */
    private Long hpalconsulta;

    /** identifier field */
    private String hpactiposervi;

    /** full constructor */
    public ChpsicoantecPK(Long hpalconsulta, String hpactiposervi) {
        this.hpalconsulta = hpalconsulta;
        this.hpactiposervi = hpactiposervi;
    }

    /** default constructor */
    public ChpsicoantecPK() {
    }

    public Long getHpalconsulta() {
        return this.hpalconsulta;
    }

    public void setHpalconsulta(Long hpalconsulta) {
        this.hpalconsulta = hpalconsulta;
    }

    public String getHpactiposervi() {
        return this.hpactiposervi;
    }

    public void setHpactiposervi(String hpactiposervi) {
        this.hpactiposervi = hpactiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hpalconsulta", getHpalconsulta())
            .append("hpactiposervi", getHpactiposervi())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChpsicoantecPK) ) return false;
        ChpsicoantecPK castOther = (ChpsicoantecPK) other;
        return new EqualsBuilder()
            .append(this.getHpalconsulta(), castOther.getHpalconsulta())
            .append(this.getHpactiposervi(), castOther.getHpactiposervi())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHpalconsulta())
            .append(getHpactiposervi())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecfarmaPK implements Serializable {

    /** identifier field */
    private Long haflconsulta;

    /** identifier field */
    private String hafctiposervi;

    /** full constructor */
    public ChantecfarmaPK(Long haflconsulta, String hafctiposervi) {
        this.haflconsulta = haflconsulta;
        this.hafctiposervi = hafctiposervi;
    }

    /** default constructor */
    public ChantecfarmaPK() {
    }

    public Long getHaflconsulta() {
        return this.haflconsulta;
    }

    public void setHaflconsulta(Long haflconsulta) {
        this.haflconsulta = haflconsulta;
    }

    public String getHafctiposervi() {
        return this.hafctiposervi;
    }

    public void setHafctiposervi(String hafctiposervi) {
        this.hafctiposervi = hafctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("haflconsulta", getHaflconsulta())
            .append("hafctiposervi", getHafctiposervi())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChantecfarmaPK) ) return false;
        ChantecfarmaPK castOther = (ChantecfarmaPK) other;
        return new EqualsBuilder()
            .append(this.getHaflconsulta(), castOther.getHaflconsulta())
            .append(this.getHafctiposervi(), castOther.getHafctiposervi())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHaflconsulta())
            .append(getHafctiposervi())
            .toHashCode();
    }

}

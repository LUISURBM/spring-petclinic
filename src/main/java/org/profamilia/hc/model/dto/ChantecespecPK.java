package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecespecPK implements Serializable {

    /** identifier field */
    private Long haelconsulta;

    /** identifier field */
    private String haectiposervi;

    /** full constructor */
    public ChantecespecPK(Long haelconsulta, String haectiposervi) {
        this.haelconsulta = haelconsulta;
        this.haectiposervi = haectiposervi;
    }

    /** default constructor */
    public ChantecespecPK() {
    }

    public Long getHaelconsulta() {
        return this.haelconsulta;
    }

    public void setHaelconsulta(Long haelconsulta) {
        this.haelconsulta = haelconsulta;
    }

    public String getHaectiposervi() {
        return this.haectiposervi;
    }

    public void setHaectiposervi(String haectiposervi) {
        this.haectiposervi = haectiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("haelconsulta", getHaelconsulta())
            .append("haectiposervi", getHaectiposervi())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChantecespecPK) ) return false;
        ChantecespecPK castOther = (ChantecespecPK) other;
        return new EqualsBuilder()
            .append(this.getHaelconsulta(), castOther.getHaelconsulta())
            .append(this.getHaectiposervi(), castOther.getHaectiposervi())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHaelconsulta())
            .append(getHaectiposervi())
            .toHashCode();
    }

}

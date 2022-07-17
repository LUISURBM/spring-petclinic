package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcontroladiPK implements Serializable {

    /** identifier field */
    private Long hcalnumero;

    /** identifier field */
    private String hcacservicio;

    /** full constructor */
    public ChcontroladiPK(Long hcalnumero, String hcacservicio) {
        this.hcalnumero = hcalnumero;
        this.hcacservicio = hcacservicio;
    }

    /** default constructor */
    public ChcontroladiPK() {
    }

    public Long getHcalnumero() {
        return this.hcalnumero;
    }

    public void setHcalnumero(Long hcalnumero) {
        this.hcalnumero = hcalnumero;
    }

    public String getHcacservicio() {
        return this.hcacservicio;
    }

    public void setHcacservicio(String hcacservicio) {
        this.hcacservicio = hcacservicio;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hcalnumero", getHcalnumero())
            .append("hcacservicio", getHcacservicio())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChcontroladiPK) ) return false;
        ChcontroladiPK castOther = (ChcontroladiPK) other;
        return new EqualsBuilder()
            .append(this.getHcalnumero(), castOther.getHcalnumero())
            .append(this.getHcacservicio(), castOther.getHcacservicio())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHcalnumero())
            .append(getHcacservicio())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChotraordenPK implements Serializable {

    /** identifier field */
    private Long hoolnumero;

    /** identifier field */
    private Integer hoonconsecutiv;

    /** full constructor */
    public ChotraordenPK(Long hoolnumero, Integer hoonconsecutiv) {
        this.hoolnumero = hoolnumero;
        this.hoonconsecutiv = hoonconsecutiv;
    }

    /** default constructor */
    public ChotraordenPK() {
    }

    public Long getHoolnumero() {
        return this.hoolnumero;
    }

    public void setHoolnumero(Long hoolnumero) {
        this.hoolnumero = hoolnumero;
    }

    public Integer getHoonconsecutiv() {
        return this.hoonconsecutiv;
    }

    public void setHoonconsecutiv(Integer hoonconsecutiv) {
        this.hoonconsecutiv = hoonconsecutiv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hoolnumero", getHoolnumero())
            .append("hoonconsecutiv", getHoonconsecutiv())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChotraordenPK) ) return false;
        ChotraordenPK castOther = (ChotraordenPK) other;
        return new EqualsBuilder()
            .append(this.getHoolnumero(), castOther.getHoolnumero())
            .append(this.getHoonconsecutiv(), castOther.getHoonconsecutiv())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHoolnumero())
            .append(getHoonconsecutiv())
            .toHashCode();
    }

}

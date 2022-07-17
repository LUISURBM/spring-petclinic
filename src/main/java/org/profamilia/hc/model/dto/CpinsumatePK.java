package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpinsumatePK implements Serializable {

    /** identifier field */
    private String cimcservic;

    /** identifier field */
    private String cimcinsumo;

    /** full constructor */
    public CpinsumatePK(String cimcservic, String cimcinsumo) {
        this.cimcservic = cimcservic;
        this.cimcinsumo = cimcinsumo;
    }

    /** default constructor */
    public CpinsumatePK() {
    }

    public String getCimcservic() {
        return this.cimcservic;
    }

    public void setCimcservic(String cimcservic) {
        this.cimcservic = cimcservic;
    }

    public String getCimcinsumo() {
        return this.cimcinsumo;
    }

    public void setCimcinsumo(String cimcinsumo) {
        this.cimcinsumo = cimcinsumo;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cimcservic", getCimcservic())
            .append("cimcinsumo", getCimcinsumo())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpinsumatePK) ) return false;
        CpinsumatePK castOther = (CpinsumatePK) other;
        return new EqualsBuilder()
            .append(this.getCimcservic(), castOther.getCimcservic())
            .append(this.getCimcinsumo(), castOther.getCimcinsumo())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCimcservic())
            .append(getCimcinsumo())
            .toHashCode();
    }

}

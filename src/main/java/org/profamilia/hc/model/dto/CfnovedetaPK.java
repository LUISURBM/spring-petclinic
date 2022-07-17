package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CfnovedetaPK implements Serializable {

    /** identifier field */
    private Long cndnnovedad;

    /** identifier field */
    private Long cndnitem;

    /** full constructor */
    public CfnovedetaPK(Long cndnnovedad, Long cndnitem) {
        this.cndnnovedad = cndnnovedad;
        this.cndnitem = cndnitem;
    }

    /** default constructor */
    public CfnovedetaPK() {
    }

    public Long getCndnnovedad() {
        return this.cndnnovedad;
    }

    public void setCndnnovedad(Long cndnnovedad) {
        this.cndnnovedad = cndnnovedad;
    }

    public Long getCndnitem() {
        return this.cndnitem;
    }

    public void setCndnitem(Long cndnitem) {
        this.cndnitem = cndnitem;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cndnnovedad", getCndnnovedad())
            .append("cndnitem", getCndnitem())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CfnovedetaPK) ) return false;
        CfnovedetaPK castOther = (CfnovedetaPK) other;
        return new EqualsBuilder()
            .append(this.getCndnnovedad(), castOther.getCndnnovedad())
            .append(this.getCndnitem(), castOther.getCndnitem())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCndnnovedad())
            .append(getCndnitem())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChdetaentvphPK implements Serializable {

    /** identifier field */
    private Long hdenvph;

    /** identifier field */
    private Long hdelidentregavph;

    /** full constructor */
    public ChdetaentvphPK(Long hdenvph, Long hdelidentregavph) {
        this.hdenvph = hdenvph;
        this.hdelidentregavph = hdelidentregavph;
    }

    /** default constructor */
    public ChdetaentvphPK() {
    }

    public Long getHdenvph() {
        return this.hdenvph;
    }

    public void setHdenvph(Long hdenvph) {
        this.hdenvph = hdenvph;
    }

    public Long getHdelidentregavph() {
        return this.hdelidentregavph;
    }

    public void setHdelidentregavph(Long hdelidentregavph) {
        this.hdelidentregavph = hdelidentregavph;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hdenvph", getHdenvph())
            .append("hdelidentregavph", getHdelidentregavph())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChdetaentvphPK) ) return false;
        ChdetaentvphPK castOther = (ChdetaentvphPK) other;
        return new EqualsBuilder()
            .append(this.getHdenvph(), castOther.getHdenvph())
            .append(this.getHdelidentregavph(), castOther.getHdelidentregavph())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHdenvph())
            .append(getHdelidentregavph())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpservxcontPK implements Serializable {

    /** identifier field */
    private Long cscnnumecont;

    /** identifier field */
    private String cscccodiserv;

    /** identifier field */
    private Long cscnclinica;

    /** identifier field */
    private String csccintrextr;

    /** full constructor */
    public CpservxcontPK(Long cscnnumecont, String cscccodiserv, Long cscnclinica, String csccintrextr) {
        this.cscnnumecont = cscnnumecont;
        this.cscccodiserv = cscccodiserv;
        this.cscnclinica = cscnclinica;
        this.csccintrextr = csccintrextr;
    }

    /** default constructor */
    public CpservxcontPK() {
    }

    public Long getCscnnumecont() {
        return this.cscnnumecont;
    }

    public void setCscnnumecont(Long cscnnumecont) {
        this.cscnnumecont = cscnnumecont;
    }

    public String getCscccodiserv() {
        return this.cscccodiserv;
    }

    public void setCscccodiserv(String cscccodiserv) {
        this.cscccodiserv = cscccodiserv;
    }

    public Long getCscnclinica() {
        return this.cscnclinica;
    }

    public void setCscnclinica(Long cscnclinica) {
        this.cscnclinica = cscnclinica;
    }

    public String getCsccintrextr() {
        return this.csccintrextr;
    }

    public void setCsccintrextr(String csccintrextr) {
        this.csccintrextr = csccintrextr;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cscnnumecont", getCscnnumecont())
            .append("cscccodiserv", getCscccodiserv())
            .append("cscnclinica", getCscnclinica())
            .append("csccintrextr", getCsccintrextr())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpservxcontPK) ) return false;
        CpservxcontPK castOther = (CpservxcontPK) other;
        return new EqualsBuilder()
            .append(this.getCscnnumecont(), castOther.getCscnnumecont())
            .append(this.getCscccodiserv(), castOther.getCscccodiserv())
            .append(this.getCscnclinica(), castOther.getCscnclinica())
            .append(this.getCsccintrextr(), castOther.getCsccintrextr())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCscnnumecont())
            .append(getCscccodiserv())
            .append(getCscnclinica())
            .append(getCsccintrextr())
            .toHashCode();
    }

}

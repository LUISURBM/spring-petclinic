package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChposicanestPK implements Serializable {

    /** identifier field */
    private Long hpalnumero;

    /** identifier field */
    private String hpactiposervi;


    /** default constructor */
    public ChposicanestPK() {
    }

    /**
     * @param hpalnumero
     */
    public void setHpalnumero(Long hpalnumero) {
        this.hpalnumero = hpalnumero;
    }

    /**
     * @return
     */
    public Long getHpalnumero() {
        return hpalnumero;
    }

    /**
     * @param hpactiposervi
     */
    public void setHpactiposervi(String hpactiposervi) {
        this.hpactiposervi = hpactiposervi;
    }

    /**
     * @return
     */
    public String getHpactiposervi() {
        return hpactiposervi;
    }
    
    public String toString() {
        return new ToStringBuilder(this).append("hpalnumero", 
                                                getHpalnumero()).append("hpactiposervi", 
                                                                          getHpactiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChposicanestPK))
            return false;
        ChposicanestPK castOther = (ChposicanestPK)other;
        return new EqualsBuilder().append(this.getHpalnumero(), 
                                          castOther.getHpalnumero()).append(this.getHpactiposervi(), 
                                                                              castOther.getHpactiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHpalnumero()).append(getHpactiposervi()).toHashCode();
    }
}

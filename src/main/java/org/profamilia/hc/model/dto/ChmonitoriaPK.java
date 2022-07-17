package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


/** @author Hibernate CodeGenerator */
public class ChmonitoriaPK implements Serializable {

    /** identifier field */
    private Long hmolnumero;

    /** identifier field */
    private String hmoctiposervi;


    /** default constructor */
    public ChmonitoriaPK() {
    }

    /**
     * @param hmolnumero
     */
    public void setHmolnumero(Long hmolnumero) {
        this.hmolnumero = hmolnumero;
    }

    /**
     * @return
     */
    public Long getHmolnumero() {
        return hmolnumero;
    }

    /**
     * @param hmoctiposervi
     */
    public void setHmoctiposervi(String hmoctiposervi) {
        this.hmoctiposervi = hmoctiposervi;
    }

    /**
     * @return
     */
    public String getHmoctiposervi() {
        return hmoctiposervi;
    }
    
    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChmonitoriaPK))
            return false;
        ChmonitoriaPK castOther = (ChmonitoriaPK)other;
        return new EqualsBuilder().append(this.getHmolnumero(), 
                                          castOther.getHmolnumero()).append(this.getHmoctiposervi(), 
                                                                              castOther.getHmoctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHmolnumero()).append(getHmoctiposervi()).toHashCode();
    }
    
    
    
}

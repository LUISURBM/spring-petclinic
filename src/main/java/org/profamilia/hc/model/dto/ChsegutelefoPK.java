package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChsegutelefoPK implements Serializable {

    /** identifier field */
    private Long hstlnumero;

    /** identifier field */
    private Integer hstlconsecutiv;

    /** identifier field */
    private String hstctiposervi;

    /** full constructor */
    public ChsegutelefoPK(Long hstlnumero, Integer hstlconsecutiv, 
                          String hstctiposervi) {
        this.hstlnumero = hstlnumero;
        this.hstlconsecutiv = hstlconsecutiv;
        this.hstctiposervi = hstctiposervi;
    }

    /** default constructor */
    public ChsegutelefoPK() {
    }

    public Long getHstlnumero() {
        return this.hstlnumero;
    }

    public void setHstlnumero(Long hstlnumero) {
        this.hstlnumero = hstlnumero;
    }

    public Integer getHstlconsecutiv() {
        return this.hstlconsecutiv;
    }

    public void setHstlconsecutiv(Integer hstlconsecutiv) {
        this.hstlconsecutiv = hstlconsecutiv;
    }

    public String getHstctiposervi() {
        return this.hstctiposervi;
    }

    public void setHstctiposervi(String hstctiposervi) {
        this.hstctiposervi = hstctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hstlnumero", 
                                                getHstlnumero()).append("hstlconsecutiv", 
                                                                        getHstlconsecutiv()).append("hstctiposervi", 
                                                                                                    getHstctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChsegutelefoPK))
            return false;
        ChsegutelefoPK castOther = (ChsegutelefoPK)other;
        return new EqualsBuilder().append(this.getHstlnumero(), 
                                          castOther.getHstlnumero()).append(this.getHstlconsecutiv(), 
                                                                            castOther.getHstlconsecutiv()).append(this.getHstctiposervi(), 
                                                                                                                  castOther.getHstctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHstlnumero()).append(getHstlconsecutiv()).append(getHstctiposervi()).toHashCode();
    }

}

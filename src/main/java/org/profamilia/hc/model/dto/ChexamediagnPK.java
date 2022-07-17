package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChexamediagnPK implements Serializable {

    /** identifier field */
    private Long hedlconsulta;

    /** identifier field */
    private String hedctiposervi;

    /** full constructor */
    public ChexamediagnPK(Long hedlconsulta, String hedctiposervi) {
        this.hedlconsulta = hedlconsulta;
        this.hedctiposervi = hedctiposervi;
    }

    /** default constructor */
    public ChexamediagnPK() {
    }

    public Long getHedlconsulta() {
        return this.hedlconsulta;
    }

    public void setHedlconsulta(Long hedlconsulta) {
        this.hedlconsulta = hedlconsulta;
    }

    public String getHedctiposervi() {
        return this.hedctiposervi;
    }

    public void setHedctiposervi(String hedctiposervi) {
        this.hedctiposervi = hedctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hedlconsulta", 
                                                getHedlconsulta()).append("hedctiposervi", 
                                                                          getHedctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChexamediagnPK))
            return false;
        ChexamediagnPK castOther = (ChexamediagnPK)other;
        return new EqualsBuilder().append(this.getHedlconsulta(), 
                                          castOther.getHedlconsulta()).append(this.getHedctiposervi(), 
                                                                              castOther.getHedctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHedlconsulta()).append(getHedctiposervi()).toHashCode();
    }

}

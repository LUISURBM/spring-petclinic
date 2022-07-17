package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecegenePK implements Serializable {

    /** identifier field */
    private Long hanlconsulta;

    /** identifier field */
    private Integer hannconsecuti;

    /** identifier field */
    private String hanctiposervi;


    /** default constructor */
    public ChantecegenePK() {
    }

    public Long getHanlconsulta() {
        return this.hanlconsulta;
    }

    public void setHanlconsulta(Long hanlconsulta) {
        this.hanlconsulta = hanlconsulta;
    }

    public Integer getHannconsecuti() {
        return this.hannconsecuti;
    }

    public void setHannconsecuti(Integer hannconsecuti) {
        this.hannconsecuti = hannconsecuti;
    }

    public String getHanctiposervi() {
        return this.hanctiposervi;
    }

    public void setHanctiposervi(String hanctiposervi) {
        this.hanctiposervi = hanctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hanlconsulta", 
                                                getHanlconsulta()).append("hannconsecuti", 
                                                                          getHannconsecuti()).append("hanctiposervi", 
                                                                                                     getHanctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecegenePK))
            return false;
        ChantecegenePK castOther = (ChantecegenePK)other;
        return new EqualsBuilder().append(this.getHanlconsulta(), 
                                          castOther.getHanlconsulta()).append(this.getHannconsecuti(), 
                                                                              castOther.getHannconsecuti()).append(this.getHanctiposervi(), 
                                                                                                                   castOther.getHanctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHanlconsulta()).append(getHannconsecuti()).append(getHanctiposervi()).toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChparaclinicPK implements Serializable {

    /** identifier field */
    private Long hpalconsulta;

    /** identifier field */
    private Integer hpanconsecuti;

    /** identifier field */
    private String hpactiposervi;


    /** default constructor */
    public ChparaclinicPK() {
    }
    public void setHpalconsulta(Long hpalconsulta) {
        this.hpalconsulta = hpalconsulta;
    }

    public Long getHpalconsulta() {
        return hpalconsulta;
    }

    public void setHpanconsecuti(Integer hpanconsecuti) {
        this.hpanconsecuti = hpanconsecuti;
    }

    public Integer getHpanconsecuti() {
        return hpanconsecuti;
    }

    public void setHpactiposervi(String hpactiposervi) {
        this.hpactiposervi = hpactiposervi;
    }

    public String getHpactiposervi() {
        return hpactiposervi;
    }


    public void setHanctiposervi(String hpactiposervi) {
        this.hpactiposervi = hpactiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hpalconsulta", 
                                                getHpalconsulta()).append("hpanconsecuti", 
                                                                          getHpanconsecuti()).append("hpactiposervi", 
                                                                                                     getHpactiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecegenePK))
            return false;
        ChantecegenePK castOther = (ChantecegenePK)other;
        return new EqualsBuilder().append(this.getHpalconsulta(), 
                                          castOther.getHanlconsulta()).append(this.getHpanconsecuti(), 
                                                                              castOther.getHannconsecuti()).append(this.getHpactiposervi(), 
                                                                                                                   castOther.getHanctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHpalconsulta()).append(getHpanconsecuti()).append(getHpactiposervi()).toHashCode();
    }

  
}

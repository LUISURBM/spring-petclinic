package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecetempPK implements Serializable {

    /** identifier field */
    private Long hatlconsulta;

    /** identifier field */
    private Integer hatnconsecuti;

    /** identifier field */
    private String hatctiposervi;

    /** full constructor */
    public ChantecetempPK(Long hatlconsulta, Integer hatnconsecuti, 
                          String hatctiposervi) {
        this.hatlconsulta = hatlconsulta;
        this.hatnconsecuti = hatnconsecuti;
        this.hatctiposervi = hatctiposervi;
    }

    /** default constructor */
    public ChantecetempPK() {
    }

    public Long getHatlconsulta() {
        return this.hatlconsulta;
    }

    public void setHatlconsulta(Long hatlconsulta) {
        this.hatlconsulta = hatlconsulta;
    }

    public Integer getHatnconsecuti() {
        return this.hatnconsecuti;
    }

    public void setHatnconsecuti(Integer hatnconsecuti) {
        this.hatnconsecuti = hatnconsecuti;
    }

    public String getHatctiposervi() {
        return this.hatctiposervi;
    }

    public void setHatctiposervi(String hatctiposervi) {
        this.hatctiposervi = hatctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hatlconsulta", 
                                                getHatlconsulta()).append("hatnconsecuti", 
                                                                          getHatnconsecuti()).append("hatctiposervi", 
                                                                                                     getHatctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChantecetempPK))
            return false;
        ChantecetempPK castOther = (ChantecetempPK)other;
        return new EqualsBuilder().append(this.getHatlconsulta(), 
                                          castOther.getHatlconsulta()).append(this.getHatnconsecuti(), 
                                                                              castOther.getHatnconsecuti()).append(this.getHatctiposervi(), 
                                                                                                                   castOther.getHatctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHatlconsulta()).append(getHatnconsecuti()).append(getHatctiposervi()).toHashCode();
    }

}

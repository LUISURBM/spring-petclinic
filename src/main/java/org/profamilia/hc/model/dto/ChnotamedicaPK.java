package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChnotamedicaPK implements Serializable {

    /** identifier field */
    private Long hnmlconsulta;

    /** identifier field */
    private Integer hnmnconsecuti;

    /** identifier field */
    private String hnmctiposervi;

    /** full constructor */
    public ChnotamedicaPK(Long hnmlconsulta, Integer hnmnconsecuti, 
                          String hnmctiposervi) {
        this.hnmlconsulta = hnmlconsulta;
        this.hnmnconsecuti = hnmnconsecuti;
        this.hnmctiposervi = hnmctiposervi;
    }

    /** default constructor */
    public ChnotamedicaPK() {
    }

    public Long getHnmlconsulta() {
        return this.hnmlconsulta;
    }

    public void setHnmlconsulta(Long hnmlconsulta) {
        this.hnmlconsulta = hnmlconsulta;
    }

    public Integer getHnmnconsecuti() {
        return this.hnmnconsecuti;
    }

    public void setHnmnconsecuti(Integer hnmnconsecuti) {
        this.hnmnconsecuti = hnmnconsecuti;
    }

    public String getHnmctiposervi() {
        return this.hnmctiposervi;
    }

    public void setHnmctiposervi(String hnmctiposervi) {
        this.hnmctiposervi = hnmctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hnmlconsulta", 
                                                getHnmlconsulta()).append("hnmnconsecuti", 
                                                                          getHnmnconsecuti()).append("hnmctiposervi", 
                                                                                                     getHnmctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChnotamedicaPK))
            return false;
        ChnotamedicaPK castOther = (ChnotamedicaPK)other;
        return new EqualsBuilder().append(this.getHnmlconsulta(), 
                                          castOther.getHnmlconsulta()).append(this.getHnmnconsecuti(), 
                                                                              castOther.getHnmnconsecuti()).append(this.getHnmctiposervi(), 
                                                                                                                   castOther.getHnmctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHnmlconsulta()).append(getHnmnconsecuti()).append(getHnmctiposervi()).toHashCode();
    }

}

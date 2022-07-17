package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChexameparacPK implements Serializable {

    /** identifier field */
    private Long heplconsulta;

    /** identifier field */
    private Integer hepnconsecuti;

    /** identifier field */
    private String hepctiposervi;

    /** full constructor */
    public ChexameparacPK(Long heplconsulta, Integer hepnconsecuti, 
                          String hepctiposervi) {
        this.heplconsulta = heplconsulta;
        this.hepnconsecuti = hepnconsecuti;
        this.hepctiposervi = hepctiposervi;
    }

    /** default constructor */
    public ChexameparacPK() {
    }

    public Long getHeplconsulta() {
        return this.heplconsulta;
    }

    public void setHeplconsulta(Long heplconsulta) {
        this.heplconsulta = heplconsulta;
    }

    public Integer getHepnconsecuti() {
        return this.hepnconsecuti;
    }

    public void setHepnconsecuti(Integer hepnconsecuti) {
        this.hepnconsecuti = hepnconsecuti;
    }

    public String getHepctiposervi() {
        return this.hepctiposervi;
    }

    public void setHepctiposervi(String hepctiposervi) {
        this.hepctiposervi = hepctiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("heplconsulta", 
                                                getHeplconsulta()).append("hepnconsecuti", 
                                                                          getHepnconsecuti()).append("hepctiposervi", 
                                                                                                     getHepctiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChexameparacPK))
            return false;
        ChexameparacPK castOther = (ChexameparacPK)other;
        return new EqualsBuilder().append(this.getHeplconsulta(), 
                                          castOther.getHeplconsulta()).append(this.getHepnconsecuti(), 
                                                                              castOther.getHepnconsecuti()).append(this.getHepctiposervi(), 
                                                                                                                   castOther.getHepctiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHeplconsulta()).append(getHepnconsecuti()).append(getHepctiposervi()).toHashCode();
    }

}

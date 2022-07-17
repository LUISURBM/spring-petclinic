package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcontrvasecPK implements Serializable {

    /** identifier field */
    private Long hcvlconsulta;

    /** identifier field */
    private Integer hcvnconsecutiv;

    /** full constructor */
    public ChcontrvasecPK(Long hcvlconsulta, Integer hcvnconsecutiv 
                          ) {
        this.hcvlconsulta = hcvlconsulta;
        this.hcvnconsecutiv = hcvnconsecutiv;
      
    }

    /** default constructor */
    public ChcontrvasecPK() {
    }



    public String toString() {
        return new ToStringBuilder(this).append("hcvlconsulta", 
                                                getHcvlconsulta()).append("hcvnconsecutiv", 
                                                                        getHcvnconsecutiv()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChcontrvasecPK))
            return false;
        ChcontrvasecPK castOther = (ChcontrvasecPK)other;
        return new EqualsBuilder().append(this.getHcvlconsulta(), 
                                          castOther.getHcvlconsulta()).append(this.getHcvnconsecutiv(), 
                                                                            castOther.getHcvnconsecutiv()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHcvlconsulta()).append(getHcvnconsecutiv()).toHashCode();
    }

    public void setHcvlconsulta(Long hcvlconsulta) {
        this.hcvlconsulta = hcvlconsulta;
    }

    public Long getHcvlconsulta() {
        return hcvlconsulta;
    }

    public void setHcvnconsecutiv(Integer hcvnconsecutiv) {
        this.hcvnconsecutiv = hcvnconsecutiv;
    }

    public Integer getHcvnconsecutiv() {
        return hcvnconsecutiv;
    }
}

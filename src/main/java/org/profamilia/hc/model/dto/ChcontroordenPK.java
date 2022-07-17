package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChcontroordenPK implements Serializable {

    /** identifier field */
    private Long hcolnumero;

    /** identifier field */
    private Integer hconconsecutiv;

    /** full constructor */
    public ChcontroordenPK(Long hcolnumero, Integer hconconsecutiv 
                          ) {
        this.hcolnumero = hcolnumero;
        this.hconconsecutiv = hconconsecutiv;
      
    }

    /** default constructor */
    public ChcontroordenPK() {
    }



    public String toString() {
        return new ToStringBuilder(this).append("hcolnumero", 
                                                getHcolnumero()).append("hconconsecutiv", 
                                                                        getHconconsecutiv()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChcontroordenPK))
            return false;
        ChcontroordenPK castOther = (ChcontroordenPK)other;
        return new EqualsBuilder().append(this.getHcolnumero(), 
                                          castOther.getHcolnumero()).append(this.getHconconsecutiv(), 
                                                                            castOther.getHconconsecutiv()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHcolnumero()).append(getHconconsecutiv()).toHashCode();
    }

    public void setHcolnumero(Long hcolnumero) {
        this.hcolnumero = hcolnumero;
    }

    public Long getHcolnumero() {
        return hcolnumero;
    }

    public void setHconconsecutiv(Integer hconconsecutiv) {
        this.hconconsecutiv = hconconsecutiv;
    }

    public Integer getHconconsecutiv() {
        return hconconsecutiv;
    }
}

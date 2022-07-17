package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChnotaenfermPK implements Serializable {

    /** identifier field */
    private Long hnelnumero;

    /** identifier field */
    private Integer hnelconsecutiv;

    /** identifier field */
    private String hnectiposervi;

    /** full constructor */
    public ChnotaenfermPK(Long hnelnumero, Integer hnelconsecutiv, 
                          String hnectiposervi) {
        this.hnelnumero = hnelnumero;
        this.hnelconsecutiv = hnelconsecutiv;
        this.hnectiposervi = hnectiposervi;
    }

    /** default constructor */
    public ChnotaenfermPK() {
    }

    public Long getHnelnumero() {
        return this.hnelnumero;
    }

    public void setHnelnumero(Long hnelnumero) {
        this.hnelnumero = hnelnumero;
    }

    public Integer getHnelconsecutiv() {
        return this.hnelconsecutiv;
    }

    public void setHnelconsecutiv(Integer hnelconsecutiv) {
        this.hnelconsecutiv = hnelconsecutiv;
    }

    public String getHnectiposervi() {
        return this.hnectiposervi;
    }

    public void setHnectiposervi(String hnectiposervi) {
        this.hnectiposervi = hnectiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hnelnumero", 
                                                getHnelnumero()).append("hnelconsecutiv", 
                                                                        getHnelconsecutiv()).append("hnectiposervi", 
                                                                                                    getHnectiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChnotaenfermPK))
            return false;
        ChnotaenfermPK castOther = (ChnotaenfermPK)other;
        return new EqualsBuilder().append(this.getHnelnumero(), 
                                          castOther.getHnelnumero()).append(this.getHnelconsecutiv(), 
                                                                            castOther.getHnelconsecutiv()).append(this.getHnectiposervi(), 
                                                                                                                  castOther.getHnectiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHnelnumero()).append(getHnelconsecutiv()).append(getHnectiposervi()).toHashCode();
    }

}

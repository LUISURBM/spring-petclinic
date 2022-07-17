package org.profamilia.hc.model.dto;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChgestacionPK implements Serializable {

    /** identifier field */
    private Long hgelconsulta;

    /** identifier field */
    private String hgectiposervi;

    /** full constructor */
    public ChgestacionPK(Long hgelconsulta, String hgectiposervi) {
        this.hgelconsulta = hgelconsulta;
        this.hgectiposervi = hgectiposervi;
    }

    /** default constructor */
    public ChgestacionPK() {
    }

    public Long getHgelconsulta() {
        return this.hgelconsulta;
    }

    public void setHgelconsulta(Long hgelconsulta) {
        this.hgelconsulta = hgelconsulta;
    }

    public String getHgectiposervi() {
        return this.hgectiposervi;
    }

    public void setHgectiposervi(String hgectiposervi) {
        this.hgectiposervi = hgectiposervi;
    }

    public String toString() {
        return new ToStringBuilder(this).append("hgelconsulta", 
                                                getHgelconsulta()).append("hgectiposervi", 
                                                                          getHgectiposervi()).toString();
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if (!(other instanceof ChgestacionPK))
            return false;
        ChgestacionPK castOther = (ChgestacionPK)other;
        return new EqualsBuilder().append(this.getHgelconsulta(), 
                                          castOther.getHgelconsulta()).append(this.getHgectiposervi(), 
                                                                              castOther.getHgectiposervi()).isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder().append(getHgelconsulta()).append(getHgectiposervi()).toHashCode();
    }

}

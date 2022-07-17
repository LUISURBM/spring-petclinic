package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChantecdetalPK implements Serializable {

    /** identifier field */
    private Long hadlconsulta;

    /** identifier field */
    private Integer hadnconsecuti;

    /** full constructor */
    public ChantecdetalPK(Long hadlconsulta, Integer hadnconsecuti) {
        this.hadlconsulta = hadlconsulta;
        this.hadnconsecuti = hadnconsecuti;
    }

    /** default constructor */
    public ChantecdetalPK() {
    }

    public Long getHadlconsulta() {
        return this.hadlconsulta;
    }

    public void setHadlconsulta(Long hadlconsulta) {
        this.hadlconsulta = hadlconsulta;
    }

    public Integer getHadnconsecuti() {
        return this.hadnconsecuti;
    }

    public void setHadnconsecuti(Integer hadnconsecuti) {
        this.hadnconsecuti = hadnconsecuti;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hadlconsulta", getHadlconsulta())
            .append("hadnconsecuti", getHadnconsecuti())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChantecdetalPK) ) return false;
        ChantecdetalPK castOther = (ChantecdetalPK) other;
        return new EqualsBuilder()
            .append(this.getHadlconsulta(), castOther.getHadlconsulta())
            .append(this.getHadnconsecuti(), castOther.getHadnconsecuti())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHadlconsulta())
            .append(getHadnconsecuti())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class ChescvalcaiPK implements Serializable {

    /** identifier field */
    private Long hevclconsulta;

    /** identifier field */
    private Long hevcnconsecuti;

    /** full constructor */
    public ChescvalcaiPK(Long hevclconsulta, Long hevcnconsecuti) {
        this.hevclconsulta = hevclconsulta;
        this.hevcnconsecuti = hevcnconsecuti;
    }

    /** default constructor */
    public ChescvalcaiPK() {
    }

    public Long getHevclconsulta() {
        return this.hevclconsulta;
    }

    public void setHevclconsulta(Long hevclconsulta) {
        this.hevclconsulta = hevclconsulta;
    }

    public Long getHevcnconsecuti() {
        return this.hevcnconsecuti;
    }

    public void setHevcnconsecuti(Long hevcnconsecuti) {
        this.hevcnconsecuti = hevcnconsecuti;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hevclconsulta", getHevclconsulta())
            .append("hevcnconsecuti", getHevcnconsecuti())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof ChescvalcaiPK) ) return false;
        ChescvalcaiPK castOther = (ChescvalcaiPK) other;
        return new EqualsBuilder()
            .append(this.getHevclconsulta(), castOther.getHevclconsulta())
            .append(this.getHevcnconsecuti(), castOther.getHevcnconsecuti())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getHevclconsulta())
            .append(getHevcnconsecuti())
            .toHashCode();
    }

}

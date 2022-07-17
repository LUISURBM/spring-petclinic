package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class CpdetaliprPK implements Serializable {

    /** identifier field */
    private Long cdlnnumero;

    /** identifier field */
    private Long cdlnclinic;

    /** identifier field */
    private String cdlcservic;

    /** identifier field */
    private String cdlcpaquet;

    /** identifier field */
    private String cdlcintext;

    /** full constructor */
    public CpdetaliprPK(Long cdlnnumero, Long cdlnclinic, String cdlcservic, String cdlcpaquet, String cdlcintext) {
        this.cdlnnumero = cdlnnumero;
        this.cdlnclinic = cdlnclinic;
        this.cdlcservic = cdlcservic;
        this.cdlcpaquet = cdlcpaquet;
        this.cdlcintext = cdlcintext;
    }

    /** default constructor */
    public CpdetaliprPK() {
    }

    public Long getCdlnnumero() {
        return this.cdlnnumero;
    }

    public void setCdlnnumero(Long cdlnnumero) {
        this.cdlnnumero = cdlnnumero;
    }

    public Long getCdlnclinic() {
        return this.cdlnclinic;
    }

    public void setCdlnclinic(Long cdlnclinic) {
        this.cdlnclinic = cdlnclinic;
    }

    public String getCdlcservic() {
        return this.cdlcservic;
    }

    public void setCdlcservic(String cdlcservic) {
        this.cdlcservic = cdlcservic;
    }

    public String getCdlcpaquet() {
        return this.cdlcpaquet;
    }

    public void setCdlcpaquet(String cdlcpaquet) {
        this.cdlcpaquet = cdlcpaquet;
    }

    public String getCdlcintext() {
        return this.cdlcintext;
    }

    public void setCdlcintext(String cdlcintext) {
        this.cdlcintext = cdlcintext;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cdlnnumero", getCdlnnumero())
            .append("cdlnclinic", getCdlnclinic())
            .append("cdlcservic", getCdlcservic())
            .append("cdlcpaquet", getCdlcpaquet())
            .append("cdlcintext", getCdlcintext())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof CpdetaliprPK) ) return false;
        CpdetaliprPK castOther = (CpdetaliprPK) other;
        return new EqualsBuilder()
            .append(this.getCdlnnumero(), castOther.getCdlnnumero())
            .append(this.getCdlnclinic(), castOther.getCdlnclinic())
            .append(this.getCdlcservic(), castOther.getCdlcservic())
            .append(this.getCdlcpaquet(), castOther.getCdlcpaquet())
            .append(this.getCdlcintext(), castOther.getCdlcintext())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getCdlnnumero())
            .append(getCdlnclinic())
            .append(getCdlcservic())
            .append(getCdlcpaquet())
            .append(getCdlcintext())
            .toHashCode();
    }

}

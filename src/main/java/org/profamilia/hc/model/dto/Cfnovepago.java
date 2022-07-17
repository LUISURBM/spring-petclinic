package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfnovepago implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CfnovepagoPK comp_id;

    /** persistent field */
    private Long cnpnforpag;

    /** persistent field */
    private Double cnpnvalor;

    /** nullable persistent field */
    private String cnpctiptar;

    /** nullable persistent field */
    private String cnpnnumdoc;

    /** nullable persistent field */
    private String cnpnprotar;

    /** nullable persistent field */
    private String cnpnfranq;

    /** nullable persistent field */
    private Long cnpnnumanti;

    /** full constructor */
    public Cfnovepago(org.profamilia.hc.model.dto.CfnovepagoPK comp_id, Long cnpnforpag, Double cnpnvalor, String cnpctiptar, String cnpnnumdoc, String cnpnprotar, String cnpnfranq, Long cnpnnumanti) {
        this.comp_id = comp_id;
        this.cnpnforpag = cnpnforpag;
        this.cnpnvalor = cnpnvalor;
        this.cnpctiptar = cnpctiptar;
        this.cnpnnumdoc = cnpnnumdoc;
        this.cnpnprotar = cnpnprotar;
        this.cnpnfranq = cnpnfranq;
        this.cnpnnumanti = cnpnnumanti;
    }

    /** default constructor */
    public Cfnovepago() {
    }

    /** minimal constructor */
    public Cfnovepago(org.profamilia.hc.model.dto.CfnovepagoPK comp_id, Long cnpnforpag, Double cnpnvalor) {
        this.comp_id = comp_id;
        this.cnpnforpag = cnpnforpag;
        this.cnpnvalor = cnpnvalor;
    }

    public org.profamilia.hc.model.dto.CfnovepagoPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CfnovepagoPK comp_id) {
        this.comp_id = comp_id;
    }

    public Long getCnpnforpag() {
        return this.cnpnforpag;
    }

    public void setCnpnforpag(Long cnpnforpag) {
        this.cnpnforpag = cnpnforpag;
    }

    public Double getCnpnvalor() {
        return this.cnpnvalor;
    }

    public void setCnpnvalor(Double cnpnvalor) {
        this.cnpnvalor = cnpnvalor;
    }

    public String getCnpctiptar() {
        return this.cnpctiptar;
    }

    public void setCnpctiptar(String cnpctiptar) {
        this.cnpctiptar = cnpctiptar;
    }

    public String getCnpnnumdoc() {
        return this.cnpnnumdoc;
    }

    public void setCnpnnumdoc(String cnpnnumdoc) {
        this.cnpnnumdoc = cnpnnumdoc;
    }

    public String getCnpnprotar() {
        return this.cnpnprotar;
    }

    public void setCnpnprotar(String cnpnprotar) {
        this.cnpnprotar = cnpnprotar;
    }

    public String getCnpnfranq() {
        return this.cnpnfranq;
    }

    public void setCnpnfranq(String cnpnfranq) {
        this.cnpnfranq = cnpnfranq;
    }

    public Long getCnpnnumanti() {
        return this.cnpnnumanti;
    }

    public void setCnpnnumanti(Long cnpnnumanti) {
        this.cnpnnumanti = cnpnnumanti;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cfnovepago) ) return false;
        Cfnovepago castOther = (Cfnovepago) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

}

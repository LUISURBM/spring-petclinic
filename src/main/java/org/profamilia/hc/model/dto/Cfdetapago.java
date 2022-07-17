package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfdetapago implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CfdetapagoPK comp_id;

    /** persistent field */
    private Long cdpnforpag;

    /** persistent field */
    private Double cdpnvalor;

    /** nullable persistent field */
    private String cdpctiptar;

    /** nullable persistent field */
    private String cdpnnumdoc;

    /** nullable persistent field */
    private String cdpnprotar;

    /** persistent field */
    private Date cdpdfechreg;

    /** nullable persistent field */
    private String cdpnfranq;

    /** nullable persistent field */
    private Long cdpnnumant;

    /** full constructor */
    public Cfdetapago(org.profamilia.hc.model.dto.CfdetapagoPK comp_id, Long cdpnforpag, Double cdpnvalor, String cdpctiptar, String cdpnnumdoc, String cdpnprotar, Date cdpdfechreg, String cdpnfranq, Long cdpnnumant) {
        this.comp_id = comp_id;
        this.cdpnforpag = cdpnforpag;
        this.cdpnvalor = cdpnvalor;
        this.cdpctiptar = cdpctiptar;
        this.cdpnnumdoc = cdpnnumdoc;
        this.cdpnprotar = cdpnprotar;
        this.cdpdfechreg = cdpdfechreg;
        this.cdpnfranq = cdpnfranq;
        this.cdpnnumant = cdpnnumant;
    }

    /** default constructor */
    public Cfdetapago() {
    }

    /** minimal constructor */
    public Cfdetapago(org.profamilia.hc.model.dto.CfdetapagoPK comp_id, Long cdpnforpag, Double cdpnvalor, Date cdpdfechreg) {
        this.comp_id = comp_id;
        this.cdpnforpag = cdpnforpag;
        this.cdpnvalor = cdpnvalor;
        this.cdpdfechreg = cdpdfechreg;
    }

    public org.profamilia.hc.model.dto.CfdetapagoPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CfdetapagoPK comp_id) {
        this.comp_id = comp_id;
    }

    public Long getCdpnforpag() {
        return this.cdpnforpag;
    }

    public void setCdpnforpag(Long cdpnforpag) {
        this.cdpnforpag = cdpnforpag;
    }

    public Double getCdpnvalor() {
        return this.cdpnvalor;
    }

    public void setCdpnvalor(Double cdpnvalor) {
        this.cdpnvalor = cdpnvalor;
    }

    public String getCdpctiptar() {
        return this.cdpctiptar;
    }

    public void setCdpctiptar(String cdpctiptar) {
        this.cdpctiptar = cdpctiptar;
    }

    public String getCdpnnumdoc() {
        return this.cdpnnumdoc;
    }

    public void setCdpnnumdoc(String cdpnnumdoc) {
        this.cdpnnumdoc = cdpnnumdoc;
    }

    public String getCdpnprotar() {
        return this.cdpnprotar;
    }

    public void setCdpnprotar(String cdpnprotar) {
        this.cdpnprotar = cdpnprotar;
    }

    public Date getCdpdfechreg() {
        return this.cdpdfechreg;
    }

    public void setCdpdfechreg(Date cdpdfechreg) {
        this.cdpdfechreg = cdpdfechreg;
    }

    public String getCdpnfranq() {
        return this.cdpnfranq;
    }

    public void setCdpnfranq(String cdpnfranq) {
        this.cdpnfranq = cdpnfranq;
    }

    public Long getCdpnnumant() {
        return this.cdpnnumant;
    }

    public void setCdpnnumant(Long cdpnnumant) {
        this.cdpnnumant = cdpnnumant;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cfdetapago) ) return false;
        Cfdetapago castOther = (Cfdetapago) other;
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

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Ctwsdetsolent implements Serializable {

    /** identifier field */
    private CtwsdetsolentPK comp_id;

    /** persistent field */
    private String cdseccodmat;

    /** persistent field */
    private int cdsencante;

    /** persistent field */
    private String cdseclote;

    /** persistent field */
    private Date cdsedfecvenc;

    /** nullable persistent field */
    private String cdsecarea;

    /** nullable persistent field */
    private String cdseccab1;

    /** nullable persistent field */
    private String cdseccab2;

    /** persistent field */
    private Date cdsedfecreg;

    /** persistent field */
    private String cdsecusuareg;

    /** nullable persistent field */
    private Long version;

    /** nullable persistent field */
    private String cdseccodsust;

    /** persistent field */
    private String cdsecunimed;

    /** full constructor */
    public Ctwsdetsolent(org.profamilia.hc.model.dto.CtwsdetsolentPK comp_id, String cdseccodmat, int cdsencante, String cdseclote, Date cdsedfecvenc, String cdsecarea, String cdseccab1, String cdseccab2, Date cdsedfecreg, String cdsecusuareg, Long version, String cdseccodsust, String cdsecunimed) {
        this.comp_id = comp_id;
        this.cdseccodmat = cdseccodmat;
        this.cdsencante = cdsencante;
        this.cdseclote = cdseclote;
        this.cdsedfecvenc = cdsedfecvenc;
        this.cdsecarea = cdsecarea;
        this.cdseccab1 = cdseccab1;
        this.cdseccab2 = cdseccab2;
        this.cdsedfecreg = cdsedfecreg;
        this.cdsecusuareg = cdsecusuareg;
        this.version = version;
        this.cdseccodsust = cdseccodsust;
        this.cdsecunimed = cdsecunimed;
    }

    /** default constructor */
    public Ctwsdetsolent() {
    }

    /** minimal constructor */
    public Ctwsdetsolent(org.profamilia.hc.model.dto.CtwsdetsolentPK comp_id, String cdseccodmat, int cdsencante, String cdseclote, Date cdsedfecvenc, Date cdsedfecreg, String cdsecusuareg, String cdsecunimed) {
        this.comp_id = comp_id;
        this.cdseccodmat = cdseccodmat;
        this.cdsencante = cdsencante;
        this.cdseclote = cdseclote;
        this.cdsedfecvenc = cdsedfecvenc;
        this.cdsedfecreg = cdsedfecreg;
        this.cdsecusuareg = cdsecusuareg;
        this.cdsecunimed = cdsecunimed;
    }

    public org.profamilia.hc.model.dto.CtwsdetsolentPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CtwsdetsolentPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCdseccodmat() {
        return this.cdseccodmat;
    }

    public void setCdseccodmat(String cdseccodmat) {
        this.cdseccodmat = cdseccodmat;
    }

    public int getCdsencante() {
        return this.cdsencante;
    }

    public void setCdsencante(int cdsencante) {
        this.cdsencante = cdsencante;
    }

    public String getCdseclote() {
        return this.cdseclote;
    }

    public void setCdseclote(String cdseclote) {
        this.cdseclote = cdseclote;
    }

    public Date getCdsedfecvenc() {
        return this.cdsedfecvenc;
    }

    public void setCdsedfecvenc(Date cdsedfecvenc) {
        this.cdsedfecvenc = cdsedfecvenc;
    }

    public String getCdsecarea() {
        return this.cdsecarea;
    }

    public void setCdsecarea(String cdsecarea) {
        this.cdsecarea = cdsecarea;
    }

    public String getCdseccab1() {
        return this.cdseccab1;
    }

    public void setCdseccab1(String cdseccab1) {
        this.cdseccab1 = cdseccab1;
    }

    public String getCdseccab2() {
        return this.cdseccab2;
    }

    public void setCdseccab2(String cdseccab2) {
        this.cdseccab2 = cdseccab2;
    }

    public Date getCdsedfecreg() {
        return this.cdsedfecreg;
    }

    public void setCdsedfecreg(Date cdsedfecreg) {
        this.cdsedfecreg = cdsedfecreg;
    }

    public String getCdsecusuareg() {
        return this.cdsecusuareg;
    }

    public void setCdsecusuareg(String cdsecusuareg) {
        this.cdsecusuareg = cdsecusuareg;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCdseccodsust() {
        return this.cdseccodsust;
    }

    public void setCdseccodsust(String cdseccodsust) {
        this.cdseccodsust = cdseccodsust;
    }

    public String getCdsecunimed() {
        return this.cdsecunimed;
    }

    public void setCdsecunimed(String cdsecunimed) {
        this.cdsecunimed = cdsecunimed;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Ctwsdetsolent) ) return false;
        Ctwsdetsolent castOther = (Ctwsdetsolent) other;
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

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpservxcont implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CpservxcontPK comp_id;

    /** persistent field */
    private String cscctipocobr;

    /** persistent field */
    private Date cscdfechregi;

    /** persistent field */
    private String csccusuaregi;

    /** persistent field */
    private String csccestado;

    /** nullable persistent field */
    private Long version;

    /** persistent field */
    private String csccrequauto;

    /** persistent field */
    private Double cscnvalser;

    /** nullable persistent field */
    private String csccnombserv;

    /** full constructor */
    public Cpservxcont(org.profamilia.hc.model.dto.CpservxcontPK comp_id, String cscctipocobr, Date cscdfechregi, String csccusuaregi, String csccestado, Long version, String csccrequauto, Double cscnvalser, String csccnombserv) {
        this.comp_id = comp_id;
        this.cscctipocobr = cscctipocobr;
        this.cscdfechregi = cscdfechregi;
        this.csccusuaregi = csccusuaregi;
        this.csccestado = csccestado;
        this.version = version;
        this.csccrequauto = csccrequauto;
        this.cscnvalser = cscnvalser;
        this.csccnombserv = csccnombserv;
    }

    /** default constructor */
    public Cpservxcont() {
    }

    /** minimal constructor */
    public Cpservxcont(org.profamilia.hc.model.dto.CpservxcontPK comp_id, String cscctipocobr, Date cscdfechregi, String csccusuaregi, String csccestado, String csccrequauto, Double cscnvalser) {
        this.comp_id = comp_id;
        this.cscctipocobr = cscctipocobr;
        this.cscdfechregi = cscdfechregi;
        this.csccusuaregi = csccusuaregi;
        this.csccestado = csccestado;
        this.csccrequauto = csccrequauto;
        this.cscnvalser = cscnvalser;
    }

    public org.profamilia.hc.model.dto.CpservxcontPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CpservxcontPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCscctipocobr() {
        return this.cscctipocobr;
    }

    public void setCscctipocobr(String cscctipocobr) {
        this.cscctipocobr = cscctipocobr;
    }

    public Date getCscdfechregi() {
        return this.cscdfechregi;
    }

    public void setCscdfechregi(Date cscdfechregi) {
        this.cscdfechregi = cscdfechregi;
    }

    public String getCsccusuaregi() {
        return this.csccusuaregi;
    }

    public void setCsccusuaregi(String csccusuaregi) {
        this.csccusuaregi = csccusuaregi;
    }

    public String getCsccestado() {
        return this.csccestado;
    }

    public void setCsccestado(String csccestado) {
        this.csccestado = csccestado;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCsccrequauto() {
        return this.csccrequauto;
    }

    public void setCsccrequauto(String csccrequauto) {
        this.csccrequauto = csccrequauto;
    }

    public Double getCscnvalser() {
        return this.cscnvalser;
    }

    public void setCscnvalser(Double cscnvalser) {
        this.cscnvalser = cscnvalser;
    }

    public String getCsccnombserv() {
        return this.csccnombserv;
    }

    public void setCsccnombserv(String csccnombserv) {
        this.csccnombserv = csccnombserv;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cpservxcont) ) return false;
        Cpservxcont castOther = (Cpservxcont) other;
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

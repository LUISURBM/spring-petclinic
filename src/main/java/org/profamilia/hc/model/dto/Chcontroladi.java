package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chcontroladi implements Serializable {

    /** identifier field */
    private ChcontroladiPK comp_id;

    /** nullable persistent field */
    private Integer hcanclinica;

    /** persistent field */
    private String hcactiposervi;

    /** nullable persistent field */
    private String hcacobserv;

    /** nullable persistent field */
    private String hcacoperador;

    /** nullable persistent field */
    private Date hcadfecreg;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chcontroladi(ChcontroladiPK comp_id, Integer hcanclinica, String hcactiposervi, String hcacobserv, String hcacoperador, Date hcadfecreg, Integer version) {
        this.comp_id = comp_id;
        this.hcanclinica = hcanclinica;
        this.hcactiposervi = hcactiposervi;
        this.hcacobserv = hcacobserv;
        this.hcacoperador = hcacoperador;
        this.hcadfecreg = hcadfecreg;
        this.version = version;
    }

    /** default constructor */
    public Chcontroladi() {
    }

    /** minimal constructor */
    public Chcontroladi(ChcontroladiPK comp_id, String hcactiposervi) {
        this.comp_id = comp_id;
        this.hcactiposervi = hcactiposervi;
    }

    public ChcontroladiPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(ChcontroladiPK comp_id) {
        this.comp_id = comp_id;
    }

    public Integer getHcanclinica() {
        return this.hcanclinica;
    }

    public void setHcanclinica(Integer hcanclinica) {
        this.hcanclinica = hcanclinica;
    }

    public String getHcactiposervi() {
        return this.hcactiposervi;
    }

    public void setHcactiposervi(String hcactiposervi) {
        this.hcactiposervi = hcactiposervi;
    }

    public String getHcacobserv() {
        return this.hcacobserv;
    }

    public void setHcacobserv(String hcacobserv) {
        this.hcacobserv = hcacobserv;
    }

    public String getHcacoperador() {
        return this.hcacoperador;
    }

    public void setHcacoperador(String hcacoperador) {
        this.hcacoperador = hcacoperador;
    }

    public Date getHcadfecreg() {
        return this.hcadfecreg;
    }

    public void setHcadfecreg(Date hcadfecreg) {
        this.hcadfecreg = hcadfecreg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chcontroladi) ) return false;
        Chcontroladi castOther = (Chcontroladi) other;
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

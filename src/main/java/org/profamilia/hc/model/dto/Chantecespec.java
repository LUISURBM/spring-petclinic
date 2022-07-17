package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantecespec implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChantecespecPK comp_id;

    /** nullable persistent field */
    private Date haedfechaplic;

    /** nullable persistent field */
    private Long haenpeso;

    /** nullable persistent field */
    private String haentalla;

    /** nullable persistent field */
    private String haecprestuber;

    /** nullable persistent field */
    private String haeccuantuber;

    /** nullable persistent field */
    private String haecrecibtrata;

    /** nullable persistent field */
    private String haectiemptrata;

    /** nullable persistent field */
    private String haeccontactubercu;

    /** nullable persistent field */
    private String haecquiencontac;

    /** nullable persistent field */
    private String haecviveconel;

    /** nullable persistent field */
    private String haectiempocompart;

    /** nullable persistent field */
    private Date haedfecregistr;

    /** nullable persistent field */
    private String haecoperador;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chantecespec(org.profamilia.hc.model.dto.ChantecespecPK comp_id, Date haedfechaplic, Long haenpeso, String haentalla, String haecprestuber, String haeccuantuber, String haecrecibtrata, String haectiemptrata, String haeccontactubercu, String haecquiencontac, String haecviveconel, String haectiempocompart, Date haedfecregistr, String haecoperador, Integer version) {
        this.comp_id = comp_id;
        this.haedfechaplic = haedfechaplic;
        this.haenpeso = haenpeso;
        this.haentalla = haentalla;
        this.haecprestuber = haecprestuber;
        this.haeccuantuber = haeccuantuber;
        this.haecrecibtrata = haecrecibtrata;
        this.haectiemptrata = haectiemptrata;
        this.haeccontactubercu = haeccontactubercu;
        this.haecquiencontac = haecquiencontac;
        this.haecviveconel = haecviveconel;
        this.haectiempocompart = haectiempocompart;
        this.haedfecregistr = haedfecregistr;
        this.haecoperador = haecoperador;
        this.version = version;
    }

    /** default constructor */
    public Chantecespec() {
    }

    /** minimal constructor */
    public Chantecespec(org.profamilia.hc.model.dto.ChantecespecPK comp_id) {
        this.comp_id = comp_id;
    }

    public org.profamilia.hc.model.dto.ChantecespecPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChantecespecPK comp_id) {
        this.comp_id = comp_id;
    }

    public Date getHaedfechaplic() {
        return this.haedfechaplic;
    }

    public void setHaedfechaplic(Date haedfechaplic) {
        this.haedfechaplic = haedfechaplic;
    }

    public Long getHaenpeso() {
        return this.haenpeso;
    }

    public void setHaenpeso(Long haenpeso) {
        this.haenpeso = haenpeso;
    }

    public String getHaentalla() {
        return this.haentalla;
    }

    public void setHaentalla(String haentalla) {
        this.haentalla = haentalla;
    }

    public String getHaecprestuber() {
        return this.haecprestuber;
    }

    public void setHaecprestuber(String haecprestuber) {
        this.haecprestuber = haecprestuber;
    }

    public String getHaeccuantuber() {
        return this.haeccuantuber;
    }

    public void setHaeccuantuber(String haeccuantuber) {
        this.haeccuantuber = haeccuantuber;
    }

    public String getHaecrecibtrata() {
        return this.haecrecibtrata;
    }

    public void setHaecrecibtrata(String haecrecibtrata) {
        this.haecrecibtrata = haecrecibtrata;
    }

    public String getHaectiemptrata() {
        return this.haectiemptrata;
    }

    public void setHaectiemptrata(String haectiemptrata) {
        this.haectiemptrata = haectiemptrata;
    }

    public String getHaeccontactubercu() {
        return this.haeccontactubercu;
    }

    public void setHaeccontactubercu(String haeccontactubercu) {
        this.haeccontactubercu = haeccontactubercu;
    }

    public String getHaecquiencontac() {
        return this.haecquiencontac;
    }

    public void setHaecquiencontac(String haecquiencontac) {
        this.haecquiencontac = haecquiencontac;
    }

    public String getHaecviveconel() {
        return this.haecviveconel;
    }

    public void setHaecviveconel(String haecviveconel) {
        this.haecviveconel = haecviveconel;
    }

    public String getHaectiempocompart() {
        return this.haectiempocompart;
    }

    public void setHaectiempocompart(String haectiempocompart) {
        this.haectiempocompart = haectiempocompart;
    }

    public Date getHaedfecregistr() {
        return this.haedfecregistr;
    }

    public void setHaedfecregistr(Date haedfecregistr) {
        this.haedfecregistr = haedfecregistr;
    }

    public String getHaecoperador() {
        return this.haecoperador;
    }

    public void setHaecoperador(String haecoperador) {
        this.haecoperador = haecoperador;
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
        if ( !(other instanceof Chantecespec) ) return false;
        Chantecespec castOther = (Chantecespec) other;
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

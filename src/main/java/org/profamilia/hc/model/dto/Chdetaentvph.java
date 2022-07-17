package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chdetaentvph implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChdetaentvphPK comp_id;

    /** nullable persistent field */
    private Date hdedfechaentreg;

    /** persistent field */
    private Date hdedfechamod;

    /** persistent field */
    private Integer hdenclinica;

    /** persistent field */
    private String hdecoperador;

    /** nullable persistent field */
    private String hdecresultado;

    /** persistent field */
    private String hdecetapa;

    /** nullable persistent field */
    private org.profamilia.hc.model.dto.Chentregavph chentregavph;

    /** full constructor */
    public Chdetaentvph(org.profamilia.hc.model.dto.ChdetaentvphPK comp_id, Date hdedfechaentreg, Date hdedfechamod, Integer hdenclinica, String hdecoperador, String hdecresultado, String hdecetapa, org.profamilia.hc.model.dto.Chentregavph chentregavph) {
        this.comp_id = comp_id;
        this.hdedfechaentreg = hdedfechaentreg;
        this.hdedfechamod = hdedfechamod;
        this.hdenclinica = hdenclinica;
        this.hdecoperador = hdecoperador;
        this.hdecresultado = hdecresultado;
        this.hdecetapa = hdecetapa;
        this.chentregavph = chentregavph;
    }

    /** default constructor */
    public Chdetaentvph() {
        comp_id = new ChdetaentvphPK();
    
    }

    /** minimal constructor */
    public Chdetaentvph(org.profamilia.hc.model.dto.ChdetaentvphPK comp_id, Date hdedfechamod, Integer hdenclinica, String hdecoperador, String hdecetapa) {
        this.comp_id = comp_id;
        this.hdedfechamod = hdedfechamod;
        this.hdenclinica = hdenclinica;
        this.hdecoperador = hdecoperador;
        this.hdecetapa = hdecetapa;
    }

    public org.profamilia.hc.model.dto.ChdetaentvphPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChdetaentvphPK comp_id) {
        this.comp_id = comp_id;
    }

    public Date getHdedfechaentreg() {
        return this.hdedfechaentreg;
    }

    public void setHdedfechaentreg(Date hdedfechaentreg) {
        this.hdedfechaentreg = hdedfechaentreg;
    }

    public Date getHdedfechamod() {
        return this.hdedfechamod;
    }

    public void setHdedfechamod(Date hdedfechamod) {
        this.hdedfechamod = hdedfechamod;
    }

    public Integer getHdenclinica() {
        return this.hdenclinica;
    }

    public void setHdenclinica(Integer hdenclinica) {
        this.hdenclinica = hdenclinica;
    }

    public String getHdecoperador() {
        return this.hdecoperador;
    }

    public void setHdecoperador(String hdecoperador) {
        this.hdecoperador = hdecoperador;
    }

    public String getHdecresultado() {
        return this.hdecresultado;
    }

    public void setHdecresultado(String hdecresultado) {
        this.hdecresultado = hdecresultado;
    }

    public String getHdecetapa() {
        return this.hdecetapa;
    }

    public void setHdecetapa(String hdecetapa) {
        this.hdecetapa = hdecetapa;
    }

    public org.profamilia.hc.model.dto.Chentregavph getChentregavph() {
        return this.chentregavph;
    }

    public void setChentregavph(org.profamilia.hc.model.dto.Chentregavph chentregavph) {
        this.chentregavph = chentregavph;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chdetaentvph) ) return false;
        Chdetaentvph castOther = (Chdetaentvph) other;
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

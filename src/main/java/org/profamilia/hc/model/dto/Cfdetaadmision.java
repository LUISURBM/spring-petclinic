package org.profamilia.hc.model.dto;

import java.io.Serializable;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfdetaadmision implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CfdetaadmisionPK id;

    /** persistent field */
    private String cdacservic;

    /** nullable persistent field */
    private String cdaccodent;

    /** persistent field */
    private Double cdanvalser;

    /** nullable persistent field */
    private Double cdanivaser;

    /** nullable persistent field */
    private Double cdandescto;

    /** persistent field */
    private Long cdancantid;

    /** nullable persistent field */
    private Double cdanvalent;

    /** persistent field */
    private Double cdanvaltot;

    /** persistent field */
    private Long cdannumite;

    /** nullable persistent field */
    private String cdacpaquet;

    /** nullable persistent field */
    private String cdacswpaqu;

    /** nullable persistent field */
    private Long version;

    /** persistent field */
    private String cdacdesserv;

    /** nullable persistent field */
    private Double cdanrecaudo;

    /** nullable persistent field */
    private String cdancuotcopa;

    /** nullable persistent field */
    private String cdactipdscto;

    /** nullable persistent field */
    private Long cdanidedscto;
    
    /** nullable persistent field */
    private String cdacestado;
    
    private boolean itemSelect;
    
    /** full constructor */
    public Cfdetaadmision(org.profamilia.hc.model.dto.CfdetaadmisionPK id, String cdacservic, String cdaccodent, Double cdanvalser, Double cdanivaser, Double cdandescto, Long cdancantid, Double cdanvalent, Double cdanvaltot, Long cdannumite, String cdacpaquet, String cdacswpaqu, Long version, String cdacdesserv, Double cdanrecaudo, String cdancuotcopa, String cdactipdscto, Long cdanidedscto,String cdacestado) {
        this.id = id;
        this.cdacservic = cdacservic;
        this.cdaccodent = cdaccodent;
        this.cdanvalser = cdanvalser;
        this.cdanivaser = cdanivaser;
        this.cdandescto = cdandescto;
        this.cdancantid = cdancantid;
        this.cdanvalent = cdanvalent;
        this.cdanvaltot = cdanvaltot;
        this.cdannumite = cdannumite;
        this.cdacpaquet = cdacpaquet;
        this.cdacswpaqu = cdacswpaqu;
        this.version = version;
        this.cdacdesserv = cdacdesserv;
        this.cdanrecaudo = cdanrecaudo;
        this.cdancuotcopa = cdancuotcopa;
        this.cdactipdscto = cdactipdscto;
        this.cdanidedscto = cdanidedscto;
        this.cdacestado = cdacestado;
    }

    /** default constructor */
    public Cfdetaadmision() {
    }

    /** minimal constructor */
    public Cfdetaadmision(org.profamilia.hc.model.dto.CfdetaadmisionPK id, String cdacservic, Double cdanvalser, Long cdancantid, Double cdanvaltot, Long cdannumite, String cdacdesserv) {
        this.id = id;
        this.cdacservic = cdacservic;
        this.cdanvalser = cdanvalser;
        this.cdancantid = cdancantid;
        this.cdanvaltot = cdanvaltot;
        this.cdannumite = cdannumite;
        this.cdacdesserv = cdacdesserv;
    }

    public org.profamilia.hc.model.dto.CfdetaadmisionPK getId() {
        return this.id;
    }

    public void setId(org.profamilia.hc.model.dto.CfdetaadmisionPK comp_id) {
        this.id = comp_id;
    }

    public String getCdacservic() {
        return this.cdacservic;
    }

    public void setCdacservic(String cdacservic) {
        this.cdacservic = cdacservic;
    }

    public String getCdaccodent() {
        return this.cdaccodent;
    }

    public void setCdaccodent(String cdaccodent) {
        this.cdaccodent = cdaccodent;
    }

    public Double getCdanvalser() {
        return this.cdanvalser;
    }

    public void setCdanvalser(Double cdanvalser) {
        this.cdanvalser = cdanvalser;
    }

    public Double getCdanivaser() {
        return this.cdanivaser;
    }

    public void setCdanivaser(Double cdanivaser) {
        this.cdanivaser = cdanivaser;
    }

    public Double getCdandescto() {
        return this.cdandescto;
    }

    public void setCdandescto(Double cdandescto) {
        this.cdandescto = cdandescto;
    }

    public Long getCdancantid() {
        return this.cdancantid;
    }

    public void setCdancantid(Long cdancantid) {
        this.cdancantid = cdancantid;
    }

    public Double getCdanvalent() {
        return this.cdanvalent;
    }

    public void setCdanvalent(Double cdanvalent) {
        this.cdanvalent = cdanvalent;
    }

    public Double getCdanvaltot() {
        return this.cdanvaltot;
    }

    public void setCdanvaltot(Double cdanvaltot) {
        this.cdanvaltot = cdanvaltot;
    }

    public Long getCdannumite() {
        return this.cdannumite;
    }

    public void setCdannumite(Long cdannumite) {
        this.cdannumite = cdannumite;
    }

    public String getCdacpaquet() {
        return this.cdacpaquet;
    }

    public void setCdacpaquet(String cdacpaquet) {
        this.cdacpaquet = cdacpaquet;
    }

    public String getCdacswpaqu() {
        return this.cdacswpaqu;
    }

    public void setCdacswpaqu(String cdacswpaqu) {
        this.cdacswpaqu = cdacswpaqu;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCdacdesserv() {
        return this.cdacdesserv;
    }

    public void setCdacdesserv(String cdacdesserv) {
        this.cdacdesserv = cdacdesserv;
    }

    public Double getCdanrecaudo() {
        return this.cdanrecaudo;
    }

    public void setCdanrecaudo(Double cdanrecaudo) {
        this.cdanrecaudo = cdanrecaudo;
    }

    public String getCdancuotcopa() {
        return this.cdancuotcopa;
    }

    public void setCdancuotcopa(String cdancuotcopa) {
        this.cdancuotcopa = cdancuotcopa;
    }

    public String getCdactipdscto() {
        return this.cdactipdscto;
    }

    public void setCdactipdscto(String cdactipdscto) {
        this.cdactipdscto = cdactipdscto;
    }

    public Long getCdanidedscto() {
        return this.cdanidedscto;
    }

    public void setCdanidedscto(Long cdanidedscto) {
        this.cdanidedscto = cdanidedscto;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cfdetaadmision) ) return false;
        Cfdetaadmision castOther = (Cfdetaadmision) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public void setCdacestado(String cdacestado) {
        this.cdacestado = cdacestado;
    }

    public String getCdacestado() {
        return cdacestado;
    }


    public void setItemSelect(boolean itemSelect) {
        this.itemSelect = itemSelect;
    }

    public boolean isItemSelect() {
        return itemSelect;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setSeleccionado(ValueChangeEvent valueChangeEvent){
        setItemSelect((Boolean)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
        }
}

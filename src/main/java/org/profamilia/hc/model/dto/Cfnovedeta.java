package org.profamilia.hc.model.dto;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfnovedeta implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CfnovedetaPK comp_id;

    /** persistent field */
    private String cndcservic;

    /** persistent field */
    private Double cndnvalser;

    /** nullable persistent field */
    private Double cndnivaser;

    /** nullable persistent field */
    private Double cndndescto;

    /** persistent field */
    private Long cndncantid;

    /** nullable persistent field */
    private Double cndnvalent;

    /** persistent field */
    private Double cndnvaltot;

    /** nullable persistent field */
    private String cndcpaquet;

    /** nullable persistent field */
    private String cndcswpaqu;

    /** nullable persistent field */
    private Long version;

    /** persistent field */
    private String cndcdesserv;

    /** nullable persistent field */
    private Double cndnrecaudo;

    /** nullable persistent field */
    private String cndncuotcopa;

    /** nullable persistent field */
    private String cndctipdscto;

    /** nullable persistent field */
    private Long cndnidedscto;

    /** nullable persistent field */
    private String cndcestado;

    /** nullable persistent field */
    private String cndcsrvant;

    /** full constructor */
    public Cfnovedeta(org.profamilia.hc.model.dto.CfnovedetaPK comp_id, String cndcservic, Double cndnvalser, Double cndnivaser, Double cndndescto, Long cndncantid, Double cndnvalent, Double cndnvaltot, String cndcpaquet, String cndcswpaqu, Long version, String cndcdesserv, Double cndnrecaudo, String cndncuotcopa, String cndctipdscto, Long cndnidedscto, String cndcestado, String cndcsrvant) {
        this.comp_id = comp_id;
        this.cndcservic = cndcservic;
        this.cndnvalser = cndnvalser;
        this.cndnivaser = cndnivaser;
        this.cndndescto = cndndescto;
        this.cndncantid = cndncantid;
        this.cndnvalent = cndnvalent;
        this.cndnvaltot = cndnvaltot;
        this.cndcpaquet = cndcpaquet;
        this.cndcswpaqu = cndcswpaqu;
        this.version = version;
        this.cndcdesserv = cndcdesserv;
        this.cndnrecaudo = cndnrecaudo;
        this.cndncuotcopa = cndncuotcopa;
        this.cndctipdscto = cndctipdscto;
        this.cndnidedscto = cndnidedscto;
        this.cndcestado = cndcestado;
        this.cndcsrvant = cndcsrvant;
    }

    /** default constructor */
    public Cfnovedeta() {
    }

    /** minimal constructor */
    public Cfnovedeta(org.profamilia.hc.model.dto.CfnovedetaPK comp_id, String cndcservic, Double cndnvalser, Long cndncantid, Double cndnvaltot, String cndcdesserv) {
        this.comp_id = comp_id;
        this.cndcservic = cndcservic;
        this.cndnvalser = cndnvalser;
        this.cndncantid = cndncantid;
        this.cndnvaltot = cndnvaltot;
        this.cndcdesserv = cndcdesserv;
    }

    public org.profamilia.hc.model.dto.CfnovedetaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CfnovedetaPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCndcservic() {
        return this.cndcservic;
    }

    public void setCndcservic(String cndcservic) {
        this.cndcservic = cndcservic;
    }

    public Double getCndnvalser() {
        return this.cndnvalser;
    }

    public void setCndnvalser(Double cndnvalser) {
        this.cndnvalser = cndnvalser;
    }

    public Double getCndnivaser() {
        return this.cndnivaser;
    }

    public void setCndnivaser(Double cndnivaser) {
        this.cndnivaser = cndnivaser;
    }

    public Double getCndndescto() {
        return this.cndndescto;
    }

    public void setCndndescto(Double cndndescto) {
        this.cndndescto = cndndescto;
    }

    public Long getCndncantid() {
        return this.cndncantid;
    }

    public void setCndncantid(Long cndncantid) {
        this.cndncantid = cndncantid;
    }

    public Double getCndnvalent() {
        return this.cndnvalent;
    }

    public void setCndnvalent(Double cndnvalent) {
        this.cndnvalent = cndnvalent;
    }

    public Double getCndnvaltot() {
        return this.cndnvaltot;
    }

    public void setCndnvaltot(Double cndnvaltot) {
        this.cndnvaltot = cndnvaltot;
    }

    public String getCndcpaquet() {
        return this.cndcpaquet;
    }

    public void setCndcpaquet(String cndcpaquet) {
        this.cndcpaquet = cndcpaquet;
    }

    public String getCndcswpaqu() {
        return this.cndcswpaqu;
    }

    public void setCndcswpaqu(String cndcswpaqu) {
        this.cndcswpaqu = cndcswpaqu;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCndcdesserv() {
        return this.cndcdesserv;
    }

    public void setCndcdesserv(String cndcdesserv) {
        this.cndcdesserv = cndcdesserv;
    }

    public Double getCndnrecaudo() {
        return this.cndnrecaudo;
    }

    public void setCndnrecaudo(Double cndnrecaudo) {
        this.cndnrecaudo = cndnrecaudo;
    }

    public String getCndncuotcopa() {
        return this.cndncuotcopa;
    }

    public void setCndncuotcopa(String cndncuotcopa) {
        this.cndncuotcopa = cndncuotcopa;
    }

    public String getCndctipdscto() {
        return this.cndctipdscto;
    }

    public void setCndctipdscto(String cndctipdscto) {
        this.cndctipdscto = cndctipdscto;
    }

    public Long getCndnidedscto() {
        return this.cndnidedscto;
    }

    public void setCndnidedscto(Long cndnidedscto) {
        this.cndnidedscto = cndnidedscto;
    }

    public String getCndcestado() {
        return this.cndcestado;
    }

    public void setCndcestado(String cndcestado) {
        this.cndcestado = cndcestado;
    }

    public String getCndcsrvant() {
        return this.cndcsrvant;
    }

    public void setCndcsrvant(String cndcsrvant) {
        this.cndcsrvant = cndcsrvant;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cfnovedeta) ) return false;
        Cfnovedeta castOther = (Cfnovedeta) other;
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

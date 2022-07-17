package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chinfopsico implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChinfopsicoPK id;

    /** persistent field */
    private String hipcmotivinfor;

    /** persistent field */
    private String hipctecinsutl;

    /** persistent field */
    private String hipcdesccaso;

    /** persistent field */
    private String hipcconcreco;

    /** persistent field */
    private String hipcnombprof;

    /** persistent field */
    private String hipccargprof;

    /** persistent field */
    private String hipcregiprof;

    /** persistent field */
    private String hipcoperador;

    /** persistent field */
    private Date hipdfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chinfopsico(org.profamilia.hc.model.dto.ChinfopsicoPK comp_id, String hipcmotivinfor, String hipctecinsutl, String hipcdesccaso, String hipcconcreco, String hipcnombprof, String hipccargprof, String hipcregiprof, String hipcoperador, Date hipdfecregistr, Integer version) {
        this.id = comp_id;
        this.hipcmotivinfor = hipcmotivinfor;
        this.hipctecinsutl = hipctecinsutl;
        this.hipcdesccaso = hipcdesccaso;
        this.hipcconcreco = hipcconcreco;
        this.hipcnombprof = hipcnombprof;
        this.hipccargprof = hipccargprof;
        this.hipcregiprof = hipcregiprof;
        this.hipcoperador = hipcoperador;
        this.hipdfecregistr = hipdfecregistr;
        this.version = version;
    }

    /** default constructor */
    public Chinfopsico() {
    }

    /** minimal constructor */
    public Chinfopsico(org.profamilia.hc.model.dto.ChinfopsicoPK comp_id, String hipcmotivinfor, String hipctecinsutl, String hipcdesccaso, String hipcconcreco, String hipcnombprof, String hipccargprof, String hipcregiprof, String hipcoperador, Date hipdfecregistr) {
        this.id = comp_id;
        this.hipcmotivinfor = hipcmotivinfor;
        this.hipctecinsutl = hipctecinsutl;
        this.hipcdesccaso = hipcdesccaso;
        this.hipcconcreco = hipcconcreco;
        this.hipcnombprof = hipcnombprof;
        this.hipccargprof = hipccargprof;
        this.hipcregiprof = hipcregiprof;
        this.hipcoperador = hipcoperador;
        this.hipdfecregistr = hipdfecregistr;
    }

    public org.profamilia.hc.model.dto.ChinfopsicoPK getId() {
        return this.id;
    }

    public void setId(org.profamilia.hc.model.dto.ChinfopsicoPK id) {
        this.id = id;
    }

    public String getHipcmotivinfor() {
        return this.hipcmotivinfor;
    }

    public void setHipcmotivinfor(String hipcmotivinfor) {
        this.hipcmotivinfor = hipcmotivinfor;
    }

    public String getHipctecinsutl() {
        return this.hipctecinsutl;
    }

    public void setHipctecinsutl(String hipctecinsutl) {
        this.hipctecinsutl = hipctecinsutl;
    }

    public String getHipcdesccaso() {
        return this.hipcdesccaso;
    }

    public void setHipcdesccaso(String hipcdesccaso) {
        this.hipcdesccaso = hipcdesccaso;
    }

    public String getHipcconcreco() {
        return this.hipcconcreco;
    }

    public void setHipcconcreco(String hipcconcreco) {
        this.hipcconcreco = hipcconcreco;
    }

    public String getHipcnombprof() {
        return this.hipcnombprof;
    }

    public void setHipcnombprof(String hipcnombprof) {
        this.hipcnombprof = hipcnombprof;
    }

    public String getHipccargprof() {
        return this.hipccargprof;
    }

    public void setHipccargprof(String hipccargprof) {
        this.hipccargprof = hipccargprof;
    }

    public String getHipcregiprof() {
        return this.hipcregiprof;
    }

    public void setHipcregiprof(String hipcregiprof) {
        this.hipcregiprof = hipcregiprof;
    }

    public String getHipcoperador() {
        return this.hipcoperador;
    }

    public void setHipcoperador(String hipcoperador) {
        this.hipcoperador = hipcoperador;
    }

    public Date getHipdfecregistr() {
        return this.hipdfecregistr;
    }

    public void setHipdfecregistr(Date hipdfecregistr) {
        this.hipdfecregistr = hipdfecregistr;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chinfopsico) ) return false;
        Chinfopsico castOther = (Chinfopsico) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chlecttuber implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChlecttuberPK comp_id;

    /** nullable persistent field */
    private Date hltdfechlect;

    /** nullable persistent field */
    private String hltcresultado;

    /** nullable persistent field */
    private String hltcobservac;

    /** nullable persistent field */
    private String hltcusuregisl;

    /** persistent field */
    private String hltcusunombl;

    /** nullable persistent field */
    private String hltcusuprofel;

    /** nullable persistent field */
    private String hltcentilectl;

    /** nullable persistent field */
    private String hltcusuregist;

    /** nullable persistent field */
    private String hltcusunombt;

    /** nullable persistent field */
    private String hltcusuprofet;

    /** nullable persistent field */
    private String hltcentilectt;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chlecttuber(org.profamilia.hc.model.dto.ChlecttuberPK comp_id, Date hltdfechlect, String hltcresultado, String hltcobservac, String hltcusuregisl, String hltcusunombl, String hltcusuprofel, String hltcentilectl, String hltcusuregist, String hltcusunombt, String hltcusuprofet, String hltcentilectt, Integer version) {
        this.comp_id = comp_id;
        this.hltdfechlect = hltdfechlect;
        this.hltcresultado = hltcresultado;
        this.hltcobservac = hltcobservac;
        this.hltcusuregisl = hltcusuregisl;
        this.hltcusunombl = hltcusunombl;
        this.hltcusuprofel = hltcusuprofel;
        this.hltcentilectl = hltcentilectl;
        this.hltcusuregist = hltcusuregist;
        this.hltcusunombt = hltcusunombt;
        this.hltcusuprofet = hltcusuprofet;
        this.hltcentilectt = hltcentilectt;
        this.version = version;
    }

    /** default constructor */
    public Chlecttuber() {
    }

    /** minimal constructor */
    public Chlecttuber(org.profamilia.hc.model.dto.ChlecttuberPK comp_id, String hltcusunombl) {
        this.comp_id = comp_id;
        this.hltcusunombl = hltcusunombl;
    }

    public org.profamilia.hc.model.dto.ChlecttuberPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChlecttuberPK comp_id) {
        this.comp_id = comp_id;
    }

    public Date getHltdfechlect() {
        return this.hltdfechlect;
    }

    public void setHltdfechlect(Date hltdfechlect) {
        this.hltdfechlect = hltdfechlect;
    }

    public String getHltcresultado() {
        return this.hltcresultado;
    }

    public void setHltcresultado(String hltcresultado) {
        this.hltcresultado = hltcresultado;
    }

    public String getHltcobservac() {
        return this.hltcobservac;
    }

    public void setHltcobservac(String hltcobservac) {
        this.hltcobservac = hltcobservac;
    }

    public String getHltcusuregisl() {
        return this.hltcusuregisl;
    }

    public void setHltcusuregisl(String hltcusuregisl) {
        this.hltcusuregisl = hltcusuregisl;
    }

    public String getHltcusunombl() {
        return this.hltcusunombl;
    }

    public void setHltcusunombl(String hltcusunombl) {
        this.hltcusunombl = hltcusunombl;
    }

    public String getHltcusuprofel() {
        return this.hltcusuprofel;
    }

    public void setHltcusuprofel(String hltcusuprofel) {
        this.hltcusuprofel = hltcusuprofel;
    }

    public String getHltcentilectl() {
        return this.hltcentilectl;
    }

    public void setHltcentilectl(String hltcentilectl) {
        this.hltcentilectl = hltcentilectl;
    }

    public String getHltcusuregist() {
        return this.hltcusuregist;
    }

    public void setHltcusuregist(String hltcusuregist) {
        this.hltcusuregist = hltcusuregist;
    }

    public String getHltcusunombt() {
        return this.hltcusunombt;
    }

    public void setHltcusunombt(String hltcusunombt) {
        this.hltcusunombt = hltcusunombt;
    }

    public String getHltcusuprofet() {
        return this.hltcusuprofet;
    }

    public void setHltcusuprofet(String hltcusuprofet) {
        this.hltcusuprofet = hltcusuprofet;
    }

    public String getHltcentilectt() {
        return this.hltcentilectt;
    }

    public void setHltcentilectt(String hltcentilectt) {
        this.hltcentilectt = hltcentilectt;
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
        if ( !(other instanceof Chlecttuber) ) return false;
        Chlecttuber castOther = (Chlecttuber) other;
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

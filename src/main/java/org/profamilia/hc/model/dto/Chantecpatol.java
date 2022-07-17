package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chantecpatol implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChantecpatolPK comp_id;

    /** nullable persistent field */
    private String hapcvih;

    /** nullable persistent field */
    private String hapcdiabmelli;

    /** nullable persistent field */
    private String hapcartrireuma;

    /** nullable persistent field */
    private String hapcesclmult;

    /** nullable persistent field */
    private String hapccancer;

    /** nullable persistent field */
    private String hapcescllatamio;

    /** nullable persistent field */
    private String hapcnefropa;

    /** nullable persistent field */
    private String hapcmigrana;

    /** nullable persistent field */
    private String hapcfibromi;

    /** nullable persistent field */
    private String hapcotra;

    /** nullable persistent field */
    private String hapccual;

    /** nullable persistent field */
    private Date hapdfecregistr;

    /** nullable persistent field */
    private String hapcoperador;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chantecpatol(org.profamilia.hc.model.dto.ChantecpatolPK comp_id, String hapcvih, String hapcdiabmelli, String hapcartrireuma, String hapcesclmult, String hapccancer, String hapcescllatamio, String hapcnefropa, String hapcmigrana, String hapcfibromi, String hapcotra, String hapccual, Date hapdfecregistr, String hapcoperador, Integer version) {
        this.comp_id = comp_id;
        this.hapcvih = hapcvih;
        this.hapcdiabmelli = hapcdiabmelli;
        this.hapcartrireuma = hapcartrireuma;
        this.hapcesclmult = hapcesclmult;
        this.hapccancer = hapccancer;
        this.hapcescllatamio = hapcescllatamio;
        this.hapcnefropa = hapcnefropa;
        this.hapcmigrana = hapcmigrana;
        this.hapcfibromi = hapcfibromi;
        this.hapcotra = hapcotra;
        this.hapccual = hapccual;
        this.hapdfecregistr = hapdfecregistr;
        this.hapcoperador = hapcoperador;
        this.version = version;
    }

    /** default constructor */
    public Chantecpatol() {
    }

    /** minimal constructor */
    public Chantecpatol(org.profamilia.hc.model.dto.ChantecpatolPK comp_id) {
        this.comp_id = comp_id;
    }

    public org.profamilia.hc.model.dto.ChantecpatolPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChantecpatolPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHapcvih() {
        return this.hapcvih;
    }

    public void setHapcvih(String hapcvih) {
        this.hapcvih = hapcvih;
    }

    public String getHapcdiabmelli() {
        return this.hapcdiabmelli;
    }

    public void setHapcdiabmelli(String hapcdiabmelli) {
        this.hapcdiabmelli = hapcdiabmelli;
    }

    public String getHapcartrireuma() {
        return this.hapcartrireuma;
    }

    public void setHapcartrireuma(String hapcartrireuma) {
        this.hapcartrireuma = hapcartrireuma;
    }

    public String getHapcesclmult() {
        return this.hapcesclmult;
    }

    public void setHapcesclmult(String hapcesclmult) {
        this.hapcesclmult = hapcesclmult;
    }

    public String getHapccancer() {
        return this.hapccancer;
    }

    public void setHapccancer(String hapccancer) {
        this.hapccancer = hapccancer;
    }

    public String getHapcescllatamio() {
        return this.hapcescllatamio;
    }

    public void setHapcescllatamio(String hapcescllatamio) {
        this.hapcescllatamio = hapcescllatamio;
    }

    public String getHapcnefropa() {
        return this.hapcnefropa;
    }

    public void setHapcnefropa(String hapcnefropa) {
        this.hapcnefropa = hapcnefropa;
    }

    public String getHapcmigrana() {
        return this.hapcmigrana;
    }

    public void setHapcmigrana(String hapcmigrana) {
        this.hapcmigrana = hapcmigrana;
    }

    public String getHapcfibromi() {
        return this.hapcfibromi;
    }

    public void setHapcfibromi(String hapcfibromi) {
        this.hapcfibromi = hapcfibromi;
    }

    public String getHapcotra() {
        return this.hapcotra;
    }

    public void setHapcotra(String hapcotra) {
        this.hapcotra = hapcotra;
    }

    public String getHapccual() {
        return this.hapccual;
    }

    public void setHapccual(String hapccual) {
        this.hapccual = hapccual;
    }

    public Date getHapdfecregistr() {
        return this.hapdfecregistr;
    }

    public void setHapdfecregistr(Date hapdfecregistr) {
        this.hapdfecregistr = hapdfecregistr;
    }

    public String getHapcoperador() {
        return this.hapcoperador;
    }

    public void setHapcoperador(String hapcoperador) {
        this.hapcoperador = hapcoperador;
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
        if ( !(other instanceof Chantecpatol) ) return false;
        Chantecpatol castOther = (Chantecpatol) other;
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

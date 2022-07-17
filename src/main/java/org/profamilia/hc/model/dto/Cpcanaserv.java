package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpcanaserv implements Serializable {

    /** identifier field */
    private CpcanaservPK id;

    /** persistent field */
    private Date ccsdfecreg;

    /** persistent field */
    private String ccscusuari;

    /** persistent field */
    private Long ccsncantid;

    /** nullable persistent field */
    private String ccscestado;

    /** nullable persistent field */
    private Long version;

    /** persistent field */
    private String ccsccontrola;

    /** full constructor */
    public Cpcanaserv(CpcanaservPK id, Date ccsdfecreg, String ccscusuari, Long ccsncantid, String ccscestado, Long version, String ccsccontrola) {
        this.id = id;
        this.ccsdfecreg = ccsdfecreg;
        this.ccscusuari = ccscusuari;
        this.ccsncantid = ccsncantid;
        this.ccscestado = ccscestado;
        this.version = version;
        this.ccsccontrola = ccsccontrola;
    }

    /** default constructor */
    public Cpcanaserv() {
    }

    /** minimal constructor */
    public Cpcanaserv(CpcanaservPK id, Date ccsdfecreg, String ccscusuari, Long ccsncantid, String ccsccontrola) {
        this.id = id;
        this.ccsdfecreg = ccsdfecreg;
        this.ccscusuari = ccscusuari;
        this.ccsncantid = ccsncantid;
        this.ccsccontrola = ccsccontrola;
    }

    public CpcanaservPK getId() {
        return this.id;
    }

    public void setId(CpcanaservPK id) {
        this.id = id;
    }

    public Date getCcsdfecreg() {
        return this.ccsdfecreg;
    }

    public void setCcsdfecreg(Date ccsdfecreg) {
        this.ccsdfecreg = ccsdfecreg;
    }

    public String getCcscusuari() {
        return this.ccscusuari;
    }

    public void setCcscusuari(String ccscusuari) {
        this.ccscusuari = ccscusuari;
    }

    public Long getCcsncantid() {
        return this.ccsncantid;
    }

    public void setCcsncantid(Long ccsncantid) {
        this.ccsncantid = ccsncantid;
    }

    public String getCcscestado() {
        return this.ccscestado;
    }

    public void setCcscestado(String ccscestado) {
        this.ccscestado = ccscestado;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCcsccontrola() {
        return this.ccsccontrola;
    }

    public void setCcsccontrola(String ccsccontrola) {
        this.ccsccontrola = ccsccontrola;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cpcanaserv) ) return false;
        Cpcanaserv castOther = (Cpcanaserv) other;
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

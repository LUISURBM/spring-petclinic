package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpinsumate implements Serializable {

    /** identifier field */
    private CpinsumatePK id;

    /** persistent field */
    private String cimcdescserv;

    /** persistent field */
    private String cimcunimedbas;

    /** persistent field */
    private String cimcuniduso;

    /** persistent field */
    private BigDecimal cimncantusad;

    /** persistent field */
    private BigDecimal cimndesperdi;

    /** persistent field */
    private String cimcmatetraz;

    /** persistent field */
    private String cimccargpaci;

    /** persistent field */
    private String cimcestado;

    /** nullable persistent field */
    private BigDecimal version;

    /** persistent field */
    private String cimcusuario;

    /** persistent field */
    private Date cimdfechregi;

   
    /** default constructor */
    public Cpinsumate() {
    }

   
  
    public String getCimcdescserv() {
        return this.cimcdescserv;
    }

    public void setCimcdescserv(String cimcdescserv) {
        this.cimcdescserv = cimcdescserv;
    }

    public String getCimcunimedbas() {
        return this.cimcunimedbas;
    }

    public void setCimcunimedbas(String cimcunimedbas) {
        this.cimcunimedbas = cimcunimedbas;
    }

    public String getCimcuniduso() {
        return this.cimcuniduso;
    }

    public void setCimcuniduso(String cimcuniduso) {
        this.cimcuniduso = cimcuniduso;
    }

    public BigDecimal getCimncantusad() {
        return this.cimncantusad;
    }

    public void setCimncantusad(BigDecimal cimncantusad) {
        this.cimncantusad = cimncantusad;
    }

    public BigDecimal getCimndesperdi() {
        return this.cimndesperdi;
    }

    public void setCimndesperdi(BigDecimal cimndesperdi) {
        this.cimndesperdi = cimndesperdi;
    }

    public String getCimcmatetraz() {
        return this.cimcmatetraz;
    }

    public void setCimcmatetraz(String cimcmatetraz) {
        this.cimcmatetraz = cimcmatetraz;
    }

    public String getCimccargpaci() {
        return this.cimccargpaci;
    }

    public void setCimccargpaci(String cimccargpaci) {
        this.cimccargpaci = cimccargpaci;
    }

    public String getCimcestado() {
        return this.cimcestado;
    }

    public void setCimcestado(String cimcestado) {
        this.cimcestado = cimcestado;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getCimcusuario() {
        return this.cimcusuario;
    }

    public void setCimcusuario(String cimcusuario) {
        this.cimcusuario = cimcusuario;
    }

    public Date getCimdfechregi() {
        return this.cimdfechregi;
    }

    public void setCimdfechregi(Date cimdfechregi) {
        this.cimdfechregi = cimdfechregi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getId())
            .toString();
    }
    

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cpinsumate) ) return false;
        Cpinsumate castOther = (Cpinsumate) other;
        return new EqualsBuilder()
            .append(this.getId(), castOther.getId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public void setId(CpinsumatePK id) {
        this.id = id;
    }

    public CpinsumatePK getId() {
        return id;
    }
}

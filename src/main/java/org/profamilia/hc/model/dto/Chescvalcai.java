package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chescvalcai implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChescvalcaiPK comp_id;

    /** nullable persistent field */
    private Date hevcdfecregistr;

    /** nullable persistent field */
    private String hevccoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hevccaidprev;

    /** nullable persistent field */
    private String hevccmedicamen;

    /** nullable persistent field */
    private String hevccdefisens;

    /** nullable persistent field */
    private String hevccestament;
    
    /** nullable persistent field */
    private String hevccdeambula;

    /** nullable persistent field */
    private Integer hevccpuntos;
    
    /** nullable persistent field */
    private Long hevlusuario;
    
    private boolean editable;
    
    private String caidasPrevias ;
    
    private String medicamentos ;
    
    private String deficitSensorial ;
    
    private String estadoMental ;
    
    private String deambulacion ;
    


    /** default constructor */
    public Chescvalcai() {
    }

    /** minimal constructor */
    public Chescvalcai(org.profamilia.hc.model.dto.ChescvalcaiPK comp_id) {
        this.comp_id = comp_id;
    }

    public org.profamilia.hc.model.dto.ChescvalcaiPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChescvalcaiPK comp_id) {
        this.comp_id = comp_id;
    }

    public Date getHevcdfecregistr() {
        return this.hevcdfecregistr;
    }

    public void setHevcdfecregistr(Date hevcdfecregistr) {
        this.hevcdfecregistr = hevcdfecregistr;
    }

    public String getHevccoperador() {
        return this.hevccoperador;
    }

    public void setHevccoperador(String hevccoperador) {
        this.hevccoperador = hevccoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHevccaidprev() {
        return this.hevccaidprev;
    }

    public void setHevccaidprev(String hevccaidprev) {
        this.hevccaidprev = hevccaidprev;
    }


    public String getHevccmedicamen() {
        return this.hevccmedicamen;
    }

    public void setHevccmedicamen(String hevccmedicamen) {
        this.hevccmedicamen = hevccmedicamen;
    }

    public String getHevccdefisens() {
        return this.hevccdefisens;
    }

    public void setHevccdefisens(String hevccdefisens) {
        this.hevccdefisens = hevccdefisens;
    }

    public String getHevccestament() {
        return this.hevccestament;
    }

    public void setHevccestament(String hevccestament) {
        this.hevccestament = hevccestament;
    }

    public String getHevccdeambula() {
        return this.hevccdeambula;
    }

    public void setHevccdeambula(String hevccdeambula) {
        this.hevccdeambula = hevccdeambula;
    }

    public Integer getHevccpuntos() {
        return this.hevccpuntos;
    }

    public void setHevccpuntos(Integer hevccpuntos) {
        this.hevccpuntos = hevccpuntos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Chescvalcai) ) return false;
        Chescvalcai castOther = (Chescvalcai) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setCaidasPrevias(String caidasPrevias) {
        this.caidasPrevias = caidasPrevias;
    }

    public String getCaidasPrevias() {
        return caidasPrevias;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setDeficitSensorial(String deficitSensorial) {
        this.deficitSensorial = deficitSensorial;
    }

    public String getDeficitSensorial() {
        return deficitSensorial;
    }

    public void setEstadoMental(String estadoMental) {
        this.estadoMental = estadoMental;
    }

    public String getEstadoMental() {
        return estadoMental;
    }

    public void setDeambulacion(String deambulacion) {
        this.deambulacion = deambulacion;
    }

    public String getDeambulacion() {
        return deambulacion;
    }

    public void setHevlusuario(Long hevlusuario) {
        this.hevlusuario = hevlusuario;
    }

    public Long getHevlusuario() {
        return hevlusuario;
    }
}

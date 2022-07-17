package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cfdetafactura implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.CfdetafacturaPK comp_id;

    /** nullable persistent field */
    private String cdfcservicio;

    /** nullable persistent field */
    private Long cdfnorden;

    /** nullable persistent field */
    private String cdfcobserv;

    /** nullable persistent field */
    private String cdfclote;

    /** nullable persistent field */
    private Double cdfndescuento;

    /** nullable persistent field */
    private Double cdfniva;

    /** nullable persistent field */
    private Long cdfncliente;

    /** nullable persistent field */
    private String cdfnestado;

    /** nullable persistent field */
    private String cdfcpaquet;

    /** nullable persistent field */
    private String cdfctipdscto;

    /** nullable persistent field */
    private Double cdfnvalsrv;

    /** nullable persistent field */
    private Long cdfncantidad;

    /** nullable persistent field */
    private Long version;

    /** nullable persistent field */
    private String cdfcetapa;

    /** nullable persistent field */
    private String cdfcusuamodi;

    /** nullable persistent field */
    private Date cdfdfechmodi;

    /** nullable persistent field */
    private Long cdfnconsuclin;

    /** nullable persistent field */
    private String cdfcswitpaq;
    
    private Boolean validacionConsultaClinica;

    private String nombreServicio;
    
    private String descripcionServicio;
    
    private boolean checkServiciosAsociados;
    
    private Integer tipoHistoria;
    
    
    /** full constructor */
    public Cfdetafactura(org.profamilia.hc.model.dto.CfdetafacturaPK comp_id, String cdfcservicio, Long cdfnorden, String cdfcobserv, String cdfclote, Double cdfndescuento, Double cdfniva, Long cdfncliente, String cdfnestado, String cdfcpaquet, String cdfctipdscto, Double cdfnvalsrv, Long cdfncantidad, Long version, String cdfcetapa, String cdfcusuamodi, Date cdfdfechmodi, Long cdfnconsuclin, String cdfcswitpaq) {
        this.comp_id = comp_id;
        this.cdfcservicio = cdfcservicio;
        this.cdfnorden = cdfnorden;
        this.cdfcobserv = cdfcobserv;
        this.cdfclote = cdfclote;
        this.cdfndescuento = cdfndescuento;
        this.cdfniva = cdfniva;
        this.cdfncliente = cdfncliente;
        this.cdfnestado = cdfnestado;
        this.cdfcpaquet = cdfcpaquet;
        this.cdfctipdscto = cdfctipdscto;
        this.cdfnvalsrv = cdfnvalsrv;
        this.cdfncantidad = cdfncantidad;
        this.version = version;
        this.cdfcetapa = cdfcetapa;
        this.cdfcusuamodi = cdfcusuamodi;
        this.cdfdfechmodi = cdfdfechmodi;
        this.cdfnconsuclin = cdfnconsuclin;
        this.cdfcswitpaq = cdfcswitpaq;
    }

    /** default constructor */
    public Cfdetafactura() {
    }

    /** minimal constructor */
    public Cfdetafactura(org.profamilia.hc.model.dto.CfdetafacturaPK comp_id) {
        this.comp_id = comp_id;
    }

    public org.profamilia.hc.model.dto.CfdetafacturaPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.CfdetafacturaPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getCdfcservicio() {
        return this.cdfcservicio;
    }

    public void setCdfcservicio(String cdfcservicio) {
        this.cdfcservicio = cdfcservicio;
    }

    public Long getCdfnorden() {
        return this.cdfnorden;
    }

    public void setCdfnorden(Long cdfnorden) {
        this.cdfnorden = cdfnorden;
    }

    public String getCdfcobserv() {
        return this.cdfcobserv;
    }

    public void setCdfcobserv(String cdfcobserv) {
        this.cdfcobserv = cdfcobserv;
    }

    public String getCdfclote() {
        return this.cdfclote;
    }

    public void setCdfclote(String cdfclote) {
        this.cdfclote = cdfclote;
    }

    public Double getCdfndescuento() {
        return this.cdfndescuento;
    }

    public void setCdfndescuento(Double cdfndescuento) {
        this.cdfndescuento = cdfndescuento;
    }

    public Double getCdfniva() {
        return this.cdfniva;
    }

    public void setCdfniva(Double cdfniva) {
        this.cdfniva = cdfniva;
    }

    public Long getCdfncliente() {
        return this.cdfncliente;
    }

    public void setCdfncliente(Long cdfncliente) {
        this.cdfncliente = cdfncliente;
    }

    public String getCdfnestado() {
        return this.cdfnestado;
    }

    public void setCdfnestado(String cdfnestado) {
        this.cdfnestado = cdfnestado;
    }

    public String getCdfcpaquet() {
        return this.cdfcpaquet;
    }

    public void setCdfcpaquet(String cdfcpaquet) {
        this.cdfcpaquet = cdfcpaquet;
    }

    public String getCdfctipdscto() {
        return this.cdfctipdscto;
    }

    public void setCdfctipdscto(String cdfctipdscto) {
        this.cdfctipdscto = cdfctipdscto;
    }

    public Double getCdfnvalsrv() {
        return this.cdfnvalsrv;
    }

    public void setCdfnvalsrv(Double cdfnvalsrv) {
        this.cdfnvalsrv = cdfnvalsrv;
    }

    public Long getCdfncantidad() {
        return this.cdfncantidad;
    }

    public void setCdfncantidad(Long cdfncantidad) {
        this.cdfncantidad = cdfncantidad;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCdfcetapa() {
        return this.cdfcetapa;
    }

    public void setCdfcetapa(String cdfcetapa) {
        this.cdfcetapa = cdfcetapa;
    }

    public String getCdfcusuamodi() {
        return this.cdfcusuamodi;
    }

    public void setCdfcusuamodi(String cdfcusuamodi) {
        this.cdfcusuamodi = cdfcusuamodi;
    }

    public Date getCdfdfechmodi() {
        return this.cdfdfechmodi;
    }

    public void setCdfdfechmodi(Date cdfdfechmodi) {
        this.cdfdfechmodi = cdfdfechmodi;
    }

    public Long getCdfnconsuclin() {
        return this.cdfnconsuclin;
    }

    public void setCdfnconsuclin(Long cdfnconsuclin) {
        this.cdfnconsuclin = cdfnconsuclin;
    }

    public String getCdfcswitpaq() {
        return this.cdfcswitpaq;
    }

    public void setCdfcswitpaq(String cdfcswitpaq) {
        this.cdfcswitpaq = cdfcswitpaq;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("comp_id", getComp_id())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Cfdetafactura) ) return false;
        Cfdetafactura castOther = (Cfdetafactura) other;
        return new EqualsBuilder()
            .append(this.getComp_id(), castOther.getComp_id())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getComp_id())
            .toHashCode();
    }

    public void setValidacionConsultaClinica(Boolean validacionConsultaClinica) {
        this.validacionConsultaClinica = validacionConsultaClinica;
    }

    public Boolean getValidacionConsultaClinica() {
        return validacionConsultaClinica;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setDescripcionServicio(String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }

    public String getDescripcionServicio() {
        return descripcionServicio;
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setDescripcionServi(ValueChangeEvent valueChangeEvent) {
         setDescripcionServicio((String)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setCheckServiciosAsociados(boolean checkServiciosAsociados) {
        this.checkServiciosAsociados = checkServiciosAsociados;
    }

    public boolean isCheckServiciosAsociados() {
        return checkServiciosAsociados;
    }

    public void setTipoHistoria(Integer tipoHistoria) {
        this.tipoHistoria = tipoHistoria;
    }

    public Integer getTipoHistoria() {
        return tipoHistoria;
    }
}

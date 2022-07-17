package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Ctacumcosto implements Serializable {

    /** identifier field */
    private Long cacnnumero;

    /** persistent field */
    private Long cacnclinica;

    /** persistent field */
    private Date cacdfecmov;

    /** persistent field */
    private long cacnadmision;

    /** persistent field */
    private String cacctipocost;

    /** persistent field */
    private String caccinsumo;

    /** nullable persistent field */
    private String cacclote;

    /** persistent field */
    private long cacncantidad;

    /** persistent field */
    private String caccunidmedi;

    /** persistent field */
    private String cacccargpaci;

    /** nullable persistent field */
    private Long cacnconsclin;

    /** persistent field */
    private String caccservicio;

    /** nullable persistent field */
    private String caccsector;

    /** nullable persistent field */
    private String cacccencos;

    /** persistent field */
    private String caccestado;

    /** persistent field */
    private String caccetapa;

    /** persistent field */
    private String caccusureg;

    /** persistent field */
    private Date cacdfecreg;

    /** nullable persistent field */
    private String caccusuanu;

    /** nullable persistent field */
    private Date cacdfecanu;

    /** nullable persistent field */
    private BigDecimal version;

  
    /** default constructor */
    public Ctacumcosto() {
    }

  

    /** 
     * 		       Identificador acumulado de costos
     * 		    
     */
  

    public Long getCacnclinica() {
        return this.cacnclinica;
    }

    public void setCacnclinica(Long cacnclinica) {
        this.cacnclinica = cacnclinica;
    }

    public Date getCacdfecmov() {
        return this.cacdfecmov;
    }

    public void setCacdfecmov(Date cacdfecmov) {
        this.cacdfecmov = cacdfecmov;
    }

    public long getCacnadmision() {
        return this.cacnadmision;
    }

    public void setCacnadmision(long cacnadmision) {
        this.cacnadmision = cacnadmision;
    }

    public String getCacctipocost() {
        return this.cacctipocost;
    }

    public void setCacctipocost(String cacctipocost) {
        this.cacctipocost = cacctipocost;
    }

    public String getCaccinsumo() {
        return this.caccinsumo;
    }

    public void setCaccinsumo(String caccinsumo) {
        this.caccinsumo = caccinsumo;
    }

    public String getCacclote() {
        return this.cacclote;
    }

    public void setCacclote(String cacclote) {
        this.cacclote = cacclote;
    }

    public long getCacncantidad() {
        return this.cacncantidad;
    }

    public void setCacncantidad(long cacncantidad) {
        this.cacncantidad = cacncantidad;
    }

    public String getCaccunidmedi() {
        return this.caccunidmedi;
    }

    public void setCaccunidmedi(String caccunidmedi) {
        this.caccunidmedi = caccunidmedi;
    }

    public String getCacccargpaci() {
        return this.cacccargpaci;
    }

    public void setCacccargpaci(String cacccargpaci) {
        this.cacccargpaci = cacccargpaci;
    }

    public Long getCacnconsclin() {
        return this.cacnconsclin;
    }

    public void setCacnconsclin(Long cacnconsclin) {
        this.cacnconsclin = cacnconsclin;
    }

    public String getCaccservicio() {
        return this.caccservicio;
    }

    public void setCaccservicio(String caccservicio) {
        this.caccservicio = caccservicio;
    }

    public String getCaccsector() {
        return this.caccsector;
    }

    public void setCaccsector(String caccsector) {
        this.caccsector = caccsector;
    }

    public String getCacccencos() {
        return this.cacccencos;
    }

    public void setCacccencos(String cacccencos) {
        this.cacccencos = cacccencos;
    }

    public String getCaccestado() {
        return this.caccestado;
    }

    public void setCaccestado(String caccestado) {
        this.caccestado = caccestado;
    }

    public String getCaccetapa() {
        return this.caccetapa;
    }

    public void setCaccetapa(String caccetapa) {
        this.caccetapa = caccetapa;
    }

    public String getCaccusureg() {
        return this.caccusureg;
    }

    public void setCaccusureg(String caccusureg) {
        this.caccusureg = caccusureg;
    }

    public Date getCacdfecreg() {
        return this.cacdfecreg;
    }

    public void setCacdfecreg(Date cacdfecreg) {
        this.cacdfecreg = cacdfecreg;
    }

    public String getCaccusuanu() {
        return this.caccusuanu;
    }

    public void setCaccusuanu(String caccusuanu) {
        this.caccusuanu = caccusuanu;
    }

    public Date getCacdfecanu() {
        return this.cacdfecanu;
    }

    public void setCacdfecanu(Date cacdfecanu) {
        this.cacdfecanu = cacdfecanu;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cacnnumero", getCacnnumero())
            .toString();
    }

    public void setCacnnumero(Long cacnnumero) {
        this.cacnnumero = cacnnumero;
    }

    public Long getCacnnumero() {
        return cacnnumero;
    }
}

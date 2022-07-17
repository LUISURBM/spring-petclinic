package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chentregacitol implements Serializable {

    /** identifier field */
    private Long heclidentificador;

    /** persistent field */
    private Date hecdfechaenvio;

    /** persistent field */
    private Date hecdfechaenvio2;

    /** persistent field */
    private BigDecimal hecnlablectura1;

    /** nullable persistent field */
    private BigDecimal hecnlablectura2;

    /** persistent field */
    private Integer hecnclinica;

    /** persistent field */
    private String heccoperador;

    /** persistent field */
    private Date hecdfechamod;

    /** persistent field */
    private Set chdetaentcitos = new HashSet(0);

    /** default constructor */
    public Chentregacitol() {
    }

    /** 
     * Identificador del listado de citologias que se entregan para su analisis.
     * 		    
     */
    public Long getHeclidentificador() {
        return this.heclidentificador;
    }

    public void setHeclidentificador(Long heclidentificador) {
        this.heclidentificador = heclidentificador;
    }

    public Date getHecdfechaenvio() {
        return this.hecdfechaenvio;
    }

    public void setHecdfechaenvio(Date hecdfechaenvio) {
        this.hecdfechaenvio = hecdfechaenvio;
    }

    public BigDecimal getHecnlablectura1() {
        return this.hecnlablectura1;
    }

    public void setHecnlablectura1(BigDecimal hecnlablectura1) {
        this.hecnlablectura1 = hecnlablectura1;
    }

    public BigDecimal getHecnlablectura2() {
        return this.hecnlablectura2;
    }

    public void setHecnlablectura2(BigDecimal hecnlablectura2) {
        this.hecnlablectura2 = hecnlablectura2;
    }

    public Integer getHecnclinica() {
        return this.hecnclinica;
    }

    public void setHecnclinica(Integer hecnclinica) {
        this.hecnclinica = hecnclinica;
    }

    public String getHeccoperador() {
        return this.heccoperador;
    }

    public void setHeccoperador(String heccoperador) {
        this.heccoperador = heccoperador;
    }

    public Date getHecdfechamod() {
        return this.hecdfechamod;
    }

    public void setHecdfechamod(Date hecdfechamod) {
        this.hecdfechamod = hecdfechamod;
    }

    public Set getChdetaentcitos() {
        return this.chdetaentcitos;
    }

    public void setChdetaentcitos(Set chdetaentcitos) {
        this.chdetaentcitos = chdetaentcitos;
    }

    public void setHecdfechaenvio2(Date hecdfechaenvio2) {
        this.hecdfechaenvio2 = hecdfechaenvio2;
    }

    public Date getHecdfechaenvio2() {
        return hecdfechaenvio2;
    }
}

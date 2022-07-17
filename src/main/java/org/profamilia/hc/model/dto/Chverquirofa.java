package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chverquirofa implements Serializable {

    /** identifier field */
    private Long hvqlcirugia;

    /** nullable persistent field */
    private Date hvqdfecverifi;

    /** nullable persistent field */
    private Chusuario hvqlusuario;

    /** nullable persistent field */
    private String hvqctipoaneste;

    /** nullable persistent field */
    private String hvqchoraingres;

    /** nullable persistent field */
    private String hvqchorasalida;

    /** nullable persistent field */
    private String hvqcobservac;

    /** nullable persistent field */
    private BigDecimal hvqnanestesio;
    
    /** nullable persistent field */
    private BigDecimal hvqncirujano;

    /** nullable persistent field */
    private BigDecimal hvqnenfermero;

    /** nullable persistent field */
    private BigDecimal hvqninstrumen;

    /** nullable persistent field */
    private Date hvqdfecreg;

    /** nullable persistent field */
    private String hvqcgrabador;

    /** nullable persistent field */
    private String hvqcimpreso;

    /** nullable persistent field */
    private String hvqcetapa;

    /** persistent field */
    private Set<Chitemvrquir> chitemvrquir;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chverquirofa() {

    }


    /**
     * @param hvqlnumero
     */
    public void setHvqlcirugia(Long hvqlcirugia) {
        this.hvqlcirugia = hvqlcirugia;
    }

    /**
     * @return
     */
    public Long getHvqlcirugia() {
        return hvqlcirugia;
    }

    /**
     * @param hvqlusuario
     */
    public void setHvqlusuario(Chusuario hvqlusuario) {
        this.hvqlusuario = hvqlusuario;
    }

    /**
     * @return
     */
    public Chusuario getHvqlusuario() {
        return hvqlusuario;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return version;
    }


    /**
     * @param chitemvrquir
     */
    public void setChitemvrquir(Set<Chitemvrquir> chitemvrquir) {
        this.chitemvrquir = chitemvrquir;
    }

    /**
     * @return
     */
    public Set<Chitemvrquir> getChitemvrquir() {
        return chitemvrquir;
    }


    public void setHvqdfecverifi(Date hvqdfecverifi) {
        this.hvqdfecverifi = hvqdfecverifi;
    }

    public Date getHvqdfecverifi() {
        return hvqdfecverifi;
    }

    public void setHvqctipoaneste(String hvqctipoaneste) {
        this.hvqctipoaneste = hvqctipoaneste;
    }

    public String getHvqctipoaneste() {
        return hvqctipoaneste;
    }

    public void setHvqchoraingres(String hvqchoraingres) {
        this.hvqchoraingres = hvqchoraingres;
    }

    public String getHvqchoraingres() {
        return hvqchoraingres;
    }

    public void setHvqchorasalida(String hvqchorasalida) {
        this.hvqchorasalida = hvqchorasalida;
    }

    public String getHvqchorasalida() {
        return hvqchorasalida;
    }

    public void setHvqcobservac(String hvqcobservac) {
        this.hvqcobservac = hvqcobservac;
    }

    public String getHvqcobservac() {
        return hvqcobservac;
    }

    public void setHvqdfecreg(Date hvqdfecreg) {
        this.hvqdfecreg = hvqdfecreg;
    }

    public Date getHvqdfecreg() {
        return hvqdfecreg;
    }

    public void setHvqcgrabador(String hvqcgrabador) {
        this.hvqcgrabador = hvqcgrabador;
    }

    public String getHvqcgrabador() {
        return hvqcgrabador;
    }


    public void setHvqcimpreso(String hvqcimpreso) {
        this.hvqcimpreso = hvqcimpreso;
    }

    public String getHvqcimpreso() {
        return hvqcimpreso;
    }


    public void setHvqnanestesio(BigDecimal hvqnanestesio) {
        this.hvqnanestesio = hvqnanestesio;
    }

    public BigDecimal getHvqnanestesio() {
        return hvqnanestesio;
    }

    public void setHvqncirujano(BigDecimal hvqncirujano) {
        this.hvqncirujano = hvqncirujano;
    }

    public BigDecimal getHvqncirujano() {
        return hvqncirujano;
    }

    public void setHvqnenfermero(BigDecimal hvqnenfermero) {
        this.hvqnenfermero = hvqnenfermero;
    }

    public BigDecimal getHvqnenfermero() {
        return hvqnenfermero;
    }

    public void setHvqninstrumen(BigDecimal hvqninstrumen) {
        this.hvqninstrumen = hvqninstrumen;
    }

    public BigDecimal getHvqninstrumen() {
        return hvqninstrumen;
    }

    public void setHvqcetapa(String hvqcetapa) {
        this.hvqcetapa = hvqcetapa;
    }

    public String getHvqcetapa() {
        return hvqcetapa;
    }
}

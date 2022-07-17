package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cffactura implements Serializable {

    private Long cfnconsfact;
    private String cfcorden;
    private String cfcpaciente;
    private String cfceps;
    private Long cfnclinica;
    private String cfcutilizacion;
    private Double cfnvalor_total;
    private Double cfndescuento;
    private Long cfncontrato;
    private String cfcintext;
    private Long cfnturno;
    private String cfcip;
    private String cfnestado;
    private Long cfnnumpaci;
    private String cfcusuareg;
    private Long cfnadmision;
    private String cfctipide;
    private Long cfnnumide;
    private Double cfncuotacop;
    private Long version;
    private String cfnnumfact;
    private Date cfdfechregi;
    private String cfcusuaregi;
    private String cfctipoadmi;
    private Date cfdfechadmi;
    private Long cfnnumesap;
    private String cfcetapa;
    private Date cfdfechanul;
    
    /** default constructor */
    public Cffactura() {
    }


    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }


    public void setCfnconsfact(Long cfnconsfact) {
        this.cfnconsfact = cfnconsfact;
    }

    public Long getCfnconsfact() {
        return cfnconsfact;
    }

    public void setCfcorden(String cfcorden) {
        this.cfcorden = cfcorden;
    }

    public String getCfcorden() {
        return cfcorden;
    }

    public void setCfcpaciente(String cfcpaciente) {
        this.cfcpaciente = cfcpaciente;
    }

    public String getCfcpaciente() {
        return cfcpaciente;
    }

    public void setCfceps(String cfceps) {
        this.cfceps = cfceps;
    }

    public String getCfceps() {
        return cfceps;
    }

    public void setCfnclinica(Long cfnclinica) {
        this.cfnclinica = cfnclinica;
    }

    public Long getCfnclinica() {
        return cfnclinica;
    }

    public void setCfcutilizacion(String cfcutilizacion) {
        this.cfcutilizacion = cfcutilizacion;
    }

    public String getCfcutilizacion() {
        return cfcutilizacion;
    }

    public void setCfnvalor_total(Double cfnvalor_total) {
        this.cfnvalor_total = cfnvalor_total;
    }

    public Double getCfnvalor_total() {
        return cfnvalor_total;
    }

    public void setCfndescuento(Double cfndescuento) {
        this.cfndescuento = cfndescuento;
    }

    public Double getCfndescuento() {
        return cfndescuento;
    }

    public void setCfncontrato(Long cfncontrato) {
        this.cfncontrato = cfncontrato;
    }

    public Long getCfncontrato() {
        return cfncontrato;
    }

    public void setCfcintext(String cfcintext) {
        this.cfcintext = cfcintext;
    }

    public String getCfcintext() {
        return cfcintext;
    }

    public void setCfnturno(Long cfnturno) {
        this.cfnturno = cfnturno;
    }

    public Long getCfnturno() {
        return cfnturno;
    }

    public void setCfcip(String cfcip) {
        this.cfcip = cfcip;
    }

    public String getCfcip() {
        return cfcip;
    }

    public void setCfnestado(String cfnestado) {
        this.cfnestado = cfnestado;
    }

    public String getCfnestado() {
        return cfnestado;
    }

    public void setCfnnumpaci(Long cfnnumpaci) {
        this.cfnnumpaci = cfnnumpaci;
    }

    public Long getCfnnumpaci() {
        return cfnnumpaci;
    }

    public void setCfcusuareg(String cfcusuareg) {
        this.cfcusuareg = cfcusuareg;
    }

    public String getCfcusuareg() {
        return cfcusuareg;
    }

    public void setCfnadmision(Long cfnadmision) {
        this.cfnadmision = cfnadmision;
    }

    public Long getCfnadmision() {
        return cfnadmision;
    }

    public void setCfctipide(String cfctipide) {
        this.cfctipide = cfctipide;
    }

    public String getCfctipide() {
        return cfctipide;
    }

    public void setCfnnumide(Long cfnnumide) {
        this.cfnnumide = cfnnumide;
    }

    public Long getCfnnumide() {
        return cfnnumide;
    }

    public void setCfncuotacop(Double cfncuotacop) {
        this.cfncuotacop = cfncuotacop;
    }

    public Double getCfncuotacop() {
        return cfncuotacop;
    }

    public void setCfnnumfact(String cfnnumfact) {
        this.cfnnumfact = cfnnumfact;
    }

    public String getCfnnumfact() {
        return cfnnumfact;
    }

    public void setCfdfechregi(Date cfdfechregi) {
        this.cfdfechregi = cfdfechregi;
    }

    public Date getCfdfechregi() {
        return cfdfechregi;
    }

    public void setCfcusuaregi(String cfcusuaregi) {
        this.cfcusuaregi = cfcusuaregi;
    }

    public String getCfcusuaregi() {
        return cfcusuaregi;
    }

    public void setCfctipoadmi(String cfctipoadmi) {
        this.cfctipoadmi = cfctipoadmi;
    }

    public String getCfctipoadmi() {
        return cfctipoadmi;
    }

    public void setCfdfechadmi(Date cfdfechadmi) {
        this.cfdfechadmi = cfdfechadmi;
    }

    public Date getCfdfechadmi() {
        return cfdfechadmi;
    }

    public void setCfnnumesap(Long cfnnumesap) {
        this.cfnnumesap = cfnnumesap;
    }

    public Long getCfnnumesap() {
        return cfnnumesap;
    }

    public void setCfcetapa(String cfcetapa) {
        this.cfcetapa = cfcetapa;
    }

    public String getCfcetapa() {
        return cfcetapa;
    }

    public void setCfdfechanul(Date cfdfechanul) {
        this.cfdfechanul = cfdfechanul;
    }

    public Date getCfdfechanul() {
        return cfdfechanul;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcuestplani implements Serializable {

    /** identifier field */
    private ChcuestplaniPK id;

    /** nullable persistent field */
    private String hcpcmetotempla;

    /** nullable persistent field */
    private String hcpcmetodefpla;

    /** nullable persistent field */
    private String hcpcembarazada;

    /** nullable persistent field */
    private String hcpcmestnormal;

    /** nullable persistent field */
    private String hcpcfallametem;

    /** nullable persistent field */
    private String hcpcinfometoso;

    /** nullable persistent field */
    private String hcpcusametopla;

    /** nullable persistent field */
    private String hcpcpartoabort;

    /** nullable persistent field */
    private String hcpcmetodoplan;

    /** nullable persistent field */
    private Date hcpdfechaparto;

    /** nullable persistent field */
    private Date hcpdfechultmes;

    /** nullable persistent field */
    private String hcpcoperador;

    /** nullable persistent field */
    private Date hcpdfecregistr;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hcpcmetintemb; 


    /** default constructor */
    public Chcuestplani() {
    }

    public void setId(ChcuestplaniPK id) {
        this.id = id;
    }

    public ChcuestplaniPK getId() {
        return id;
    }

    public void setHcpcmetotempla(String hcpcmetotempla) {
        this.hcpcmetotempla = hcpcmetotempla;
    }

    public String getHcpcmetotempla() {
        return hcpcmetotempla;
    }

    public void setHcpcmetodefpla(String hcpcmetodefpla) {
        this.hcpcmetodefpla = hcpcmetodefpla;
    }

    public String getHcpcmetodefpla() {
        return hcpcmetodefpla;
    }

    public void setHcpcembarazada(String hcpcembarazada) {
        this.hcpcembarazada = hcpcembarazada;
    }

    public String getHcpcembarazada() {
        return hcpcembarazada;
    }

    public void setHcpcmestnormal(String hcpcmestnormal) {
        this.hcpcmestnormal = hcpcmestnormal;
    }

    public String getHcpcmestnormal() {
        return hcpcmestnormal;
    }

    public void setHcpcfallametem(String hcpcfallametem) {
        this.hcpcfallametem = hcpcfallametem;
    }

    public String getHcpcfallametem() {
        return hcpcfallametem;
    }

    public void setHcpcinfometoso(String hcpcinfometoso) {
        this.hcpcinfometoso = hcpcinfometoso;
    }

    public String getHcpcinfometoso() {
        return hcpcinfometoso;
    }

    public void setHcpcusametopla(String hcpcusametopla) {
        this.hcpcusametopla = hcpcusametopla;
    }

    public String getHcpcusametopla() {
        return hcpcusametopla;
    }

    public void setHcpcpartoabort(String hcpcpartoabort) {
        this.hcpcpartoabort = hcpcpartoabort;
    }

    public String getHcpcpartoabort() {
        return hcpcpartoabort;
    }

    public void setHcpcmetodoplan(String hcpcmetodoplan) {
        this.hcpcmetodoplan = hcpcmetodoplan;
    }

    public String getHcpcmetodoplan() {
        return hcpcmetodoplan;
    }

    public void setHcpdfechaparto(Date hcpdfechaparto) {
        this.hcpdfechaparto = hcpdfechaparto;
    }

    public Date getHcpdfechaparto() {
        return hcpdfechaparto;
    }

    public void setHcpdfechultmes(Date hcpdfechultmes) {
        this.hcpdfechultmes = hcpdfechultmes;
    }

    public Date getHcpdfechultmes() {
        return hcpdfechultmes;
    }

    public void setHcpcoperador(String hcpcoperador) {
        this.hcpcoperador = hcpcoperador;
    }

    public String getHcpcoperador() {
        return hcpcoperador;
    }

    public void setHcpdfecregistr(Date hcpdfecregistr) {
        this.hcpdfecregistr = hcpdfecregistr;
    }

    public Date getHcpdfecregistr() {
        return hcpdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHcpcmetintemb(String hcpcmetintemb) {
        this.hcpcmetintemb = hcpcmetintemb;
    }

    public String getHcpcmetintemb() {
        return hcpcmetintemb;
    }
}

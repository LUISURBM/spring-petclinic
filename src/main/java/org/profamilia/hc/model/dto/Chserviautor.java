package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

public class Chserviautor implements Serializable {

    /** identifier field */
    private ChserviautorPK id;
    
     /** identifier field */
    private String hsencodigocups;
    /** identifier field */
    private Integer hsencantiservi;
    /** identifier field */
    private String hsecnombreserv;
    /** identifier field */
    private Integer hsenconsecuaut;
    /** identifier field */
    private Integer version;
    /** identifier field */
    private Date hsedfechregist;
    /** identifier field */
    private String hsecoperador;


    public Chserviautor() {
         id = new ChserviautorPK();
    }

    public void setId(ChserviautorPK id) {
        this.id = id;
    }

    public ChserviautorPK getId() {
        return id;
    }

    public void setHsencodigocups(String hsencodigocups) {
        this.hsencodigocups = hsencodigocups;
    }

    public String getHsencodigocups() {
        return hsencodigocups;
    }

    public void setHsencantiservi(Integer hsencantiservi) {
        this.hsencantiservi = hsencantiservi;
    }

    public Integer getHsencantiservi() {
        return hsencantiservi;
    }

    public void setHsecnombreserv(String hsecnombreserv) {
        this.hsecnombreserv = hsecnombreserv;
    }

    public String getHsecnombreserv() {
        return hsecnombreserv;
    }

    public void setHsenconsecuaut(Integer hsenconsecuaut) {
        this.hsenconsecuaut = hsenconsecuaut;
    }

    public Integer getHsenconsecuaut() {
        return hsenconsecuaut;
    }

    public void setHsedfechregist(Date hsedfechregist) {
        this.hsedfechregist = hsedfechregist;
    }

    public Date getHsedfechregist() {
        return hsedfechregist;
    }

    public void setHsecoperador(String hsecoperador) {
        this.hsecoperador = hsecoperador;
    }

    public String getHsecoperador() {
        return hsecoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import org.profamilia.hc.view.constantes.IConstantes;


/** @author Hibernate CodeGenerator */
public class Cncitologi implements Serializable {

    /** identifier field */
    private Integer ccinconsec;

    /** persistent field */
    private Integer ccinnumero;

    /** persistent field */
    private Integer ccinclinic;

    /** persistent field */
    private String ccictipide;

    /** persistent field */
    private Long ccianumide;

    /** persistent field */
    private String ccicprinom;

    /** nullable persistent field */
    private String ccicsegnom;

    /** persistent field */
    private String ccicpriape;

    /** nullable persistent field */
    private String ccicsegape;

    /** nullable persistent field */
    private String ccicdirecc;

    /** nullable persistent field */
    private String ccictelefo;

    /** persistent field */
    private Integer ccindepart;

    /** persistent field */
    private Integer ccinmunici;

    /** nullable persistent field */
    private String ccicotrdir;

    /** nullable persistent field */
    private String ccicotrtel;

    /** nullable persistent field */
    private Integer ccinotrdep;

    /** nullable persistent field */
    private Integer ccinotrmun;

    /** persistent field */
    private Integer ccinedad;

    /** persistent field */
    private String ccictipafi;

    /** nullable persistent field */
    private String ccicasegur;

    /** persistent field */
    private String ccicusureg;

    /** persistent field */
    private Date ccidfecreg;

    /** persistent field */
    private Integer ccintipdoc;

    /** persistent field */
    private BigDecimal ccinnumdoc;

    /** nullable persistent field */
    private Integer version;

    /** persistent field */
    private Date ccithorreg;

    /** nullable persistent field */
    private Date ccidfeccit;

    /** persistent field */
    private String ccicentreg;

    /** nullable persistent field */
    private Date ccidfecent;

    /** persistent field */
    private Integer ccinestado;

    /** persistent field */
    private Chusuario ccilusuario;

    /** nullable persistent field */
    private Long ccilconcli;
 
   /** nullable persistent field */
    private Integer ccintiphis;
    
    /** nullable persistent field */
    private String ccicidengen;
    
    /** nullable persistent field */
    private String ccicvulnera; 
    
    private String wtipcito;
    
    private String ccicreaconinf;
    
    private String cciccuacondil;
    
    private String ccicautusodat;



    /** default constructor */
    public Cncitologi() {
    }


    public void setCcinconsec(Integer ccinconsec) {
        this.ccinconsec = ccinconsec;
    }

    public Integer getCcinconsec() {
        return ccinconsec;
    }

    public void setCcinnumero(Integer ccinnumero) {
        this.ccinnumero = ccinnumero;
    }

    public Integer getCcinnumero() {
        return ccinnumero;
    }

    public void setCcinclinic(Integer ccinclinic) {
        this.ccinclinic = ccinclinic;
    }

    public Integer getCcinclinic() {
        return ccinclinic;
    }

    public void setCcictipide(String ccictipide) {
        this.ccictipide = ccictipide;
    }

    public String getCcictipide() {
        return ccictipide;
    }

    public void setCcianumide(Long ccianumide) {
        this.ccianumide = ccianumide;
    }

    public Long getCcianumide() {
        return ccianumide;
    }

    public void setCcicprinom(String ccicprinom) {
        this.ccicprinom = ccicprinom;
    }

    public String getCcicprinom() {
        return ccicprinom;
    }

    public void setCcicsegnom(String ccicsegnom) {
        this.ccicsegnom = ccicsegnom;
    }

    public String getCcicsegnom() {
        return ccicsegnom;
    }

    public void setCcicpriape(String ccicpriape) {
        this.ccicpriape = ccicpriape;
    }

    public String getCcicpriape() {
        return ccicpriape;
    }

    public void setCcicsegape(String ccicsegape) {
        this.ccicsegape = ccicsegape;
    }

    public String getCcicsegape() {
        return ccicsegape;
    }

    public void setCcicdirecc(String ccicdirecc) {
        this.ccicdirecc = ccicdirecc;
    }

    public String getCcicdirecc() {
        return ccicdirecc;
    }

    public void setCcictelefo(String ccictelefo) {
        this.ccictelefo = ccictelefo;
    }

    public String getCcictelefo() {
        return ccictelefo;
    }

    public void setCcindepart(Integer ccindepart) {
        this.ccindepart = ccindepart;
    }

    public Integer getCcindepart() {
        return ccindepart;
    }

    public void setCcinmunici(Integer ccinmunici) {
        this.ccinmunici = ccinmunici;
    }

    public Integer getCcinmunici() {
        return ccinmunici;
    }

    public void setCcicotrdir(String ccicotrdir) {
        this.ccicotrdir = ccicotrdir;
    }

    public String getCcicotrdir() {
        return ccicotrdir;
    }

    public void setCcicotrtel(String ccicotrtel) {
        this.ccicotrtel = ccicotrtel;
    }

    public String getCcicotrtel() {
        return ccicotrtel;
    }

    public void setCcinotrdep(Integer ccinotrdep) {
        this.ccinotrdep = ccinotrdep;
    }

    public Integer getCcinotrdep() {
        return ccinotrdep;
    }

    public void setCcinotrmun(Integer ccinotrmun) {
        this.ccinotrmun = ccinotrmun;
    }

    public Integer getCcinotrmun() {
        return ccinotrmun;
    }

    public void setCcinedad(Integer ccinedad) {
        this.ccinedad = ccinedad;
    }

    public Integer getCcinedad() {
        return ccinedad;
    }

    public void setCcictipafi(String ccictipafi) {
        this.ccictipafi = ccictipafi;
    }

    public String getCcictipafi() {
        return ccictipafi;
    }

    public void setCcicasegur(String ccicasegur) {
        this.ccicasegur = ccicasegur;
    }

    public String getCcicasegur() {
        return ccicasegur;
    }

    public void setCcicusureg(String ccicusureg) {
        this.ccicusureg = ccicusureg;
    }

    public String getCcicusureg() {
        return ccicusureg;
    }

    public void setCcidfecreg(Date ccidfecreg) {
        this.ccidfecreg = ccidfecreg;
    }

    public Date getCcidfecreg() {
        return ccidfecreg;
    }

    public void setCcintipdoc(Integer ccintipdoc) {
        this.ccintipdoc = ccintipdoc;
    }

    public Integer getCcintipdoc() {
        return ccintipdoc;
    }

    public void setCcinnumdoc(BigDecimal ccinnumdoc) {
        this.ccinnumdoc = ccinnumdoc;
    }

    public BigDecimal getCcinnumdoc() {
        return ccinnumdoc;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setCcithorreg(Date ccithorreg) {
        this.ccithorreg = ccithorreg;
    }

    /**
     * @return
     */
    public Date getCcithorreg() {
        return ccithorreg;
    }

    /**
     * @param ccidfeccit
     */
    public void setCcidfeccit(Date ccidfeccit) {
        this.ccidfeccit = ccidfeccit;
    }

    /**
     * @return
     */
    public Date getCcidfeccit() {
        return ccidfeccit;
    }

    /**
     * @param ccicentreg
     */
    public void setCcicentreg(String ccicentreg) {
        this.ccicentreg = ccicentreg;
    }

    /**
     * @return
     */
    public String getCcicentreg() {
        return ccicentreg;
    }

    /**
     * @param ccidfecent
     */
    public void setCcidfecent(Date ccidfecent) {
        this.ccidfecent = ccidfecent;
    }

    /**
     * @return
     */
    public Date getCcidfecent() {
        return ccidfecent;
    }

    /**
     * @param ccinestado
     */
    public void setCcinestado(Integer ccinestado) {
        this.ccinestado = ccinestado;
    }

    /**
     * @return
     */
    public Integer getCcinestado() {
        return ccinestado;
    }

    /**
     * @param ccilusuario
     */
    public void setCcilusuario(Chusuario ccilusuario) {
        this.ccilusuario = ccilusuario;
    }

    /**
     * @return
     */
    public Chusuario getCcilusuario() {
        return ccilusuario;
    }

    /**
     * @param ccilconcli
     */
    public void setCcilconcli(Long ccilconcli) {
        this.ccilconcli = ccilconcli;
    }

    /**
     * @return
     */
    public Long getCcilconcli() {
        return ccilconcli;
    }

    public void setCcintiphis(Integer ccintiphis) {
        this.ccintiphis = ccintiphis;
    }

    public Integer getCcintiphis() {
        return ccintiphis;
    }

    public void setCcicidengen(String ccicidengen) {
        this.ccicidengen = ccicidengen;
    }

    public String getCcicidengen() {
        return ccicidengen;
    }

    public void setCcicvulnera(String ccicvulnera) {
        this.ccicvulnera = ccicvulnera;
    }

    public String getCcicvulnera() {
        return ccicvulnera;
    }
    
    public String getWtipcito() {
     wtipcito = "";
        if(ccintiphis != null){
            if(ccintiphis.equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA)){
                wtipcito = "Convencional";
            }
            
            if(ccintiphis.equals(IConstantes.HISTORIA_PROCEDIMIENTO_VPH_TOMA)){
                wtipcito = "VPH";
            }
            
            if(ccintiphis.equals(IConstantes.HISTORIA_PROCEDIMIENTO_CITOLOGIA_TOMA_BASELIQUIDA)){
                wtipcito = "Base Liquida";
            }     
            
            if(ccintiphis.equals(IConstantes.HISTORIA_LECTURA_CITOLOGIA_CONVENCIONAL)){
                wtipcito = "Lectura Convencional";
            }    
            
            if(ccintiphis.equals(IConstantes.HISTORIA_LECTURA_CITOLOGIA_BASE_LIQUIDA)){
                wtipcito = "Lectura Base Liquida";
            }    
            
            if(ccintiphis.equals(IConstantes.HISTORIA_LECTURA_VPH_BASE_LIQUIDA)){
                wtipcito = "Lectura VPH";
            }    
        }
    
        return wtipcito;
    }

    public void setCcicreaconinf(String ccicreaconinf) {
        this.ccicreaconinf = ccicreaconinf;
    }

    public String getCcicreaconinf() {
        return ccicreaconinf;
    }

    public void setCciccuacondil(String cciccuacondil) {
        this.cciccuacondil = cciccuacondil;
    }

    public String getCciccuacondil() {
        return cciccuacondil;
    }

    public void setCcicautusodat(String ccicautusodat) {
        this.ccicautusodat = ccicautusodat;
    }

    public String getCcicautusodat() {
        return ccicautusodat;
    }
}

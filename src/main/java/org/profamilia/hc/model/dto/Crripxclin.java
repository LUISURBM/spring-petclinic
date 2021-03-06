package org.profamilia.hc.model.dto;

import java.util.Date;


/**
 * Crregcontr generated by hbm2java
 */
public class

Crripxclin implements java.io.Serializable {


    private CrripxclinId id;
    private String cricconpro;
    private Integer crinconcep;
    private Integer crinfinali;
    private Integer crinambito;
    private Integer crincauext;
    private String cricperate;
    private String cricdiagpr;
    private String cricdiagre;
    private Integer crintipdia;
    private Integer crinrealiz;
    private Date cridfecreg;
    private String cricusuari;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }
    // Constructors

    /** default constructor */
    public Crripxclin() {
    }

    /** constructor with id */
    public
    // HS == CrregcontrId


    Crripxclin(CrripxclinId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR


    // Property accessors


    public CrripxclinId getId() {
        return this.id;
    }

    public void setId(CrripxclinId id) {
        this.id = id;
    }


    public String getCricconpro() {
        return cricconpro;
    }

    public void setCricconpro(String cricconpro) {
        this.cricconpro = cricconpro;
    }

    public Integer getCrinconcep() {
        return crinconcep;
    }

    public void setCrinconcep(Integer crinconcep) {
        this.crinconcep = crinconcep;
    }

    public Integer getCrinfinali() {
        return crinfinali;
    }

    public void setCrinfinali(Integer crinfinali) {
        this.crinfinali = crinfinali;
    }

    public Integer getCrinambito() {
        return crinambito;
    }

    public void setCrinambito(Integer crinambito) {
        this.crinambito = crinambito;
    }

    public Integer getCrincauext() {
        return crincauext;
    }

    public void setCrincauext(Integer crincauext) {
        this.crincauext = crincauext;
    }

    public String getCricperate() {
        return cricperate;
    }

    public void setCricperate(String cricperate) {
        this.cricperate = cricperate;
    }

    public String getCricdiagpr() {
        return cricdiagpr;
    }

    public void setCricdiagpr(String cricdiagpr) {
        this.cricdiagpr = cricdiagpr;
    }

    public String getCricdiagre() {
        return cricdiagre;
    }

    public void setCricdiagre(String cricdiagre) {
        this.cricdiagre = cricdiagre;
    }

    public Integer getCrintipdia() {
        return crintipdia;
    }

    public void setCrintipdia(Integer crintipdia) {
        this.crintipdia = crintipdia;
    }

    public Integer getCrinrealiz() {
        return crinrealiz;
    }

    public void setCrinrealiz(Integer crinrealiz) {
        this.crinrealiz = crinrealiz;
    }

    public Date getCridfecreg() {
        return cridfecreg;
    }

    public void setCridfecreg(Date cridfecreg) {
        this.cridfecreg = cridfecreg;
    }

    public String getCricusuari() {
        return cricusuari;
    }

    public void setCricusuari(String cricusuari) {
        this.cricusuari = cricusuari;
    }

}

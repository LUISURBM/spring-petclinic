package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chsolicanula implements Serializable {

    /** identifier field */
    private ChsolicanulaPK id;
    
    /** nullable persistent field */
    private Chusuario hsalusuario; 

    /** nullable persistent field */
    private Cpservicio hsacservicio; 

    /** nullable persistent field */
    private String hsacacepta; 

    /** nullable persistent field */
    private String hsacobsermedic;

    /** nullable persistent field */
    private String hsacobseradmin;

    /** persistent field */
    private Date hsadfecharegis;

    /** nullable persistent field */
    private Date hsadfechamodif;

    /** persistent field */
    private String hsacoperaregis;

    /** nullable persistent field */
    private String hsacoperamodif;

    /** persistent field */
    private Integer hsanclinica;

    /** persistent field */
    private String hsacetapa;

    /** nullable persistent field */
    private Integer version;

  

    /** default constructor */
    public Chsolicanula() {
         id = new ChsolicanulaPK();
    }


    /**
     * @param id
     */
    public void setId(ChsolicanulaPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChsolicanulaPK getId() {
        return id;
    }

    /**
     * @param hsacobsermedic
     */
    public void setHsacobsermedic(String hsacobsermedic) {
        this.hsacobsermedic = hsacobsermedic;
    }

    /**
     * @return
     */
    public String getHsacobsermedic() {
        return hsacobsermedic;
    }

    /**
     * @param hsacobseradmin
     */
    public void setHsacobseradmin(String hsacobseradmin) {
        this.hsacobseradmin = hsacobseradmin;
    }

    /**
     * @return
     */
    public String getHsacobseradmin() {
        return hsacobseradmin;
    }

    /**
     * @param hsadfecharegis
     */
    public void setHsadfecharegis(Date hsadfecharegis) {
        this.hsadfecharegis = hsadfecharegis;
    }

    /**
     * @return
     */
    public Date getHsadfecharegis() {
        return hsadfecharegis;
    }

    /**
     * @param hsadfechamodif
     */
    public void setHsadfechamodif(Date hsadfechamodif) {
        this.hsadfechamodif = hsadfechamodif;
    }

    /**
     * @return
     */
    public Date getHsadfechamodif() {
        return hsadfechamodif;
    }

    /**
     * @param hsacoperaregis
     */
    public void setHsacoperaregis(String hsacoperaregis) {
        this.hsacoperaregis = hsacoperaregis;
    }

    /**
     * @return
     */
    public String getHsacoperaregis() {
        return hsacoperaregis;
    }

    /**
     * @param hsacoperamodif
     */
    public void setHsacoperamodif(String hsacoperamodif) {
        this.hsacoperamodif = hsacoperamodif;
    }

    /**
     * @return
     */
    public String getHsacoperamodif() {
        return hsacoperamodif;
    }

    /**
     * @param hsanclinica
     */
    public void setHsanclinica(Integer hsanclinica) {
        this.hsanclinica = hsanclinica;
    }

    /**
     * @return
     */
    public Integer getHsanclinica() {
        return hsanclinica;
    }

    /**
     * @param hsacetapa
     */
    public void setHsacetapa(String hsacetapa) {
        this.hsacetapa = hsacetapa;
    }

    /**
     * @return
     */
    public String getHsacetapa() {
        return hsacetapa;
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
     * @param hsalusuario
     */
    public void setHsalusuario(Chusuario hsalusuario) {
        this.hsalusuario = hsalusuario;
    }

    /**
     * @return
     */
    public Chusuario getHsalusuario() {
        return hsalusuario;
    }

    /**
     * @param hsacservicio
     */
    public void setHsacservicio(Cpservicio hsacservicio) {
        this.hsacservicio = hsacservicio;
    }

    /**
     * @return
     */
    public Cpservicio getHsacservicio() {
        return hsacservicio;
    }

    /**
     * @param hsacacepta
     */
    public void setHsacacepta(String hsacacepta) {
        this.hsacacepta = hsacacepta;
    }

    /**
     * @return
     */
    public String getHsacacepta() {
        return hsacacepta;
    }
}

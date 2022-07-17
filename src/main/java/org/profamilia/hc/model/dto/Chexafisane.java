package org.profamilia.hc.model.dto;

import java.io.Serializable;


import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexafisane implements Serializable {

    /** identifier field */
    private ChexafisanePK id;

    /** nullable persistent field */
    private Date headfecregistr;

    /** nullable persistent field */
    private String heacoperador;

    /** nullable persistent field */
    private Integer heanapertoral;

    /** nullable persistent field */
    private String heactieneprosu;

    /** nullable persistent field */
    private String heactieneproin;

    /** nullable persistent field */
    private String heacgradoproin;

    /** nullable persistent field */
    private String heacgradoprosu;

    /** nullable persistent field */
    private String heacmallampati;

    /** nullable persistent field */
    private String heandistametri;

    /** nullable persistent field */
    private String heacmovilanter;

    /** nullable persistent field */
    private String heacmovilatlan;

    /** nullable persistent field */
    private String heacevalugloba;

    /** nullable persistent field */
    private String heacmovilproin;

    /** nullable persistent field */
    private String heacmovilprosu;

    /** nullable persistent field */
    private String heactieneprote;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chexafisane() {
    }


    /**
     * @param id
     */
    public void setId(ChexafisanePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChexafisanePK getId() {
        return id;
    }

  
     /**
     * @param headfecregistr
     */
    public void setHeadfecregistr(Date headfecregistr) {
        this.headfecregistr = headfecregistr;
    }

    /**
     * @return
     */
    public Date getHeadfecregistr() {
        return headfecregistr;
    }

    /**
     * @param heacoperador
     */
    public void setHeacoperador(String heacoperador) {
        this.heacoperador = heacoperador;
    }

    /**
     * @return
     */
    public String getHeacoperador() {
        return heacoperador;
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
     * @param heanapertoral
     */
    public void setHeanapertoral(Integer heanapertoral) {
        this.heanapertoral = heanapertoral;
    }

    /**
     * @return
     */
    public Integer getHeanapertoral() {
        return heanapertoral;
    }


    /**
     * @param heacmallampati
     */
    public void setHeacmallampati(String heacmallampati) {
        this.heacmallampati = heacmallampati;
    }

    /**
     * @return
     */
    public String getHeacmallampati() {
        return heacmallampati;
    }

    /**
     * @param heandistametri
     */
    public void setHeandistametri(String heandistametri) {
        this.heandistametri = heandistametri;
    }

    /**
     * @return
     */
    public String getHeandistametri() {
        return heandistametri;
    }

    /**
     * @param heacmovilanter
     */
    public void setHeacmovilanter(String heacmovilanter) {
        this.heacmovilanter = heacmovilanter;
    }

    /**
     * @return
     */
    public String getHeacmovilanter() {
        return heacmovilanter;
    }

    /**
     * @param heacmovilatlan
     */
    public void setHeacmovilatlan(String heacmovilatlan) {
        this.heacmovilatlan = heacmovilatlan;
    }

    /**
     * @return
     */
    public String getHeacmovilatlan() {
        return heacmovilatlan;
    }

    /**
     * @param heacevalugloba
     */
    public void setHeacevalugloba(String heacevalugloba) {
        this.heacevalugloba = heacevalugloba;
    }

    /**
     * @return
     */
    public String getHeacevalugloba() {
        return heacevalugloba;
    }

    /**
     * @param heactieneprosu
     */
    public void setHeactieneprosu(String heactieneprosu) {
        this.heactieneprosu = heactieneprosu;
    }

    /**
     * @return
     */
    public String getHeactieneprosu() {
        return heactieneprosu;
    }

    /**
     * @param heactieneproin
     */
    public void setHeactieneproin(String heactieneproin) {
        this.heactieneproin = heactieneproin;
    }

    /**
     * @return
     */
    public String getHeactieneproin() {
        return heactieneproin;
    }

    /**
     * @param heacgradoproin
     */
    public void setHeacgradoproin(String heacgradoproin) {
        this.heacgradoproin = heacgradoproin;
    }

    /**
     * @return
     */
    public String getHeacgradoproin() {
        return heacgradoproin;
    }

    /**
     * @param heacgradoprosu
     */
    public void setHeacgradoprosu(String heacgradoprosu) {
        this.heacgradoprosu = heacgradoprosu;
    }

    /**
     * @return
     */
    public String getHeacgradoprosu() {
        return heacgradoprosu;
    }

    /**
     * @param heacmovilproin
     */
    public void setHeacmovilproin(String heacmovilproin) {
        this.heacmovilproin = heacmovilproin;
    }

    /**
     * @return
     */
    public String getHeacmovilproin() {
        return heacmovilproin;
    }

    /**
     * @param heacmovilprosu
     */
    public void setHeacmovilprosu(String heacmovilprosu) {
        this.heacmovilprosu = heacmovilprosu;
    }

    /**
     * @return
     */
    public String getHeacmovilprosu() {
        return heacmovilprosu;
    }

    /**
     * @param heactieneprote
     */
    public void setHeactieneprote(String heactieneprote) {
        this.heactieneprote = heactieneprote;
    }

    /**
     * @return
     */
    public String getHeactieneprote() {
        return heactieneprote;
    }
}

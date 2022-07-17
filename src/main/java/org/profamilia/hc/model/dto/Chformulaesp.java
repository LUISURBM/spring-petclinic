package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chformulaesp implements Serializable {

    /** identifier field */
    private ChformulaespPK id;

    /** nullable persistent field */
    private String hfecmedicament;

    /** nullable persistent field */
    private String hfectratramien;

    /** nullable persistent field */
    private String hfeccontraindi;

    /** nullable persistent field */
    private String hfecviadministr;

    /** nullable persistent field */
    private String hfecviadminotr;

    /** nullable persistent field */
    private Integer hfecadosis;

    /** nullable persistent field */
    private Date hfedfecregistr;

    /** nullable persistent field */
    private String hfecoperador;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chformulaesp() {
    }


    /**
     * @param id
     */
    public void setId(ChformulaespPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChformulaespPK getId() {
        return id;
    }

    /**
     * @param hfecmedicament
     */
    public void setHfecmedicament(String hfecmedicament) {
        this.hfecmedicament = hfecmedicament;
    }

    /**
     * @return
     */
    public String getHfecmedicament() {
        return hfecmedicament;
    }

    /**
     * @param hfectratramien
     */
    public void setHfectratramien(String hfectratramien) {
        this.hfectratramien = hfectratramien;
    }

    /**
     * @return
     */
    public String getHfectratramien() {
        return hfectratramien;
    }

    /**
     * @param hfeccontraindi
     */
    public void setHfeccontraindi(String hfeccontraindi) {
        this.hfeccontraindi = hfeccontraindi;
    }

    /**
     * @return
     */
    public String getHfeccontraindi() {
        return hfeccontraindi;
    }

    /**
     * @param hfecviadministr
     */
    public void setHfecviadministr(String hfecviadministr) {
        this.hfecviadministr = hfecviadministr;
    }

    /**
     * @return
     */
    public String getHfecviadministr() {
        return hfecviadministr;
    }

    /**
     * @param hfecviadminotr
     */
    public void setHfecviadminotr(String hfecviadminotr) {
        this.hfecviadminotr = hfecviadminotr;
    }

    /**
     * @return
     */
    public String getHfecviadminotr() {
        return hfecviadminotr;
    }

    /**
     * @param hfecadosis
     */
    public void setHfecadosis(Integer hfecadosis) {
        this.hfecadosis = hfecadosis;
    }

    /**
     * @return
     */
    public Integer getHfecadosis() {
        return hfecadosis;
    }

    /**
     * @param hfedfecregistr
     */
    public void setHfedfecregistr(Date hfedfecregistr) {
        this.hfedfecregistr = hfedfecregistr;
    }

    /**
     * @return
     */
    public Date getHfedfecregistr() {
        return hfedfecregistr;
    }

    /**
     * @param hfecoperador
     */
    public void setHfecoperador(String hfecoperador) {
        this.hfecoperador = hfecoperador;
    }

    /**
     * @return
     */
    public String getHfecoperador() {
        return hfecoperador;
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
}

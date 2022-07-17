package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chresersangr implements Serializable {

    /** identifier field */
    private ChresersangrPK id;

    /** nullable persistent field */
    private String hrscdiagprin;

    /** nullable persistent field */
    private String hrseconmedalta;

    /** nullable persistent field */
    private String hrsccirugiapro;

    /** nullable persistent field */
    private Date hrsdcirugiapro;

    /** nullable persistent field */
    private Date hrsdfecregistr;

    /** nullable persistent field */
    private String hrsetiporeserv;

    /** nullable persistent field */
    private String hrsecompreserv;

    /** nullable persistent field */
    private Integer hrsncantidadre;

    /** nullable persistent field */
    private String hrseotrcompsan;

    /** nullable persistent field */
    private String hrsccuales;

    /** nullable persistent field */
    private String hrscsolbancsan;

    /** nullable persistent field  */
    private Integer hrsncantiotros;

    /** nullable persistent field */
    private String hrscoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hrscconmedaltadesc;
    
    /** nullable persistent field */
    private String hrscviaacceso;
    
    /** nullable persistent field */
    private String hrsccualviaacceso;
    
    /** default constructor */
    public Chresersangr() {
    }


    /**
     * @param id
     */
    public void setId(ChresersangrPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChresersangrPK getId() {
        return id;
    }

    /**
     * @param hrscdiagprin
     */
    public void setHrscdiagprin(String hrscdiagprin) {
        this.hrscdiagprin = hrscdiagprin;
    }

    /**
     * @return
     */
    public String getHrscdiagprin() {
        return hrscdiagprin;
    }

    /**
     * @param hrseconmedalta
     */
    public void setHrseconmedalta(String hrseconmedalta) {
        this.hrseconmedalta = hrseconmedalta;
    }

    /**
     * @return
     */
    public String getHrseconmedalta() {
        return hrseconmedalta;
    }

    /**
     * @param hrsccirugiapro
     */
    public void setHrsccirugiapro(String hrsccirugiapro) {
        this.hrsccirugiapro = hrsccirugiapro;
    }

    /**
     * @return
     */
    public String getHrsccirugiapro() {
        return hrsccirugiapro;
    }

    /**
     * @param hrsdcirugiapro
     */
    public void setHrsdcirugiapro(Date hrsdcirugiapro) {
        this.hrsdcirugiapro = hrsdcirugiapro;
    }

    /**
     * @return
     */
    public Date getHrsdcirugiapro() {
        return hrsdcirugiapro;
    }

    /**
     * @param hrsdfecregistr
     */
    public void setHrsdfecregistr(Date hrsdfecregistr) {
        this.hrsdfecregistr = hrsdfecregistr;
    }

    /**
     * @return
     */
    public Date getHrsdfecregistr() {
        return hrsdfecregistr;
    }

    /**
     * @param hrsetiporeserv
     */
    public void setHrsetiporeserv(String hrsetiporeserv) {
        this.hrsetiporeserv = hrsetiporeserv;
    }

    /**
     * @return
     */
    public String getHrsetiporeserv() {
        return hrsetiporeserv;
    }

    /**
     * @param hrsecompreserv
     */
    public void setHrsecompreserv(String hrsecompreserv) {
        this.hrsecompreserv = hrsecompreserv;
    }

    /**
     * @return
     */
    public String getHrsecompreserv() {
        return hrsecompreserv;
    }

    /**
     * @param hrsncantidadre
     */
    public void setHrsncantidadre(Integer hrsncantidadre) {
        this.hrsncantidadre = hrsncantidadre;
    }

    /**
     * @return
     */
    public Integer getHrsncantidadre() {
        return hrsncantidadre;
    }

    /**
     * @param hrseotrcompsan
     */
    public void setHrseotrcompsan(String hrseotrcompsan) {
        this.hrseotrcompsan = hrseotrcompsan;
    }

    /**
     * @return
     */
    public String getHrseotrcompsan() {
        return hrseotrcompsan;
    }

    /**
     * @param hrsccuales
     */
    public void setHrsccuales(String hrsccuales) {
        this.hrsccuales = hrsccuales;
    }

    /**
     * @return
     */
    public String getHrsccuales() {
        return hrsccuales;
    }

    /**
     * @param hrscsolbancsan
     */
    public void setHrscsolbancsan(String hrscsolbancsan) {
        this.hrscsolbancsan = hrscsolbancsan;
    }

    /**
     * @return
     */
    public String getHrscsolbancsan() {
        return hrscsolbancsan;
    }

    /**
     * @param hrscoperador
     */
    public void setHrscoperador(String hrscoperador) {
        this.hrscoperador = hrscoperador;
    }

    /**
     * @return
     */
    public String getHrscoperador() {
        return hrscoperador;
    }

    /**
     * @param hrsncantiotros
     */
    public void setHrsncantiotros(Integer hrsncantiotros) {
        this.hrsncantiotros = hrsncantiotros;
    }

    /**
     * @return
     */
    public Integer getHrsncantiotros() {
        return hrsncantiotros;
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

    public void setHrscconmedaltadesc(String hrscconmedaltadesc) {
        this.hrscconmedaltadesc = hrscconmedaltadesc;
    }

    public String getHrscconmedaltadesc() {
        return hrscconmedaltadesc;
    }

    public void setHrscviaacceso(String hrscviaacceso) {
        this.hrscviaacceso = hrscviaacceso;
    }

    public String getHrscviaacceso() {
        return hrscviaacceso;
    }

    public void setHrsccualviaacceso(String hrsccualviaacceso) {
        this.hrsccualviaacceso = hrsccualviaacceso;
    }

    public String getHrsccualviaacceso() {
        return hrsccualviaacceso;
    }
}

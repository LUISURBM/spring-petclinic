package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chdispoaplic implements Serializable {

    /** identifier field */
    private ChdispoaplicPK id;

    /** nullable persistent field */
    private String hdacdispoinser;

    /** nullable persistent field */
    private String hdacretiro;

    /** nullable persistent field */
    private String hdacdescrproce;

    /** nullable persistent field */
    private Date hdadfecregistr;

    /** nullable persistent field */
    private String hdacoperador;

    /** nullable persistent field */
    private String hdacdisporetir;

    /** nullable persistent field */
    private String hdacinsercion;

    /** nullable persistent field */
    private String hdacmotivretir;
     
    /** nullable persistent field */
    private Integer version;
    
    
    /** nullable persistent field */
    private String hdacdiagprinci;


    /** nullable persistent field */
    private String hdacdiagposter;


    /** nullable persistent field */
    private Integer hdanfinalidad;


    /** nullable persistent field */
    private String hdacdiagcompli;

    /** nullable persistent field */
    private String hdacdescrcompl;


    /** nullable persistent field */
    private Integer hdanambitproce;


    /** nullable persistent field */
    private Integer hdanrealizacio;
    
    
    /** nullable persistent field */
    private String hdacdeslugmar;
    
    /** nullable persistent field */
    private String hdacreaproins;

    /** nullable persistent field */
    private String hdacreaproret;

    /** default constructor */
    public Chdispoaplic() {
    }


    /**
     * @param id
     */
    public void setId(ChdispoaplicPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChdispoaplicPK getId() {
        return id;
    }

    /**
     * @param hdacdispoinser
     */
    public void setHdacdispoinser(String hdacdispoinser) {
        this.hdacdispoinser = hdacdispoinser;
    }

    /**
     * @return
     */
    public String getHdacdispoinser() {
        return hdacdispoinser;
    }

    /**
     * @param hdacretiro
     */
    public void setHdacretiro(String hdacretiro) {
        this.hdacretiro = hdacretiro;
    }

    /**
     * @return
     */
    public String getHdacretiro() {
        return hdacretiro;
    }

    /**
     * @param hdacdescrproce
     */
    public void setHdacdescrproce(String hdacdescrproce) {
        this.hdacdescrproce = hdacdescrproce;
    }

    /**
     * @return
     */
    public String getHdacdescrproce() {
        return hdacdescrproce;
    }

    /**
     * @param hdadfecregistr
     */
    public void setHdadfecregistr(Date hdadfecregistr) {
        this.hdadfecregistr = hdadfecregistr;
    }

    /**
     * @return
     */
    public Date getHdadfecregistr() {
        return hdadfecregistr;
    }

    /**
     * @param hdacoperador
     */
    public void setHdacoperador(String hdacoperador) {
        this.hdacoperador = hdacoperador;
    }

    /**
     * @return
     */
    public String getHdacoperador() {
        return hdacoperador;
    }

    /**
     * @param hdacdisporetir
     */
    public void setHdacdisporetir(String hdacdisporetir) {
        this.hdacdisporetir = hdacdisporetir;
    }

    /**
     * @return
     */
    public String getHdacdisporetir() {
        return hdacdisporetir;
    }

    /**
     * @param hdacinsercion
     */
    public void setHdacinsercion(String hdacinsercion) {
        this.hdacinsercion = hdacinsercion;
    }

    /**
     * @return
     */
    public String getHdacinsercion() {
        return hdacinsercion;
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
     * @param hdacmotivretir
     */
    public void setHdacmotivretir(String hdacmotivretir) {
        this.hdacmotivretir = hdacmotivretir;
    }

    /**
     * @return
     */
    public String getHdacmotivretir() {
        return hdacmotivretir;
    }

    /**
     * @param hdacdiagprinci
     */
    public void setHdacdiagprinci(String hdacdiagprinci) {
        this.hdacdiagprinci = hdacdiagprinci;
    }

    /**
     * @return
     */
    public String getHdacdiagprinci() {
        return hdacdiagprinci;
    }

    /**
     * @param hdacdiagposter
     */
    public void setHdacdiagposter(String hdacdiagposter) {
        this.hdacdiagposter = hdacdiagposter;
    }

    /**
     * @return
     */
    public String getHdacdiagposter() {
        return hdacdiagposter;
    }

    /**
     * @param hdanfinalidad
     */
    public void setHdanfinalidad(Integer hdanfinalidad) {
        this.hdanfinalidad = hdanfinalidad;
    }

    /**
     * @return
     */
    public Integer getHdanfinalidad() {
        return hdanfinalidad;
    }

    /**
     * @param hdacdiagcompli
     */
    public void setHdacdiagcompli(String hdacdiagcompli) {
        this.hdacdiagcompli = hdacdiagcompli;
    }

    /**
     * @return
     */
    public String getHdacdiagcompli() {
        return hdacdiagcompli;
    }

    /**
     * @param hdacdescrcompl
     */
    public void setHdacdescrcompl(String hdacdescrcompl) {
        this.hdacdescrcompl = hdacdescrcompl;
    }

    /**
     * @return
     */
    public String getHdacdescrcompl() {
        return hdacdescrcompl;
    }

    /**
     * @param hdanambitproce
     */
    public void setHdanambitproce(Integer hdanambitproce) {
        this.hdanambitproce = hdanambitproce;
    }

    /**
     * @return
     */
    public Integer getHdanambitproce() {
        return hdanambitproce;
    }

    /**
     * @param hdanrealizacio
     */
    public void setHdanrealizacio(Integer hdanrealizacio) {
        this.hdanrealizacio = hdanrealizacio;
    }

    /**
     * @return
     */
    public Integer getHdanrealizacio() {
        return hdanrealizacio;
    }


    public void setHdacdeslugmar(String hdacdeslugmar) {
        this.hdacdeslugmar = hdacdeslugmar;
    }

    public String getHdacdeslugmar() {
        return hdacdeslugmar;
    }

    public void setHdacreaproins(String hdacreaproins) {
        this.hdacreaproins = hdacreaproins;
    }

    public String getHdacreaproins() {
        return hdacreaproins;
    }

    public void setHdacreaproret(String hdacreaproret) {
        this.hdacreaproret = hdacreaproret;
    }

    public String getHdacreaproret() {
        return hdacreaproret;
    }
}

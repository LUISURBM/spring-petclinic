package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chproceconsu implements Serializable {

    /** identifier field */
    private ChproceconsuPK id;

    /** nullable persistent field */
    private String hpccdiagprinci;

    /** nullable persistent field */
    private String hpccdiagposter;
    
    /** nullable persistent field */
    private Integer hpcnambitproce;

    /** nullable persistent field */
    private Integer hpcnfinalidad;

    /** nullable persistent field */
    private String hpccdescrproce;

    /** nullable persistent field */
    private String hpccdiagcompli;

    /** nullable persistent field */
    private String hpccdescrcompl;
    
    /** nullable persistent field */
    private Integer hpcnrealizacio;

    /** nullable persistent field */
    private Date hpcdfecregistr;

    /** nullable persistent field */
    private String hpccoperador;
    
    /** nullable persistent field  */
    private String hpccrefierdolor;     
    
    /** nullable persistent field  */
    private Integer hpcnescaladolor;      
    
    /** nullable persistent field  */
    private Integer hpcnduracidolor;
    
    private String hpccdudointen;
    
    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chproceconsu() {
    }


    /**
     * @param id
     */
    public void setId(ChproceconsuPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChproceconsuPK getId() {
        return id;
    }

    /**
     * @param hpccdiagprinci
     */
    public void setHpccdiagprinci(String hpccdiagprinci) {
        this.hpccdiagprinci = hpccdiagprinci;
    }

    /**
     * @return
     */
    public String getHpccdiagprinci() {
        return hpccdiagprinci;
    }

    /**
     * @param hpccdiagposter
     */
    public void setHpccdiagposter(String hpccdiagposter) {
        this.hpccdiagposter = hpccdiagposter;
    }

    /**
     * @return
     */
    public String getHpccdiagposter() {
        return hpccdiagposter;
    }

    /**
     * @param hpcnfinalidad
     */
    public void setHpcnfinalidad(Integer hpcnfinalidad) {
        this.hpcnfinalidad = hpcnfinalidad;
    }

    /**
     * @return
     */
    public Integer getHpcnfinalidad() {
        return hpcnfinalidad;
    }

    /**
     * @param hpccdescrproce
     */
    public void setHpccdescrproce(String hpccdescrproce) {
        this.hpccdescrproce = hpccdescrproce;
    }

    /**
     * @return
     */
    public String getHpccdescrproce() {
        return hpccdescrproce;
    }

    /**
     * @param hpccdiagcompli
     */
    public void setHpccdiagcompli(String hpccdiagcompli) {
        this.hpccdiagcompli = hpccdiagcompli;
    }

    /**
     * @return
     */
    public String getHpccdiagcompli() {
        return hpccdiagcompli;
    }

    /**
     * @param hpccdescrcompl
     */
    public void setHpccdescrcompl(String hpccdescrcompl) {
        this.hpccdescrcompl = hpccdescrcompl;
    }

    /**
     * @return
     */
    public String getHpccdescrcompl() {
        return hpccdescrcompl;
    }

    /**
     * @param hpcdfecregistr
     */
    public void setHpcdfecregistr(Date hpcdfecregistr) {
        this.hpcdfecregistr = hpcdfecregistr;
    }

    /**
     * @return
     */
    public Date getHpcdfecregistr() {
        return hpcdfecregistr;
    }

    /**
     * @param hpccoperador
     */
    public void setHpccoperador(String hpccoperador) {
        this.hpccoperador = hpccoperador;
    }

    /**
     * @return
     */
    public String getHpccoperador() {
        return hpccoperador;
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
     * @param hpcnambitproce
     */
    public void setHpcnambitproce(Integer hpcnambitproce) {
        this.hpcnambitproce = hpcnambitproce;
    }

    /**
     * @return
     */
    public Integer getHpcnambitproce() {
        return hpcnambitproce;
    }

    /**
     * @param hpcnrealizacio
     */
    public void setHpcnrealizacio(Integer hpcnrealizacio) {
        this.hpcnrealizacio = hpcnrealizacio;
    }

    /**
     * @return
     */
    public Integer getHpcnrealizacio() {
        return hpcnrealizacio;
    }

    public void setHpccrefierdolor(String hpccrefierdolor) {
        this.hpccrefierdolor = hpccrefierdolor;
    }

    public String getHpccrefierdolor() {
        return hpccrefierdolor;
    }

    public void setHpcnescaladolor(Integer hpcnescaladolor) {
        this.hpcnescaladolor = hpcnescaladolor;
    }

    public Integer getHpcnescaladolor() {
        return hpcnescaladolor;
    }

    public void setHpcnduracidolor(Integer hpcnduracidolor) {
        this.hpcnduracidolor = hpcnduracidolor;
    }

    public Integer getHpcnduracidolor() {
        return hpcnduracidolor;
    }

    public void setHpccdudointen(String hpccdudointen) {
        this.hpccdudointen = hpccdudointen;
    }

    public String getHpccdudointen() {
        return hpccdudointen;
    }
}

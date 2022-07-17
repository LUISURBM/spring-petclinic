package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chvacunacion implements Serializable {

    /** identifier field */
    private ChvacunacionPK id;

    /** persistent field */
    private Integer hvacnumervacun;

    /** persistent field */
    private String hvaccodigservi;
    
    /** persistent field */
    private String hvacnombrservi;

    /** nullable persistent field */
    private String hvacnumerlote;

    /** nullable persistent field */
    private String hvacviaadmin;

    /** nullable persistent field */
    private String hvacpresereacc;

    /** nullable persistent field */
    private String hvaccualreacc;

    /** nullable persistent field */
    private String hvacobservacio;

    /** nullable persistent field */
    private String hvacpresecompl;

    /** nullable persistent field */
    private String hvaccualcompl;

    /** nullable persistent field */
    private String hvacsitioaplic;

    /** persistent field */
    private Date hvadfechavenci;

    /** persistent field */
    private Date hvadfecregistr;

    /** persistent field */
    private String hvacoperador;
    
    /** persistent field */
    private String hvacobservac;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chvacunacion() {
    
         id = new ChvacunacionPK(); 
    }


    public void setId(ChvacunacionPK id) {
        this.id = id;
    }

    public ChvacunacionPK getId() {
        return id;
    }

    public void setHvacnumervacun(Integer hvacnumervacun) {
        this.hvacnumervacun = hvacnumervacun;
    }

    public Integer getHvacnumervacun() {
        return hvacnumervacun;
    }

    public void setHvaccodigservi(String hvaccodigservi) {
        this.hvaccodigservi = hvaccodigservi;
    }

    public String getHvaccodigservi() {
        return hvaccodigservi;
    }

    public void setHvacnumerlote(String hvacnumerlote) {
        this.hvacnumerlote = hvacnumerlote;
    }

    public String getHvacnumerlote() {
        return hvacnumerlote;
    }

    public void setHvacviaadmin(String hvacviaadmin) {
        this.hvacviaadmin = hvacviaadmin;
    }

    public String getHvacviaadmin() {
        return hvacviaadmin;
    }

    public void setHvacpresereacc(String hvacpresereacc) {
        this.hvacpresereacc = hvacpresereacc;
    }

    public String getHvacpresereacc() {
        return hvacpresereacc;
    }

    public void setHvaccualreacc(String hvaccualreacc) {
        this.hvaccualreacc = hvaccualreacc;
    }

    public String getHvaccualreacc() {
        return hvaccualreacc;
    }

    public void setHvacobservacio(String hvacobservacio) {
        this.hvacobservacio = hvacobservacio;
    }

    public String getHvacobservacio() {
        return hvacobservacio;
    }

    public void setHvacpresecompl(String hvacpresecompl) {
        this.hvacpresecompl = hvacpresecompl;
    }

    public String getHvacpresecompl() {
        return hvacpresecompl;
    }

    public void setHvaccualcompl(String hvaccualcompl) {
        this.hvaccualcompl = hvaccualcompl;
    }

    public String getHvaccualcompl() {
        return hvaccualcompl;
    }

    public void setHvacsitioaplic(String hvacsitioaplic) {
        this.hvacsitioaplic = hvacsitioaplic;
    }

    public String getHvacsitioaplic() {
        return hvacsitioaplic;
    }

    public void setHvadfechavenci(Date hvadfechavenci) {
        this.hvadfechavenci = hvadfechavenci;
    }

    public Date getHvadfechavenci() {
        return hvadfechavenci;
    }

    public void setHvadfecregistr(Date hvadfecregistr) {
        this.hvadfecregistr = hvadfecregistr;
    }

    public Date getHvadfecregistr() {
        return hvadfecregistr;
    }

    public void setHvacoperador(String hvacoperador) {
        this.hvacoperador = hvacoperador;
    }

    public String getHvacoperador() {
        return hvacoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHvacnombrservi(String hvacnombrservi) {
        this.hvacnombrservi = hvacnombrservi;
    }

    public String getHvacnombrservi() {
        return hvacnombrservi;
    }

    public void setHvacobservac(String hvacobservac) {
        this.hvacobservac = hvacobservac;
    }

    public String getHvacobservac() {
        return hvacobservac;
    }
}

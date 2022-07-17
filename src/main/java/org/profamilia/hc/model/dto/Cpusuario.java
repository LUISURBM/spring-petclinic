package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Cpusuario extends BasicBean implements Serializable {

    /** identifier field */
    private String curcusuari;

    /** persistent field */
    private Integer curnclinic;

    /** persistent field */
    private String curcnombre;

    /** persistent field */
    private BigDecimal curacedula;

    /** persistent field */
    private String curcactivo;

    /** persistent field */
    private String curcgrabad;

    /** persistent field */
    private Date curdfecgra;

    /** persistent field */
    private Integer curnbodega;

    /** nullable persistent field */
    private BigDecimal version;

    /** persistent field */
    private BigDecimal curnprofes;
    
    
    /** default constructor */
    public Cpusuario() {
    }


    public String getCurcusuari() {
        return this.curcusuari;
    }

    public void setCurcusuari(String curcusuari) {
        this.curcusuari = curcusuari;
    }

    public Integer getCurnclinic() {
        return this.curnclinic;
    }

    public void setCurnclinic(Integer curnclinic) {
        this.curnclinic = curnclinic;
    }

    public String getCurcnombre() {
        return this.curcnombre;
    }

    public void setCurcnombre(String curcnombre) {
        this.curcnombre = curcnombre;
    }

    public BigDecimal getCuracedula() {
        return this.curacedula;
    }

    public void setCuracedula(BigDecimal curacedula) {
        this.curacedula = curacedula;
    }

    public String getCurcactivo() {
        return this.curcactivo;
    }

    public void setCurcactivo(String curcactivo) {
        this.curcactivo = curcactivo;
    }

    public String getCurcgrabad() {
        return this.curcgrabad;
    }

    public void setCurcgrabad(String curcgrabad) {
        this.curcgrabad = curcgrabad;
    }

    public Date getCurdfecgra() {
        return this.curdfecgra;
    }

    public void setCurdfecgra(Date curdfecgra) {
        this.curdfecgra = curdfecgra;
    }

    public Integer getCurnbodega() {
        return this.curnbodega;
    }

    public void setCurnbodega(Integer curnbodega) {
        this.curnbodega = curnbodega;
    }

    public BigDecimal getCurnprofes() {
        return this.curnprofes;
    }

    public void setCurnprofes(BigDecimal curnprofes) {
        this.curnprofes = curnprofes;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }


}

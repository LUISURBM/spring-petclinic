package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Chprofpatol extends BasicBean implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChprofpatolPK comp_id;

    /** persistent field */
    private String hppcestado;

    /** persistent field */
    private Integer hppnclinprof;

    /** persistent field */
    private String hppcoperador;

    /** persistent field */
    private Date hppdfechamod;
    
    /** persistent field */
    private Integer hppngrupat;
    
    /** nullable persistent field */
    private org.profamilia.hc.model.dto.Cpprofesio cpprofesio;
    
    private String centroProfesional;    
    
    private String centroLectura;    
    
    private String nombservicio;   

    /** default constructor */
    public Chprofpatol() {
        comp_id = new ChprofpatolPK();
        cpprofesio = new Cpprofesio();
    }

    public org.profamilia.hc.model.dto.ChprofpatolPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChprofpatolPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHppcestado() {
        return this.hppcestado;
    }

    public void setHppcestado(String hppcestado) {
        this.hppcestado = hppcestado;
    }

    public Integer getHppnclinprof() {
        return this.hppnclinprof;
    }

    public void setHppnclinprof(Integer hppnclinprof) {
        this.hppnclinprof = hppnclinprof;
    }

    public String getHppcoperador() {
        return this.hppcoperador;
    }

    public void setHppcoperador(String hppcoperador) {
        this.hppcoperador = hppcoperador;
    }

    public Date getHppdfechamod() {
        return this.hppdfechamod;
    }

    public void setHppdfechamod(Date hppdfechamod) {
        this.hppdfechamod = hppdfechamod;
    }
    
    public void setCentroProfesional(String centroProfesional) {
        this.centroProfesional = centroProfesional;
    }

    public String getCentroProfesional() {
        return centroProfesional;
    }

    public void setCentroLectura(String centroLectura) {
        this.centroLectura = centroLectura;
    }

    public String getCentroLectura() {
        return centroLectura;
    }
    
    public void setCpprofesio(Cpprofesio cpprofesio) {
        this.cpprofesio = cpprofesio;
    }

    public Cpprofesio getCpprofesio() {
        return cpprofesio;
    }

    public void setHppngrupat(Integer hppngrupat) {
        this.hppngrupat = hppngrupat;
    }

    public Integer getHppngrupat() {
        return hppngrupat;
    }

    public void setNombservicio(String nombservicio) {
        this.nombservicio = nombservicio;
    }

    public String getNombservicio() {
        return nombservicio;
    }
}

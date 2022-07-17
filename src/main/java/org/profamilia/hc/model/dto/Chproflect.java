package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Chproflect extends BasicBean implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChproflectPK comp_id;

    /** persistent field */
    private String hplcestado;

    /** persistent field */
    private Integer hplnclinprof;

    /** persistent field */
    private String hplcoperador;

    /** persistent field */
    private Date hpldfechamod;

    /** nullable persistent field */
    private org.profamilia.hc.model.dto.Cpprofesio cpprofesio;

    private String centroProfesional;

    private String centroLectura;

    /** default constructor */
    public Chproflect() {
        comp_id = new ChproflectPK();
        cpprofesio = new Cpprofesio();
    }

    public org.profamilia.hc.model.dto.ChproflectPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(org.profamilia.hc.model.dto.ChproflectPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHplcestado() {
        return this.hplcestado;
    }

    public void setHplcestado(String hplcestado) {
        this.hplcestado = hplcestado;
    }

    public String getHplcoperador() {
        return this.hplcoperador;
    }

    public void setHplcoperador(String hplcoperador) {
        this.hplcoperador = hplcoperador;
    }

    public Date getHpldfechamod() {
        return this.hpldfechamod;
    }

    public void setHpldfechamod(Date hpldfechamod) {
        this.hpldfechamod = hpldfechamod;
    }

    public void setCpprofesio(Cpprofesio cpprofesio) {
        this.cpprofesio = cpprofesio;
    }

    public Cpprofesio getCpprofesio() {
        return cpprofesio;
    }

    public void setHplnclinprof(Integer hplnclinprof) {
        this.hplnclinprof = hplnclinprof;
    }

    public Integer getHplnclinprof() {
        return hplnclinprof;
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
}

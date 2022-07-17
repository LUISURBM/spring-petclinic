package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Chproflabo extends BasicBean implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChproflaboPK comp_id;

    /** persistent field */
    private String hplcestado;


    /** persistent field */
    private String hplcoperador;

    /** persistent field */
    private Date hpldfechamod;

 

    /** default constructor */
    public Chproflabo() {
        comp_id = new ChproflaboPK();
       
    }


    public void setComp_id(ChproflaboPK comp_id) {
        this.comp_id = comp_id;
    }

    public ChproflaboPK getComp_id() {
        return comp_id;
    }

    public void setHplcestado(String hplcestado) {
        this.hplcestado = hplcestado;
    }

    public String getHplcestado() {
        return hplcestado;
    }

    public void setHplcoperador(String hplcoperador) {
        this.hplcoperador = hplcoperador;
    }

    public String getHplcoperador() {
        return hplcoperador;
    }

    public void setHpldfechamod(Date hpldfechamod) {
        this.hpldfechamod = hpldfechamod;
    }

    public Date getHpldfechamod() {
        return hpldfechamod;
    }
}

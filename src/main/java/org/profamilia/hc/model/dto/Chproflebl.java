package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import org.profamilia.hc.model.BasicBean;


/** @author Hibernate CodeGenerator */
public class Chproflebl extends BasicBean implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChprofleblPK comp_id;

    /** persistent field */
    private String hplcestado;


    /** persistent field */
    private String hplcoperador;

    /** persistent field */
    private Date hpldfechamod;

 

    /** default constructor */
    public Chproflebl() {
        comp_id = new ChprofleblPK();
       
    }


    public void setComp_id(ChprofleblPK comp_id) {
        this.comp_id = comp_id;
    }

    public ChprofleblPK getComp_id() {
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

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chconfiservi implements Serializable {

    /** identifier field */
    private ChconfiserviPK comp_id;

    /** persistent field */
    private String hcscrealiservi;

    /** nullable persistent field */
    private String hcscserviingre;

    /** nullable persistent field */
    private String hcscserviegres;

    /** persistent field */
    private Date hcsdfecregistr;

    /** persistent field */
    private String hcscoperador;

    /** nullable persistent field */
    private Integer version;
    
    private String descServicioIngreso;

  

    /** default constructor */
    public Chconfiservi() {
        comp_id = new ChconfiserviPK();
    }


    public ChconfiserviPK getComp_id() {
        return this.comp_id;
    }

    public void setComp_id(ChconfiserviPK comp_id) {
        this.comp_id = comp_id;
    }

    public String getHcscrealiservi() {
        return this.hcscrealiservi;
    }

    public void setHcscrealiservi(String hcscrealiservi) {
        this.hcscrealiservi = hcscrealiservi;
    }

    public String getHcscserviingre() {
        return this.hcscserviingre;
    }

    public void setHcscserviingre(String hcscserviingre) {
        this.hcscserviingre = hcscserviingre;
    }

    public String getHcscserviegres() {
        return this.hcscserviegres;
    }

    public void setHcscserviegres(String hcscserviegres) {
        this.hcscserviegres = hcscserviegres;
    }

    public Date getHcsdfecregistr() {
        return this.hcsdfecregistr;
    }

    public void setHcsdfecregistr(Date hcsdfecregistr) {
        this.hcsdfecregistr = hcsdfecregistr;
    }

    public String getHcscoperador() {
        return this.hcscoperador;
    }

    public void setHcscoperador(String hcscoperador) {
        this.hcscoperador = hcscoperador;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public void setDescServicioIngreso(String descServicioIngreso) {
        this.descServicioIngreso = descServicioIngreso;
    }

    public String getDescServicioIngreso() {
        return descServicioIngreso;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chparacgener implements Serializable {


    /** identifier field */
     private ChparacgenerPK id;

    /** identifier field */
    private String hpgcnombpara;

    /** identifier field */
    private String hpgtdescripcio;

    /** identifier field */
    private Date hpgdfecregistr;

    /** identifier field */
    private String hpgcoperador;

    /** identifier field */
    private Integer version;

   
    /** default constructor */
    public Chparacgener() {
    }


    public void setId(ChparacgenerPK id) {
        this.id = id;
    }

    public ChparacgenerPK getId() {
        return id;
    }

    public void setHpgcnombpara(String hpgcnombpara) {
        this.hpgcnombpara = hpgcnombpara;
    }

    public String getHpgcnombpara() {
        return hpgcnombpara;
    }

    public void setHpgtdescripcio(String hpgtdescripcio) {
        this.hpgtdescripcio = hpgtdescripcio;
    }

    public String getHpgtdescripcio() {
        return hpgtdescripcio;
    }

    public void setHpgdfecregistr(Date hpgdfecregistr) {
        this.hpgdfecregistr = hpgdfecregistr;
    }

    public Date getHpgdfecregistr() {
        return hpgdfecregistr;
    }

    public void setHpgcoperador(String hpgcoperador) {
        this.hpgcoperador = hpgcoperador;
    }

    public String getHpgcoperador() {
        return hpgcoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

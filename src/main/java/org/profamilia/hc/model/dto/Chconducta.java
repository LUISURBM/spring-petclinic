package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chconducta implements Serializable {

    /** identifier field */
    private ChconductaPK id;

    /** nullable persistent field */
    private String hcncobservacio;

    /** nullable persistent field */
    private Date hcndfecregistr;

    /** nullable persistent field */
    private String hcncoperador;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent fielf */
    private String hcncplanmanejo;
    
     /** nullable persistent fielf */
    private String hcnccondentr; 
    


    /** default constructor */
    public Chconducta() {
    }


    public void setId(ChconductaPK id) {
        this.id = id;
    }

    public ChconductaPK getId() {
        return id;
    }

    public void setHcncobservacio(String hcncobservacio) {
        this.hcncobservacio = hcncobservacio;
    }

    public String getHcncobservacio() {
        return hcncobservacio;
    }

    public void setHcndfecregistr(Date hcndfecregistr) {
        this.hcndfecregistr = hcndfecregistr;
    }

    public Date getHcndfecregistr() {
        return hcndfecregistr;
    }

    public void setHcncoperador(String hcncoperador) {
        this.hcncoperador = hcncoperador;
    }

    public String getHcncoperador() {
        return hcncoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHcncplanmanejo(String hcncplanmanejo) {
        this.hcncplanmanejo = hcncplanmanejo;
    }

    public String getHcncplanmanejo() {
        return hcncplanmanejo;
    }

    public void setHcnccondentr(String hcnccondentr) {
        this.hcnccondentr = hcnccondentr;
    }

    public String getHcnccondentr() {
        return hcnccondentr;
    }
}

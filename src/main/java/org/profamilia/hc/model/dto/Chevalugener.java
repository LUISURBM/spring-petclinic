package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chevalugener implements Serializable {

    /** identifier field */
    private ChevalugenerPK id;
    
    /** nullable persistent field */
    private String hegcapoyofamil; 
    
    /** nullable persistent field */
    private String hegccanalcomun; 
    
    /** nullable persistent field */
    private String hegcproblestud; 
    
    /** nullable persistent field */
    private String hegcrelacapoyo; 
    
    /** nullable persistent field */
    private String hegccualprobl; 
    
    /** nullable persistent field */
    private String hegccualrelac; 
    
    /** nullable persistent field */
    private String hegccualapoyo; 
    
    /** nullable persistent field */
    private String hegccualcanal; 
    
    /** nullable persistent field */
    private String hegcrelacfamil; 

    /** nullable persistent field */
    private String hegcoperador;

    /** nullable persistent field */
    private Date hegdfecreg;
    
    /** nullable persistent field */
    private String hegcareaafect;

    /** nullable persistent field */
    private String hegcareacogni;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hegcobsexamental;
    
    
    /** nullable persistent field */
    private String hegccompfami;
    
    /** nullable persistent field */
    private String hegcdesasesion;
    

    /** default constructor */
    public Chevalugener() {
        id = new ChevalugenerPK();
    }


    /**
     * @param id
     */
    public void setId(ChevalugenerPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChevalugenerPK getId() {
        return id;
    }

    /**
     * @param hegcoperador
     */
    public void setHegcoperador(String hegcoperador) {
        this.hegcoperador = hegcoperador;
    }

    /**
     * @return
     */
    public String getHegcoperador() {
        return hegcoperador;
    }

    /**
     * @param hegdfecreg
     */
    public void setHegdfecreg(Date hegdfecreg) {
        this.hegdfecreg = hegdfecreg;
    }

    /**
     * @return
     */
    public Date getHegdfecreg() {
        return hegdfecreg;
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
     * @param hegcapoyofamil
     */
    public void setHegcapoyofamil(String hegcapoyofamil) {
        this.hegcapoyofamil = hegcapoyofamil;
    }

    /**
     * @return
     */
    public String getHegcapoyofamil() {
        return hegcapoyofamil;
    }

    /**
     * @param hegccanalcomun
     */
    public void setHegccanalcomun(String hegccanalcomun) {
        this.hegccanalcomun = hegccanalcomun;
    }

    /**
     * @return
     */
    public String getHegccanalcomun() {
        return hegccanalcomun;
    }

    /**
     * @param hegcproblestud
     */
    public void setHegcproblestud(String hegcproblestud) {
        this.hegcproblestud = hegcproblestud;
    }

    /**
     * @return
     */
    public String getHegcproblestud() {
        return hegcproblestud;
    }

    /**
     * @param hegcrelacapoyo
     */
    public void setHegcrelacapoyo(String hegcrelacapoyo) {
        this.hegcrelacapoyo = hegcrelacapoyo;
    }

    /**
     * @return
     */
    public String getHegcrelacapoyo() {
        return hegcrelacapoyo;
    }

    /**
     * @param hegccualprobl
     */
    public void setHegccualprobl(String hegccualprobl) {
        this.hegccualprobl = hegccualprobl;
    }

    /**
     * @return
     */
    public String getHegccualprobl() {
        return hegccualprobl;
    }

    /**
     * @param hegccualrelac
     */
    public void setHegccualrelac(String hegccualrelac) {
        this.hegccualrelac = hegccualrelac;
    }

    /**
     * @return
     */
    public String getHegccualrelac() {
        return hegccualrelac;
    }

    /**
     * @param hegccualapoyo
     */
    public void setHegccualapoyo(String hegccualapoyo) {
        this.hegccualapoyo = hegccualapoyo;
    }

    /**
     * @return
     */
    public String getHegccualapoyo() {
        return hegccualapoyo;
    }

    /**
     * @param hegccualcanal
     */
    public void setHegccualcanal(String hegccualcanal) {
        this.hegccualcanal = hegccualcanal;
    }

    /**
     * @return
     */
    public String getHegccualcanal() {
        return hegccualcanal;
    }

    /**
     * @param hegcrelacfamil
     */
    public void setHegcrelacfamil(String hegcrelacfamil) {
        this.hegcrelacfamil = hegcrelacfamil;
    }

    /**
     * @return
     */
    public String getHegcrelacfamil() {
        return hegcrelacfamil;
    }

    /**
     * @param hegcareaafect
     */
    public void setHegcareaafect(String hegcareaafect) {
        this.hegcareaafect = hegcareaafect;
    }

    /**
     * @return
     */
    public String getHegcareaafect() {
        return hegcareaafect;
    }

    /**
     * @param hegcareacogni
     */
    public void setHegcareacogni(String hegcareacogni) {
        this.hegcareacogni = hegcareacogni;
    }

    /**
     * @return
     */
    public String getHegcareacogni() {
        return hegcareacogni;
    }

    public void setHegcobsexamental(String hegcobsexamental) {
        this.hegcobsexamental = hegcobsexamental;
    }

    public String getHegcobsexamental() {
        return hegcobsexamental;
    }

    public void setHegccompfami(String hegccompfami) {
        this.hegccompfami = hegccompfami;
    }

    public String getHegccompfami() {
        return hegccompfami;
    }

    public void setHegcdesasesion(String hegcdesasesion) {
        this.hegcdesasesion = hegcdesasesion;
    }

    public String getHegcdesasesion() {
        return hegcdesasesion;
    }
}

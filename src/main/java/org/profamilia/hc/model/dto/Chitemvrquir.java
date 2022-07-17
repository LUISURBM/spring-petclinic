package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

import javax.faces.component.UIInput;


/** @author Hibernate CodeGenerator */
public class Chitemvrquir implements Serializable {

    /** identifier field */
    private ChitemvrquirPK id;

    /** nullable persistent field */
    private String hiqcdescri;

    /** nullable persistent field */
    private String hiqcrespuesta;

    /** nullable persistent field */
    private String hiqcnoaplica;

    /** nullable persistent field */
    private Date hiqdfecreg;

    /** nullable persistent field */
    private String hiqcgrabad;

    /** nullable persistent field */
    private String hiqcetapa;

    /** nullable persistent field */
    private Integer version;
    




    /** default constructor */
    public Chitemvrquir() {
        id = new ChitemvrquirPK(); 
     
    }


    /**
     * @param id
     */
    public void setId(ChitemvrquirPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChitemvrquirPK getId() {
        return id;
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


    public void setHiqcdescri(String hiqcdescri) {
        this.hiqcdescri = hiqcdescri;
    }

    public String getHiqcdescri() {
        return hiqcdescri;
    }

    public void setHiqcrespuesta(String hiqcrespuesta) {
        this.hiqcrespuesta = hiqcrespuesta;
    }

    public String getHiqcrespuesta() {
        return hiqcrespuesta;
    }

    public void setHiqdfecreg(Date hiqdfecreg) {
        this.hiqdfecreg = hiqdfecreg;
    }

    public Date getHiqdfecreg() {
        return hiqdfecreg;
    }

    public void setHiqcgrabad(String hiqcgrabad) {
        this.hiqcgrabad = hiqcgrabad;
    }

    public String getHiqcgrabad() {
        return hiqcgrabad;
    }


    public void setHiqcnoaplica(String hiqcnoaplica) {
        this.hiqcnoaplica = hiqcnoaplica;
    }

    public String getHiqcnoaplica() {
        return hiqcnoaplica;
    }

    public void setHiqcetapa(String hiqcetapa) {
        this.hiqcetapa = hiqcetapa;
    }

    public String getHiqcetapa() {
        return hiqcetapa;
    }

  
}

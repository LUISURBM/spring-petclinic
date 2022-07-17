package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chpermitema implements Serializable {

    /** identifier field */
    private ChpermitemaPK id;

    /** nullable persistent field */
    private Date hptdfecregistr;

    /** nullable persistent field */
    private String hptcoperador;

    /** nullable persistent field */
    private Integer version;



    /** default constructor */
    public Chpermitema() {
        id = new ChpermitemaPK();
    }


    /**
     * @param id
     */
    public void setId(ChpermitemaPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChpermitemaPK getId() {
        return id;
    }

    /**
     * @param hptdfecregistr
     */
    public void setHptdfecregistr(Date hptdfecregistr) {
        this.hptdfecregistr = hptdfecregistr;
    }

    /**
     * @return
     */
    public Date getHptdfecregistr() {
        return hptdfecregistr;
    }

    /**
     * @param hptcoperador
     */
    public void setHptcoperador(String hptcoperador) {
        this.hptcoperador = hptcoperador;
    }

    /**
     * @return
     */
    public String getHptcoperador() {
        return hptcoperador;
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
}

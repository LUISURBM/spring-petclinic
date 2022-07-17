package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chremihospit implements Serializable {

    /** identifier field */
    private ChremihospitPK id;

    /** nullable persistent field */
    private String hrhcmotivhospi;

    /** nullable persistent field */
    private String hrhcplanmanejo;

    /** nullable persistent field */
    private Date hrhdfecregistr;

    /** nullable persistent field */
    private String hrhcoperador;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chremihospit() {
    }


    public void setId(ChremihospitPK id) {
        this.id = id;
    }

    public ChremihospitPK getId() {
        return id;
    }

    public void setHrhcmotivhospi(String hrhcmotivhospi) {
        this.hrhcmotivhospi = hrhcmotivhospi;
    }

    public String getHrhcmotivhospi() {
        return hrhcmotivhospi;
    }

    public void setHrhcplanmanejo(String hrhcplanmanejo) {
        this.hrhcplanmanejo = hrhcplanmanejo;
    }

    public String getHrhcplanmanejo() {
        return hrhcplanmanejo;
    }

    public void setHrhdfecregistr(Date hrhdfecregistr) {
        this.hrhdfecregistr = hrhdfecregistr;
    }

    public Date getHrhdfecregistr() {
        return hrhdfecregistr;
    }

    public void setHrhcoperador(String hrhcoperador) {
        this.hrhcoperador = hrhcoperador;
    }

    public String getHrhcoperador() {
        return hrhcoperador;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

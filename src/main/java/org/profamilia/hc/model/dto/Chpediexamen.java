package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chpediexamen implements Serializable {

    /** identifier field */
    private ChpediexamenPK id;

    /** nullable persistent field */
    private String hpeccompofamil;

    /** nullable persistent field */
    private String hpeeestadogene;

    /** nullable persistent field */
    private String hpeeestadoresp;

    /** nullable persistent field */
    private String hpeeestadohidr;

    /** nullable persistent field */
    private String hpeeestadoconc;

    /** nullable persistent field */
    private String hpecobservacio;

    /** nullable persistent field */
    private String hpecoperador;

    /** nullable persistent field */
    private Date hpedfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chpediexamen() {
    }


    public void setId(ChpediexamenPK id) {
        this.id = id;
    }

    public ChpediexamenPK getId() {
        return id;
    }

    public void setHpeccompofamil(String hpeccompofamil) {
        this.hpeccompofamil = hpeccompofamil;
    }

    public String getHpeccompofamil() {
        return hpeccompofamil;
    }

    public void setHpeeestadogene(String hpeeestadogene) {
        this.hpeeestadogene = hpeeestadogene;
    }

    public String getHpeeestadogene() {
        return hpeeestadogene;
    }

    public void setHpeeestadoresp(String hpeeestadoresp) {
        this.hpeeestadoresp = hpeeestadoresp;
    }

    public String getHpeeestadoresp() {
        return hpeeestadoresp;
    }

    public void setHpeeestadohidr(String hpeeestadohidr) {
        this.hpeeestadohidr = hpeeestadohidr;
    }

    public String getHpeeestadohidr() {
        return hpeeestadohidr;
    }

    public void setHpeeestadoconc(String hpeeestadoconc) {
        this.hpeeestadoconc = hpeeestadoconc;
    }

    public String getHpeeestadoconc() {
        return hpeeestadoconc;
    }

    public void setHpecobservacio(String hpecobservacio) {
        this.hpecobservacio = hpecobservacio;
    }

    public String getHpecobservacio() {
        return hpecobservacio;
    }

    public void setHpecoperador(String hpecoperador) {
        this.hpecoperador = hpecoperador;
    }

    public String getHpecoperador() {
        return hpecoperador;
    }

    public void setHpedfecregistr(Date hpedfecregistr) {
        this.hpedfecregistr = hpedfecregistr;
    }

    public Date getHpedfecregistr() {
        return hpedfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

}

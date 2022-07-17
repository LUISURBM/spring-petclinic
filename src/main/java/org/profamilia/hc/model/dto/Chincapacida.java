package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chincapacida implements Serializable {

    /** identifier field */
    private ChincapacidaPK id;

    /** nullable persistent field */
    private String hintdescripcio;

    /** nullable persistent field */
    private Date hindfecinicia;

    /** nullable persistent field */
    private Integer hidndias;

    /** nullable persistent field */
    private Date hiddfecregistr;

    /** nullable persistent field */
    private String hidcoperador;

    /** nullable persistent field */
    private Integer hidnorigeincap;

    /** nullable persistent field */
    private Integer hidntipoincapa;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chincapacida() {
    }


    public void setId(ChincapacidaPK id) {
        this.id = id;
    }

    public ChincapacidaPK getId() {
        return id;
    }

    public void setHintdescripcio(String hintdescripcio) {
        this.hintdescripcio = hintdescripcio;
    }

    public String getHintdescripcio() {
        return hintdescripcio;
    }

    public void setHindfecinicia(Date hindfecinicia) {
        this.hindfecinicia = hindfecinicia;
    }

    public Date getHindfecinicia() {
        return hindfecinicia;
    }

    public void setHidndias(Integer hidndias) {
        this.hidndias = hidndias;
    }

    public Integer getHidndias() {
        return hidndias;
    }

    public void setHiddfecregistr(Date hiddfecregistr) {
        this.hiddfecregistr = hiddfecregistr;
    }

    public Date getHiddfecregistr() {
        return hiddfecregistr;
    }

    public void setHidcoperador(String hidcoperador) {
        this.hidcoperador = hidcoperador;
    }

    public String getHidcoperador() {
        return hidcoperador;
    }

    public void setHidnorigeincap(Integer hidnorigeincap) {
        this.hidnorigeincap = hidnorigeincap;
    }

    public Integer getHidnorigeincap() {
        return hidnorigeincap;
    }

    public void setHidntipoincapa(Integer hidntipoincapa) {
        this.hidntipoincapa = hidntipoincapa;
    }

    public Integer getHidntipoincapa() {
        return hidntipoincapa;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

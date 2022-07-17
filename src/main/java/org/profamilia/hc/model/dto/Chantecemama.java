package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chantecemama implements Serializable {

    /** identifier field */
    private ChantecemamaPK id;

    /** nullable persistent field */
    private String hamevalorant;

    /** nullable persistent field */
    private Date hamdfecvalant;

    /** nullable persistent field */
    private String hamcresultado;

    /** nullable persistent field */
    private Integer hamnlactacum;

    /** nullable persistent field */
    private String hamcoperador;

    /** nullable persistent field */
    private Date hamdfecregistr;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hamcotrometod;


    /** nullable persistent field */
    private String hamcmetodo;


    /** default constructor */
    public Chantecemama() {
    }


    public void setId(ChantecemamaPK id) {
        this.id = id;
    }

    public ChantecemamaPK getId() {
        return id;
    }

    public void setHamevalorant(String hamevalorant) {
        this.hamevalorant = hamevalorant;
    }

    public String getHamevalorant() {
        return hamevalorant;
    }

    public void setHamdfecvalant(Date hamdfecvalant) {
        this.hamdfecvalant = hamdfecvalant;
    }

    public Date getHamdfecvalant() {
        return hamdfecvalant;
    }

    public void setHamcresultado(String hamcresultado) {
        this.hamcresultado = hamcresultado;
    }

    public String getHamcresultado() {
        return hamcresultado;
    }

    public void setHamnlactacum(Integer hamnlactacum) {
        this.hamnlactacum = hamnlactacum;
    }

    public Integer getHamnlactacum() {
        return hamnlactacum;
    }

    public void setHamcoperador(String hamcoperador) {
        this.hamcoperador = hamcoperador;
    }

    public String getHamcoperador() {
        return hamcoperador;
    }

    public void setHamdfecregistr(Date hamdfecregistr) {
        this.hamdfecregistr = hamdfecregistr;
    }

    public Date getHamdfecregistr() {
        return hamdfecregistr;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHamcotrometod(String hamcotrometod) {
        this.hamcotrometod = hamcotrometod;
    }

    public String getHamcotrometod() {
        return hamcotrometod;
    }

    public void setHamcmetodo(String hamcmetodo) {
        this.hamcmetodo = hamcmetodo;
    }

    public String getHamcmetodo() {
        return hamcmetodo;
    }
}

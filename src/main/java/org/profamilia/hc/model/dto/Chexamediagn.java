package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chexamediagn implements Serializable {

    /** identifier field */
    private ChexamediagnPK id;

    /** nullable persistent field */
    private String hedccontraindi;

    /** nullable persistent field */
    private Date heddfecregistr;

    /** nullable persistent field */
    private String hedcoperador;


    /** nullable persistent field */
    private String hedcmetodopaci;

    /** nullable persistent field */
    private String hedcmetodosuge;

    /** nullable persistent field */
    private String hedcmetodosoli;


    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hedcprimmet;
    
    /** nullable persistent field */
    private Long hednmetodopaq;
    


    /** default constructor */
    public Chexamediagn() {
    }


    public void setId(ChexamediagnPK id) {
        this.id = id;
    }

    public ChexamediagnPK getId() {
        return id;
    }

    public void setHedccontraindi(String hedccontraindi) {
        this.hedccontraindi = hedccontraindi;
    }

    public String getHedccontraindi() {
        return hedccontraindi;
    }

    public void setHeddfecregistr(Date heddfecregistr) {
        this.heddfecregistr = heddfecregistr;
    }

    public Date getHeddfecregistr() {
        return heddfecregistr;
    }

    public void setHedcoperador(String hedcoperador) {
        this.hedcoperador = hedcoperador;
    }

    public String getHedcoperador() {
        return hedcoperador;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHedcmetodopaci(String hedcmetodopaci) {
        this.hedcmetodopaci = hedcmetodopaci;
    }

    public String getHedcmetodopaci() {
        return hedcmetodopaci;
    }

    public void setHedcmetodosuge(String hedcmetodosuge) {
        this.hedcmetodosuge = hedcmetodosuge;
    }

    public String getHedcmetodosuge() {
        return hedcmetodosuge;
    }

    public void setHedcmetodosoli(String hedcmetodosoli) {
        this.hedcmetodosoli = hedcmetodosoli;
    }

    public String getHedcmetodosoli() {
        return hedcmetodosoli;
    }


    public void setHedcprimmet(String hedcprimmet) {
        this.hedcprimmet = hedcprimmet;
    }

    public String getHedcprimmet() {
        return hedcprimmet;
    }

    public void setHednmetodopaq(Long hednmetodopaq) {
        this.hednmetodopaq = hednmetodopaq;
    }

    public Long getHednmetodopaq() {
        return hednmetodopaq;
    }
}

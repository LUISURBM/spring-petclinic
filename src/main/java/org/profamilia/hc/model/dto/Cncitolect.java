package org.profamilia.hc.model.dto;

import java.io.IOException;
import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Cncitolect implements Serializable {

    /** identifier field */
    private Integer clcnconsec;

    /** persistent field */
    private Integer clcnclinic;

    /** persistent field */
    private Integer clcnnumero;

    /** persistent field */
    private Date clcdprilec;

    /** persistent field */
    private String clccprilec;

    /** persistent field */
    private String clccnompri;

    /** nullable persistent field */
    private Date clcdseglec;

    /** nullable persistent field */
    private String clccseglec;

    /** nullable persistent field */
    private String clccnomseg;

    /** nullable persistent field */
    private String clcccalmue;

    /** nullable persistent field */
    private String clccmicorg;

    /** nullable persistent field */
    private String clccotrmic;

    /** nullable persistent field */
    private String clcccatego;

    /** nullable persistent field */
    private String clccotrhal;

    /** nullable persistent field */
    private String clccanoesc;

    /** nullable persistent field */
    private String clccanogla;

    /** nullable persistent field */
    private String clccotrneo;

    /** nullable persistent field */
    private String clccobserv;

    /** persistent field */
    private String clccusureg;

    /** nullable persistent field */
    private Date clcdfecreg;
    
    /** nullable persistent field */
    private String clccnumpri;
    
    /** nullable persistent field */
    private String clccnumseg;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Cncitolect() {
    }

    public Integer getClcnconsec() {
        return this.clcnconsec;
    }

    public void setClcnconsec(Integer clcnconsec) {
        this.clcnconsec = clcnconsec;
    }

    public Integer getClcnclinic() {
        return this.clcnclinic;
    }

    public void setClcnclinic(Integer clcnclinic) {
        this.clcnclinic = clcnclinic;
    }

    public Integer getClcnnumero() {
        return this.clcnnumero;
    }

    public void setClcnnumero(Integer clcnnumero) {
        this.clcnnumero = clcnnumero;
    }

    public Date getClcdprilec() {
        return this.clcdprilec;
    }

    public void setClcdprilec(Date clcdprilec) {
        this.clcdprilec = clcdprilec;
    }

    public String getClccprilec() {
        return this.clccprilec;
    }

    public void setClccprilec(String clccprilec) {
        this.clccprilec = clccprilec;
    }

    public String getClccnompri() {
        return this.clccnompri;
    }

    public void setClccnompri(String clccnompri) {
        this.clccnompri = clccnompri;
    }

    public Date getClcdseglec() {
        return this.clcdseglec;
    }

        public void setClcdseglec(Date clcdseglec) {
        this.clcdseglec = clcdseglec;
    }

    public String getClccseglec() {
        return this.clccseglec;
    }

    public void setClccseglec(String clccseglec) {
        this.clccseglec = clccseglec;
    }

    public String getClccnomseg() {
        return this.clccnomseg;
    }

    public void setClccnomseg(String clccnomseg) {
        this.clccnomseg = clccnomseg;
    }

    public String getClcccalmue() {
        return this.clcccalmue;
    }

    public void setClcccalmue(String clcccalmue) {
        this.clcccalmue = clcccalmue;
    }

    public String getClccmicorg() {
        return this.clccmicorg;
    }

    public void setClccmicorg(String clccmicorg) {
        this.clccmicorg = clccmicorg;
    }

    public String getClccotrmic() {
        return this.clccotrmic;
    }

    public void setClccotrmic(String clccotrmic) {
        this.clccotrmic = clccotrmic;
    }

    public String getClcccatego() {
        return this.clcccatego;
    }

    public void setClcccatego(String clcccatego) {
        this.clcccatego = clcccatego;
    }

    public String getClccotrhal() {
        return this.clccotrhal;
    }

    public void setClccotrhal(String clccotrhal) {
        this.clccotrhal = clccotrhal;
    }

    public String getClccanoesc() {
        return this.clccanoesc;
    }

    public void setClccanoesc(String clccanoesc) {
        this.clccanoesc = clccanoesc;
    }

    public String getClccanogla() {
        return this.clccanogla;
    }

    public void setClccanogla(String clccanogla) {
        this.clccanogla = clccanogla;
    }

    public String getClccotrneo() {
        return this.clccotrneo;
    }

    public void setClccotrneo(String clccotrneo) {
        this.clccotrneo = clccotrneo;
    }

    public String getClccobserv() {
        return this.clccobserv;
    }

    public void setClccobserv(String clccobserv) {
        this.clccobserv = clccobserv;
    }

    public String getClccusureg() {
        return this.clccusureg;
    }

    public void setClccusureg(String clccusureg) {
        this.clccusureg = clccusureg;
    }

    public Date getClcdfecreg() {
        return this.clcdfecreg;
    }

    public void setClcdfecreg(Date clcdfecreg) {
        this.clcdfecreg = clcdfecreg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, 
                                                                     ClassNotFoundException { 
    // Aqui debemos leer los bytes de stream y reconstruir el objeto 
    System.out.println("Entro a readObject ");
    
    }   
    
    private void writeObject(java.io.ObjectOutputStream stream)      throws IOException {    
    // Aqu� escribimos en stream los bytes que queramos que se envien por red. } 


    }


    public void setClccnumpri(String clccnumpri) {
        this.clccnumpri = clccnumpri;
    }

    public String getClccnumpri() {
        return clccnumpri;
    }

    public void setClccnumseg(String clccnumseg) {
        this.clccnumseg = clccnumseg;
    }

    public String getClccnumseg() {
        return clccnumseg;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chnotaenferm implements Serializable {

    /** identifier field */
    private ChnotaenfermPK id;

    /** nullable persistent field */
    private Long hnelusuario;

    /** nullable persistent field */
    private String hnecnotaenferm;

    /** nullable persistent field */
    private Integer hnenclinica;

    /** nullable persistent field */
    private String hnecestado;
    
    
    /** nullable persistent field */
    private String hnecetapa;

    /** nullable persistent field */
    private Date hnedfecregistr;

    /** nullable persistent field */
    private String hnecoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer hnencama;

    /** nullable persistent field */
    private Date hnedfechanotac;

    /** nullable persistent field */
    private String hnectomasigno;

    /** nullable persistent field */
    private String hnecestadocon;

    /** nullable persistent field */
    private String hnecaldrobrom;
   
    /** nullable persistent field */
   private String hnecdescropera;
   
   private Date fechaEmbarazo; 
   
   private String resultadoPrueba;
   
   /** nullable persistent field */
   private String hnecrefiedolor;      
   
   /** nullable persistent field */
   private Integer hnenescaladolo;


    /** nullable persistent field */
    private Integer hnenduradolor;

    /** nullable persistent field */
    private String hnecdudointen;


    /** default constructor */
    public Chnotaenferm() {
    }


    public void setId(ChnotaenfermPK id) {
        this.id = id;
    }

    public ChnotaenfermPK getId() {
        return id;
    }

    public void setHnelusuario(Long hnelusuario) {
        this.hnelusuario = hnelusuario;
    }

    public Long getHnelusuario() {
        return hnelusuario;
    }

    public void setHnecnotaenferm(String hnecnotaenferm) {
        this.hnecnotaenferm = hnecnotaenferm;
    }

    public String getHnecnotaenferm() {
        return hnecnotaenferm;
    }

    public void setHnenclinica(Integer hnenclinica) {
        this.hnenclinica = hnenclinica;
    }

    public Integer getHnenclinica() {
        return hnenclinica;
    }

    public void setHnecestado(String hnecestado) {
        this.hnecestado = hnecestado;
    }

    public String getHnecestado() {
        return hnecestado;
    }

    public void setHnedfecregistr(Date hnedfecregistr) {
        this.hnedfecregistr = hnedfecregistr;
    }

    public Date getHnedfecregistr() {
        return hnedfecregistr;
    }

    public void setHnecoperador(String hnecoperador) {
        this.hnecoperador = hnecoperador;
    }

    public String getHnecoperador() {
        return hnecoperador;
    }

    public void setHnencama(Integer hnencama) {
        this.hnencama = hnencama;
    }

    public Integer getHnencama() {
        return hnencama;
    }

    public void setHnedfechanotac(Date hnedfechanotac) {
        this.hnedfechanotac = hnedfechanotac;
    }

    public Date getHnedfechanotac() {
        return hnedfechanotac;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }


    public void setHnecetapa(String hnecetapa) {
        this.hnecetapa = hnecetapa;
    }

    public String getHnecetapa() {
        return hnecetapa;
    }


    public void setHnectomasigno(String hnectomasigno) {
        this.hnectomasigno = hnectomasigno;
    }

    public String getHnectomasigno() {
        return hnectomasigno;
    }

    public void setHnecestadocon(String hnecestadocon) {
        this.hnecestadocon = hnecestadocon;
    }

    public String getHnecestadocon() {
        return hnecestadocon;
    }

    public void setHnecaldrobrom(String hnecaldrobrom) {
        this.hnecaldrobrom = hnecaldrobrom;
    }

    public String getHnecaldrobrom() {
        return hnecaldrobrom;
    }

    public void setHnecdescropera(String hnecdescropera) {
        this.hnecdescropera = hnecdescropera;
    }

    public String getHnecdescropera() {
        return hnecdescropera;
    }

    public void setFechaEmbarazo(Date fechaEmbarazo) {
        this.fechaEmbarazo = fechaEmbarazo;
    }

    public Date getFechaEmbarazo() {
        return fechaEmbarazo;
    }

    public void setResultadoPrueba(String resultadoPrueba) {
        this.resultadoPrueba = resultadoPrueba;
    }

    public String getResultadoPrueba() {
        return resultadoPrueba;
    }


    public void setHnecrefiedolor(String hnecrefiedolor) {
        this.hnecrefiedolor = hnecrefiedolor;
    }

    public String getHnecrefiedolor() {
        return hnecrefiedolor;
    }

    public void setHnenescaladolo(Integer hnenescaladolo) {
        this.hnenescaladolo = hnenescaladolo;
    }

    public Integer getHnenescaladolo() {
        return hnenescaladolo;
    }

    public void setHnenduradolor(Integer hnenduradolor) {
        this.hnenduradolor = hnenduradolor;
    }

    public Integer getHnenduradolor() {
        return hnenduradolor;
    }

    public void setHnecdudointen(String hnecdudointen) {
        this.hnecdudointen = hnecdudointen;
    }

    public String getHnecdudointen() {
        return hnecdudointen;
    }
}

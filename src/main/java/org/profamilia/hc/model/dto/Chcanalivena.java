package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcanalivena implements Serializable {

    /** identifier field */
    private ChcanalivenaPK id;

    /** nullable persistent field */
    private Long hcvlusuario;

    /** nullable persistent field */
    private String hcvecanalizaci;

    /** nullable persistent field */
    private String hcveasepsia;

    /** nullable persistent field */
    private String hcvczonacanali;

    /** nullable persistent field */
    private Integer hcvnclinica;


    /** nullable persistent field */
    private Integer hcvnnumerinten;


    /** nullable persistent field */
    private String hcvcestado;

    /** nullable persistent field */
    private Date hcvdfecregistr;

    /** nullable persistent field */
    private String hcvcoperador;

    /** nullable persistent field */
    private String hcvcmiembsuper;

    /** nullable persistent field */
    private String hcvcubicamiemb;

    /** nullable persistent field */
    private String hcvctipocatete;

    /** nullable persistent field */
    private Integer hcvncalibre;

    /** nullable persistent field */
    private String hcvcdescmiembr;

    /** nullable persistent field */
    private String hcvcdesclocali;

    /** nullable persistent field */
    private String hcvcdesccatete;

    /** nullable persistent field */
    private boolean hcvbsuspender;

    /** nullable persistent field */
    private boolean hcvbrendersusp;

    /** nullable persistent field */
    private Date hcvdfechamodif;

    /** nullable persistent field */
    private String hcvcoperamodif;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chcanalivena() {
        this.id = new ChcanalivenaPK();
    }


    /**
     * @param id
     */
    public void setId(ChcanalivenaPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcanalivenaPK getId() {
        return id;
    }

    /**
     * @param hcvlusuario
     */
    public void setHcvlusuario(Long hcvlusuario) {
        this.hcvlusuario = hcvlusuario;
    }

    /**
     * @return
     */
    public Long getHcvlusuario() {
        return hcvlusuario;
    }

    /**
     * @param hcvecanalizaci
     */
    public void setHcvecanalizaci(String hcvecanalizaci) {
        this.hcvecanalizaci = hcvecanalizaci;
    }

    /**
     * @return
     */
    public String getHcvecanalizaci() {
        return hcvecanalizaci;
    }

    /**
     * @param hcveasepsia
     */
    public void setHcveasepsia(String hcveasepsia) {
        this.hcveasepsia = hcveasepsia;
    }

    /**
     * @return
     */
    public String getHcveasepsia() {
        return hcveasepsia;
    }

    /**
     * @param hcvczonacanali
     */
    public void setHcvczonacanali(String hcvczonacanali) {
        this.hcvczonacanali = hcvczonacanali;
    }

    /**
     * @return
     */
    public String getHcvczonacanali() {
        return hcvczonacanali;
    }

    /**
     * @param hcvnclinica
     */
    public void setHcvnclinica(Integer hcvnclinica) {
        this.hcvnclinica = hcvnclinica;
    }

    /**
     * @return
     */
    public Integer getHcvnclinica() {
        return hcvnclinica;
    }

    /**
     * @param hcvcestado
     */
    public void setHcvcestado(String hcvcestado) {
        this.hcvcestado = hcvcestado;
    }

    /**
     * @return
     */
    public String getHcvcestado() {
        return hcvcestado;
    }

    /**
     * @param hcvdfecregistr
     */
    public void setHcvdfecregistr(Date hcvdfecregistr) {
        this.hcvdfecregistr = hcvdfecregistr;
    }

    /**
     * @return
     */
    public Date getHcvdfecregistr() {
        return hcvdfecregistr;
    }

    /**
     * @param hcvcoperador
     */
    public void setHcvcoperador(String hcvcoperador) {
        this.hcvcoperador = hcvcoperador;
    }

    /**
     * @return
     */
    public String getHcvcoperador() {
        return hcvcoperador;
    }

    /**
     * @param hcvcmiembsuper
     */
    public void setHcvcmiembsuper(String hcvcmiembsuper) {
        this.hcvcmiembsuper = hcvcmiembsuper;
    }

    /**
     * @return
     */
    public String getHcvcmiembsuper() {
        return hcvcmiembsuper;
    }

    /**
     * @param hcvcubicamiemb
     */
    public void setHcvcubicamiemb(String hcvcubicamiemb) {
        this.hcvcubicamiemb = hcvcubicamiemb;
    }

    /**
     * @return
     */
    public String getHcvcubicamiemb() {
        return hcvcubicamiemb;
    }

    /**
     * @param hcvctipocatete
     */
    public void setHcvctipocatete(String hcvctipocatete) {
        this.hcvctipocatete = hcvctipocatete;
    }

    /**
     * @return
     */
    public String getHcvctipocatete() {
        return hcvctipocatete;
    }

    /**
     * @param hcvncalibre
     */
    public void setHcvncalibre(Integer hcvncalibre) {
        this.hcvncalibre = hcvncalibre;
    }

    /**
     * @return
     */
    public Integer getHcvncalibre() {
        return hcvncalibre;
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
     * @param hcvcdescmiembr
     */
    public void setHcvcdescmiembr(String hcvcdescmiembr) {
        this.hcvcdescmiembr = hcvcdescmiembr;
    }

    /**
     * @return
     */
    public String getHcvcdescmiembr() {
        hcvcdescmiembr = "--";
        if (hcvcmiembsuper != null) {
            if (hcvcmiembsuper.equals("B")) {
                hcvcdescmiembr = "Brazo";
            }
            if (hcvcmiembsuper.equals("A")) {
                hcvcdescmiembr = "Antebrazo";
            }
            if (hcvcmiembsuper.equals("M")) {
                hcvcdescmiembr = "Mano";
            }
        }
        return hcvcdescmiembr;
    }

    /**
     * @param hcvcdesclocali
     */
    public void setHcvcdesclocali(String hcvcdesclocali) {
        this.hcvcdesclocali = hcvcdesclocali;
    }

    /**
     * @return
     */
    public String getHcvcdesclocali() {
        if (hcvczonacanali != null) {
            if (hcvczonacanali.equals("D")) {
                hcvcdesclocali = "Derecho";
            }
            if (hcvczonacanali.equals("I")) {
                hcvcdesclocali = "Izquierdo";
            }
        }
        return hcvcdesclocali;
    }

    /**
     * @param hcvcdesccatete
     */
    public void setHcvcdesccatete(String hcvcdesccatete) {
        this.hcvcdesccatete = hcvcdesccatete;
    }

    /**
     * @return
     */
    public String getHcvcdesccatete() {
        if (hcvctipocatete != null) {
            if (hcvctipocatete.equals("P")) {
                hcvcdesccatete = "Pericraneal";
            }
            if (hcvctipocatete.equals("C")) {
                hcvcdesccatete = "Cat�ter perif�rico";
            }
        }
        return hcvcdesccatete;
    }

    /**
     * @param hcvbsuspender
     */
    public void setHcvbsuspender(boolean hcvbsuspender) {
        this.hcvbsuspender = hcvbsuspender;
    }

    /**
     * @return
     */
    public boolean isHcvbsuspender() {
        return hcvbsuspender;
    }

    /**
     * @param hcvbrendersusp
     */
    public void setHcvbrendersusp(boolean hcvbrendersusp) {
        this.hcvbrendersusp = hcvbrendersusp;
    }

    /**
     * @return
     */
    public boolean isHcvbrendersusp() {
        if (hcvcestado != null && hcvcestado.equals("VG")) {
            hcvbrendersusp = true;
        } else {
            hcvbrendersusp = false;
        }
        return hcvbrendersusp;
    }

    /**
     * @param hcvdfechamodif
     */
    public void setHcvdfechamodif(Date hcvdfechamodif) {
        this.hcvdfechamodif = hcvdfechamodif;
    }

    /**
     * @return
     */
    public Date getHcvdfechamodif() {
        return hcvdfechamodif;
    }

    /**
     * @param hcvcoperamodif
     */
    public void setHcvcoperamodif(String hcvcoperamodif) {
        this.hcvcoperamodif = hcvcoperamodif;
    }

    /**
     * @return
     */
    public String getHcvcoperamodif() {
        return hcvcoperamodif;
    }

    public void setHcvnnumerinten(Integer hcvnnumerinten) {
        this.hcvnnumerinten = hcvnnumerinten;
    }

    public Integer getHcvnnumerinten() {
        return hcvnnumerinten;
    }
}

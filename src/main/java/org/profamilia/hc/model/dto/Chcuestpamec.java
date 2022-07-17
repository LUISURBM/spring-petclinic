package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcuestpamec implements Serializable {

    /** identifier field */
    private ChcuestpamecPK id;
    
    /** nullable persistent field */
    private String hcpcdescrpregu;

    /** nullable persistent field */
    private Integer hcpnmesenero;

    /** nullable persistent field */
    private Integer hcpnmesfebre;

    /** nullable persistent field */
    private Integer hcpnmesmarzo;

    /** nullable persistent field */
    private Integer hcpnmesabril;

    /** nullable persistent field */
    private Integer hcpnmesmayo;

    /** nullable persistent field */
    private Integer hcpnmesjunio;

    /** nullable persistent field */
    private Integer hcpnmesjulio;

    /** nullable persistent field */
    private Integer hcpnmesagost;

    /** nullable persistent field */
    private Integer hcpnmessepti;

    /** nullable persistent field */
    private Integer hcpnmesoctub;

    /** nullable persistent field */
    private Integer hcpnmesnovie;

    /** nullable persistent field */
    private Integer hcpnmesdicie;

    /** nullable persistent field */
    private String hppcestado;

    /** nullable persistent field */
    private Date hppdfecregistr;

    /** nullable persistent field */
    private String hppcoperador;

    /** nullable persistent field */
    private Integer version;

    

    /** default constructor */
    public Chcuestpamec() {
        id = new ChcuestpamecPK(); 
    }


    /**
     * @param hcpcdescrpregu
     */
    public void setHcpcdescrpregu(String hcpcdescrpregu) {
        this.hcpcdescrpregu = hcpcdescrpregu;
    }

    /**
     * @return
     */
    public String getHcpcdescrpregu() {
        return hcpcdescrpregu;
    }

    /**
     * @param id
     */
    public void setId(ChcuestpamecPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcuestpamecPK getId() {
        return id;
    }

    /**
     * @param hcpnmesenero
     */
    public void setHcpnmesenero(Integer hcpnmesenero) {
        this.hcpnmesenero = hcpnmesenero;
    }

    /**
     * @return
     */
    public Integer getHcpnmesenero() {
        return hcpnmesenero;
    }

    /**
     * @param hcpnmesfebre
     */
    public void setHcpnmesfebre(Integer hcpnmesfebre) {
        this.hcpnmesfebre = hcpnmesfebre;
    }

    /**
     * @return
     */
    public Integer getHcpnmesfebre() {
        return hcpnmesfebre;
    }

    /**
     * @param hcpnmesmarzo
     */
    public void setHcpnmesmarzo(Integer hcpnmesmarzo) {
        this.hcpnmesmarzo = hcpnmesmarzo;
    }

    /**
     * @return
     */
    public Integer getHcpnmesmarzo() {
        return hcpnmesmarzo;
    }

    /**
     * @param hcpnmesabril
     */
    public void setHcpnmesabril(Integer hcpnmesabril) {
        this.hcpnmesabril = hcpnmesabril;
    }

    /**
     * @return
     */
    public Integer getHcpnmesabril() {
        return hcpnmesabril;
    }

    /**
     * @param hcpnmesmayo
     */
    public void setHcpnmesmayo(Integer hcpnmesmayo) {
        this.hcpnmesmayo = hcpnmesmayo;
    }

    /**
     * @return
     */
    public Integer getHcpnmesmayo() {
        return hcpnmesmayo;
    }

    /**
     * @param hcpnmesjunio
     */
    public void setHcpnmesjunio(Integer hcpnmesjunio) {
        this.hcpnmesjunio = hcpnmesjunio;
    }

    /**
     * @return
     */
    public Integer getHcpnmesjunio() {
        return hcpnmesjunio;
    }

    /**
     * @param hcpnmesjulio
     */
    public void setHcpnmesjulio(Integer hcpnmesjulio) {
        this.hcpnmesjulio = hcpnmesjulio;
    }

    /**
     * @return
     */
    public Integer getHcpnmesjulio() {
        return hcpnmesjulio;
    }

    /**
     * @param hcpnmesagost
     */
    public void setHcpnmesagost(Integer hcpnmesagost) {
        this.hcpnmesagost = hcpnmesagost;
    }

    /**
     * @return
     */
    public Integer getHcpnmesagost() {
        return hcpnmesagost;
    }

    /**
     * @param hcpnmessepti
     */
    public void setHcpnmessepti(Integer hcpnmessepti) {
        this.hcpnmessepti = hcpnmessepti;
    }

    /**
     * @return
     */
    public Integer getHcpnmessepti() {
        return hcpnmessepti;
    }

    /**
     * @param hcpnmesoctub
     */
    public void setHcpnmesoctub(Integer hcpnmesoctub) {
        this.hcpnmesoctub = hcpnmesoctub;
    }

    /**
     * @return
     */
    public Integer getHcpnmesoctub() {
        return hcpnmesoctub;
    }

    /**
     * @param hcpnmesnovie
     */
    public void setHcpnmesnovie(Integer hcpnmesnovie) {
        this.hcpnmesnovie = hcpnmesnovie;
    }

    /**
     * @return
     */
    public Integer getHcpnmesnovie() {
        return hcpnmesnovie;
    }

    /**
     * @param hcpnmesdicie
     */
    public void setHcpnmesdicie(Integer hcpnmesdicie) {
        this.hcpnmesdicie = hcpnmesdicie;
    }

    /**
     * @return
     */
    public Integer getHcpnmesdicie() {
        return hcpnmesdicie;
    }

    /**
     * @param hppcestado
     */
    public void setHppcestado(String hppcestado) {
        this.hppcestado = hppcestado;
    }

    /**
     * @return
     */
    public String getHppcestado() {
        return hppcestado;
    }

    /**
     * @param hppdfecregistr
     */
    public void setHppdfecregistr(Date hppdfecregistr) {
        this.hppdfecregistr = hppdfecregistr;
    }

    /**
     * @return
     */
    public Date getHppdfecregistr() {
        return hppdfecregistr;
    }

    /**
     * @param hppcoperador
     */
    public void setHppcoperador(String hppcoperador) {
        this.hppcoperador = hppcoperador;
    }

    /**
     * @return
     */
    public String getHppcoperador() {
        return hppcoperador;
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

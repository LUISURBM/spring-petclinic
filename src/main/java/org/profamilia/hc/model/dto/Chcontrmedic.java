package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcontrmedic implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChcontrmedicPK id;

    /** nullable persistent field */
    private String hcmcmedicament;

    /** nullable persistent field */
    private String hcmcpresentaci;

    /** nullable persistent field */
    private BigDecimal hcmcadosis;

    /** nullable persistent field */
    private Integer hcmnfrecuadmin;

    /** nullable persistent field */
    private String hcmcviadministr;

    /** nullable persistent field */
    private String hcmcviadminotr;

    /** nullable persistent field */
    private String hcmcformaadmin;

    /** nullable persistent field */
    private String hcmcetapa;

    /** nullable persistent field */
    private Date hcmdfecregistr;

    /** nullable persistent field */
    private String hcmcoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Date hcmdfechaanota;

    /** nullable persistent field */
    private String hcmcunidad;


    /** identifier field */
    private String hcmctiposerv;


    /** default constructor */
    public Chcontrmedic() {
    }


    public void setId(ChcontrmedicPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontrmedicPK getId() {
        return id;
    }

    /**
     * @param hcmcmedicament
     */
    public void setHcmcmedicament(String hcmcmedicament) {
        this.hcmcmedicament = hcmcmedicament;
    }

    /**
     * @return
     */
    public String getHcmcmedicament() {
        return hcmcmedicament;
    }

    /**
     * @param hcmcpresentaci
     */
    public void setHcmcpresentaci(String hcmcpresentaci) {
        this.hcmcpresentaci = hcmcpresentaci;
    }

    /**
     * @return
     */
    public String getHcmcpresentaci() {
        return hcmcpresentaci;
    }

    /**
     * @param hcmcadosis
     */
    public void setHcmcadosis(BigDecimal hcmcadosis) {
        this.hcmcadosis = hcmcadosis;
    }

    /**
     * @return
     */
    public BigDecimal getHcmcadosis() {
        return hcmcadosis;
    }

    /**
     * @param hcmcviadministr
     */
    public void setHcmcviadministr(String hcmcviadministr) {
        this.hcmcviadministr = hcmcviadministr;
    }

    /**
     * @return
     */
    public String getHcmcviadministr() {
        return hcmcviadministr;
    }

    /**
     * @param hcmcviadminotr
     */
    public void setHcmcviadminotr(String hcmcviadminotr) {
        this.hcmcviadminotr = hcmcviadminotr;
    }

    /**
     * @return
     */
    public String getHcmcviadminotr() {
        return hcmcviadminotr;
    }

    /**
     * @param hcmcformaadmin
     */
    public void setHcmcformaadmin(String hcmcformaadmin) {
        this.hcmcformaadmin = hcmcformaadmin;
    }

    /**
     * @return
     */
    public String getHcmcformaadmin() {
        return hcmcformaadmin;
    }

    /**
     * @param hcmcetapa
     */
    public void setHcmcetapa(String hcmcetapa) {
        this.hcmcetapa = hcmcetapa;
    }

    /**
     * @return
     */
    public String getHcmcetapa() {
        return hcmcetapa;
    }

    /**
     * @param hcmdfecregistr
     */
    public void setHcmdfecregistr(Date hcmdfecregistr) {
        this.hcmdfecregistr = hcmdfecregistr;
    }

    /**
     * @return
     */
    public Date getHcmdfecregistr() {
        return hcmdfecregistr;
    }

    /**
     * @param hcmcoperador
     */
    public void setHcmcoperador(String hcmcoperador) {
        this.hcmcoperador = hcmcoperador;
    }

    /**
     * @return
     */
    public String getHcmcoperador() {
        return hcmcoperador;
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
     * @param hcmdfechaanota
     */
    public void setHcmdfechaanota(Date hcmdfechaanota) {
        this.hcmdfechaanota = hcmdfechaanota;
    }

    /**
     * @return
     */
    public Date getHcmdfechaanota() {
        return hcmdfechaanota;
    }


    /**
     * @param hcmnfrecuadmin
     */
    public void setHcmnfrecuadmin(Integer hcmnfrecuadmin) {
        this.hcmnfrecuadmin = hcmnfrecuadmin;
    }

    /**
     * @return
     */
    public Integer getHcmnfrecuadmin() {
        return hcmnfrecuadmin;
    }

    /**
     * @param hcmcunidad
     */
    public void setHcmcunidad(String hcmcunidad) {
        this.hcmcunidad = hcmcunidad;
    }

    /**
     * @return
     */
    public String getHcmcunidad() {
        return hcmcunidad;
    }

    /**
     * @param hcmctiposerv
     */
    public void setHcmctiposerv(String hcmctiposerv) {
        this.hcmctiposerv = hcmctiposerv;
    }

    /**
     * @return
     */
    public String getHcmctiposerv() {
        return hcmctiposerv;
    }
}

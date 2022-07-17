package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;


/** @author Hibernate CodeGenerator */
public class Chregicirpro implements Serializable {

    /** identifier field */
    private Long hrcnnumero;

    /** nullable persistent field */
    private Cpclinica hrcnclinic;
    
    /** nullable persistent field */
    private Date hrcdfeccirpro;

    /** nullable persistent field */
    private Date hrctfecreg;

    /** nullable persistent field */
    private Integer hrcnprogra;

    /** nullable persistent field */
    private BigDecimal hrcndonant;

    /** nullable persistent field */
    private Integer hrcntipusu;

    /** nullable persistent field */
     private Chusuario hrclusuario;

    /** nullable persistent field */
    private String hrcctipide;

    /** nullable persistent field */
    private BigDecimal hrcanumide;

    /** nullable persistent field */
    private String hrccusureg;

    /** nullable persistent field */
     private Cpservicio hrccservic;

    /** nullable persistent field */
    private Integer hrcnconini;

    /** nullable persistent field */
    private Integer hrcnconfac;

    /** nullable persistent field */
    private BigDecimal hrcnnumfac;

    /** nullable persistent field */
    private String hrccestado;

    /** nullable persistent field */
    private String hrccetapa;

    /** nullable persistent field */
    private String hrccusucnf;

    /** nullable persistent field */
    private Date hrctfeccnf;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chregicirpro() {

    }


    /**
     * @param hrcnnumero
     */
    public void setHrcnnumero(Long hrcnnumero) {
        this.hrcnnumero = hrcnnumero;
    }

    /**
     * @return
     */
    public Long getHrcnnumero() {
        return hrcnnumero;
    }

    /**
     * @param hcpdfechacirug
     */
    public void setHrcdfeccirpro(Date hrcdfeccirpro) {
        this.hrcdfeccirpro = hrcdfeccirpro;
    }

    /**
     * @return
     */
    public Date getHrcdfeccirpro() {
        return hrcdfeccirpro;
    }

    /**
     * @param hrclusuario
     */
    public void setHrclusuario(Chusuario hrclusuario) {
        this.hrclusuario = hrclusuario;
    }

    /**
     * @return
     */
    public Chusuario getHrclusuario() {
        return hrclusuario;
    }
    /**
     * @param hrccestado
     */
    public void setHrccestado(String hrccestado) {
        this.hrccestado = hrccestado;
    }

    /**
     * @return
     */
    public String getHrccestado() {
        return hrccestado;
    }

    /**
     * @param hrcnclinic
     */
    public void setHrcnclinic(Cpclinica hrcnclinic) {
        this.hrcnclinic = hrcnclinic;
    }

    /**
     * @return
     */
    public Cpclinica getHrcnclinic() {
        return hrcnclinic;
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
     * @param hrccetapa
     */
    public void setHrccetapa(String hrccetapa) {
        this.hrccetapa = hrccetapa;
    }

    /**
     * @return
     */
    public String getHrccetapa() {
        return hrccetapa;
    }


    public void setHrctfecreg(Date hrctfecreg) {
        this.hrctfecreg = hrctfecreg;
    }

    public Date getHrctfecreg() {
        return hrctfecreg;
    }

    public void setHrcnprogra(Integer hrcnprogra) {
        this.hrcnprogra = hrcnprogra;
    }

    public Integer getHrcnprogra() {
        return hrcnprogra;
    }

    public void setHrcndonant(BigDecimal hrcndonant) {
        this.hrcndonant = hrcndonant;
    }

    public BigDecimal getHrcndonant() {
        return hrcndonant;
    }

    public void setHrcntipusu(Integer hrcntipusu) {
        this.hrcntipusu = hrcntipusu;
    }

    public Integer getHrcntipusu() {
        return hrcntipusu;
    }

    public void setHrcctipide(String hrcctipide) {
        this.hrcctipide = hrcctipide;
    }

    public String getHrcctipide() {
        return hrcctipide;
    }

    public void setHrcanumide(BigDecimal hrcanumide) {
        this.hrcanumide = hrcanumide;
    }

    public BigDecimal getHrcanumide() {
        return hrcanumide;
    }

    public void setHrccusureg(String hrccusureg) {
        this.hrccusureg = hrccusureg;
    }

    public String getHrccusureg() {
        return hrccusureg;
    }

    public void setHrccservic(Cpservicio hrccservic) {
        this.hrccservic = hrccservic;
    }

    public Cpservicio getHrccservic() {
        return hrccservic;
    }

    public void setHrcnconini(Integer hrcnconini) {
        this.hrcnconini = hrcnconini;
    }

    public Integer getHrcnconini() {
        return hrcnconini;
    }

    public void setHrcnconfac(Integer hrcnconfac) {
        this.hrcnconfac = hrcnconfac;
    }

    public Integer getHrcnconfac() {
        return hrcnconfac;
    }

    public void setHrcnnumfac(BigDecimal hrcnnumfac) {
        this.hrcnnumfac = hrcnnumfac;
    }

    public BigDecimal getHrcnnumfac() {
        return hrcnnumfac;
    }

    public void setHrccusucnf(String hrccusucnf) {
        this.hrccusucnf = hrccusucnf;
    }

    public String getHrccusucnf() {
        return hrccusucnf;
    }

    public void setHrctfeccnf(Date hrctfeccnf) {
        this.hrctfeccnf = hrctfeccnf;
    }

    public Date getHrctfeccnf() {
        return hrctfeccnf;
    }
    
    
}

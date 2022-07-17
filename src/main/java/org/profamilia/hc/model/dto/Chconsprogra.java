package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chconsprogra implements Serializable {

    /** identifier field */
    private Long hcplnumero;

    /** nullable persistent field */
    private Date hcpdfechprocon;

    /** nullable persistent field */
    private Integer hcpnclinica;

    /** nullable persistent field */
    private BigDecimal hcpncodigoprof;

    /** nullable persistent field */
    private String hcpcservicio;

    /** nullable persistent field */
    private String hcpcoperador;

    /** nullable persistent field */
    private Date hcpdfecregistr;

    /** nullable persistent field */
    private String hcpeetapa;

    /** nullable persistent field */
    private Integer hcpntipdoc;

    /** nullable persistent field */
    private BigDecimal hcpnnumdoc;

    /** nullable persistent field */
    private Long hcplusuario;

    /** nullable persistent field */
    private Integer hcpncantid;

    /** nullable persistent field */
    private BigDecimal hcpavalser;

    /** nullable persistent field */
    private String hcpcopemod;

    /** nullable persistent field */
    private Date hcpdfecmod;

    /** nullable persistent field */
    private Integer version;

    /** persistent field */
    private String hcpctiposervi;

    /** persistent field */
    private Integer hcpncontro;

    /** persistent field */
    private String hcpcserori;

    /** persistent field */
    private Integer hcpndiasate;

    /** persistent field */
    private String hcpcobserv;
    
    private String nombreServicio;
    private String horaRegi;
    private String tipoDocumento;


    /** full constructor */
    public Chconsprogra(Long hcplnumero, Date hcpdfechprocon, Integer hcpnclinica, BigDecimal hcpncodigoprof, String hcpcservicio, String hcpcoperador, 
           Date hcpdfecregistr, String hcpeetapa, Integer hcpntipdoc, BigDecimal hcpnnumdoc, Long hcplusuario, Integer hcpncantid, BigDecimal hcpavalser, 
           String hcpcopemod, Date hcpdfecmod, Integer version, String hcpctiposervi, Integer hcpncontro, String hcpcserori, Integer hcpndiasate, String hcpcobserv) {
        this.hcplnumero = hcplnumero;
        this.hcpdfechprocon = hcpdfechprocon;
        this.hcpnclinica = hcpnclinica;
        this.hcpncodigoprof = hcpncodigoprof;
        this.hcpcservicio = hcpcservicio;
        this.hcpcoperador = hcpcoperador;
        this.hcpdfecregistr = hcpdfecregistr;
        this.hcpeetapa = hcpeetapa;
        this.hcpntipdoc = hcpntipdoc;
        this.hcpnnumdoc = hcpnnumdoc;
        this.hcplusuario = hcplusuario;
        this.hcpncantid = hcpncantid;
        this.hcpavalser = hcpavalser;
        this.hcpcopemod = hcpcopemod;
        this.hcpdfecmod = hcpdfecmod;
        this.version = version;
        this.hcpctiposervi = hcpctiposervi;
        this.hcpncontro = hcpncontro;
        this.hcpcserori = hcpcserori;
        this.hcpndiasate = hcpndiasate;
        this.hcpcobserv = hcpcobserv;
    }

    /** default constructor */
    public Chconsprogra() {
    }

    /** minimal constructor */
    public Chconsprogra(Long hcplnumero, String hcpctiposervi, Integer hcpncontro, String hcpcserori) {
        this.hcplnumero = hcplnumero;
        this.hcpctiposervi = hcpctiposervi;
        this.hcpncontro = hcpncontro;
        this.hcpcserori = hcpcserori;
    }

    /** 
     * Codigo del control es un consecutivo en el sistema
     * 		    
     */
    public Long getHcplnumero() {
        return this.hcplnumero;
    }

    /**
     * @param hcplnumero
     */
    public void setHcplnumero(Long hcplnumero) {
        this.hcplnumero = hcplnumero;
    }

    /**
     * @return
     */
    public Date getHcpdfechprocon() {
        return this.hcpdfechprocon;
    }

    /**
     * @param hcpdfechprocon
     */
    public void setHcpdfechprocon(Date hcpdfechprocon) {
        this.hcpdfechprocon = hcpdfechprocon;
    }

    /**
     * @return
     */
    public Integer getHcpnclinica() {
        return this.hcpnclinica;
    }

    /**
     * @param hcpnclinica
     */
    public void setHcpnclinica(Integer hcpnclinica) {
        this.hcpnclinica = hcpnclinica;
    }

    /**
     * @return
     */
    public BigDecimal getHcpncodigoprof() {
        return this.hcpncodigoprof;
    }

    /**
     * @param hcpncodigoprof
     */
    public void setHcpncodigoprof(BigDecimal hcpncodigoprof) {
        this.hcpncodigoprof = hcpncodigoprof;
    }

    /**
     * @return
     */
    public String getHcpcservicio() {
        return this.hcpcservicio;
    }

    /**
     * @param hcpcservicio
     */
    public void setHcpcservicio(String hcpcservicio) {
        this.hcpcservicio = hcpcservicio;
    }

    /**
     * @return
     */
    public String getHcpcoperador() {
        return this.hcpcoperador;
    }

    /**
     * @param hcpcoperador
     */
    public void setHcpcoperador(String hcpcoperador) {
        this.hcpcoperador = hcpcoperador;
    }

    /**
     * @return
     */
    public Date getHcpdfecregistr() {
        return this.hcpdfecregistr;
    }

    /**
     * @param hcpdfecregistr
     */
    public void setHcpdfecregistr(Date hcpdfecregistr) {
        this.hcpdfecregistr = hcpdfecregistr;
    }

    /**
     * @return
     */
    public String getHcpeetapa() {
        return this.hcpeetapa;
    }

    /**
     * @param hcpeetapa
     */
    public void setHcpeetapa(String hcpeetapa) {
        this.hcpeetapa = hcpeetapa;
    }

    /**
     * @return
     */
    public Integer getHcpntipdoc() {
        return this.hcpntipdoc;
    }

    /**
     * @param hcpntipdoc
     */
    public void setHcpntipdoc(Integer hcpntipdoc) {
        this.hcpntipdoc = hcpntipdoc;
    }

    /**
     * @return
     */
    public BigDecimal getHcpnnumdoc() {
        return this.hcpnnumdoc;
    }

    /**
     * @param hcpnnumdoc
     */
    public void setHcpnnumdoc(BigDecimal hcpnnumdoc) {
        this.hcpnnumdoc = hcpnnumdoc;
    }

    /**
     * @return
     */
    public Long getHcplusuario() {
        return this.hcplusuario;
    }

    /**
     * @param hcplusuario
     */
    public void setHcplusuario(Long hcplusuario) {
        this.hcplusuario = hcplusuario;
    }

    /**
     * @return
     */
    public Integer getHcpncantid() {
        return this.hcpncantid;
    }

    /**
     * @param hcpncantid
     */
    public void setHcpncantid(Integer hcpncantid) {
        this.hcpncantid = hcpncantid;
    }

    /**
     * @return
     */
    public BigDecimal getHcpavalser() {
        return this.hcpavalser;
    }

    /**
     * @param hcpavalser
     */
    public void setHcpavalser(BigDecimal hcpavalser) {
        this.hcpavalser = hcpavalser;
    }

    /**
     * @return
     */
    public String getHcpcopemod() {
        return this.hcpcopemod;
    }

    /**
     * @param hcpcopemod
     */
    public void setHcpcopemod(String hcpcopemod) {
        this.hcpcopemod = hcpcopemod;
    }

    /**
     * @return
     */
    public Date getHcpdfecmod() {
        return this.hcpdfecmod;
    }

    /**
     * @param hcpdfecmod
     */
    public void setHcpdfecmod(Date hcpdfecmod) {
        this.hcpdfecmod = hcpdfecmod;
    }

    /**
     * @return
     */
    public Integer getVersion() {
        return this.version;
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
    public String getHcpctiposervi() {
        return this.hcpctiposervi;
    }

    /**
     * @param hcpctiposervi
     */
    public void setHcpctiposervi(String hcpctiposervi) {
        this.hcpctiposervi = hcpctiposervi;
    }

    /**
     * @return
     */
    public Integer getHcpncontro() {
        return this.hcpncontro;
    }

    /**
     * @param hcpncontro
     */
    public void setHcpncontro(Integer hcpncontro) {
        this.hcpncontro = hcpncontro;
    }

    /**
     * @return
     */
    public String getHcpcserori() {
        return this.hcpcserori;
    }

    /**
     * @param hcpcserori
     */
    public void setHcpcserori(String hcpcserori) {
        this.hcpcserori = hcpcserori;
    }

    /**
     * @return
     */
    public String toString() {
        return new ToStringBuilder(this)
            .append("hcplnumero", getHcplnumero())
            .toString();
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param horaRegi
     */
    public void setHoraRegi(String horaRegi) {
        this.horaRegi = horaRegi;
    }

    /**
     * @return
     */
    public String getHoraRegi() {
        if (hcpdfechprocon != null) {
            GregorianCalendar fecha = new GregorianCalendar();
            fecha.setTime(hcpdfechprocon);
            int hora;
            int minuto;
            String horaSelect = "";
            String minutoSelect = "";

            hora = fecha.get(Calendar.HOUR_OF_DAY);
            minuto = fecha.get(Calendar.MINUTE);

            if (hora < 10) {
                horaSelect = "0" + hora;
            } else {
                horaSelect = hora + "";
            }
            if (minuto < 10) {
                minutoSelect = "0" + minuto;
            } else {
                minutoSelect = minuto + "";
            }


            this.horaRegi = horaSelect + ":" + minutoSelect;
        }

        return horaRegi;
    }


    public void setHcpndiasate(Integer hcpndiasate) {
        this.hcpndiasate = hcpndiasate;
    }

    public Integer getHcpndiasate() {
        return hcpndiasate;
    }

    public void setHcpcobserv(String hcpcobserv) {
        this.hcpcobserv = hcpcobserv;
    }

    public String getHcpcobserv() {
        return hcpcobserv;
    }
}

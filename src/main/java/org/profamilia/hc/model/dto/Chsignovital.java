package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chsignovital implements Serializable {

    /** identifier field */
    private ChsignovitalPK id;

    /** nullable persistent field */
    private Long hsvlusuario;

    /** nullable persistent field */
    private Integer hsvnpresart1;

    /** nullable persistent field */
    private Integer hsvnpresart2;

    /** nullable persistent field */
    private Integer hsvnfreccard;

    /** nullable persistent field */
    private Integer hsvnfrecresp;

    /** nullable persistent field */
    private String hsvetipotemper;

    /** nullable persistent field */
    private BigDecimal hsvatemperatu;
    
    /** nullable persistent field */
    private String hsvdhoraactivi;

    /** nullable persistent field */
    private String hsvdhoraactfin;

    /** nullable persistent field */
    private Integer hsvnsatuoxihe;

    /** nullable persistent field */
    private Integer hsvnclinica;

    /** nullable persistent field */
    private String hsvcestado;

    /** nullable persistent field */
    private Date hsvdfecregistr;

    /** nullable persistent field */
    private String hsvcoperador;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private Integer hsvnpresioxido;

    /** nullable persistent field */
    private String hsvctiporespir;

    /** nullable persistent field */
    private Date hsvdfechaactiv;

    /** nullable persistent field  */
    private String hsvctipoproced;

    /** nullable persistent field  */
    private Integer hsvnescaldolor;
    
    /** nullable persistent field  */
    private String hsvcdescropera; 
    
    /** nullable persistent field  */
    private String hsvctiposervi; 


    /** default constructor */
    public Chsignovital() {
        id = new ChsignovitalPK(); 
    }


    public void setId(ChsignovitalPK id) {
        this.id = id;
    }

    public ChsignovitalPK getId() {
        return id;
    }

    /**
     * @param hsvlusuario
     */
    public void setHsvlusuario(Long hsvlusuario) {
        this.hsvlusuario = hsvlusuario;
    }

    /**
     * @return
     */
    public Long getHsvlusuario() {
        return hsvlusuario;
    }

   

    /**
     * @param hsvnfreccard
     */
    public void setHsvnfreccard(Integer hsvnfreccard) {
        this.hsvnfreccard = hsvnfreccard;
    }

    /**
     * @return
     */
    public Integer getHsvnfreccard() {
        return hsvnfreccard;
    }

    /**
     * @param hsvnfrecresp
     */
    public void setHsvnfrecresp(Integer hsvnfrecresp) {
        this.hsvnfrecresp = hsvnfrecresp;
    }

    /**
     * @return
     */
    public Integer getHsvnfrecresp() {
        return hsvnfrecresp;
    }

    /**
     * @param hsvetipotemper
     */
    public void setHsvetipotemper(String hsvetipotemper) {
        this.hsvetipotemper = hsvetipotemper;
    }

    /**
     * @return
     */
    public String getHsvetipotemper() {
        return hsvetipotemper;
    }

    /**
     * @param hsvatemperatu
     */
    public void setHsvatemperatu(BigDecimal hsvatemperatu) {
        this.hsvatemperatu = hsvatemperatu;
    }

    /**
     * @return
     */
    public BigDecimal getHsvatemperatu() {
        return hsvatemperatu;
    }

    /**
     * @param hsvnsatuoxihe
     */
    public void setHsvnsatuoxihe(Integer hsvnsatuoxihe) {
        this.hsvnsatuoxihe = hsvnsatuoxihe;
    }

    /**
     * @return
     */
    public Integer getHsvnsatuoxihe() {
        return hsvnsatuoxihe;
    }

    /**
     * @param hsvnclinica
     */
    public void setHsvnclinica(Integer hsvnclinica) {
        this.hsvnclinica = hsvnclinica;
    }

    /**
     * @return
     */
    public Integer getHsvnclinica() {
        return hsvnclinica;
    }

    /**
     * @param hsvcestado
     */
    public void setHsvcestado(String hsvcestado) {
        this.hsvcestado = hsvcestado;
    }

    /**
     * @return
     */
    public String getHsvcestado() {
        return hsvcestado;
    }

    /**
     * @param hsvdfecregistr
     */
    public void setHsvdfecregistr(Date hsvdfecregistr) {
        this.hsvdfecregistr = hsvdfecregistr;
    }

    /**
     * @return
     */
    public Date getHsvdfecregistr() {
        return hsvdfecregistr;
    }

    /**
     * @param hsvcoperador
     */
    public void setHsvcoperador(String hsvcoperador) {
        this.hsvcoperador = hsvcoperador;
    }

    /**
     * @return
     */
    public String getHsvcoperador() {
        return hsvcoperador;
    }

    /**
     * @param hsvnpresioxido
     */
    public void setHsvnpresioxido(Integer hsvnpresioxido) {
        this.hsvnpresioxido = hsvnpresioxido;
    }

    /**
     * @return
     */
    public Integer getHsvnpresioxido() {
        return hsvnpresioxido;
    }

    /**
     * @param hsvctiporespir
     */
    public void setHsvctiporespir(String hsvctiporespir) {
        this.hsvctiporespir = hsvctiporespir;
    }

    /**
     * @return
     */
    public String getHsvctiporespir() {
        return hsvctiporespir;
    }

    /**
     * @param hsvdfechaactiv
     */
    public void setHsvdfechaactiv(Date hsvdfechaactiv) {
        this.hsvdfechaactiv = hsvdfechaactiv;
    }

    /**
     * @return
     */
    public Date getHsvdfechaactiv() {
        return hsvdfechaactiv;
    }

    /**
     * @param hsvctipoproced
     */
    public void setHsvctipoproced(String hsvctipoproced) {
        this.hsvctipoproced = hsvctipoproced;
    }

    /**
     * @return
     */
    public String getHsvctipoproced() {
        return hsvctipoproced;
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
     * @param hsvnescaldolor
     */
    public void setHsvnescaldolor(Integer hsvnescaldolor) {
        this.hsvnescaldolor = hsvnescaldolor;
    }

    /**
     * @return
     */
    public Integer getHsvnescaldolor() {
        return hsvnescaldolor;
    }

    /**
     * @param hsvnpresart1
     */
    public void setHsvnpresart1(Integer hsvnpresart1) {
        this.hsvnpresart1 = hsvnpresart1;
    }

    /**
     * @return
     */
    public Integer getHsvnpresart1() {
        return hsvnpresart1;
    }

    /**
     * @param hsvnpresart2
     */
    public void setHsvnpresart2(Integer hsvnpresart2) {
        this.hsvnpresart2 = hsvnpresart2;
    }

    /**
     * @return
     */
    public Integer getHsvnpresart2() {
        return hsvnpresart2;
    }

    public void setHsvdhoraactivi(String hsvdhoraactivi) {
        this.hsvdhoraactivi = hsvdhoraactivi;
    }

    public String getHsvdhoraactivi() {      
    if (hsvdfechaactiv != null) {
            Calendar fecha = Calendar.getInstance();
            fecha.setTime(hsvdfechaactiv);

            String f = "";

            if (hsvdfechaactiv != null) {
                String DATE_FORMAT = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                f = sdf.format(hsvdfechaactiv);
            }

            Integer hora = fecha.get(Calendar.HOUR_OF_DAY);
            Integer minuto = fecha.get(Calendar.MINUTE);

            String horaSelect = "";
            String minutoSelect = "";

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
            this.hsvdhoraactivi = f + " _ " + horaSelect + ":" + minutoSelect;

        }
        return hsvdhoraactivi;
    }

    public void setHsvdhoraactfin(String hsvdhoraactfin) {
        this.hsvdhoraactfin = hsvdhoraactfin;
    }

    public String getHsvdhoraactfin() {
        return hsvdhoraactfin;
    }

    public void setHsvcdescropera(String hsvcdescropera) {
        this.hsvcdescropera = hsvcdescropera;
    }

    public String getHsvcdescropera() {
        return hsvcdescropera;
    }

    public void setHsvctiposervi(String hsvctiposervi) {
        this.hsvctiposervi = hsvctiposervi;
    }

    public String getHsvctiposervi() {
        return hsvctiposervi;
    }
}

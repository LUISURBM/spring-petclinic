package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chvalorabiopsi implements Serializable {

    /** identifier field */
    private Long hvbnconsulta;

    /** nullable persistent field */
    private Integer hvbnedad;

    /** nullable persistent field */
    private String hvbccesaprev;

    /** nullable persistent field */
    private String hvbcpreehipe;

    /** nullable persistent field */
    private String hvbcaborinfe;

    /** nullable persistent field */
    private Integer hvbnparidad;

    /** nullable persistent field */
    private String hvbchemposrem;

    /** nullable persistent field */
    private String hvbcmanuplac;

    /** nullable persistent field */
    private Integer hvbnpesrecnac;

    /** nullable persistent field */
    private String hvbcmorfetneo;

    /** nullable persistent field */
    private String hvbcparanodifi;

    /** nullable persistent field */
    private String hvbccirginpre;

    /** nullable persistent field */
    private String hvbcenfrencro;

    /** nullable persistent field */
    private String hvbcdiabgest;

    /** nullable persistent field */
    private String hvbcdiabprec;

    /** nullable persistent field */
    private Integer hvbnhemorragia;

    /** nullable persistent field */
    private String hvbcanemia;

    /** nullable persistent field */
    private Integer hvbnembpro;

    /** nullable persistent field */
    private String hvbchipearte;

    /** nullable persistent field */
    private String hvbcpolihidra;

    /** nullable persistent field */
    private String hvbcembmult;

    /** nullable persistent field */
    private String hvbcprefretra;

    /** nullable persistent field */
    private String hvbcisoinnmu;

    /** nullable persistent field */
    private String hvbcansiseve;

    /** nullable persistent field */
    private String hvbcsosofain;

    /** nullable persistent field */
    private String hvbcobservacion;

    /** nullable persistent field */
    private Integer version;

    /** nullable persistent field */
    private String hvbcusuaregi;

    /** nullable persistent field */
    private Date hvbdfechregi;
    
    /** nullable persistent field */
    private Integer hvbnpuntos;
    
    /** nullable persistent field */
    private Integer hvbnanemiadesc;

    /** full constructor */
    public Chvalorabiopsi(Long hvbnconsulta, Integer hvbnedad, String hvbccesaprev, String hvbcpreehipe, String hvbcaborinfe, Integer hvbnparidad, String hvbchemposrem, String hvbcmanuplac, Integer hvbnpesrecnac, String hvbcmorfetneo, String hvbcparanodifi, String hvbccirginpre, String hvbcenfrencro, String hvbcdiabgest, String hvbcdiabprec, Integer hvbnhemorragia, String hvbnanemia, Integer hvbnembpro, String hvbchipearte, String hvbcpolihidra, String hvbcembmult, String hvbcprefretra, String hvbcisoinnmu, String hvbcansiseve, String hvbcsosofain, String hvbcobservacion, Integer version, String hvbcusuaregi, Date hvbdfechregi,Integer hvbnpuntos,Integer hvbnanemiadesc) {
        this.hvbnconsulta = hvbnconsulta;
        this.hvbnedad = hvbnedad;
        this.hvbccesaprev = hvbccesaprev;
        this.hvbcpreehipe = hvbcpreehipe;
        this.hvbcaborinfe = hvbcaborinfe;
        this.hvbnparidad = hvbnparidad;
        this.hvbchemposrem = hvbchemposrem;
        this.hvbcmanuplac = hvbcmanuplac;
        this.hvbnpesrecnac = hvbnpesrecnac;
        this.hvbcmorfetneo = hvbcmorfetneo;
        this.hvbcparanodifi = hvbcparanodifi;
        this.hvbccirginpre = hvbccirginpre;
        this.hvbcenfrencro = hvbcenfrencro;
        this.hvbcdiabgest = hvbcdiabgest;
        this.hvbcdiabprec = hvbcdiabprec;
        this.hvbnhemorragia = hvbnhemorragia;
        this.hvbcanemia = hvbnanemia;
        this.hvbnembpro = hvbnembpro;
        this.hvbchipearte = hvbchipearte;
        this.hvbcpolihidra = hvbcpolihidra;
        this.hvbcembmult = hvbcembmult;
        this.hvbcprefretra = hvbcprefretra;
        this.hvbcisoinnmu = hvbcisoinnmu;
        this.hvbcansiseve = hvbcansiseve;
        this.hvbcsosofain = hvbcsosofain;
        this.hvbcobservacion = hvbcobservacion;
        this.version = version;
        this.hvbcusuaregi = hvbcusuaregi;
        this.hvbdfechregi = hvbdfechregi;
        this.hvbnpuntos = hvbnpuntos;
        this.hvbnanemiadesc = hvbnanemiadesc;
    }

    /** default constructor */
    public Chvalorabiopsi() {
    }

    /** minimal constructor */
    public Chvalorabiopsi(Long hvbnconsulta) {
        this.hvbnconsulta = hvbnconsulta;
    }

    /** 
     * 		       ConsultaClinica
     * 		    
     */
    public Long getHvbnconsulta() {
        return this.hvbnconsulta;
    }

    public void setHvbnconsulta(Long hvbnconsulta) {
        this.hvbnconsulta = hvbnconsulta;
    }

    public Integer getHvbnedad() {
        return this.hvbnedad;
    }

    public void setHvbnedad(Integer hvbnedad) {
        this.hvbnedad = hvbnedad;
    }

    public String getHvbccesaprev() {
        return this.hvbccesaprev;
    }

    public void setHvbccesaprev(String hvbccesaprev) {
        this.hvbccesaprev = hvbccesaprev;
    }

    public String getHvbcpreehipe() {
        return this.hvbcpreehipe;
    }

    public void setHvbcpreehipe(String hvbcpreehipe) {
        this.hvbcpreehipe = hvbcpreehipe;
    }

    public String getHvbcaborinfe() {
        return this.hvbcaborinfe;
    }

    public void setHvbcaborinfe(String hvbcaborinfe) {
        this.hvbcaborinfe = hvbcaborinfe;
    }

    public Integer getHvbnparidad() {
        return this.hvbnparidad;
    }

    public void setHvbnparidad(Integer hvbnparidad) {
        this.hvbnparidad = hvbnparidad;
    }

    public String getHvbchemposrem() {
        return this.hvbchemposrem;
    }

    public void setHvbchemposrem(String hvbchemposrem) {
        this.hvbchemposrem = hvbchemposrem;
    }

    public String getHvbcmanuplac() {
        return this.hvbcmanuplac;
    }

    public void setHvbcmanuplac(String hvbcmanuplac) {
        this.hvbcmanuplac = hvbcmanuplac;
    }

    public Integer getHvbnpesrecnac() {
        return this.hvbnpesrecnac;
    }

    public void setHvbnpesrecnac(Integer hvbnpesrecnac) {
        this.hvbnpesrecnac = hvbnpesrecnac;
    }

    public String getHvbcmorfetneo() {
        return this.hvbcmorfetneo;
    }

    public void setHvbcmorfetneo(String hvbcmorfetneo) {
        this.hvbcmorfetneo = hvbcmorfetneo;
    }

    public String getHvbcparanodifi() {
        return this.hvbcparanodifi;
    }

    public void setHvbcparanodifi(String hvbcparanodifi) {
        this.hvbcparanodifi = hvbcparanodifi;
    }

    public String getHvbccirginpre() {
        return this.hvbccirginpre;
    }

    public void setHvbccirginpre(String hvbccirginpre) {
        this.hvbccirginpre = hvbccirginpre;
    }

    public String getHvbcenfrencro() {
        return this.hvbcenfrencro;
    }

    public void setHvbcenfrencro(String hvbcenfrencro) {
        this.hvbcenfrencro = hvbcenfrencro;
    }

    public String getHvbcdiabgest() {
        return this.hvbcdiabgest;
    }

    public void setHvbcdiabgest(String hvbcdiabgest) {
        this.hvbcdiabgest = hvbcdiabgest;
    }

    public String getHvbcdiabprec() {
        return this.hvbcdiabprec;
    }

    public void setHvbcdiabprec(String hvbcdiabprec) {
        this.hvbcdiabprec = hvbcdiabprec;
    }

    public Integer getHvbnhemorragia() {
        return this.hvbnhemorragia;
    }

    public void setHvbnhemorragia(Integer hvbnhemorragia) {
        this.hvbnhemorragia = hvbnhemorragia;
    }

    public String getHvbcanemia() {
        return this.hvbcanemia;
    }

    public void setHvbcanemia(String hvbnanemia) {
        this.hvbcanemia = hvbnanemia;
    }

    public Integer getHvbnembpro() {
        return this.hvbnembpro;
    }

    public void setHvbnembpro(Integer hvbnembpro) {
        this.hvbnembpro = hvbnembpro;
    }

    public String getHvbchipearte() {
        return this.hvbchipearte;
    }

    public void setHvbchipearte(String hvbchipearte) {
        this.hvbchipearte = hvbchipearte;
    }

    public String getHvbcpolihidra() {
        return this.hvbcpolihidra;
    }

    public void setHvbcpolihidra(String hvbcpolihidra) {
        this.hvbcpolihidra = hvbcpolihidra;
    }

    public String getHvbcembmult() {
        return this.hvbcembmult;
    }

    public void setHvbcembmult(String hvbcembmult) {
        this.hvbcembmult = hvbcembmult;
    }

    public String getHvbcprefretra() {
        return this.hvbcprefretra;
    }

    public void setHvbcprefretra(String hvbcprefretra) {
        this.hvbcprefretra = hvbcprefretra;
    }

    public String getHvbcisoinnmu() {
        return this.hvbcisoinnmu;
    }

    public void setHvbcisoinnmu(String hvbcisoinnmu) {
        this.hvbcisoinnmu = hvbcisoinnmu;
    }

    public String getHvbcansiseve() {
        return this.hvbcansiseve;
    }

    public void setHvbcansiseve(String hvbcansiseve) {
        this.hvbcansiseve = hvbcansiseve;
    }

    public String getHvbcsosofain() {
        return this.hvbcsosofain;
    }

    public void setHvbcsosofain(String hvbcsosofain) {
        this.hvbcsosofain = hvbcsosofain;
    }

    public String getHvbcobservacion() {
        return this.hvbcobservacion;
    }

    public void setHvbcobservacion(String hvbcobservacion) {
        this.hvbcobservacion = hvbcobservacion;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getHvbcusuaregi() {
        return this.hvbcusuaregi;
    }

    public void setHvbcusuaregi(String hvbcusuaregi) {
        this.hvbcusuaregi = hvbcusuaregi;
    }

    public Date getHvbdfechregi() {
        return this.hvbdfechregi;
    }

    public void setHvbdfechregi(Date hvbdfechregi) {
        this.hvbdfechregi = hvbdfechregi;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hvbnconsulta", getHvbnconsulta())
            .toString();
    }

    public void setHvbnpuntos(Integer hvbnpuntos) {
        this.hvbnpuntos = hvbnpuntos;
    }

    public Integer getHvbnpuntos() {
        return hvbnpuntos;
    }

    public void setHvbnanemiadesc(Integer hvbnanemiadesc) {
        this.hvbnanemiadesc = hvbnanemiadesc;
    }

    public Integer getHvbnanemiadesc() {
        return hvbnanemiadesc;
    }
}

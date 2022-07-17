package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chdetaldescr implements Serializable {

    /** identifier field */
    private ChdetaldescrPK id;

    /** nullable persistent field */
    private Chusuario hddlusuario;

    /** nullable persistent field */
    private BigDecimal hddccirujano;

    /** persistent field */
    private String hddcdiagnprinc;

    /** nullable persistent field */
    private String hddcdiagnrelac;

    /** nullable persistent field */
    private String hddcpiezapatol;

    /** nullable persistent field */
    private String hddchallazgos;

    /** nullable persistent field */
    private String hddcdescripcio;

    /** nullable persistent field */
    private String hddctienecompl;
    
    /** nullable persistent field */
    private String hddctienepiepa;
                   
    /** nullable persistent field */
    private String hddcdiagncompl;

    /** nullable persistent field */
    private String hddctienesangr;

    /** nullable persistent field */
    private Integer hddnsangraprox;

    /** nullable persistent field */
    private String hddcanotardiur;

    /** nullable persistent field */
    private Integer hddncantidadiu;

    /** nullable persistent field */
    private String hddcaspectodiu;

    /** nullable persistent field */
    private Date hdddfecregistr;

    /** nullable persistent field */
    private String hddcoperador;

    /** nullable persistent field */
    private String hddcdescrcompl;

    /** nullable persistent field */
    private String hddcgradohemar;
    
    /** nullable persistent field */
    private Integer hddnfinalidad; 
    
    /** nullable persistent field */
    private BigDecimal hddnayudante1;
    
    /** nullable persistent field */
    private BigDecimal hddnayudante2;
    
    /** nullable persistent field */
    private String hddcanestesiol;
    
    /** nullable persistent field */
    private String hddctipoaneste;
    
    /** nullable persistent field */
    private BigDecimal hddninstrument;
    
    /** nullable persistent field */
    private BigDecimal hddncirculante;
    
    /** nullable persistent field */
    private Integer hddntiempohora;
    
    /** nullable persistent field */
    private Integer hddntiempominu;
    
   /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hddcestado;
    
    /** nullable persistent field */
    private String hddcnomresiden;  
    
    /** nullable persistent field */
    private String hddcayudante1;  
    
    /** nullable persistent field */
    private String hddcayudante2;
    
    
    /** nullable persistent field */
    private BigDecimal hddcmediayud1;  
    
    /** nullable persistent field */
    private BigDecimal hddcmediayud2;
    
    
    /** nullable persistent field */
    private String hddcnomresiden1;  

    
    /** nullable persistent field */
    private String hddcnomresiden2;  
    
    /** nullable persistent field */
    private String hddccuantifi;  

    /** nullable persistent field */
    private String hddccuantidiure;  


    /** default constructor */
    public Chdetaldescr() {
    
        id = new ChdetaldescrPK(); 
    }


    /**
     * @param id
     */
    public void setId(ChdetaldescrPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChdetaldescrPK getId() {
        return id;
    }

    /**
     * @param hddlusuario
     */
    public void setHddlusuario(Chusuario hddlusuario) {
        this.hddlusuario = hddlusuario;
    }

    /**
     * @return
     */
    public Chusuario getHddlusuario() {
        return hddlusuario;
    }

    /**
     * @param hddccirujano
     */
    public void setHddccirujano(BigDecimal hddccirujano) {
        this.hddccirujano = hddccirujano;
    }

    /**
     * @return
     */
    public BigDecimal getHddccirujano() {
        return hddccirujano;
    }

    /**
     * @param hddcdiagnprinc
     */
    public void setHddcdiagnprinc(String hddcdiagnprinc) {
        this.hddcdiagnprinc = hddcdiagnprinc;
    }

    /**
     * @return
     */
    public String getHddcdiagnprinc() {
        return hddcdiagnprinc;
    }

    /**
     * @param hddcdiagnrelac
     */
    public void setHddcdiagnrelac(String hddcdiagnrelac) {
        this.hddcdiagnrelac = hddcdiagnrelac;
    }

    /**
     * @return
     */
    public String getHddcdiagnrelac() {
        return hddcdiagnrelac;
    }

    /**
     * @param hddcpiezapatol
     */
    public void setHddcpiezapatol(String hddcpiezapatol) {
        this.hddcpiezapatol = hddcpiezapatol;
    }

    /**
     * @return
     */
    public String getHddcpiezapatol() {
        return hddcpiezapatol;
    }

    /**
     * @param hddchallazgos
     */
    public void setHddchallazgos(String hddchallazgos) {
        this.hddchallazgos = hddchallazgos;
    }

    /**
     * @return
     */
    public String getHddchallazgos() {
        return hddchallazgos;
    }

    /**
     * @param hddcdescripcio
     */
    public void setHddcdescripcio(String hddcdescripcio) {
        this.hddcdescripcio = hddcdescripcio;
    }

    /**
     * @return
     */
    public String getHddcdescripcio() {
        return hddcdescripcio;
    }

    /**
     * @param hddctienecompl
     */
    public void setHddctienecompl(String hddctienecompl) {
        this.hddctienecompl = hddctienecompl;
    }

    /**
     * @return
     */
    public String getHddctienecompl() {
        return hddctienecompl;
    }

    /**
     * @param hddcdiagncompl
     */
    public void setHddcdiagncompl(String hddcdiagncompl) {
        this.hddcdiagncompl = hddcdiagncompl;
    }

    /**
     * @return
     */
    public String getHddcdiagncompl() {
        return hddcdiagncompl;
    }

    /**
     * @param hddctienesangr
     */
    public void setHddctienesangr(String hddctienesangr) {
        this.hddctienesangr = hddctienesangr;
    }

    /**
     * @return
     */
    public String getHddctienesangr() {
        return hddctienesangr;
    }

    /**
     * @param hddnsangraprox
     */
    public void setHddnsangraprox(Integer hddnsangraprox) {
        this.hddnsangraprox = hddnsangraprox;
    }

    /**
     * @return
     */
    public Integer getHddnsangraprox() {
        return hddnsangraprox;
    }

    /**
     * @param hddcanotardiur
     */
    public void setHddcanotardiur(String hddcanotardiur) {
        this.hddcanotardiur = hddcanotardiur;
    }

    /**
     * @return
     */
    public String getHddcanotardiur() {
        return hddcanotardiur;
    }

    /**
     * @param hddncantidadiu
     */
    public void setHddncantidadiu(Integer hddncantidadiu) {
        this.hddncantidadiu = hddncantidadiu;
    }

    /**
     * @return
     */
    public Integer getHddncantidadiu() {
        return hddncantidadiu;
    }

    /**
     * @param hddcaspectodiu
     */
    public void setHddcaspectodiu(String hddcaspectodiu) {
        this.hddcaspectodiu = hddcaspectodiu;
    }

    /**
     * @return
     */
    public String getHddcaspectodiu() {
        return hddcaspectodiu;
    }

    /**
     * @param hdddfecregistr
     */
    public void setHdddfecregistr(Date hdddfecregistr) {
        this.hdddfecregistr = hdddfecregistr;
    }

    /**
     * @return
     */
    public Date getHdddfecregistr() {
        return hdddfecregistr;
    }

    /**
     * @param hddcoperador
     */
    public void setHddcoperador(String hddcoperador) {
        this.hddcoperador = hddcoperador;
    }

    /**
     * @return
     */
    public String getHddcoperador() {
        return hddcoperador;
    }

    /**
     * @param hddcdescrcompl
     */
    public void setHddcdescrcompl(String hddcdescrcompl) {
        this.hddcdescrcompl = hddcdescrcompl;
    }

    /**
     * @return
     */
    public String getHddcdescrcompl() {
        return hddcdescrcompl;
    }

    /**
     * @param hddcgradohemar
     */
    public void setHddcgradohemar(String hddcgradohemar) {
        this.hddcgradohemar = hddcgradohemar;
    }

    /**
     * @return
     */
    public String getHddcgradohemar() {
        return hddcgradohemar;
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
     * @param hddnfinalidad
     */
    public void setHddnfinalidad(Integer hddnfinalidad) {
        this.hddnfinalidad = hddnfinalidad;
    }

    /**
     * @return
     */
    public Integer getHddnfinalidad() {
        return hddnfinalidad;
    }

    
    /**
     * @param hddcanestesiol
     */
    public void setHddcanestesiol(String hddcanestesiol) {
        this.hddcanestesiol = hddcanestesiol;
    }

    /**
     * @return
     */
    public String getHddcanestesiol() {
        return hddcanestesiol;
    }

    /**
     * @param hddctipoaneste
     */
    public void setHddctipoaneste(String hddctipoaneste) {
        this.hddctipoaneste = hddctipoaneste;
    }

    /**
     * @return
     */
    public String getHddctipoaneste() {
        return hddctipoaneste;
    }


    /**
     * @param hddntiempohora
     */
    public void setHddntiempohora(Integer hddntiempohora) {
        this.hddntiempohora = hddntiempohora;
    }

    /**
     * @return
     */
    public Integer getHddntiempohora() {
        return hddntiempohora;
    }

    /**
     * @param hddntiempominu
     */
    public void setHddntiempominu(Integer hddntiempominu) {
        this.hddntiempominu = hddntiempominu;
    }

    /**
     * @return
     */
    public Integer getHddntiempominu() {
        return hddntiempominu;
    }


    /**
     * @param hddcestado
     */
    public void setHddcestado(String hddcestado) {
        this.hddcestado = hddcestado;
    }

    /**
     * @return
     */
    public String getHddcestado() {
        return hddcestado;
    }

    /**
     * @param hddctienepiepa
     */
    public void setHddctienepiepa(String hddctienepiepa) {
        this.hddctienepiepa = hddctienepiepa;
    }

    /**
     * @return
     */
    public String getHddctienepiepa() {
        return hddctienepiepa;
    }

    /**
     * @param hddninstrument
     */
    public void setHddninstrument(BigDecimal hddninstrument) {
        this.hddninstrument = hddninstrument;
    }

    /**
     * @return
     */
    public BigDecimal getHddninstrument() {
        return hddninstrument;
    }



    /**
     * @param hddnayudante2
     */
    public void setHddnayudante2(BigDecimal hddnayudante2) {
        this.hddnayudante2 = hddnayudante2;
    }

    /**
     * @return
     */
    public BigDecimal getHddnayudante2() {
        return hddnayudante2;
    }

    /**
     * @param hddncirculante
     */
    public void setHddncirculante(BigDecimal hddncirculante) {
        this.hddncirculante = hddncirculante;
    }

    /**
     * @return
     */
    public BigDecimal getHddncirculante() {
        return hddncirculante;
    }

    public void setHddcnomresiden(String hddcnomresiden) {
        this.hddcnomresiden = hddcnomresiden;
    }

    public String getHddcnomresiden() {
        return hddcnomresiden;
    }

    public void setHddnayudante1(BigDecimal hddnayudante1) {
        this.hddnayudante1 = hddnayudante1;
    }

    public BigDecimal getHddnayudante1() {
        return hddnayudante1;
    }

    public void setHddcayudante1(String hddcayudante1) {
        this.hddcayudante1 = hddcayudante1;
    }

    public String getHddcayudante1() {
        return hddcayudante1;
    }

    public void setHddcayudante2(String hddcayudante2) {
        this.hddcayudante2 = hddcayudante2;
    }

    public String getHddcayudante2() {
        return hddcayudante2;
    }

    public void setHddcmediayud1(BigDecimal hddcmediayud1) {
        this.hddcmediayud1 = hddcmediayud1;
    }

    public BigDecimal getHddcmediayud1() {
        return hddcmediayud1;
    }

    public void setHddcmediayud2(BigDecimal hddcmediayud2) {
        this.hddcmediayud2 = hddcmediayud2;
    }

    public BigDecimal getHddcmediayud2() {
        return hddcmediayud2;
    }

    public void setHddcnomresiden1(String hddcnomresiden1) {
        this.hddcnomresiden1 = hddcnomresiden1;
    }

    public String getHddcnomresiden1() {
        return hddcnomresiden1;
    }

    public void setHddcnomresiden2(String hddcnomresiden2) {
        this.hddcnomresiden2 = hddcnomresiden2;
    }

    public String getHddcnomresiden2() {
        return hddcnomresiden2;
    }

    public void setHddccuantifi(String hddccuantifi) {
        this.hddccuantifi = hddccuantifi;
    }

    public String getHddccuantifi() {
        return hddccuantifi;
    }

    public void setHddccuantidiure(String hddccuantidiure) {
        this.hddccuantidiure = hddccuantidiure;
    }

    public String getHddccuantidiure() {
        return hddccuantidiure;
    }
}

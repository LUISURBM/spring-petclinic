package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chcontrolpre implements Serializable {

    /** identifier field */
    private ChcontrolprePK id;

    /** nullable persistent field */
    private Integer hcpnaltuterina;

    /** nullable persistent field */
    private Integer hcpnfcf;

    /** nullable persistent field */
    private String hcpcmovimfetal;

    /** nullable persistent field */
    private String hcpcpresefetal;

    /** nullable persistent field */
    private String hcpevalcueuter;

    /** nullable persistent field */
    private String hcpeedemas;

    /** nullable persistent field */
    private Date hcpdfecharegis;

    /** nullable persistent field */
    private String hcpcoperador;

    /** nullable persistent field */
    private String hcpeexaclinico;

    /** nullable persistent field */
    private String hcpeexamemamas;

    /** nullable persistent field */
    private String hcpeexaodontol;

    /** nullable persistent field */
    private String hcpeexamepelvi;

    /** nullable persistent field */
    private String hcpeexacitolog;

    /** nullable persistent field */
    private String hcpeexamcervix;

    /** nullable persistent field */
    private Long hcplconsulprin;

    /** nullable persistent field */
    private String hcpcpresart1;

    /** nullable persistent field */
    private String hcpcpresart2;

    /** nullable persistent field */
    private Integer hcpnfreccard;

    /** nullable persistent field */
    private Integer hcpnfrecresp;

    /** nullable persistent field */
    private BigDecimal hcpapeso;

    /** nullable persistent field */
    private BigDecimal hcpatalla;

    /** nullable persistent field */
    private BigDecimal hcpaimc;

    /** nullable persistent field */
    private BigDecimal hcpatemperatu;

    /** nullable persistent field */
    private String hcpthallaorl;

    /** nullable persistent field */
    private String hcpthallcarpul;

    /** nullable persistent field */
    private String hcpthallaextre;

    /** nullable persistent field */
    private String hcpthallsisner;

    /** nullable persistent field */
    private String hcpetipotemper;

    /** nullable persistent field */
    private Integer version;
    
    /** nullable persistent field */
    private String hcpctienhalorl; 
    
    
    /** nullable persistent field */
    private String hcpctienhalext;
    
    /** nullable persistent field */
    private String hcpctienhalcar;
    
    
    /** nullable persistent field */
    private String hcpctienhalsis;
    
    /** nullable persistent field */
    private String hcpcestanutri; 
    
    /** nullable persistent field */
    private String hcpcgenituri; 
    
    /** nullable persistent field */
    private String hcpcdescgeni; 
    
    /** nullable persistent field */
    private String hcpcgastroin; 
    
    /** nullable persistent field */
    private String hcpcdescgast; 
    
    
    /** default constructor */
    public Chcontrolpre() {
    }


    /**
     * @param id
     */
    public void setId(ChcontrolprePK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChcontrolprePK getId() {
        return id;
    }

    /**
     * @param hcpnaltuterina
     */
    public void setHcpnaltuterina(Integer hcpnaltuterina) {
        this.hcpnaltuterina = hcpnaltuterina;
    }

    /**
     * @return
     */
    public Integer getHcpnaltuterina() {
        return hcpnaltuterina;
    }

    /**
     * @param hcpnfcf
     */
    public void setHcpnfcf(Integer hcpnfcf) {
        this.hcpnfcf = hcpnfcf;
    }

    /**
     * @return
     */
    public Integer getHcpnfcf() {
        return hcpnfcf;
    }

    /**
     * @param hcpcmovimfetal
     */
    public void setHcpcmovimfetal(String hcpcmovimfetal) {
        this.hcpcmovimfetal = hcpcmovimfetal;
    }

    /**
     * @return
     */
    public String getHcpcmovimfetal() {
        return hcpcmovimfetal;
    }

    /**
     * @param hcpcpresefetal
     */
    public void setHcpcpresefetal(String hcpcpresefetal) {
        this.hcpcpresefetal = hcpcpresefetal;
    }

    /**
     * @return
     */
    public String getHcpcpresefetal() {
        return hcpcpresefetal;
    }

    /**
     * @param hcpevalcueuter
     */
    public void setHcpevalcueuter(String hcpevalcueuter) {
        this.hcpevalcueuter = hcpevalcueuter;
    }

    /**
     * @return
     */
    public String getHcpevalcueuter() {
        return hcpevalcueuter;
    }

    /**
     * @param hcpeedemas
     */
    public void setHcpeedemas(String hcpeedemas) {
        this.hcpeedemas = hcpeedemas;
    }

    /**
     * @return
     */
    public String getHcpeedemas() {
        return hcpeedemas;
    }

    /**
     * @param hcpdfecharegis
     */
    public void setHcpdfecharegis(Date hcpdfecharegis) {
        this.hcpdfecharegis = hcpdfecharegis;
    }

    /**
     * @return
     */
    public Date getHcpdfecharegis() {
        return hcpdfecharegis;
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
    public String getHcpcoperador() {
        return hcpcoperador;
    }

    /**
     * @param hcpeexaclinico
     */
    public void setHcpeexaclinico(String hcpeexaclinico) {
        this.hcpeexaclinico = hcpeexaclinico;
    }

    /**
     * @return
     */
    public String getHcpeexaclinico() {
        return hcpeexaclinico;
    }

    /**
     * @param hcpeexamemamas
     */
    public void setHcpeexamemamas(String hcpeexamemamas) {
        this.hcpeexamemamas = hcpeexamemamas;
    }

    /**
     * @return
     */
    public String getHcpeexamemamas() {
        return hcpeexamemamas;
    }

    /**
     * @param hcpeexaodontol
     */
    public void setHcpeexaodontol(String hcpeexaodontol) {
        this.hcpeexaodontol = hcpeexaodontol;
    }

    /**
     * @return
     */
    public String getHcpeexaodontol() {
        return hcpeexaodontol;
    }

    /**
     * @param hcpeexamepelvi
     */
    public void setHcpeexamepelvi(String hcpeexamepelvi) {
        this.hcpeexamepelvi = hcpeexamepelvi;
    }

    /**
     * @return
     */
    public String getHcpeexamepelvi() {
        return hcpeexamepelvi;
    }

    /**
     * @param hcpeexacitolog
     */
    public void setHcpeexacitolog(String hcpeexacitolog) {
        this.hcpeexacitolog = hcpeexacitolog;
    }

    /**
     * @return
     */
    public String getHcpeexacitolog() {
        return hcpeexacitolog;
    }

    /**
     * @param hcpeexamcervix
     */
    public void setHcpeexamcervix(String hcpeexamcervix) {
        this.hcpeexamcervix = hcpeexamcervix;
    }

    /**
     * @return
     */
    public String getHcpeexamcervix() {
        return hcpeexamcervix;
    }

    /**
     * @param hcplconsulprin
     */
    public void setHcplconsulprin(Long hcplconsulprin) {
        this.hcplconsulprin = hcplconsulprin;
    }

    /**
     * @return
     */
    public Long getHcplconsulprin() {
        return hcplconsulprin;
    }

    /**
     * @param hcpcpresart1
     */
    public void setHcpcpresart1(String hcpcpresart1) {
        this.hcpcpresart1 = hcpcpresart1;
    }

    /**
     * @return
     */
    public String getHcpcpresart1() {
        return hcpcpresart1;
    }

    /**
     * @param hcpcpresart2
     */
    public void setHcpcpresart2(String hcpcpresart2) {
        this.hcpcpresart2 = hcpcpresart2;
    }

    /**
     * @return
     */
    public String getHcpcpresart2() {
        return hcpcpresart2;
    }

    /**
     * @param hcpnfreccard
     */
    public void setHcpnfreccard(Integer hcpnfreccard) {
        this.hcpnfreccard = hcpnfreccard;
    }

    /**
     * @return
     */
    public Integer getHcpnfreccard() {
        return hcpnfreccard;
    }

    /**
     * @param hcpnfrecresp
     */
    public void setHcpnfrecresp(Integer hcpnfrecresp) {
        this.hcpnfrecresp = hcpnfrecresp;
    }

    /**
     * @return
     */
    public Integer getHcpnfrecresp() {
        return hcpnfrecresp;
    }

    /**
     * @param hcpapeso
     */
    public void setHcpapeso(BigDecimal hcpapeso) {
        this.hcpapeso = hcpapeso;
    }

    /**
     * @return
     */
    public BigDecimal getHcpapeso() {
        return hcpapeso;
    }

    /**
     * @param hcpatalla
     */
    public void setHcpatalla(BigDecimal hcpatalla) {
        this.hcpatalla = hcpatalla;
    }

    /**
     * @return
     */
    public BigDecimal getHcpatalla() {
        return hcpatalla;
    }

    /**
     * @param hcpaimc
     */
    public void setHcpaimc(BigDecimal hcpaimc) {
        this.hcpaimc = hcpaimc;
    }

    /**
     * @return
     */
    public BigDecimal getHcpaimc() {
        return hcpaimc;
    }

    /**
     * @param hcpatemperatu
     */
    public void setHcpatemperatu(BigDecimal hcpatemperatu) {
        this.hcpatemperatu = hcpatemperatu;
    }

    /**
     * @return
     */
    public BigDecimal getHcpatemperatu() {
        return hcpatemperatu;
    }

    /**
     * @param hcpetipotemper
     */
    public void setHcpetipotemper(String hcpetipotemper) {
        this.hcpetipotemper = hcpetipotemper;
    }

    /**
     * @return
     */
    public String getHcpetipotemper() {
        return hcpetipotemper;
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
     * @param hcpthallaorl
     */
    public void setHcpthallaorl(String hcpthallaorl) {
        this.hcpthallaorl = hcpthallaorl;
    }

    /**
     * @return
     */
    public String getHcpthallaorl() {
        return hcpthallaorl;
    }

    /**
     * @param hcpthallcarpul
     */
    public void setHcpthallcarpul(String hcpthallcarpul) {
        this.hcpthallcarpul = hcpthallcarpul;
    }

    /**
     * @return
     */
    public String getHcpthallcarpul() {
        return hcpthallcarpul;
    }

    /**
     * @param hcpthallaextre
     */
    public void setHcpthallaextre(String hcpthallaextre) {
        this.hcpthallaextre = hcpthallaextre;
    }

    /**
     * @return
     */
    public String getHcpthallaextre() {
        return hcpthallaextre;
    }

    /**
     * @param hcpthallsisner
     */
    public void setHcpthallsisner(String hcpthallsisner) {
        this.hcpthallsisner = hcpthallsisner;
    }

    /**
     * @return
     */
    public String getHcpthallsisner() {
        return hcpthallsisner;
    }

    /**
     * @param hcpctienhalorl
     */
    public void setHcpctienhalorl(String hcpctienhalorl) {
        this.hcpctienhalorl = hcpctienhalorl;
    }

    /**
     * @return
     */
    public String getHcpctienhalorl() {
        return hcpctienhalorl;
    }

    /**
     * @param hcpctienhalext
     */
    public void setHcpctienhalext(String hcpctienhalext) {
        this.hcpctienhalext = hcpctienhalext;
    }

    /**
     * @return
     */
    public String getHcpctienhalext() {
        return hcpctienhalext;
    }

    /**
     * @param hcpctienhalcar
     */
    public void setHcpctienhalcar(String hcpctienhalcar) {
        this.hcpctienhalcar = hcpctienhalcar;
    }

    /**
     * @return
     */
    public String getHcpctienhalcar() {
        return hcpctienhalcar;
    }

    /**
     * @param hcpctienhalsis
     */
    public void setHcpctienhalsis(String hcpctienhalsis) {
        this.hcpctienhalsis = hcpctienhalsis;
    }

    /**
     * @return
     */
    public String getHcpctienhalsis() {
        return hcpctienhalsis;
    }

    public void setHcpcestanutri(String hcpcestanutri) {
        this.hcpcestanutri = hcpcestanutri;
    }

    public String getHcpcestanutri() {
        return hcpcestanutri;
    }

    public void setHcpcgenituri(String hcpcgenituri) {
        this.hcpcgenituri = hcpcgenituri;
    }

    public String getHcpcgenituri() {
        return hcpcgenituri;
    }

    public void setHcpcdescgeni(String hcpcdescgeni) {
        this.hcpcdescgeni = hcpcdescgeni;
    }

    public String getHcpcdescgeni() {
        return hcpcdescgeni;
    }

    public void setHcpcgastroin(String hcpcgastroin) {
        this.hcpcgastroin = hcpcgastroin;
    }

    public String getHcpcgastroin() {
        return hcpcgastroin;
    }

    public void setHcpcdescgast(String hcpcdescgast) {
        this.hcpcdescgast = hcpcdescgast;
    }

    public String getHcpcdescgast() {
        return hcpcdescgast;
    }
}

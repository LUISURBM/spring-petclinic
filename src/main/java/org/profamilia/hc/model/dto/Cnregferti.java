package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Cnregferti implements Serializable {

    /** identifier field */
    private CnregfertiPK id;

    /** nullable persistent field */
    private Integer version;

    private String crfctihomb;
    
    private BigDecimal crfanihomb;
    
    private String crfcnomhom;
 
    private Date crfdfecfer;

    private String crfxmotivo;
    
    private Integer crfnmenarq;
    
    private String crfnciclos;

    private Date crfdfecfum;

    private Date crfdfecfpm;
    
    private Date crfdfecapm;

    private Integer crfngestac;

    private Integer crfnpartos;

    private Integer crfnaborto;

    private Integer crfncesare;

    private Integer crfnvivos;

    private Integer crfnectopi;

    private Integer crfnmortin;

    private Integer crfnmuerto;

    private Integer crfndiacic;

    private Date crfdfulpar;

    private String crfcultccv;

    private String crfcaborto;

    private String crfcplanif;

    private String crfcdismen;

    private String crfcdispar;

    private String crfcrelsem;

    private Date crfdfecreg;

    private String crfcusuari;

    private String crfcocumuj;

    private String crfcocuhom;

    private Date crfdnachom;

    private Integer crfnanoinf;

    private Long crflusuario;

    private String crfcestdon;

    private String crfccoddon;
    
    private String crfcunimed;

    /** default constructor */
    public Cnregferti() {
    }


    public void setId(CnregfertiPK id) {
        this.id = id;
    }

    public CnregfertiPK getId() {
        return id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }


    public void setCrfctihomb(String crfctihomb) {
        this.crfctihomb = crfctihomb;
    }

    public String getCrfctihomb() {
        return crfctihomb;
    }

    public void setCrfanihomb(BigDecimal crfanihomb) {
        this.crfanihomb = crfanihomb;
    }

    public BigDecimal getCrfanihomb() {
        return crfanihomb;
    }

    public void setCrfcnomhom(String crfcnomhom) {
        this.crfcnomhom = crfcnomhom;
    }

    public String getCrfcnomhom() {
        return crfcnomhom;
    }

    public void setCrfdfecfer(Date crfdfecfer) {
        this.crfdfecfer = crfdfecfer;
    }

    public Date getCrfdfecfer() {
        return crfdfecfer;
    }

    public void setCrfxmotivo(String crfxmotivo) {
        this.crfxmotivo = crfxmotivo;
    }

    public String getCrfxmotivo() {
        return crfxmotivo;
    }

    public void setCrfnmenarq(Integer crfnmenarq) {
        this.crfnmenarq = crfnmenarq;
    }

    public Integer getCrfnmenarq() {
        return crfnmenarq;
    }

    public void setCrfnciclos(String crfnciclos) {
        this.crfnciclos = crfnciclos;
    }

    public String getCrfnciclos() {
        return crfnciclos;
    }

    public void setCrfdfecfum(Date crfdfecfum) {
        this.crfdfecfum = crfdfecfum;
    }

    public Date getCrfdfecfum() {
        return crfdfecfum;
    }

    public void setCrfdfecfpm(Date crfdfecfpm) {
        this.crfdfecfpm = crfdfecfpm;
    }

    public Date getCrfdfecfpm() {
        return crfdfecfpm;
    }

    public void setCrfdfecapm(Date crfdfecapm) {
        this.crfdfecapm = crfdfecapm;
    }

    public Date getCrfdfecapm() {
        return crfdfecapm;
    }

    public void setCrfngestac(Integer crfngestac) {
        this.crfngestac = crfngestac;
    }

    public Integer getCrfngestac() {
        return crfngestac;
    }

    public void setCrfnpartos(Integer crfnpartos) {
        this.crfnpartos = crfnpartos;
    }

    public Integer getCrfnpartos() {
        return crfnpartos;
    }

    public void setCrfnaborto(Integer crfnaborto) {
        this.crfnaborto = crfnaborto;
    }

    public Integer getCrfnaborto() {
        return crfnaborto;
    }

    public void setCrfncesare(Integer crfncesare) {
        this.crfncesare = crfncesare;
    }

    public Integer getCrfncesare() {
        return crfncesare;
    }

    public void setCrfnvivos(Integer crfnvivos) {
        this.crfnvivos = crfnvivos;
    }

    public Integer getCrfnvivos() {
        return crfnvivos;
    }

    public void setCrfnectopi(Integer crfnectopi) {
        this.crfnectopi = crfnectopi;
    }

    public Integer getCrfnectopi() {
        return crfnectopi;
    }

    public void setCrfnmortin(Integer crfnmortin) {
        this.crfnmortin = crfnmortin;
    }

    public Integer getCrfnmortin() {
        return crfnmortin;
    }

    public void setCrfnmuerto(Integer crfnmuerto) {
        this.crfnmuerto = crfnmuerto;
    }

    public Integer getCrfnmuerto() {
        return crfnmuerto;
    }

    public void setCrfndiacic(Integer crfndiacic) {
        this.crfndiacic = crfndiacic;
    }

    public Integer getCrfndiacic() {
        return crfndiacic;
    }

    public void setCrfdfulpar(Date crfdfulpar) {
        this.crfdfulpar = crfdfulpar;
    }

    public Date getCrfdfulpar() {
        return crfdfulpar;
    }

    public void setCrfcultccv(String crfcultccv) {
        this.crfcultccv = crfcultccv;
    }

    public String getCrfcultccv() {
        return crfcultccv;
    }

    public void setCrfcaborto(String crfcaborto) {
        this.crfcaborto = crfcaborto;
    }

    public String getCrfcaborto() {
        return crfcaborto;
    }

    public void setCrfcplanif(String crfcplanif) {
        this.crfcplanif = crfcplanif;
    }

    public String getCrfcplanif() {
        return crfcplanif;
    }

    public void setCrfcdismen(String crfcdismen) {
        this.crfcdismen = crfcdismen;
    }

    public String getCrfcdismen() {
        return crfcdismen;
    }

    public void setCrfcdispar(String crfcdispar) {
        this.crfcdispar = crfcdispar;
    }

    public String getCrfcdispar() {
        return crfcdispar;
    }

    public void setCrfcrelsem(String crfcrelsem) {
        this.crfcrelsem = crfcrelsem;
    }

    public String getCrfcrelsem() {
        return crfcrelsem;
    }

    public void setCrfdfecreg(Date crfdfecreg) {
        this.crfdfecreg = crfdfecreg;
    }

    public Date getCrfdfecreg() {
        return crfdfecreg;
    }

    public void setCrfcusuari(String crfcusuari) {
        this.crfcusuari = crfcusuari;
    }

    public String getCrfcusuari() {
        return crfcusuari;
    }

    public void setCrfcocumuj(String crfcocumuj) {
        this.crfcocumuj = crfcocumuj;
    }

    public String getCrfcocumuj() {
        return crfcocumuj;
    }

    public void setCrfcocuhom(String crfcocuhom) {
        this.crfcocuhom = crfcocuhom;
    }

    public String getCrfcocuhom() {
        return crfcocuhom;
    }

    public void setCrfdnachom(Date crfdnachom) {
        this.crfdnachom = crfdnachom;
    }

    public Date getCrfdnachom() {
        return crfdnachom;
    }

    public void setCrfnanoinf(Integer crfnanoinf) {
        this.crfnanoinf = crfnanoinf;
    }

    public Integer getCrfnanoinf() {
        return crfnanoinf;
    }

    public void setCrflusuario(Long crflusuario) {
        this.crflusuario = crflusuario;
    }

    public Long getCrflusuario() {
        return crflusuario;
    }

    public void setCrfcestdon(String crfcestdon) {
        this.crfcestdon = crfcestdon;
    }

    public String getCrfcestdon() {
        return crfcestdon;
    }

    public void setCrfccoddon(String crfccoddon) {
        this.crfccoddon = crfccoddon;
    }

    public String getCrfccoddon() {
        return crfccoddon;
    }


    public void setCrfcunimed(String crfcunimed) {
        this.crfcunimed = crfcunimed;
    }

    public String getCrfcunimed() {
        return crfcunimed;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;



/** @author Hibernate CodeGenerator */
public class Chseguavis implements Serializable {

    /** identifier field */
    private org.profamilia.hc.model.dto.ChseguavisPK id;

    /** persistent field */
    private String hsactipide;

    /** persistent field */
    private Long hsaanumide;

    /** persistent field */
    private Integer hsanclinic;

    /** persistent field */
    private Date hsadfecreg;

    /** persistent field */
    private String hsacusureg;

    /** nullable persistent field */
    private Integer hsanedages;

    /** nullable persistent field */
    private String hsacremmot;

    /** nullable persistent field */
    private String hsacnmbotr;

    /** persistent field */
    private String hsacremotr;

    /** persistent field */
    private String hsacremind;

    /** persistent field */
    private String hsacremcos;

    /** persistent field */
    private String hsacremeps;

    /** persistent field */
    private String hsacremips;

    /** persistent field */
    private String hsacremcau;

    /** persistent field */
    private String hsacremmay;

    /** persistent field */
    private String hsacremcon;

    /** persistent field */
    private String hsacremilv;

    /** persistent field */
    private String hsacremapl;

    /** persistent field */
    private String hsacestado;

    /** nullable persistent field */
    private String hsacasesor;

    /** persistent field */
    private String hsacseguim;
    
    /** persistent field */
    //semanas estimadas
    private Integer hsansemest;
    
    /** persistent field */
    // fecha ecografia
    private Date hsadfececo;
    
    /** persistent field */
    //semanas ecografias
    private Integer hsansemeco;
    
    /** persistent field */
    //conducta
    private String hsacconduc;
    
    /** persistent field */
    // Institucion remision
    private String hsacinsrem;
    
    /** persistent field */
    // contacto
    private String hsaccontac;
    
    /** persistent field */
    // telefono contacto
    private BigDecimal hsantelcon;
    
    /** persistent field */
    // reliza procedimiento
    private String hsacreapro;
    
    /** persistent field */
    // lugar procedimiento
    private String hsaclugpro;
    
    /** persistent field */
    // Metodo anticonceptivo
    private String hsacmetant;
    
    /** persistent field */
    //confirma uso
    private String hsacconuso;
    
    /** persistent field */
    // observaciones
    private String hsacobserv;
    
    /** persistent field */
    //confirma uso anticoncepcion
    private String hsaccousan;
    
    /** persistent field */
    //confirma metodo en profamilia
    private String hsaciveins;
    
    /** persistent field */
    // otra institucion
    private String hsacotrins;
    
    
    /** nullable persistent field */
    private Integer version;

 
    /** default constructor */
    public Chseguavis() {
        id = new ChseguavisPK(); 
    }


    /**
     * @param id
     */
    public void setId(ChseguavisPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChseguavisPK getId() {
        return id;
    }

    /**
     * @param hsactipide
     */
    public void setHsactipide(String hsactipide) {
        this.hsactipide = hsactipide;
    }

    /**
     * @return
     */
    public String getHsactipide() {
        return hsactipide;
    }

    /**
     * @param hsaanumide
     */
    public void setHsaanumide(Long hsaanumide) {
        this.hsaanumide = hsaanumide;
    }

    /**
     * @return
     */
    public Long getHsaanumide() {
        return hsaanumide;
    }

    /**
     * @param hsanclinic
     */
    public void setHsanclinic(Integer hsanclinic) {
        this.hsanclinic = hsanclinic;
    }

    /**
     * @return
     */
    public Integer getHsanclinic() {
        return hsanclinic;
    }

    /**
     * @param hsadfecreg
     */
    public void setHsadfecreg(Date hsadfecreg) {
        this.hsadfecreg = hsadfecreg;
    }

    /**
     * @return
     */
    public Date getHsadfecreg() {
        return hsadfecreg;
    }

    /**
     * @param hsacusureg
     */
    public void setHsacusureg(String hsacusureg) {
        this.hsacusureg = hsacusureg;
    }

    /**
     * @return
     */
    public String getHsacusureg() {
        return hsacusureg;
    }

    /**
     * @param hsanedages
     */
    public void setHsanedages(Integer hsanedages) {
        this.hsanedages = hsanedages;
    }

    /**
     * @return
     */
    public Integer getHsanedages() {
        return hsanedages;
    }

    /**
     * @param hsacremmot
     */
    public void setHsacremmot(String hsacremmot) {
        this.hsacremmot = hsacremmot;
    }

    /**
     * @return
     */
    public String getHsacremmot() {
        return hsacremmot;
    }

    /**
     * @param hsacnmbotr
     */
    public void setHsacnmbotr(String hsacnmbotr) {
        this.hsacnmbotr = hsacnmbotr;
    }

    /**
     * @return
     */
    public String getHsacnmbotr() {
        return hsacnmbotr;
    }

    /**
     * @param hsacremotr
     */
    public void setHsacremotr(String hsacremotr) {
        this.hsacremotr = hsacremotr;
    }

    /**
     * @return
     */
    public String getHsacremotr() {
        return hsacremotr;
    }

    /**
     * @param hsacremind
     */
    public void setHsacremind(String hsacremind) {
        this.hsacremind = hsacremind;
    }

    /**
     * @return
     */
    public String getHsacremind() {
        return hsacremind;
    }

    /**
     * @param hsacremcos
     */
    public void setHsacremcos(String hsacremcos) {
        this.hsacremcos = hsacremcos;
    }

    /**
     * @return
     */
    public String getHsacremcos() {
        return hsacremcos;
    }

    /**
     * @param hsacremeps
     */
    public void setHsacremeps(String hsacremeps) {
        this.hsacremeps = hsacremeps;
    }

    /**
     * @return
     */
    public String getHsacremeps() {
        return hsacremeps;
    }

    /**
     * @param hsacremips
     */
    public void setHsacremips(String hsacremips) {
        this.hsacremips = hsacremips;
    }

    /**
     * @return
     */
    public String getHsacremips() {
        return hsacremips;
    }

    /**
     * @param hsacremcau
     */
    public void setHsacremcau(String hsacremcau) {
        this.hsacremcau = hsacremcau;
    }

    /**
     * @return
     */
    public String getHsacremcau() {
        return hsacremcau;
    }

    /**
     * @param hsacremmay
     */
    public void setHsacremmay(String hsacremmay) {
        this.hsacremmay = hsacremmay;
    }

    /**
     * @return
     */
    public String getHsacremmay() {
        return hsacremmay;
    }

    public void setHsacremcon(String hsacremcon) {
        this.hsacremcon = hsacremcon;
    }

    public String getHsacremcon() {
        return hsacremcon;
    }

    public void setHsacremilv(String hsacremilv) {
        this.hsacremilv = hsacremilv;
    }

    public String getHsacremilv() {
        return hsacremilv;
    }

    public void setHsacremapl(String hsacremapl) {
        this.hsacremapl = hsacremapl;
    }

    public String getHsacremapl() {
        return hsacremapl;
    }

    public void setHsacestado(String hsacestado) {
        this.hsacestado = hsacestado;
    }

    public String getHsacestado() {
        return hsacestado;
    }

    public void setHsacasesor(String hsacasesor) {
        this.hsacasesor = hsacasesor;
    }

    public String getHsacasesor() {
        return hsacasesor;
    }

    public void setHsacseguim(String hsacseguim) {
        this.hsacseguim = hsacseguim;
    }

    public String getHsacseguim() {
        return hsacseguim;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }

    public void setHsansemest(Integer hsansemest) {
        this.hsansemest = hsansemest;
    }

    public Integer getHsansemest() {
        return hsansemest;
    }

    public void setHsadfececo(Date hsadfececo) {
        this.hsadfececo = hsadfececo;
    }

    public Date getHsadfececo() {
        return hsadfececo;
    }

    public void setHsansemeco(Integer hsansemeco) {
        this.hsansemeco = hsansemeco;
    }

    public Integer getHsansemeco() {
        return hsansemeco;
    }

    public void setHsacconduc(String hsacconduc) {
        this.hsacconduc = hsacconduc;
    }

    public String getHsacconduc() {
        return hsacconduc;
    }

    public void setHsacinsrem(String hsacinsrem) {
        this.hsacinsrem = hsacinsrem;
    }

    public String getHsacinsrem() {
        return hsacinsrem;
    }

    public void setHsaccontac(String hsaccontac) {
        this.hsaccontac = hsaccontac;
    }

    public String getHsaccontac() {
        return hsaccontac;
    }

    public void setHsantelcon(BigDecimal hsantelcon) {
        this.hsantelcon = hsantelcon;
    }

    public BigDecimal getHsantelcon() {
        return hsantelcon;
    }

    public void setHsacreapro(String hsacreapro) {
        this.hsacreapro = hsacreapro;
    }

    public String getHsacreapro() {
        return hsacreapro;
    }

    public void setHsaclugpro(String hsaclugpro) {
        this.hsaclugpro = hsaclugpro;
    }

    public String getHsaclugpro() {
        return hsaclugpro;
    }

    public void setHsacmetant(String hsacmetant) {
        this.hsacmetant = hsacmetant;
    }

    public String getHsacmetant() {
        return hsacmetant;
    }

    public void setHsacconuso(String hsacconuso) {
        this.hsacconuso = hsacconuso;
    }

    public String getHsacconuso() {
        return hsacconuso;
    }

    public void setHsacobserv(String hsacobserv) {
        this.hsacobserv = hsacobserv;
    }

    public String getHsacobserv() {
        return hsacobserv;
    }

    public void setHsaccousan(String hsaccousan) {
        this.hsaccousan = hsaccousan;
    }

    public String getHsaccousan() {
        return hsaccousan;
    }

    public void setHsaciveins(String hsaciveins) {
        this.hsaciveins = hsaciveins;
    }

    public String getHsaciveins() {
        return hsaciveins;
    }

    public void setHsacotrins(String hsacotrins) {
        this.hsacotrins = hsacotrins;
    }

    public String getHsacotrins() {
        return hsacotrins;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Cpservanex implements Serializable {

    /** identifier field */
    private CpservanexPK id;

    /** persistent field */
    private Integer csandiaate;

    /** persistent field */
    private Integer csandiafle;

    /** persistent field */
    private String csacautoma;

    /** persistent field */
    private String csacestado;

    /** persistent field */
    private Date csadfecreg;

    /** persistent field */
    private String csacusureg;

    /** nullable persistent field */
    private Date csadfecmod;

    /** nullable persistent field */
    private String csacusumod;

    /** nullable persistent field */
    private Integer version;

    /** persistent field */
    private Integer csancntmax;

    /** persistent field */
    private BigDecimal csaavalor;

    
    /** default constructor */
    public Cpservanex() {
        id = new CpservanexPK(); 
    }


    /**
     * @param id
     */
    public void setId(CpservanexPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public CpservanexPK getId() {
        return id;
    }

    /**
     * @param csandiaate
     */
    public void setCsandiaate(Integer csandiaate) {
        this.csandiaate = csandiaate;
    }

    /**
     * @return
     */
    public Integer getCsandiaate() {
        return csandiaate;
    }

    /**
     * @param csandiafle
     */
    public void setCsandiafle(Integer csandiafle) {
        this.csandiafle = csandiafle;
    }

    /**
     * @return
     */
    public Integer getCsandiafle() {
        return csandiafle;
    }

    /**
     * @param csacautoma
     */
    public void setCsacautoma(String csacautoma) {
        this.csacautoma = csacautoma;
    }

    /**
     * @return
     */
    public String getCsacautoma() {
        return csacautoma;
    }

    /**
     * @param csacestado
     */
    public void setCsacestado(String csacestado) {
        this.csacestado = csacestado;
    }

    /**
     * @return
     */
    public String getCsacestado() {
        return csacestado;
    }

    /**
     * @param csadfecreg
     */
    public void setCsadfecreg(Date csadfecreg) {
        this.csadfecreg = csadfecreg;
    }

    /**
     * @return
     */
    public Date getCsadfecreg() {
        return csadfecreg;
    }

    /**
     * @param csacusureg
     */
    public void setCsacusureg(String csacusureg) {
        this.csacusureg = csacusureg;
    }

    /**
     * @return
     */
    public String getCsacusureg() {
        return csacusureg;
    }

    /**
     * @param csadfecmod
     */
    public void setCsadfecmod(Date csadfecmod) {
        this.csadfecmod = csadfecmod;
    }

    /**
     * @return
     */
    public Date getCsadfecmod() {
        return csadfecmod;
    }

    /**
     * @param csacusumod
     */
    public void setCsacusumod(String csacusumod) {
        this.csacusumod = csacusumod;
    }

    /**
     * @return
     */
    public String getCsacusumod() {
        return csacusumod;
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
     * @param csancntmax
     */
    public void setCsancntmax(Integer csancntmax) {
        this.csancntmax = csancntmax;
    }

    /**
     * @return
     */
    public Integer getCsancntmax() {
        return csancntmax;
    }

    /**
     * @param csaavalor
     */
    public void setCsaavalor(BigDecimal csaavalor) {
        this.csaavalor = csaavalor;
    }

    /**
     * @return
     */
    public BigDecimal getCsaavalor() {
        return csaavalor;
    }
}

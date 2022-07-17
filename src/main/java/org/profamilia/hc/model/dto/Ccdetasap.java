package org.profamilia.hc.model.dto;

import java.math.BigDecimal;

/**
 * 
 */
public class

Ccdetasap implements java.io.Serializable {

    private CcdetasapId id;
    private String cdfcservic;
    private String cdfccodent;
    private BigDecimal cdfavalser;
    private BigDecimal cdfaivaser;
    private BigDecimal cdfadescto;
    private Integer cdfncantid;
    private BigDecimal cdfavalent;
    private BigDecimal cdfavaltot;
    private String cdfcpaquet;
    private String cdfcswpaqu;
    private BigDecimal cdfavaldon;
    private String cdfcintext;

    private Integer version;

    /**
     * @return the version
     */
    public final Integer getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public final void setVersion(Integer version) {
        this.version = version;
    }

    // Constructors

    /** default constructor */
    public Ccdetasap() {
    }

    /** constructor with id */
    public
    // HS == CcdetafactId

    Ccdetasap(CcdetasapId id) {
        this.id = id;
    }

    // HS SEPARADOR CONSTRUCTOR

    // Property accessors

    public CcdetasapId getId() {
        return this.id;
    }

    public void setId(CcdetasapId id) {
        this.id = id;
    }

    public String getCdfcservic() {
        return this.cdfcservic;
    }

    public void setCdfcservic(String cdfcservic) {
        this.cdfcservic = cdfcservic;
    }

    public String getCdfccodent() {
        return this.cdfccodent;
    }

    public void setCdfccodent(String cdfccodent) {
        this.cdfccodent = cdfccodent;
    }

    public BigDecimal getCdfavalser() {
        return this.cdfavalser;
    }

    public void setCdfavalser(BigDecimal cdfavalser) {
        this.cdfavalser = cdfavalser;
    }

    public BigDecimal getCdfaivaser() {
        return this.cdfaivaser;
    }

    public void setCdfaivaser(BigDecimal cdfaivaser) {
        this.cdfaivaser = cdfaivaser;
    }

    public BigDecimal getCdfadescto() {
        return this.cdfadescto;
    }

    public void setCdfadescto(BigDecimal cdfadescto) {
        this.cdfadescto = cdfadescto;
    }

    public Integer getCdfncantid() {
        return this.cdfncantid;
    }

    public void setCdfncantid(Integer cdfncantid) {
        this.cdfncantid = cdfncantid;
    }

    public BigDecimal getCdfavalent() {
        return this.cdfavalent;
    }

    public void setCdfavalent(BigDecimal cdfavalent) {
        this.cdfavalent = cdfavalent;
    }

    public BigDecimal getCdfavaltot() {
        return this.cdfavaltot;
    }

    public void setCdfavaltot(BigDecimal cdfavaltot) {
        this.cdfavaltot = cdfavaltot;
    }

    public String getCdfcpaquet() {
        return this.cdfcpaquet;
    }

    public void setCdfcpaquet(String cdfcpaquet) {
        this.cdfcpaquet = cdfcpaquet;
    }

    public String getCdfcswpaqu() {
        return this.cdfcswpaqu;
    }

    public void setCdfcswpaqu(String cdfcswpaqu) {
        this.cdfcswpaqu = cdfcswpaqu;
    }

    public BigDecimal getCdfavaldon() {
        return this.cdfavaldon;
    }

    public void setCdfavaldon(BigDecimal cdfavaldon) {
        this.cdfavaldon = cdfavaldon;
    }

    public BigDecimal getCdfnnumero() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdfnnumero();
    }

    public void setCdfnnumero(BigDecimal cdfnnumero) {
        if (this.id == null) {
            this.id = new CcdetasapId();
        }
        this.id.setCdfnnumero(cdfnnumero);
    }

    public Integer getCdfnconsec() {
        if (this.id == null) {
            return null;
        }
        return this.id.getCdfnconsec();
    }

    public void setCdfnconsec(Integer cdfnconsec) {
        if (this.id == null) {
            this.id = new CcdetasapId();
        }
        this.id.setCdfnconsec(cdfnconsec);
    }

    public final String getCdfcintext() {
        return cdfcintext;
    }

    public final void setCdfcintext(String cdfcintext) {
        this.cdfcintext = cdfcintext;
    }


}

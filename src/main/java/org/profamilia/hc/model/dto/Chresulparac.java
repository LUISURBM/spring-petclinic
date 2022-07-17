package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;


/** @author Hibernate CodeGenerator */
public class Chresulparac implements Serializable {

    /** identifier field */
    private ChresulparacPK id;

    /** nullable persistent field */
    private BigDecimal hrpnhemoglobin;

    /** nullable persistent field */
    private BigDecimal hrpnhematocrit;

    /** nullable persistent field */
    private Integer hrpnleucocitos;

    /** nullable persistent field */
    private BigDecimal hrpnpt;

    /** nullable persistent field */
    private BigDecimal hrpninr;

    /** nullable persistent field */
    private BigDecimal hrpnptt;

    /** nullable persistent field */
    private Integer hrpnplaquetas;

    /** nullable persistent field */
    private String hrpcparciorina;

    /** nullable persistent field */
    private BigDecimal hrpnglicemipre;

    /** nullable persistent field */
    private BigDecimal hrpnglicemipos;

    /** nullable persistent field */
    private BigDecimal hrpnnitroureic;

    /** nullable persistent field */
    private BigDecimal hrpnncreatinin;

    /** nullable persistent field */
    private String hrpcelectrocar;

    /** nullable persistent field */
    private String hrpcrayosxtora;

    /** nullable persistent field */
    private String hrpcecografias;

    /** nullable persistent field */
    private String hrpcotrosresul;

    /** nullable persistent field */
    private String hrpcoperador;

    /** nullable persistent field */
    private Date hrpdfecregistr;

    /** nullable persistent field */
    private Integer version;


    /** default constructor */
    public Chresulparac() {
    }


    /**
     * @param id
     */
    public void setId(ChresulparacPK id) {
        this.id = id;
    }

    /**
     * @return
     */
    public ChresulparacPK getId() {
        return id;
    }

    /**
     * @param hrpnhemoglobin
     */
    public void setHrpnhemoglobin(BigDecimal hrpnhemoglobin) {
        this.hrpnhemoglobin = hrpnhemoglobin;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnhemoglobin() {
        return hrpnhemoglobin;
    }

    /**
     * @param hrpnhematocrit
     */
    public void setHrpnhematocrit(BigDecimal hrpnhematocrit) {
        this.hrpnhematocrit = hrpnhematocrit;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnhematocrit() {
        return hrpnhematocrit;
    }

    /**
     * @param hrpnleucocitos
     */
    public void setHrpnleucocitos(Integer hrpnleucocitos) {
        this.hrpnleucocitos = hrpnleucocitos;
    }

    /**
     * @return
     */
    public Integer getHrpnleucocitos() {
        return hrpnleucocitos;
    }

    /**
     * @param hrpnpt
     */
    public void setHrpnpt(BigDecimal hrpnpt) {
        this.hrpnpt = hrpnpt;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnpt() {
        return hrpnpt;
    }

    /**
     * @param hrpninr
     */
    public void setHrpninr(BigDecimal hrpninr) {
        this.hrpninr = hrpninr;
    }

    /**
     * @return
     */
    public BigDecimal getHrpninr() {
        return hrpninr;
    }

    /**
     * @param hrpnptt
     */
    public void setHrpnptt(BigDecimal hrpnptt) {
        this.hrpnptt = hrpnptt;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnptt() {
        return hrpnptt;
    }

    /**
     * @param hrpnplaquetas
     */
    public void setHrpnplaquetas(Integer hrpnplaquetas) {
        this.hrpnplaquetas = hrpnplaquetas;
    }

    /**
     * @return
     */
    public Integer getHrpnplaquetas() {
        return hrpnplaquetas;
    }

    /**
     * @param hrpcparciorina
     */
    public void setHrpcparciorina(String hrpcparciorina) {
        this.hrpcparciorina = hrpcparciorina;
    }

    /**
     * @return
     */
    public String getHrpcparciorina() {
        return hrpcparciorina;
    }

    /**
     * @param hrpnglicemipre
     */
    public void setHrpnglicemipre(BigDecimal hrpnglicemipre) {
        this.hrpnglicemipre = hrpnglicemipre;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnglicemipre() {
        return hrpnglicemipre;
    }

    /**
     * @param hrpnglicemipos
     */
    public void setHrpnglicemipos(BigDecimal hrpnglicemipos) {
        this.hrpnglicemipos = hrpnglicemipos;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnglicemipos() {
        return hrpnglicemipos;
    }

    /**
     * @param hrpnnitroureic
     */
    public void setHrpnnitroureic(BigDecimal hrpnnitroureic) {
        this.hrpnnitroureic = hrpnnitroureic;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnnitroureic() {
        return hrpnnitroureic;
    }

    /**
     * @param hrpnncreatinin
     */
    public void setHrpnncreatinin(BigDecimal hrpnncreatinin) {
        this.hrpnncreatinin = hrpnncreatinin;
    }

    /**
     * @return
     */
    public BigDecimal getHrpnncreatinin() {
        return hrpnncreatinin;
    }

    /**
     * @param hrpcelectrocar
     */
    public void setHrpcelectrocar(String hrpcelectrocar) {
        this.hrpcelectrocar = hrpcelectrocar;
    }

    /**
     * @return
     */
    public String getHrpcelectrocar() {
        return hrpcelectrocar;
    }

    /**
     * @param hrpcrayosxtora
     */
    public void setHrpcrayosxtora(String hrpcrayosxtora) {
        this.hrpcrayosxtora = hrpcrayosxtora;
    }

    /**
     * @return
     */
    public String getHrpcrayosxtora() {
        return hrpcrayosxtora;
    }

    /**
     * @param hrpcecografias
     */
    public void setHrpcecografias(String hrpcecografias) {
        this.hrpcecografias = hrpcecografias;
    }

    /**
     * @return
     */
    public String getHrpcecografias() {
        return hrpcecografias;
    }

    /**
     * @param hrpcotrosresul
     */
    public void setHrpcotrosresul(String hrpcotrosresul) {
        this.hrpcotrosresul = hrpcotrosresul;
    }

    /**
     * @return
     */
    public String getHrpcotrosresul() {
        return hrpcotrosresul;
    }

    /**
     * @param hrpcoperador
     */
    public void setHrpcoperador(String hrpcoperador) {
        this.hrpcoperador = hrpcoperador;
    }

    /**
     * @return
     */
    public String getHrpcoperador() {
        return hrpcoperador;
    }

    /**
     * @param hrpdfecregistr
     */
    public void setHrpdfecregistr(Date hrpdfecregistr) {
        this.hrpdfecregistr = hrpdfecregistr;
    }

    /**
     * @return
     */
    public Date getHrpdfecregistr() {
        return hrpdfecregistr;
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
}

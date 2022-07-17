package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpempresa implements Serializable {

    /** identifier field */
    private Integer cemncodigo;

    /** persistent field */
    private String cemcnombre;

    /** persistent field */
    private BigDecimal cemanit;

    /** nullable persistent field */
    private String cemcrepleg;

    /** nullable persistent field */
    private String cemcdirecc;

    /** nullable persistent field */
    private String cemctelefo;

    /** persistent field */
    private String cemctesore;

    /** nullable persistent field */
    private String cemclin980;

    /** nullable persistent field */
    private String cemcserial;

    /** nullable persistent field */
    private BigDecimal version;

    /** nullable persistent field */
    private String cemcactual;

    /** nullable persistent field */
    private String cemctokmen;

    /** nullable persistent field */
    private String cemcclimen;

    /** nullable persistent field */
    private String cemcpasmen;

    /** nullable persistent field */
    private String cemcact084;

    /** nullable persistent field */
    private String cemcambiente;

    /** nullable persistent field */
    private String cemcremfac;

    /** nullable persistent field */
    private String cemcwsosap;

    /** nullable persistent field */
    private String cemccostos;

    /** full constructor */
    public Cpempresa(Integer cemncodigo, String cemcnombre, BigDecimal cemanit, String cemcrepleg, String cemcdirecc, String cemctelefo, String cemctesore, String cemclin980, String cemcserial, BigDecimal version, String cemcactual, String cemctokmen, String cemcclimen, String cemcpasmen, String cemcact084, String cemcambiente, String cemcremfac, String cemcwsosap, String cemccostos) {
        this.cemncodigo = cemncodigo;
        this.cemcnombre = cemcnombre;
        this.cemanit = cemanit;
        this.cemcrepleg = cemcrepleg;
        this.cemcdirecc = cemcdirecc;
        this.cemctelefo = cemctelefo;
        this.cemctesore = cemctesore;
        this.cemclin980 = cemclin980;
        this.cemcserial = cemcserial;
        this.version = version;
        this.cemcactual = cemcactual;
        this.cemctokmen = cemctokmen;
        this.cemcclimen = cemcclimen;
        this.cemcpasmen = cemcpasmen;
        this.cemcact084 = cemcact084;
        this.cemcambiente = cemcambiente;
        this.cemcremfac = cemcremfac;
        this.cemcwsosap = cemcwsosap;
        this.cemccostos = cemccostos;
    }

    /** default constructor */
    public Cpempresa() {
    }

    /** minimal constructor */
    public Cpempresa(Integer cemncodigo, String cemcnombre, BigDecimal cemanit, String cemctesore) {
        this.cemncodigo = cemncodigo;
        this.cemcnombre = cemcnombre;
        this.cemanit = cemanit;
        this.cemctesore = cemctesore;
    }

    public Integer getCemncodigo() {
        return this.cemncodigo;
    }

    public void setCemncodigo(Integer cemncodigo) {
        this.cemncodigo = cemncodigo;
    }

    public String getCemcnombre() {
        return this.cemcnombre;
    }

    public void setCemcnombre(String cemcnombre) {
        this.cemcnombre = cemcnombre;
    }

    public BigDecimal getCemanit() {
        return this.cemanit;
    }

    public void setCemanit(BigDecimal cemanit) {
        this.cemanit = cemanit;
    }

    public String getCemcrepleg() {
        return this.cemcrepleg;
    }

    public void setCemcrepleg(String cemcrepleg) {
        this.cemcrepleg = cemcrepleg;
    }

    public String getCemcdirecc() {
        return this.cemcdirecc;
    }

    public void setCemcdirecc(String cemcdirecc) {
        this.cemcdirecc = cemcdirecc;
    }

    public String getCemctelefo() {
        return this.cemctelefo;
    }

    public void setCemctelefo(String cemctelefo) {
        this.cemctelefo = cemctelefo;
    }

    public String getCemctesore() {
        return this.cemctesore;
    }

    public void setCemctesore(String cemctesore) {
        this.cemctesore = cemctesore;
    }

    public String getCemclin980() {
        return this.cemclin980;
    }

    public void setCemclin980(String cemclin980) {
        this.cemclin980 = cemclin980;
    }

    public String getCemcserial() {
        return this.cemcserial;
    }

    public void setCemcserial(String cemcserial) {
        this.cemcserial = cemcserial;
    }

    public BigDecimal getVersion() {
        return this.version;
    }

    public void setVersion(BigDecimal version) {
        this.version = version;
    }

    public String getCemcactual() {
        return this.cemcactual;
    }

    public void setCemcactual(String cemcactual) {
        this.cemcactual = cemcactual;
    }

    public String getCemctokmen() {
        return this.cemctokmen;
    }

    public void setCemctokmen(String cemctokmen) {
        this.cemctokmen = cemctokmen;
    }

    public String getCemcclimen() {
        return this.cemcclimen;
    }

    public void setCemcclimen(String cemcclimen) {
        this.cemcclimen = cemcclimen;
    }

    public String getCemcpasmen() {
        return this.cemcpasmen;
    }

    public void setCemcpasmen(String cemcpasmen) {
        this.cemcpasmen = cemcpasmen;
    }

    public String getCemcact084() {
        return this.cemcact084;
    }

    public void setCemcact084(String cemcact084) {
        this.cemcact084 = cemcact084;
    }

    public String getCemcambiente() {
        return this.cemcambiente;
    }

    public void setCemcambiente(String cemcambiente) {
        this.cemcambiente = cemcambiente;
    }

    public String getCemcremfac() {
        return this.cemcremfac;
    }

    public void setCemcremfac(String cemcremfac) {
        this.cemcremfac = cemcremfac;
    }

    public String getCemcwsosap() {
        return this.cemcwsosap;
    }

    public void setCemcwsosap(String cemcwsosap) {
        this.cemcwsosap = cemcwsosap;
    }

    public String getCemccostos() {
        return this.cemccostos;
    }

    public void setCemccostos(String cemccostos) {
        this.cemccostos = cemccostos;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cemncodigo", getCemncodigo())
            .toString();
    }

}

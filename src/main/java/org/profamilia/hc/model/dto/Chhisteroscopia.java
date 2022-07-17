package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Chhisteroscopia implements Serializable {

    /** identifier field */
    private Long hhtlnumero;

    /** nullable persistent field */
    private String hhtctiposerv;

    /** nullable persistent field */
    private Date hhtdfecreg;

    /** nullable persistent field */
    private String hhtcusureg;

    /** nullable persistent field */
    private Long hhtlnumusu;

    /** nullable persistent field */
    private String hhtcintpro;

    /** nullable persistent field */
    private String hhtcmedidist;

    /** nullable persistent field */
    private Long hhtlcantirri;

    /** nullable persistent field */
    private Long httlcantreco;

    /** nullable persistent field */
    private Long httlbalance;

    /** nullable persistent field */
    private String httlbalposneg;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Chhisteroscopia(Long hhtlnumero, String hhtctiposerv, Date hhtdfecreg, String hhtcusureg, Long hhtlnumusu, String hhtcintpro, String hhtcmedidist, Long hhtlcantirri, Long httlcantreco, Long httlbalance, String httlbalposneg, Integer version) {
        this.hhtlnumero = hhtlnumero;
        this.hhtctiposerv = hhtctiposerv;
        this.hhtdfecreg = hhtdfecreg;
        this.hhtcusureg = hhtcusureg;
        this.hhtlnumusu = hhtlnumusu;
        this.hhtcintpro = hhtcintpro;
        this.hhtcmedidist = hhtcmedidist;
        this.hhtlcantirri = hhtlcantirri;
        this.httlcantreco = httlcantreco;
        this.httlbalance = httlbalance;
        this.httlbalposneg = httlbalposneg;
        this.version = version;
    }

    /** default constructor */
    public Chhisteroscopia() {
    }

    /** minimal constructor */
    public Chhisteroscopia(Long hhtlnumero) {
        this.hhtlnumero = hhtlnumero;
    }

    /** 
     * 		       NUMERO CONSULTA
     * 		    
     */
    public Long getHhtlnumero() {
        return this.hhtlnumero;
    }

    public void setHhtlnumero(Long hhtlnumero) {
        this.hhtlnumero = hhtlnumero;
    }

    public String getHhtctiposerv() {
        return this.hhtctiposerv;
    }

    public void setHhtctiposerv(String hhtctiposerv) {
        this.hhtctiposerv = hhtctiposerv;
    }

    public Date getHhtdfecreg() {
        return this.hhtdfecreg;
    }

    public void setHhtdfecreg(Date hhtdfecreg) {
        this.hhtdfecreg = hhtdfecreg;
    }

    public String getHhtcusureg() {
        return this.hhtcusureg;
    }

    public void setHhtcusureg(String hhtcusureg) {
        this.hhtcusureg = hhtcusureg;
    }

    public Long getHhtlnumusu() {
        return this.hhtlnumusu;
    }

    public void setHhtlnumusu(Long hhtlnumusu) {
        this.hhtlnumusu = hhtlnumusu;
    }

    public String getHhtcintpro() {
        return this.hhtcintpro;
    }

    public void setHhtcintpro(String hhtcintpro) {
        this.hhtcintpro = hhtcintpro;
    }

    public String getHhtcmedidist() {
        return this.hhtcmedidist;
    }

    public void setHhtcmedidist(String hhtcmedidist) {
        this.hhtcmedidist = hhtcmedidist;
    }

    public Long getHhtlcantirri() {
        return this.hhtlcantirri;
    }

    public void setHhtlcantirri(Long hhtlcantirri) {
        this.hhtlcantirri = hhtlcantirri;
    }

    public Long getHttlcantreco() {
        return this.httlcantreco;
    }

    public void setHttlcantreco(Long httlcantreco) {
        this.httlcantreco = httlcantreco;
    }

    public Long getHttlbalance() {
        return this.httlbalance;
    }

    public void setHttlbalance(Long httlbalance) {
        this.httlbalance = httlbalance;
    }

    public String getHttlbalposneg() {
        return this.httlbalposneg;
    }

    public void setHttlbalposneg(String httlbalposneg) {
        this.httlbalposneg = httlbalposneg;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("hhtlnumero", getHhtlnumero())
            .toString();
    }

}

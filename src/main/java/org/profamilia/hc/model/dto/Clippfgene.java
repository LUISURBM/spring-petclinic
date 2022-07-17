package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Clippfgene implements Serializable {

    /** identifier field */
    private String clccodid;

    /** nullable persistent field */
    private String clcgenero;

    /** nullable persistent field */
    private BigDecimal clnedamax;

    /** nullable persistent field */
    private BigDecimal clnedamin;

    /** nullable persistent field */
    private String clcnumuid;

    /** nullable persistent field */
    private String clncodigo;

    /** full constructor */
    public Clippfgene(String clccodid, String clcgenero, BigDecimal clnedamax, 
                      BigDecimal clnedamin, String clcnumuid, 
                      String clncodigo) {
        this.clccodid = clccodid;
        this.clcgenero = clcgenero;
        this.clnedamax = clnedamax;
        this.clnedamin = clnedamin;
        this.clcnumuid = clcnumuid;
        this.clncodigo = clncodigo;
    }

    /** default constructor */
    public Clippfgene() {
    }

    /** minimal constructor */
    public Clippfgene(String clccodid) {
        this.clccodid = clccodid;
    }

    /** 
     * 		       Id
     * 		    
     */
    public String getClccodid() {
        return this.clccodid;
    }

    public void setClccodid(String clccodid) {
        this.clccodid = clccodid;
    }

    public String getClcgenero() {
        return this.clcgenero;
    }

    public void setClcgenero(String clcgenero) {
        this.clcgenero = clcgenero;
    }

    public BigDecimal getClnedamax() {
        return this.clnedamax;
    }

    public void setClnedamax(BigDecimal clnedamax) {
        this.clnedamax = clnedamax;
    }

    public BigDecimal getClnedamin() {
        return this.clnedamin;
    }

    public void setClnedamin(BigDecimal clnedamin) {
        this.clnedamin = clnedamin;
    }

    public String getClcnumuid() {
        return this.clcnumuid;
    }

    public void setClcnumuid(String clcnumuid) {
        this.clcnumuid = clcnumuid;
    }

    public String getClncodigo() {
        return this.clncodigo;
    }

    public void setClncodigo(String clncodigo) {
        this.clncodigo = clncodigo;
    }

    public String toString() {
        return new ToStringBuilder(this).append("clccodid", 
                                                getClccodid()).toString();
    }

}

package org.profamilia.hc.model.dto;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Cpparamcitol implements Serializable {

    /** identifier field */
    private Long cpcnconsec;

    /** nullable persistent field */
    private String cpcccodpaq;

    /** nullable persistent field */
    private String cpcccodser;

    /** nullable persistent field */
    private String cpcccodlab;

    /** nullable persistent field */
    private String cpcestado;

    /** nullable persistent field */
    private String cpccusuaregi;

    /** nullable persistent field */
    private Date cpcdfechregi;
    
    private Integer cpcncodclin;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */
    public Cpparamcitol(Long cpcnconsec, String cpcccodpaq, String cpcccodser, String cpcccodlab, String cpcestado, String cpccusuaregi, Date cpcdfechregi, Integer version) {
        this.cpcnconsec = cpcnconsec;
        this.cpcccodpaq = cpcccodpaq;
        this.cpcccodser = cpcccodser;
        this.cpcccodlab = cpcccodlab;
        this.cpcestado = cpcestado;
        this.cpccusuaregi = cpccusuaregi;
        this.cpcdfechregi = cpcdfechregi;
        this.version = version;
    }

    /** default constructor */
    public Cpparamcitol() {
    }

    /** minimal constructor */
    public Cpparamcitol(Long cpcnconsec) {
        this.cpcnconsec = cpcnconsec;
    }

    /** 
     * 		       Consecutivo
     * 		    
     */
    public Long getCpcnconsec() {
        return this.cpcnconsec;
    }

    public void setCpcnconsec(Long cpcnconsec) {
        this.cpcnconsec = cpcnconsec;
    }

    public String getCpcccodpaq() {
        return this.cpcccodpaq;
    }

    public void setCpcccodpaq(String cpcccodpaq) {
        this.cpcccodpaq = cpcccodpaq;
    }

    public String getCpcccodser() {
        return this.cpcccodser;
    }

    public void setCpcccodser(String cpcccodser) {
        this.cpcccodser = cpcccodser;
    }

    public String getCpcccodlab() {
        return this.cpcccodlab;
    }

    public void setCpcccodlab(String cpcccodlab) {
        this.cpcccodlab = cpcccodlab;
    }

    public String getCpcestado() {
        return this.cpcestado;
    }

    public void setCpcestado(String cpcestado) {
        this.cpcestado = cpcestado;
    }

    public String getCpccusuaregi() {
        return this.cpccusuaregi;
    }

    public void setCpccusuaregi(String cpccusuaregi) {
        this.cpccusuaregi = cpccusuaregi;
    }

    public Date getCpcdfechregi() {
        return this.cpcdfechregi;
    }

    public void setCpcdfechregi(Date cpcdfechregi) {
        this.cpcdfechregi = cpcdfechregi;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("cpcnconsec", getCpcnconsec())
            .toString();
    }


    public void setCpcncodclin(Integer cpcncodclin) {
        this.cpcncodclin = cpcncodclin;
    }

    public Integer getCpcncodclin() {
        return cpcncodclin;
    }
}

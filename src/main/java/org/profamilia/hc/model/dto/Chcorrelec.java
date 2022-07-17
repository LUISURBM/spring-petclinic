package org.profamilia.hc.model.dto;

import java.io.Serializable;

import java.util.Date;

/** @author Hibernate CodeGenerator */
public class Chcorrelec implements Serializable {

    /** identifier field */
    private Long hcennumero;
    
    /** identifier field */
    private Long hcenconsul;

    /** identifier field */
    private Long hcelusuario;

    /** identifier field */
    private String hceccorreoelec;

    /** identifier field */
    private String hcectipo;

    /** identifier field */
    private String hcecetapa;

    /** identifier field */
    private String hcecerror;

    /** identifier field */
    private Date hcedfecreg;

    /** identifier field */
    private String hcecusureg;

    /** identifier field */
    private Date hcedfecenv;

    /** identifier field */
    private String hcecusuenv;

    /** nullable persistent field */
    private Integer version;

    /** default constructor */
    public Chcorrelec() {
    }


    public void setHcennumero(Long hcennumero) {
        this.hcennumero = hcennumero;
    }

    public Long getHcennumero() {
        return hcennumero;
    }

    public void setHcenconsul(Long hcenconsul) {
        this.hcenconsul = hcenconsul;
    }

    public Long getHcenconsul() {
        return hcenconsul;
    }

    public void setHcelusuario(Long hcelusuario) {
        this.hcelusuario = hcelusuario;
    }

    public Long getHcelusuario() {
        return hcelusuario;
    }

    public void setHceccorreoelec(String hceccorreoelec) {
        this.hceccorreoelec = hceccorreoelec;
    }

    public String getHceccorreoelec() {
        return hceccorreoelec;
    }

    public void setHcectipo(String hcectipo) {
        this.hcectipo = hcectipo;
    }

    public String getHcectipo() {
        return hcectipo;
    }

    public void setHcecetapa(String hcecetapa) {
        this.hcecetapa = hcecetapa;
    }

    public String getHcecetapa() {
        return hcecetapa;
    }

    public void setHcecerror(String hcecerror) {
        this.hcecerror = hcecerror;
    }

    public String getHcecerror() {
        return hcecerror;
    }

    public void setHcedfecreg(Date hcedfecreg) {
        this.hcedfecreg = hcedfecreg;
    }

    public Date getHcedfecreg() {
        return hcedfecreg;
    }

    public void setHcecusureg(String hcecusureg) {
        this.hcecusureg = hcecusureg;
    }

    public String getHcecusureg() {
        return hcecusureg;
    }

    public void setHcedfecenv(Date hcedfecenv) {
        this.hcedfecenv = hcedfecenv;
    }

    public Date getHcedfecenv() {
        return hcedfecenv;
    }

    public void setHcecusuenv(String hcecusuenv) {
        this.hcecusuenv = hcecusuenv;
    }

    public String getHcecusuenv() {
        return hcecusuenv;
    }


    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

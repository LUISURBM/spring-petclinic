package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class Cndesccito implements Serializable {

    /** identifier field */
    private CndesccitoPK id;

    /** persistent field */
    private String cdicdescri;

    /** persistent field */
    private String cdicvalor;

    /** persistent field */
    private String cdicestado;

    /** nullable persistent field */
    private Integer version;

    /** full constructor */

    /** default constructor */
    public Cndesccito() {
    }


    public void setId(CndesccitoPK id) {
        this.id = id;
    }

    public CndesccitoPK getId() {
        return id;
    }

    public void setCdicdescri(String cdicdescri) {
        this.cdicdescri = cdicdescri;
    }

    public String getCdicdescri() {
        return cdicdescri;
    }

    public void setCdicvalor(String cdicvalor) {
        this.cdicvalor = cdicvalor;
    }

    public String getCdicvalor() {
        return cdicvalor;
    }

    public void setCdicestado(String cdicestado) {
        this.cdicestado = cdicestado;
    }

    public String getCdicestado() {
        return cdicestado;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getVersion() {
        return version;
    }
}

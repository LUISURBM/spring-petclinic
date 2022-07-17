package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcanalivenaPK implements Serializable {

    /** identifier field */
    private Long hcvlnumero;

    /** identifier field */
    private Integer hcvlconsecutiv;

    /** identifier field */
    private String hcvctiposervi;

    private Integer hcvnllave;


    /** default constructor */
    public ChcanalivenaPK() {
    }
    
    /** default constructor */
    public ChcanalivenaPK(Long hcvlnumero,Integer hcvlconsecutiv,String hcvctiposervi,Integer hcvnllave) {
        this.hcvlnumero=hcvlnumero;
        this.hcvlconsecutiv = hcvlconsecutiv;
        this.hcvctiposervi = hcvctiposervi;
        this.hcvnllave = hcvnllave;
    }



    /**
     * @param hcvlnumero
     */
    public void setHcvlnumero(Long hcvlnumero) {
        this.hcvlnumero = hcvlnumero;
    }

    /**
     * @return
     */
    public Long getHcvlnumero() {
        return hcvlnumero;
    }

    /**
     * @param hcvlconsecutiv
     */
    public void setHcvlconsecutiv(Integer hcvlconsecutiv) {
        this.hcvlconsecutiv = hcvlconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHcvlconsecutiv() {
        return hcvlconsecutiv;
    }

    /**
     * @param hcvctiposervi
     */
    public void setHcvctiposervi(String hcvctiposervi) {
        this.hcvctiposervi = hcvctiposervi;
    }

    /**
     * @return
     */
    public String getHcvctiposervi() {
        return hcvctiposervi;
    }

    /**
     * @param hcvnllave
     */
    public void setHcvnllave(Integer hcvnllave) {
        this.hcvnllave = hcvnllave;
    }

    /**
     * @return
     */
    public Integer getHcvnllave() {
        return hcvnllave;
    }
}

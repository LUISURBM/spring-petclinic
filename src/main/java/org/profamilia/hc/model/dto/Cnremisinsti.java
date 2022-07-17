package org.profamilia.hc.model.dto;

public class Cnremisinsti {

    /** identifier field */
    private Integer crincodigo;

    /** nullable persistent field */
    private String cricdescripcio;


    public Cnremisinsti() {
    }


    /**
     * @param crincodigo
     */
    public void setCrincodigo(Integer crincodigo) {
        this.crincodigo = crincodigo;
    }

    /**
     * @return
     */
    public Integer getCrincodigo() {
        return crincodigo;
    }

    /**
     * @param cricdescripcio
     */
    public void setCricdescripcio(String cricdescripcio) {
        this.cricdescripcio = cricdescripcio;
    }

    /**
     * @return
     */
    public String getCricdescripcio() {
        return cricdescripcio;
    }
}

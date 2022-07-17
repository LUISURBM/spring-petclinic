package org.profamilia.hc.model.dto;

public class Cnconocavise {

    /** identifier field */
    private Integer ccancodigo;

    /** nullable persistent field */
    private String ccacdescripcio;


    public Cnconocavise() {
    }


    /**
     * @param ccancodigo
     */
    public void setCcancodigo(Integer ccancodigo) {
        this.ccancodigo = ccancodigo;
    }

    /**
     * @return
     */
    public Integer getCcancodigo() {
        return ccancodigo;
    }

    /**
     * @param ccacdescripcio
     */
    public void setCcacdescripcio(String ccacdescripcio) {
        this.ccacdescripcio = ccacdescripcio;
    }

    /**
     * @return
     */
    public String getCcacdescripcio() {
        return ccacdescripcio;
    }
}

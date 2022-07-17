package org.profamilia.hc.model.dto;

public class Cntiempocurr {

    /** identifier field */
    private Integer ctoncodigo;

    /** nullable persistent field */
    private String ctocdescripcio;


    public Cntiempocurr() {
    }


    /**
     * @param ctoncodigo
     */
    public void setCtoncodigo(Integer ctoncodigo) {
        this.ctoncodigo = ctoncodigo;
    }

    /**
     * @return
     */
    public Integer getCtoncodigo() {
        return ctoncodigo;
    }

    /**
     * @param ctocdescripcio
     */
    public void setCtocdescripcio(String ctocdescripcio) {
        this.ctocdescripcio = ctocdescripcio;
    }

    /**
     * @return
     */
    public String getCtocdescripcio() {
        return ctocdescripcio;
    }
}

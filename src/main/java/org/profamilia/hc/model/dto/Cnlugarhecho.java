package org.profamilia.hc.model.dto;

public class Cnlugarhecho {

    /** identifier field */
    private Integer clhncodigo;

    /** nullable persistent field */
    private String clhcdescripcio;


    public Cnlugarhecho() {
    }


    /**
     * @param clhncodigo
     */
    public void setClhncodigo(Integer clhncodigo) {
        this.clhncodigo = clhncodigo;
    }

    /**
     * @return
     */
    public Integer getClhncodigo() {
        return clhncodigo;
    }

    /**
     * @param clhcdescripcio
     */
    public void setClhcdescripcio(String clhcdescripcio) {
        this.clhcdescripcio = clhcdescripcio;
    }

    /**
     * @return
     */
    public String getClhcdescripcio() {
        return clhcdescripcio;
    }
}

package org.profamilia.hc.model.dto;

public class Cnrelacavise {

    /** identifier field */
    private Integer crancodigo;

    /** nullable persistent field */
    private String cracdescripcio;


    public Cnrelacavise() {
    }


    /**
     * @param crancodigo
     */
    public void setCrancodigo(Integer crancodigo) {
        this.crancodigo = crancodigo;
    }

    /**
     * @return
     */
    public Integer getCrancodigo() {
        return crancodigo;
    }

    /**
     * @param cracdescripcio
     */
    public void setCracdescripcio(String cracdescripcio) {
        this.cracdescripcio = cracdescripcio;
    }

    /**
     * @return
     */
    public String getCracdescripcio() {
        return cracdescripcio;
    }
}

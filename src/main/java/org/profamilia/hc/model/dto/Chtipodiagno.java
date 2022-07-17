package org.profamilia.hc.model.dto;

public class Chtipodiagno {

    /** Almacena el codigo del tipo de diagnostico */
    private Integer htdccodigo;

    /** Almacena la descripcion del diagnostico  */
    private String htdcdescripcio;

    public Chtipodiagno() {
    }


    public void setHtdccodigo(Integer htdccodigo) {
        this.htdccodigo = htdccodigo;
    }

    public Integer getHtdccodigo() {
        return htdccodigo;
    }

    public void setHtdcdescripcio(String htdcdescripcio) {
        this.htdcdescripcio = htdcdescripcio;
    }

    public String getHtdcdescripcio() {
        return htdcdescripcio;
    }
}

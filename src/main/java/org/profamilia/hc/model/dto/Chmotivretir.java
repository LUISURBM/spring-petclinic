package org.profamilia.hc.model.dto;

public class Chmotivretir {
    private String cmrccodigo;
    private String cmrcdescripcio;
    private String cmreestado;

    public Chmotivretir() {
    }


    /**
     * @param cmrccodigo
     */
    public void setCmrccodigo(String cmrccodigo) {
        this.cmrccodigo = cmrccodigo;
    }

    /**
     * @return
     */
    public String getCmrccodigo() {
        return cmrccodigo;
    }

    /**
     * @param cmrcdescripcio
     */
    public void setCmrcdescripcio(String cmrcdescripcio) {
        this.cmrcdescripcio = cmrcdescripcio;
    }

    /**
     * @return
     */
    public String getCmrcdescripcio() {
        return cmrcdescripcio;
    }

    /**
     * @param cmreestado
     */
    public void setCmreestado(String cmreestado) {
        this.cmreestado = cmreestado;
    }

    /**
     * @return
     */
    public String getCmreestado() {
        return cmreestado;
    }
}

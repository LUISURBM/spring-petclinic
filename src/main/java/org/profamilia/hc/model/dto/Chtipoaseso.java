package org.profamilia.hc.model.dto;

public class Chtipoaseso {
    private String htaecodigo;
    private String htacdescripcio;
    private String htaeestado;

    public Chtipoaseso() {
    }


    /**
     * @param htaecodigo
     */
    public void setHtaecodigo(String htaecodigo) {
        this.htaecodigo = htaecodigo;
    }

    /**
     * @return
     */
    public String getHtaecodigo() {
        return htaecodigo;
    }

    /**
     * @param htacdescripcio
     */
    public void setHtacdescripcio(String htacdescripcio) {
        this.htacdescripcio = htacdescripcio;
    }

    /**
     * @return
     */
    public String getHtacdescripcio() {
        return htacdescripcio;
    }

    /**
     * @param htaeestado
     */
    public void setHtaeestado(String htaeestado) {
        this.htaeestado = htaeestado;
    }

    /**
     * @return
     */
    public String getHtaeestado() {
        return htaeestado;
    }
}

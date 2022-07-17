package org.profamilia.hc.model.dto;

public class Chtipousuari {

    /** identifier field */
    private String htuccodigo;

    /** nullable persistent field */
    private String htucdescripcio;


    public Chtipousuari() {
    }

    /**
     * @param htuccodigo
     */
    public void setHtuccodigo(String htuccodigo) {
        this.htuccodigo = htuccodigo;
    }

    /**
     * @return
     */
    public String getHtuccodigo() {
        return htuccodigo;
    }

    /**
     * @param htucdescripcio
     */
    public void setHtucdescripcio(String htucdescripcio) {
        this.htucdescripcio = htucdescripcio;
    }

    /**
     * @return
     */
    public String getHtucdescripcio() {
        return htucdescripcio;
    }
}

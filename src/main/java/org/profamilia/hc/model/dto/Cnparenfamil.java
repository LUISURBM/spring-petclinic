package org.profamilia.hc.model.dto;

public class Cnparenfamil {

    /** identifier field */
    private Integer cpfncodigo;

    /** nullable persistent field */
    private String cpfcdescripcio;


    public Cnparenfamil() {
    }


    /**
     * @param cpfncodigo
     */
    public void setCpfncodigo(Integer cpfncodigo) {
        this.cpfncodigo = cpfncodigo;
    }

    /**
     * @return
     */
    public Integer getCpfncodigo() {
        return cpfncodigo;
    }

    /**
     * @param cpfcdescripcio
     */
    public void setCpfcdescripcio(String cpfcdescripcio) {
        this.cpfcdescripcio = cpfcdescripcio;
    }

    /**
     * @return
     */
    public String getCpfcdescripcio() {
        return cpfcdescripcio;
    }
}

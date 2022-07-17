package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChplantillaPK implements Serializable {

    private Integer hplnnumero;

    /** identifier field */
    private String hplcusuarplant;


    /** default constructor */
    public ChplantillaPK() {
    }


    /**
     * @param hplnnumero
     */
    public void setHplnnumero(Integer hplnnumero) {
        this.hplnnumero = hplnnumero;
    }

    /**
     * @return
     */
    public Integer getHplnnumero() {
        return hplnnumero;
    }

    /**
     * @param hplcusuarplant
     */
    public void setHplcusuarplant(String hplcusuarplant) {
        this.hplcusuarplant = hplcusuarplant;
    }

    /**
     * @return
     */
    public String getHplcusuarplant() {
        return hplcusuarplant;
    }
}

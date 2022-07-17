package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChconsultoriPK implements Serializable {

    /** identifier field */
    private Integer hconnumero;

    /** identifier field */
    private String hcoctipoconsu;

    /** identifier field */
    private Integer hconclinica;


    /** default constructor */
    public ChconsultoriPK() {
    }


    /**
     * @param hconnumero
     */
    public void setHconnumero(Integer hconnumero) {
        this.hconnumero = hconnumero;
    }

    /**
     * @return
     */
    public Integer getHconnumero() {
        return hconnumero;
    }

    /**
     * @param hcoctipoconsu
     */
    public void setHcoctipoconsu(String hcoctipoconsu) {
        this.hcoctipoconsu = hcoctipoconsu;
    }

    /**
     * @return
     */
    public String getHcoctipoconsu() {
        return hcoctipoconsu;
    }

    /**
     * @param hconclinica
     */
    public void setHconclinica(Integer hconclinica) {
        this.hconclinica = hconclinica;
    }

    /**
     * @return
     */
    public Integer getHconclinica() {
        return hconclinica;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChformulaliqPK implements Serializable {

    /** identifier field */
    private Long hfllconsulta;

    /** identifier field */
    private Integer hflnconsecutiv;

    /** identifier field */
    private Integer hflnllave;


    /** default constructor */
    public ChformulaliqPK() {
    }


    /**
     * @param hfllconsulta
     */
    public void setHfllconsulta(Long hfllconsulta) {
        this.hfllconsulta = hfllconsulta;
    }

    /**
     * @return
     */
    public Long getHfllconsulta() {
        return hfllconsulta;
    }

    /**
     * @param hflnconsecutiv
     */
    public void setHflnconsecutiv(Integer hflnconsecutiv) {
        this.hflnconsecutiv = hflnconsecutiv;
    }

    /**
     * @return
     */
    public Integer getHflnconsecutiv() {
        return hflnconsecutiv;
    }


    /**
     * @param hflnllave
     */
    public void setHflnllave(Integer hflnllave) {
        this.hflnllave = hflnllave;
    }

    /**
     * @return
     */
    public Integer getHflnllave() {
        return hflnllave;
    }
}

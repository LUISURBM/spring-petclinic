package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChformulahosPK implements Serializable {

    /** identifier field */
    private Long hfhlconsulta;

    /** identifier field */
    private Integer hfhnconsecut;

    /** identifier field */
    private Integer hfhnevoluconse;


    /** default constructor */
    public ChformulahosPK() {
    }


    /**
     * @param hfhlconsulta
     */
    public void setHfhlconsulta(Long hfhlconsulta) {
        this.hfhlconsulta = hfhlconsulta;
    }

    /**
     * @return
     */
    public Long getHfhlconsulta() {
        return hfhlconsulta;
    }

    /**
     * @param hfhnconsecut
     */
    public void setHfhnconsecut(Integer hfhnconsecut) {
        this.hfhnconsecut = hfhnconsecut;
    }

    /**
     * @return
     */
    public Integer getHfhnconsecut() {
        return hfhnconsecut;
    }


    /**
     * @param hfhnevoluconse
     */
    public void setHfhnevoluconse(Integer hfhnevoluconse) {
        this.hfhnevoluconse = hfhnevoluconse;
    }

    /**
     * @return
     */
    public Integer getHfhnevoluconse() {
        return hfhnevoluconse;
    }
}

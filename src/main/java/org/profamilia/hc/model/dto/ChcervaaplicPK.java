package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChcervaaplicPK implements Serializable {

    /** identifier field */
    private Long hcalconsulta;

    /** identifier field */
    private String hcactiposervi;


    /** default constructor */
    public ChcervaaplicPK() {
    }


    /**
     * @param hcalconsulta
     */
    public void setHcalconsulta(Long hcalconsulta) {
        this.hcalconsulta = hcalconsulta;
    }

    /**
     * @return
     */
    public Long getHcalconsulta() {
        return hcalconsulta;
    }

    /**
     * @param hcactiposervi
     */
    public void setHcactiposervi(String hcactiposervi) {
        this.hcactiposervi = hcactiposervi;
    }

    /**
     * @return
     */
    public String getHcactiposervi() {
        return hcactiposervi;
    }
}

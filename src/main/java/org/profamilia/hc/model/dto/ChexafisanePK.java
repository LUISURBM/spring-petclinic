package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChexafisanePK implements Serializable {

    /** identifier field */
    private Long healconsulta;

    /** identifier field */
    private String heactiposervi;


    /** default constructor */
    public ChexafisanePK() {
    }

    /**
     * @return
     */
    public Long getHealconsulta() {
        return this.healconsulta;
    }

    /**
     * @param healconsulta
     */
    public void setHealconsulta(Long healconsulta) {
        this.healconsulta = healconsulta;
    }

    /**
     * @return
     */
    public String getHeactiposervi() {
        return this.heactiposervi;
    }

    /**
     * @param heactiposervi
     */
    public void setHeactiposervi(String heactiposervi) {
        this.heactiposervi = heactiposervi;
    }


}

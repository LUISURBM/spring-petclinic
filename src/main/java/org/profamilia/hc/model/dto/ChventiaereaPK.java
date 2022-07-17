package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChventiaereaPK implements Serializable {

    /** identifier field */
    private Long hvalnumero;

    /** identifier field */
    private String hvactiposervi;

    /** default constructor */
    public ChventiaereaPK() {
    }

    /**
     * @return
     */
    public Long getHvalnumero() {
        return this.hvalnumero;
    }

    /**
     * @param hvalnumero
     */
    public void setHvalnumero(Long hvalnumero) {
        this.hvalnumero = hvalnumero;
    }

    /**
     * @return
     */
    public String getHvactiposervi() {
        return this.hvactiposervi;
    }

    /**
     * @param hvactiposervi
     */
    public void setHvactiposervi(String hvactiposervi) {
        this.hvactiposervi = hvactiposervi;
    }


}

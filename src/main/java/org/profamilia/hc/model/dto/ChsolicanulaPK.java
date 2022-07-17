package org.profamilia.hc.model.dto;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class ChsolicanulaPK implements Serializable {

    /** identifier field */
    private Long hsalconsulta;

    /** identifier field */
    private String hsactiposervi;


    /** default constructor */
    public ChsolicanulaPK() {
    }

    /**
     * @param hsalconsulta
     */
    public void setHsalconsulta(Long hsalconsulta) {
        this.hsalconsulta = hsalconsulta;
    }

    /**
     * @return
     */
    public Long getHsalconsulta() {
        return hsalconsulta;
    }

    /**
     * @param hsactiposervi
     */
    public void setHsactiposervi(String hsactiposervi) {
        this.hsactiposervi = hsactiposervi;
    }

    /**
     * @return
     */
    public String getHsactiposervi() {
        return hsactiposervi;
    }
}

package org.profamilia.hc.model.dto;

import java.io.Serializable;

/** @author Hibernate CodeGenerator */
public class ChseguipsicoPK implements Serializable {

    /** identifier field */
    private Long hsplconsulta;

    /** identifier field */
    private String hspctiposervi;


    /** default constructor */
    public ChseguipsicoPK() {
    }

    /**
     * @return
     */
    public Long getHsplconsulta() {
        return this.hsplconsulta;
    }

    /**
     * @param hsplconsulta
     */
    public void setHsplconsulta(Long hsplconsulta) {
        this.hsplconsulta = hsplconsulta;
    }

    /**
     * @return
     */
    public String getHspctiposervi() {
        return this.hspctiposervi;
    }

    /**
     * @param hspctiposervi
     */
    public void setHspctiposervi(String hspctiposervi) {
        this.hspctiposervi = hspctiposervi;
    }

}

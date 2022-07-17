package org.profamilia.hc.model.dto;

import java.io.Serializable;


/** @author Hibernate CodeGenerator */
public class ChantecpsicoPK implements Serializable {

    /** identifier field */
    private Long haplconsulta;

    /** identifier field */
    private String hapctiposervi;


    /** default constructor */
    public ChantecpsicoPK() {
    }

    /**
     * @return
     */
    public Long getHaplconsulta() {
        return this.haplconsulta;
    }

    /**
     * @param haplconsulta
     */
    public void setHaplconsulta(Long haplconsulta) {
        this.haplconsulta = haplconsulta;
    }

    /**
     * @return
     */
    public String getHapctiposervi() {
        return this.hapctiposervi;
    }

    /**
     * @param hapctiposervi
     */
    public void setHapctiposervi(String hapctiposervi) {
        this.hapctiposervi = hapctiposervi;
    }



}
